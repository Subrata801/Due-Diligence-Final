package com.bankMitra.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.bankMitra.validator.GenericValidator;

import org.springframework.validation.Validator;

/**
 * @author BankMitra
 *
 */
@Configuration
public class ValidatorConfiguration {
 
	@Bean
    public Validator validatorFactory () {
        return new LocalValidatorFactoryBean();
    }
	
	/*@Bean
    public GenericValidator genericValidator () {
        return new GenericValidator();
    }*/
}
