/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.clientManagement.request.ManageEmployeeRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class ManageEmployeeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ManageEmployeeValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ManageEmployeeRequest manageEmployeeRequest = (ManageEmployeeRequest) target;
		
		if(manageEmployeeRequest.isSearchOption()) {
			if((null==manageEmployeeRequest.getUnitName() || StringUtils.isEmpty(manageEmployeeRequest.getUnitName()))
					&& (null==manageEmployeeRequest.getIfscCode() || StringUtils.isEmpty(manageEmployeeRequest.getIfscCode()))) {
		    	errors.reject("unitname.ifsccode.missing","Either unit Name or ifsc code is required for viewing employees");
		    } 
		} 
	}
	
	
}
