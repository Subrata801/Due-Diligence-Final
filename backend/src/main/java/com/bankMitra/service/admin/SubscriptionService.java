/**
 * 
 */
package com.bankMitra.service.admin;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.admin.SubscriptionModel;
import com.bankMitra.model.admin.SubscriptionSearchRequest;
import com.bankMitra.model.admin.response.SubscriptionModelResponse;
import com.bankMitra.model.subscription.SubscriptionRequest;
import com.bankMitra.model.subscription.response.SubscriptionResponse;

/**
 * @author BankMitra
 *
 */
public interface SubscriptionService {

	SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws APIException;

	List<SubscriptionModelResponse> getListOfSubscriptionModel(@Valid SubscriptionModel subscriptionModel) throws APIException;

	List<SubscriptionResponse> getListOfSubscriptions(SubscriptionSearchRequest searchUserRequest)  throws APIException;

}
