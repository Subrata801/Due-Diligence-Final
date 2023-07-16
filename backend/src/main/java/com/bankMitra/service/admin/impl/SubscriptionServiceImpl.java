/**
 * 
 */
package com.bankMitra.service.admin.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.admin.SubscriptionModel;
import com.bankMitra.model.admin.SubscriptionSearchRequest;
import com.bankMitra.model.admin.response.SubscriptionModelResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.subscription.SubscriptionRequest;
import com.bankMitra.model.subscription.response.SubscriptionResponse;
import com.bankMitra.repository.admin.SubscriptionRepository;
import com.bankMitra.service.admin.SubscriptionService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author BankMitra
 *
 */
@Service
public class SubscriptionServiceImpl implements SubscriptionService {
	
	@Autowired
	SubscriptionRepository subscriptionRepo;
	
	@Autowired
	ReferenceService refService;

	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.SubscriptionService#createSubscription(com.bankMitra.model.subscription.SubscriptionRequest)
	 */
	@Override
	@Transactional
	public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws APIException {
		SubscriptionResponse subscriptionResponse = null;
		try {
			subscriptionResponse  =  subscriptionRepo.createSubscription(subscriptionRequest);
			final String dbResponseCode = subscriptionResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				subscriptionResponse.setMessageCode(filteredMsgData.getMessageCode());
				subscriptionResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_SUBSCRIPTION_FAILURE);
		}
		return subscriptionResponse;
	}
	
	private MessageCode getMessageDescription(String dbResponseCode) throws ResourceNotFoundException {
		MessageCode msgOutPut = null;
		List<MessageCode> msgCodes = refService.getListOfMessageCode();
		for(MessageCode msg : msgCodes) {
			if(msg.getMessageCode().equalsIgnoreCase(dbResponseCode)) {
				msgOutPut =  msg;
				break;
			}
		}
		return msgOutPut;
	}

	@Override
	@Transactional(readOnly=true)
	public List<SubscriptionModelResponse> getListOfSubscriptionModel(SubscriptionModel subscriptionModel) throws APIException {
		List<SubscriptionModelResponse> listOfSubscription = null;
		try {
			listOfSubscription = subscriptionRepo.getListOfSubscriptionModel(subscriptionModel);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_SUBSCRIPTION_MODEL_FAILURE);
		}
		return listOfSubscription;
	}

	@Override
	@Transactional(readOnly=true)
	public List<SubscriptionResponse> getListOfSubscriptions(SubscriptionSearchRequest searchUserRequest)
			throws APIException {
		List<SubscriptionResponse> listOfSubscription = null;
		try {
			listOfSubscription = subscriptionRepo.getListOfSubscriptions(searchUserRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_SUBSCRIPTION_LIST_FAILURE);
		}
		return listOfSubscription;
	}

}
