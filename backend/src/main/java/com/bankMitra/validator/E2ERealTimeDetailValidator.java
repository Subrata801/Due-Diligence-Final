/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest;
import com.bankMitra.model.bankenduserpanel.request.E2ERealTimeDashboardRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class E2ERealTimeDetailValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return E2ERealTimeDetailValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		E2ERealTimeDashboardRequest e2eRealTimeDashboardRequest = (E2ERealTimeDashboardRequest) target;
		if(null==e2eRealTimeDashboardRequest.getModuleName() 
				|| StringUtils.isEmpty(e2eRealTimeDashboardRequest.getModuleName())) {
	    	errors.reject("moduleName.missing","Module Name is required");
	    }
	}

}
