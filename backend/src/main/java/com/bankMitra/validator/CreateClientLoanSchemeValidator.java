/**
 * 
 */
package com.bankMitra.validator;


import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.ClientLoanSchemeRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CreateClientLoanSchemeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClientLoanSchemeRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*ValidationUtils.rejectIfEmpty(errors,
                "clientName","clientName.key", "Client Name is required");*/
		
				
		ClientLoanSchemeRequest clientLoanSchemeRequest = (ClientLoanSchemeRequest) target;
		if(CollectionUtils.isEmpty(clientLoanSchemeRequest.getSchemeRequestForValidation())) {
			errors.reject("loanschemeDetails.missing","Loan Scheme details are required");
		} else if(!CollectionUtils.isEmpty(clientLoanSchemeRequest.getSchemeRequestForValidation()) && clientLoanSchemeRequest.getSchemeRequestForValidation().size() > 0) {
	    	for(ClientLoanSchemeRequest req : clientLoanSchemeRequest.getSchemeRequestForValidation()) {
	    		if(StringUtils.isEmpty(req.getLoanSchemeId())) {
	    			errors.reject("loanSchemeIdDetails.missing","All details for creating loan scheme are required");
	    			break;
	    		} else if(StringUtils.isEmpty(req.getLoanSchemeNameKeyword())) {
	    			errors.reject("loanSchemeKeyWordsDetails.missing","All details for creating loan scheme are required");
	    			break;
	    		} else if(StringUtils.isEmpty(req.getClientLoanSchemeName())) {
	    			errors.reject("loanSchemeNameDetails.missing","All details for creating loan scheme are required");
	    			break;
	    		} 
	    	}
	    	
	    }
	}

}
