/**
 * 
 */
package com.bankMitra.validator;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.BankDetails;
import com.bankMitra.model.admin.ClientAuditFirmBankRequest;
import com.bankMitra.model.admin.ClientLoanVariantRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class AddBankValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClientAuditFirmBankRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*ValidationUtils.rejectIfEmpty(errors,
                "clientName","clientName.key", "Client Name is required");*/
		
				
		ClientAuditFirmBankRequest addBank = (ClientAuditFirmBankRequest) target;
		if(CollectionUtils.isEmpty(addBank.getBankInfo())) {
	    	errors.reject("addBank.missing","Bank details are required");
	    } else if(!CollectionUtils.isEmpty(addBank.getBankInfo()) && addBank.getBankInfo().size() > 0) {
	    	for(BankDetails req : addBank.getBankInfo()) {
	    		if(StringUtils.isEmpty(req.getBankName())) {
	    			errors.reject("bankname.missing","Bank name is required for all added banks");
	    			break;
	    		}
	    	}
	    	
	    }
		
	}

}
