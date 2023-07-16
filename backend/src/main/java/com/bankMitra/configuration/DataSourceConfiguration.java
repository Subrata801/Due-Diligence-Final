/**
 * 
 */
package com.bankMitra.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author BankMitra
 *
 */
@Configuration
@PropertySource("database.properties")
public class DataSourceConfiguration {
	
	@Autowired
	DataSourceProperties properties;

}
