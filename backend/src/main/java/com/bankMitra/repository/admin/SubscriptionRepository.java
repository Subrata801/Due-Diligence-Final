/**
 * 
 */
package com.bankMitra.repository.admin;

import java.util.List;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.SubscriptionModel;
import com.bankMitra.model.admin.SubscriptionSearchRequest;
import com.bankMitra.model.admin.response.SubscriptionModelResponse;
import com.bankMitra.model.subscription.SubscriptionRequest;
import com.bankMitra.model.subscription.response.SubscriptionResponse;

/**
 * @author BankMitra
 *
 */
public interface SubscriptionRepository {

	SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws DataAccessException;

	List<SubscriptionModelResponse> getListOfSubscriptionModel(SubscriptionModel subscriptionModel) throws DataAccessException;

	List<SubscriptionResponse> getListOfSubscriptions(SubscriptionSearchRequest searchUserRequest) throws DataAccessException;

}
