/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.auth.ResetPasswordRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class FileUploadValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ResetPasswordRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
	}

}
