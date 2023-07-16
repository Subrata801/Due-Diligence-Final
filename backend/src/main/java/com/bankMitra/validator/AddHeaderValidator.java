/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.HeaderRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class AddHeaderValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return HeaderRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmpty(errors,
                "headerKey","header.key", "Header Key is required");
		
		ValidationUtils.rejectIfEmpty(errors,
                "englishDescription", "english.description","English Description is required");
		
		/*ValidationUtils.rejectIfEmpty(errors,
                "nonEnglishDescription", "nonenglish.description","Non-English Description is required");*/
	}

}
