/**
 * 
 */
package com.bankMitra.validator;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.ClientNewSubscriptionRequest;
import com.bankMitra.model.subscription.SubscriptionRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CreateAdminSubscriptionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SubscriptionRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		/*ValidationUtils.rejectIfEmpty(errors,
                "clientName","clientName.key", "Client Name is required");*/
		
				
		SubscriptionRequest subscriptionRequest = (SubscriptionRequest) target;
		
		if(StringUtils.isEmpty(subscriptionRequest.getProductTypeId())) {
	    	errors.reject("productType.missing","Product is required");
	    }
		
		if(StringUtils.isEmpty(subscriptionRequest.getSubscriptionTypeId())) {
	    	errors.reject("subscriptionType.missing","Subscription Type is required");
	    }
		
		if(StringUtils.isEmpty(subscriptionRequest.getSubscriptionSubTypeId())) {
	    	errors.reject("subscriptionSubType.missing","Subscription Sub Type is required");
	    }
		
		if(StringUtils.isEmpty(subscriptionRequest.getSubscriptionName())) {
	    	errors.reject("subscriptionname.missing","Subscription Name is required");
	    }
		
		if(StringUtils.isEmpty(subscriptionRequest.getSubscriptionPeriod())) {
	    	errors.reject("subscriptionperiod.missing","Subscription Period is required");
	    }
		
		if(!StringUtils.isEmpty(subscriptionRequest.getProductTypeId()) &&
				1 == subscriptionRequest.getProductTypeId() && StringUtils.isEmpty(subscriptionRequest.getMaxBranches())) {
	    	errors.reject("subscriptionmaxbranch.missing","Max number of branches is required");
	    }
		
		if(!StringUtils.isEmpty(subscriptionRequest.getProductTypeId()) &&
				1 == subscriptionRequest.getProductTypeId() &&  
				StringUtils.isEmpty(subscriptionRequest.getMaxNumOfLoanSchemes())) {
	    	errors.reject("subscriptionmaxloanschemes.missing","Max no.of loan scheme is required");
	    }
		
		/*if(StringUtils.isEmpty(subscriptionRequest.getMaxBanks())) {
	    	errors.reject("subscriptionmaxbanks.missing","Max no.of banks is required");
	    }*/
		
		if(StringUtils.isEmpty(subscriptionRequest.getRenewalReminderDate())) {
	    	errors.reject("subscriptionreminderdate.missing","Renewal reminder activation is required");
	    }
		
		if(StringUtils.isEmpty(subscriptionRequest.getDataValidityPeriod())) {
	    	errors.reject("subscriptiondatavalidity.missing","Data validity period is required");
	    }
		
		if(StringUtils.isEmpty(subscriptionRequest.getPricePerMonth())) {
	    	errors.reject("subscriptionprice.missing","Price per month is required");
	    }
		
	}

}
