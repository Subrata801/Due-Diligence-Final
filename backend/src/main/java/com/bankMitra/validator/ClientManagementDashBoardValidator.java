/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bankMitra.model.clientManagement.request.ClientManagementDashBoardTaskRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class ClientManagementDashBoardValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClientManagementDashBoardTaskRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ClientManagementDashBoardTaskRequest clientManagementDashBoardTaskRequest = (ClientManagementDashBoardTaskRequest) target;
		if(null==clientManagementDashBoardTaskRequest.getLoanAmount() 
				|| StringUtils.isEmpty(clientManagementDashBoardTaskRequest.getLoanAmount())) {
	    	errors.reject("loanamount.missing","Loan Amount is required");
	    }
		
	   		
	}

}
