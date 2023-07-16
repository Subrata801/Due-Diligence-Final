/**
 * 
 */
package com.bankMitra.validator;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.ClientSubscriptionRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class UpdateClientSubscriptionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClientSubscriptionRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*ValidationUtils.rejectIfEmpty(errors,
                "clientName","clientName.key", "Client Name is required");*/
		
				
		ClientSubscriptionRequest clientSubscriptionRequest = (ClientSubscriptionRequest) target;
		
		if(!StringUtils.isEmpty(clientSubscriptionRequest.getTypeofrequest())  &&
				clientSubscriptionRequest.getTypeofrequest().equalsIgnoreCase("basicDetails")) {
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
			
		} if(!StringUtils.isEmpty(clientSubscriptionRequest.getTypeofrequest())  &&
				clientSubscriptionRequest.getTypeofrequest().equalsIgnoreCase("renewDetails")) {
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
			
			if(StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionStartDate())){
		    	errors.reject("subscriptionStartDate.missing","Subscription Start date is required");
		    }
			
			if(StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionEndDate())){
		    	errors.reject("subscriptionEndDate.missing","Subscription End date is required");
		    }
			
			
		} else {
			if(StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionStartDate())
					&& !StringUtils.isEmpty(clientSubscriptionRequest.getTypeofrequest())  &&
					clientSubscriptionRequest.getTypeofrequest().equalsIgnoreCase("completeDetails")){
		    	errors.reject("subscriptionStartDate.missing","Subscription Start date is required");
		    }
		}
		
		/*if(StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionEndDate())) {
	    	errors.reject("subscriptionEndDate.missing","Subscription End date is required");
	    }
		
		if(StringUtils.isEmpty(clientSubscriptionRequest.getRenewalReminderDate())) {
	    	errors.reject("subscriptionRenewalDate.missing","Subscription Renewal date is required");
	    }*/
		
	}

}
