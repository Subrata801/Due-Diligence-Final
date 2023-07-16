/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bankMitra.model.auth.ResetPasswordRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class PasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ResetPasswordRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ResetPasswordRequest resetPasswordBean = (ResetPasswordRequest) target;
		if (StringUtils.isEmpty(resetPasswordBean.getUsername()) ) {
			errors.reject("username", "User Name is required");
		}
		
		if (StringUtils.isEmpty(resetPasswordBean.getSecurityQuestionId()) ) {
			errors.reject("securityQuestionId", "Security Question is required");
		}
		if (StringUtils.isEmpty(resetPasswordBean.getSecurityQuestionAnswer()) ) {
			errors.reject("securityQuestionAnswer","Security Answer is required");
		}
		if (StringUtils.isEmpty(resetPasswordBean.getNewPassword()) ) {
			errors.reject("newPassword", "Set New Password is required");
		}
		
		if (StringUtils.isEmpty(resetPasswordBean.getConfirmPassword()) ) {
			errors.reject("confirmPassword", "Retype New Password is required");
		}
		if (!StringUtils.isEmpty(resetPasswordBean.getConfirmPassword()) && !StringUtils.isEmpty(resetPasswordBean.getNewPassword()) && 
				!resetPasswordBean.getNewPassword().equalsIgnoreCase(resetPasswordBean.getConfirmPassword()) ) {
			errors.reject("newPassword.confirmPassword.unmatch","Set New Password and Retype New Password should be same");
		}
		
	}

}
