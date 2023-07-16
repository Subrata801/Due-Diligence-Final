/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CifRegistrationValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return CifRegistrationValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CifRegistrationRequest cifRegistrationRequest = (CifRegistrationRequest) target;
		if(null==cifRegistrationRequest.getCifNum() 
				|| StringUtils.isEmpty(cifRegistrationRequest.getCifNum())) {
	    	errors.reject("cifnumber.missing","CIF Number is required");
	    }
		if(null==cifRegistrationRequest.getCustomerName() 
				|| StringUtils.isEmpty(cifRegistrationRequest.getCustomerName())) {
	    	errors.reject("customername.missing","Customer Name is required");
	    }	   		
	}

}
