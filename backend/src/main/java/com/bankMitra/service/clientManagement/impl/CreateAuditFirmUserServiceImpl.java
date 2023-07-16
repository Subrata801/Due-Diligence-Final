/**
 * 
 */
package com.bankMitra.service.clientManagement.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest;
import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.clientManagement.CreateAuditFirmUserRepository;
import com.bankMitra.service.clientManagement.CreateAuditFirmUserService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Service
public class CreateAuditFirmUserServiceImpl implements CreateAuditFirmUserService {

	@Autowired
	CreateAuditFirmUserRepository createAuditFirmUserRepo;
	
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
	 * @see com.bankMitra.service.clientManagement.CreateAuditFirmUserService#createAuditFirmUser(com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest)
	 */
	@Override
	@Transactional
	public CreateAuditFirmUserResponse createAuditFirmUser(@Valid CreateAuditFirmUserRequest createAuditFirmUserRequest)
			throws APIException {
		CreateAuditFirmUserResponse createAuditFirmUserResponse = null;
		try {
			createAuditFirmUserResponse  =  createAuditFirmUserRepo.createAuditFirmUser(createAuditFirmUserRequest);
			final String dbResponseCode = createAuditFirmUserResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				createAuditFirmUserResponse.setMessageCode(filteredMsgData.getMessageCode());
				createAuditFirmUserResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_AUDIT_FIRM_USER_FAILURE);
		}
		return createAuditFirmUserResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.clientManagement.CreateAuditFirmUserService#getAuditFirmUser(com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest)
	 */
	@Override
	@Transactional(readOnly=true)
	public CreateAuditFirmUserResponse getAuditFirmUser(@Valid CreateAuditFirmUserRequest createAuditFirmUserRequest)
			throws APIException {
		CreateAuditFirmUserResponse auditFirmUser = null;
		try {
			auditFirmUser = createAuditFirmUserRepo.getAuditFirmUser(createAuditFirmUserRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_AUDIT_FIRM_USERS_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_AUDIT_FIRM_USERS_FAILURE,e.getMessage());
		}
		return auditFirmUser;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.clientManagement.CreateAuditFirmUserService#getAllAuditFirmUser(com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest)
	 */
	@Override
	@Transactional(readOnly=true)
	public List<CreateAuditFirmUserResponse> getAllAuditFirmUser(
			@Valid CreateAuditFirmUserRequest createAuditFirmUserRequest) throws APIException {
		List<CreateAuditFirmUserResponse> listOfAuditFirmUsers = null;
		try {
			listOfAuditFirmUsers = createAuditFirmUserRepo.getAllAuditFirmUsers(createAuditFirmUserRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_AUDIT_FIRM_USERS_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_AUDIT_FIRM_USERS_FAILURE,e.getMessage());
		}
		return listOfAuditFirmUsers;
	}

}
