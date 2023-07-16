/**
 * 
 */
package com.bankMitra.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author BankMitra
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Value("${swagger.includePatterns:/.*}")
	String includePatterns;
    
    @Value("${swagger.title:Bank Mitra Controller}")
	String title;
    
    @Value("${swagger.description:Bank Mitra Apis for UI metadata}")
	String description;
    
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
        		.apiInfo(getApiInformation())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.bankMitra")).build();
    }

    protected ApiInfo getApiInformation(){
        return new ApiInfoBuilder().title(title).description(description).version("1.0").build();
    }
}
