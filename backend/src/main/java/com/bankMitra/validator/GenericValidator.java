/**
 * 
 */
package com.bankMitra.validator;

import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;

/**
 * @author BankMitra
 *
 */
//@Component
public class GenericValidator {

    @Autowired
    ApplicationContext context;

    /**
     * This is a framework style generic method which can
     * validate any object given that the corresponding
     * validator is register as bean.
     */
    public boolean validateObject (Object objectToValidate) {

        Map<String, Validator> validatorMap =
                            context.getBeansOfType(Validator.class);
        if (validatorMap == null) {
            return true;
        }

        DataBinder binder = new DataBinder(objectToValidate);

        for (Validator validator : validatorMap.values()) {

            if (validator.supports(objectToValidate.getClass())) {

                binder.addValidators(validator);
            }
        }
        binder.validate();
        BindingResult bindingResult = binder.getBindingResult();
        if (bindingResult.hasErrors()) {
            ResourceBundleMessageSource messageSource =
                                new ResourceBundleMessageSource();
            messageSource.setBasename("ValidationMessages");


            System.out.println(messageSource.getMessage("object.invalid",
                                new Object[]{objectToValidate.getClass().
                                                    getSimpleName()},
                                Locale.US));

            bindingResult.getAllErrors()
                         .stream()
                         .map(e -> messageSource.getMessage(e,
                                             Locale.US))
                         .forEach(System.out::println);
            return false;
        }

        return true;
    }

}