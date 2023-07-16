/**
 * 
 */
package com.bankMitra.service.bankenduserpanel.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.bankenduserpanel.request.ReassignUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.request.SaveReassignUserRequest;
import com.bankMitra.model.bankenduserpanel.response.Checkers;
import com.bankMitra.model.bankenduserpanel.response.Makers;
import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationResponse;
import com.bankMitra.model.bankenduserpanel.response.SanctionAuthority;
import com.bankMitra.model.bankenduserpanel.response.SaveReassignUserResponse;
import com.bankMitra.model.bankenduserpanel.response.SaveViewDDResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.bankenduserpanel.ReassignUserRepository;
import com.bankMitra.service.bankenduserpanel.ReassignUserService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Service
public class ReassignUserServiceImpl implements ReassignUserService {
	private static final Logger logger = LoggerFactory.getLogger(ReassignUserServiceImpl.class);
	@Autowired
	ReassignUserRepository reassignUserRepo;
	
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
	 * @see com.bankMitra.service.bankenduserpanel.ReassignUserService#reassignUser(com.bankMitra.model.bankenduserpanel.request.ReassignUserApplicationRequest)
	 */
	@Override
	@Transactional
	public ReassignUserApplicationResponse reassignUser(
			@Valid ReassignUserApplicationRequest reassignUserApplicationRequest) throws APIException {
		ReassignUserApplicationResponse reassignUserApplicationResponse = null;
		try {
			reassignUserApplicationResponse  =  reassignUserRepo.reassignUser(reassignUserApplicationRequest);
			final String dbResponseCode = reassignUserApplicationResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				reassignUserApplicationResponse.setMessageCode(filteredMsgData.getMessageCode());
				reassignUserApplicationResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_REASSIGN_USER_FAILURE);
		}
		return reassignUserApplicationResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ReassignUserApplicationResponse> getAllUserList(
			ReassignUserApplicationRequest reassignUserApplicationRequest) throws APIException {
		List<ReassignUserApplicationResponse> listOfUsers = null;
		try {
			listOfUsers = reassignUserRepo.getAllUserList(reassignUserApplicationRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_REASSIGNUSERS_TASKS_FAILURE);
		}
		return listOfUsers;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Makers> getListOfMakers(String clientGroupId) throws APIException {
		List<Makers> makersList = null;
		try {
			makersList = reassignUserRepo.getListOfMakers(clientGroupId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_MAKERS_FAILURE);
		} 
		if(!Optional.ofNullable(makersList).isPresent() || makersList.isEmpty() )
			makersList = new ArrayList<Makers>();
		
		return makersList;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Checkers> getListOfCheckers(String clientGroupId) throws APIException {
		List<Checkers> checkersList = null;
		try {
			checkersList = reassignUserRepo.getListOfCheckers(clientGroupId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_CHECKERS_FAILURE);
		} 
		if(!Optional.ofNullable(checkersList).isPresent() || checkersList.isEmpty() )
			checkersList = new ArrayList<Checkers>();
		
		return checkersList;
	}

	@Override
	@Transactional(readOnly=true)
	public List<SanctionAuthority> getListOfSanctioningAuthority(String clientGroupId,String zoClientGroupId, String hoClientGroupId, String cpcClientGroupId) throws APIException {
		List<SanctionAuthority> saList = null;
		try {
			saList = reassignUserRepo.getListOfSanctioningAuthority(clientGroupId, zoClientGroupId, hoClientGroupId, cpcClientGroupId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_SA_FAILURE);
		} 
		if(!Optional.ofNullable(saList).isPresent() || saList.isEmpty() )
			saList = new ArrayList<SanctionAuthority>();
		
		return saList;
	}

	public SaveReassignUserResponse saveReassignUser(SaveReassignUserRequest saveReassignUserRequest) throws APIException {
		SaveReassignUserResponse response = null;
		try {
			response = reassignUserRepo.saveReassignUserDB(saveReassignUserRequest);
			final String dbResponseCode = response.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				response.setMessageCode(filteredMsgData.getMessageCode());
				response.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (Exception e) {
			logger.error("ReassignUserServiceImpl::saveReassignUser:error occurred with message::{}",e.getMessage()+e);
			throw new APIException("Error occurred while saving reassign user");
		}
		return response;
	}
}
