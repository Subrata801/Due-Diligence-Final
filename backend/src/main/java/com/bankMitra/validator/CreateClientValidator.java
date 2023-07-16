/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.ClientConfigRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CreateClientValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClientConfigRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors,
                "clientName","clientName.key", "Client Name is required");
		
				
		
		
		ClientConfigRequest clientConfigRequest = (ClientConfigRequest) target;
		if(null!=clientConfigRequest.getAddressInfo() && clientConfigRequest.getAddressInfo().size() >0 
				&& StringUtils.isEmpty(clientConfigRequest.getAddressInfo().get(0).getAddress())) {
	    	errors.reject("address.missing","Address is required");
	    }
		
	    if(null!=clientConfigRequest.getAddressInfo() && clientConfigRequest.getAddressInfo().size() >0 
	    		&& StringUtils.isEmpty(clientConfigRequest.getAddressInfo().get(0).getPincode())) {
	    	errors.reject("pincode.missing","Pincode is required");
	    }
	    if(null!=clientConfigRequest.getAddressInfo() && clientConfigRequest.getAddressInfo().size() >0 
	    		
	    		&& StringUtils.isEmpty(clientConfigRequest.getAddressInfo().get(0).getCity())) {
	    	errors.reject("city.missing","City is required");
	    }
	    if(null!=clientConfigRequest.getAddressInfo() && clientConfigRequest.getAddressInfo().size() >0 
	    		&& StringUtils.isEmpty(clientConfigRequest.getAddressInfo().get(0).getState())) {
	    	errors.reject("state.missing","State is required");
	    }
	    
	    
	    if(null!=clientConfigRequest.getPrimaryContactInfo() && clientConfigRequest.getPrimaryContactInfo().size() >0 
	    		&& StringUtils.isEmpty(clientConfigRequest.getPrimaryContactInfo().get(0).getPointOfContact())) {
	    	errors.reject("primarypointofContact.missing","Point of contact for primary contact is required");
	    }
	    if(null!=clientConfigRequest.getPrimaryContactInfo() && clientConfigRequest.getPrimaryContactInfo().size() >0 
	    		&& StringUtils.isEmpty(clientConfigRequest.getPrimaryContactInfo().get(0).getMobileNum())) {
	    	errors.reject("primaryContactMobile.missing","Mobile number for primary contact is required");
	    }
	    if(null!=clientConfigRequest.getPrimaryContactInfo() && clientConfigRequest.getPrimaryContactInfo().size() >0 
	    		&& StringUtils.isEmpty(clientConfigRequest.getPrimaryContactInfo().get(0).getOfficialEmailId())) {
	    	errors.reject("primaryContactEmail.missing","Email Id for primary contact is required");
	    }
	    
	    if(null!=clientConfigRequest.getPrimaryContactInfo() && clientConfigRequest.getPrimaryContactInfo().size() >0 
	    		&& !StringUtils.isEmpty(clientConfigRequest.getPrimaryContactInfo().get(0).getMobileNum())
	    		&& !validatePhoneNumber(String.valueOf(clientConfigRequest.getPrimaryContactInfo().get(0).getMobileNum()))) {
			errors.reject(
	                "mobileNum", "Mobile Number for primary contact  is not valid");
		}
		
		if(null!=clientConfigRequest.getPrimaryContactInfo() && clientConfigRequest.getPrimaryContactInfo().size() >0 
	    		&& !StringUtils.isEmpty(clientConfigRequest.getPrimaryContactInfo().get(0).getOfficialEmailId())
	    		&& !isValidEmail(String.valueOf(clientConfigRequest.getPrimaryContactInfo().get(0).getOfficialEmailId()))) {
			errors.reject(
	                "email", "Email id  for primary contact is not valid");
		}
		
		if(null!=clientConfigRequest.getSecondaryContactInfo() && clientConfigRequest.getSecondaryContactInfo().size() >0 
	    		&& !StringUtils.isEmpty(clientConfigRequest.getSecondaryContactInfo().get(0).getMobileNum())
	    		&& !validatePhoneNumber(String.valueOf(clientConfigRequest.getSecondaryContactInfo().get(0).getMobileNum()))) {
			errors.reject(
	                "mobileNum", "Mobile Number for sceondary contact is not valid");
		}
		
		if(null!=clientConfigRequest.getSecondaryContactInfo() && clientConfigRequest.getSecondaryContactInfo().size() >0 
	    		&& !StringUtils.isEmpty(clientConfigRequest.getSecondaryContactInfo().get(0).getOfficialEmailId())
	    		&& !isValidEmail(String.valueOf(clientConfigRequest.getSecondaryContactInfo().get(0).getOfficialEmailId()))) {
			errors.reject(
	                "email", "Email id for secondary contact is not valid");
		}
		
		if (null!=clientConfigRequest.getAddressInfo() && clientConfigRequest.getAddressInfo().size() >0 
	    		&& !StringUtils.isEmpty(clientConfigRequest.getAddressInfo().get(0).getPincode()) 
	    		&& !clientConfigRequest.getAddressInfo().get(0).getPincode().matches("[0-9]+")) {
			errors.reject(
	                "pincodenumber", "PinCode should be a number");
		}
		
		if(null==clientConfigRequest.getRiskTypeId() || StringUtils.isEmpty(clientConfigRequest.getRiskTypeId())) {
	    	errors.reject("riskType.missing","Risk detail is required");
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
