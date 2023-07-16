/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bankMitra.model.auth.SignupRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class RegisterClientValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SignupRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors,
                "clientTypeId","clientTypeId.key", "User Type is required");
		
		ValidationUtils.rejectIfEmpty(errors,
                "clientId","clientId.key", "BM/Bank/Audit/Firm is required");
		
		/*ValidationUtils.rejectIfEmpty(errors,
                "clientGroupId","clientGroupId.key", "Branch/Audit Firm is required");*/
		
		ValidationUtils.rejectIfEmpty(errors,
                "userRoleId","userRoleId.key", "User Role is required");
		
		ValidationUtils.rejectIfEmpty(errors,
                "fullName","fullName.key", "Full Name is required");
		
		ValidationUtils.rejectIfEmpty(errors,
                "email","email.key", "Email is required");
		
		ValidationUtils.rejectIfEmpty(errors,
                "mobileNum","mobileNum.key", "Mobile Number is required");
		
		ValidationUtils.rejectIfEmpty(errors,
                "userName","userName.key", "User Name is required");
		
		/*ValidationUtils.rejectIfEmpty(errors,
                "password","password.key", "Password is required");*/
		
		ValidationUtils.rejectIfEmpty(errors,
                "userStatus","userStatus.key", "Status is required");
		
		SignupRequest signupRequest = (SignupRequest) target;
		if(StringUtils.isEmpty(signupRequest.getUserId()) && StringUtils.isEmpty(signupRequest.getPassword())) {
			errors.reject(
	                "password.key", "Password is required");
		}
		
		if(!StringUtils.isEmpty(signupRequest.getClientTypeId()) && 3 == signupRequest.getClientTypeId() && StringUtils.isEmpty(signupRequest.getClientGroupId())) {
			errors.reject(
	                "clientGroupId.key", "Branch/Audit Firm is required");
		}
		
		if(!StringUtils.isEmpty(signupRequest.getMobileNum()) && !validatePhoneNumber(signupRequest.getMobileNum())) {
			errors.reject(
	                "mobileNum", "Mobile Number is not valid");
		}
		
		if(!StringUtils.isEmpty(signupRequest.getEmail()) && !isValidEmail(signupRequest.getEmail())) {
			errors.reject(
	                "email", "Email id is not valid");
		}
	}

	private static boolean validatePhoneNumber(String phoneNumber) {
		  // validate phone numbers of format "1234567890"
		  if (phoneNumber.matches("\\d{10}"))
		   return true;
		  // validating phone number with -, . or spaces
		  else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
		   return true;
		  // validating phone number with extension length from 3 to 5
		  else if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
		   return true;
		  // validating phone number where area code is in braces ()
		  else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
		   return true;
		  // Validation for India numbers
		  else if (phoneNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
		   return true;
		  else if (phoneNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
		   return true;

		  else if (phoneNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
		   return true;
		  // return false if nothing matches the input
		  else
		   return false;

   }
	
	private  boolean isValidEmail(String email) {
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}
}
