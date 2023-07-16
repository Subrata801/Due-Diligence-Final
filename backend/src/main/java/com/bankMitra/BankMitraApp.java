package com.bankMitra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Application Name : BankMitra
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
//@EnableSwagger2
public class BankMitraApp 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(BankMitraApp.class, args);

    }
}
