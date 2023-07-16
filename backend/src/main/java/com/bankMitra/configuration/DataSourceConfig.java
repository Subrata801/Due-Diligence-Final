/**
 * 
 */
package com.bankMitra.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author BankMitra
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.bankMitra.repository.user","com.bankMitra.repository.dashboard","com.bankMitra.repository.reference",
		"com.bankMitra.repository.admin","com.bankMitra.repository.user.impl","com.bankMitra.repository.reference.impl",
		"com.bankMitra.repository.admin.impl"},
	entityManagerFactoryRef = "entityManager",
	transactionManagerRef= "transactionManager"
)
public class DataSourceConfig {
	
	@Autowired
	DataSource datasource;
	
	@Autowired
	private Environment env;
	
	@Primary
	@Bean(name="entityManager")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(this.datasource);
        entityManagerFactoryBean.setPersistenceUnitName("entityManagerUnit");
        entityManagerFactoryBean.setPackagesToScan(new String[] {
            "com.bankMitra.model.admin","com.bankMitra.model.auth","com.bankMitra.model.reference",
            "com.bankMitra.model.subscription"
        });

        final HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        entityManagerFactoryBean.setJpaVendorAdapter(vendorAdapter);
        entityManagerFactoryBean.setJpaPropertyMap(additionalProperties());

        return entityManagerFactoryBean;
    }

    final Map<String,Object> additionalProperties() {
        final Map<String,Object> hibernateProperties = new HashMap<String,Object>();
        hibernateProperties.put("spring.jpa.show-sql", "true");
        //hibernateProperties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        //hibernateProperties.put("hibernate.cache.use_second_level_cache", env.getProperty("hibernate.cache.use_second_level_cache"));
        //hibernateProperties.put("hibernate.cache.use_query_cache", env.getProperty("hibernate.cache.use_query_cache"));
        // hibernateProperties.setProperty("hibernate.globally_quoted_identifiers", "true");
        return hibernateProperties;
    }
    @Primary
    @Bean(name="transactionManager")
    public PlatformTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
        return transactionManager;
    }

}
