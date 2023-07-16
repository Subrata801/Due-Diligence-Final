/**
 * 
 */
package com.bankMitra.validator;


import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.ClientConfigRequest;
import com.bankMitra.model.admin.ClientLoanVariantRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CreateClientLoanVariantValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClientConfigRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*ValidationUtils.rejectIfEmpty(errors,
                "clientName","clientName.key", "Client Name is required");*/
		
				
		ClientConfigRequest clientConfigRequest = (ClientConfigRequest) target;
		if(CollectionUtils.isEmpty(clientConfigRequest.getLoanSchemeVariantDetails())) {
	    	errors.reject("loanVariantDetails.missing","Loan Variant details are required");
	    } else if(!CollectionUtils.isEmpty(clientConfigRequest.getLoanSchemeVariantDetails()) && clientConfigRequest.getLoanSchemeVariantDetails().size() > 0) {
	    	for(ClientLoanVariantRequest req : clientConfigRequest.getLoanSchemeVariantDetails()) {
	    		if(StringUtils.isEmpty(req.getLoanSchemeId())) {
	    			errors.reject("loanVariantSchemeDetails.missing","All details for creating loan variant are required");
	    			break;
	    		} else if(StringUtils.isEmpty(req.getLoanVariantId())) {
	    			errors.reject("loanVariantIdDetails.missing","All details for creating loan variant are required");
	    			break;
	    		} else if(StringUtils.isEmpty(req.getLoanVariantKeyword())) {
	    			errors.reject("loanVariantKeywordDetails.missing","All details for creating loan variant are required");
	    			break;
	    		} /*else if(StringUtils.isEmpty(req.getPreferefLoanVariantName())) {
	    			errors.reject("loanVariantPreferedNames.missing","All details for creating loan variant are required");
	    			break;
	    		} */
	    	}
	    	
	    }
		
		
		
	}

}
