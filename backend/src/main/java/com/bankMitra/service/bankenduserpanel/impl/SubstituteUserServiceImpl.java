/**
 * 
 */
package com.bankMitra.service.bankenduserpanel.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.bankenduserpanel.request.SubstituteUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationResponse;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserApplicationResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.bankenduserpanel.SubstituteUserRepository;
import com.bankMitra.service.bankenduserpanel.SubstituteUserService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Service
public class SubstituteUserServiceImpl implements SubstituteUserService {

	@Autowired
	SubstituteUserRepository substituteUserRepo;
	
	@Autowired
	ReferenceService refService;
	
	
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
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.bankenduserpanel.SubstituteUserService#substituteUser(com.bankMitra.model.bankenduserpanel.request.SubstituteUserApplicationRequest)
	 */
	@Override
	@Transactional
	public SubstituteUserApplicationResponse substituteUser(
			@Valid SubstituteUserApplicationRequest substituteUserApplicationRequest) throws APIException {
		SubstituteUserApplicationResponse substituteUserApplicationResponse = null;
		try {
			substituteUserApplicationResponse  =  substituteUserRepo.substituteUser(substituteUserApplicationRequest);
			final String dbResponseCode = substituteUserApplicationResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				substituteUserApplicationResponse.setMessageCode(filteredMsgData.getMessageCode());
				substituteUserApplicationResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_SUBSTITUTE_USER_FAILURE);
		}
		return substituteUserApplicationResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public List<SubstituteUserApplicationResponse> getAllSubstituteUserList(
			SubstituteUserApplicationRequest substituteUserApplicationRequest) throws APIException {
		List<SubstituteUserApplicationResponse> listOfUsers = null;
		try {
			listOfUsers = substituteUserRepo.getAllSubstituteUserList(substituteUserApplicationRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_USERS_FAILURE);
		}
		return listOfUsers;
	}

}
