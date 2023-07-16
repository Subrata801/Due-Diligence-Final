/**
 * 
 */
package com.bankMitra.validator;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.ClientNewSubscriptionRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CreateClientSubscriptionVariantValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClientNewSubscriptionRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*ValidationUtils.rejectIfEmpty(errors,
                "clientName","clientName.key", "Client Name is required");*/
		
				
		ClientNewSubscriptionRequest clientSubscriptionRequest = (ClientNewSubscriptionRequest) target;
		
		if(StringUtils.isEmpty(clientSubscriptionRequest.getProductTypeId())) {
	    	errors.reject("productType.missing","Product is required");
	    }
		
		if(StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionTypeId())) {
	    	errors.reject("subscriptionType.missing","Subscription Type is required");
	    }
		
		if(StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionSubTypeId())) {
	    	errors.reject("subscriptionSubType.missing","Subscription Sub Type is required");
	    }
		
		if(StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionModelId())) {
	    	errors.reject("subscriptionModel.missing","Subscription Model is required");
	    }
		
	}

}
