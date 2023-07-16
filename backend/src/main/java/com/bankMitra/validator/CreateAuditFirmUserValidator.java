/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CreateAuditFirmUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CreateAuditFirmUserValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CreateAuditFirmUserRequest createAuditFirmUserRequest = (CreateAuditFirmUserRequest) target;
		if(createAuditFirmUserRequest.isSearchOption()) { 
			if(null==createAuditFirmUserRequest.getSearchType() || StringUtils.isEmpty(createAuditFirmUserRequest.getSearchType())) {
				errors.reject("searchtype.missing","One of the search criteria is required");
			}
			if(null==createAuditFirmUserRequest.getSearchKeyword() || StringUtils.isEmpty(createAuditFirmUserRequest.getSearchKeyword())) {
				if(null!=createAuditFirmUserRequest.getSearchType() & !"usertypesearch".equalsIgnoreCase(createAuditFirmUserRequest.getSearchType())){
					errors.reject("searchkeyword.missing","Search keyword is required");
				}
		    }
	    } else {
			if(null==createAuditFirmUserRequest.getUserRoleId() 
					|| StringUtils.isEmpty(createAuditFirmUserRequest.getUserRoleId())) {
		    	errors.reject("userrole.missing","User Role is required");
		    }
			if(null==createAuditFirmUserRequest.getEmployeeName() 
					|| StringUtils.isEmpty(createAuditFirmUserRequest.getEmployeeName())) {
		    	errors.reject("employeeName.missing","Employee Name is required");
		    }
			if(null==createAuditFirmUserRequest.getMobileNum() 
					|| StringUtils.isEmpty(createAuditFirmUserRequest.getMobileNum())) {
		    	errors.reject("mobilenum.missing","Mobile Number is required");
		    }
			if(null==createAuditFirmUserRequest.getUserName() 
					|| StringUtils.isEmpty(createAuditFirmUserRequest.getUserName())) {
		    	errors.reject("username.missing","User Name is required");
		    }
			if(null==createAuditFirmUserRequest.getPassword() 
					|| StringUtils.isEmpty(createAuditFirmUserRequest.getPassword())) {
		    	errors.reject("password.missing","Password is required");
		    }	   
			
			if(null!=createAuditFirmUserRequest.getMobileNum() && !StringUtils.isEmpty(createAuditFirmUserRequest.getMobileNum())
		    		&& !validatePhoneNumber(String.valueOf(createAuditFirmUserRequest.getMobileNum()))) {
				errors.reject(
		                "mobileNum", "Mobile Number is not valid");
			}
			
			if(null!=createAuditFirmUserRequest.getEmployeeMail()  
		    		&& !StringUtils.isEmpty(createAuditFirmUserRequest.getEmployeeMail())
		    		&& !isValidEmail(String.valueOf(createAuditFirmUserRequest.getEmployeeMail()))) {
				errors.reject(
		                "email", "Employee Email is not valid");
			}
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
