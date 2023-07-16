/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.SubscriptionSearchRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class SearchSubscriptionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SubscriptionSearchRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
				
		SubscriptionSearchRequest searchSubscription = (SubscriptionSearchRequest) target;
		if(StringUtils.isEmpty(searchSubscription.getProductTypeId()) &&
				StringUtils.isEmpty(searchSubscription.getSubscriptionTypeId()) &&
				StringUtils.isEmpty(searchSubscription.getSubscriptionSubTypeId())) {
			if(StringUtils.isEmpty(searchSubscription.getSubscriptionId())) 
				errors.reject("searchCriteria.missing","Product,Subscription Type and Subscription Sub Type is required");
	    } 
		
	}
}
