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
import com.bankMitra.model.clientManagement.request.CreateUnitRequest;
import com.bankMitra.model.clientManagement.response.BranchUserResponse;
import com.bankMitra.model.clientManagement.response.CreateUnitResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.clientManagement.CreateUnitRepository;
import com.bankMitra.service.clientManagement.CreateUnitService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Service
public class CreateUnitServiceImpl implements CreateUnitService {

	@Autowired
	CreateUnitRepository createUnitRepo;
	
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
	 * @see com.bankMitra.service.clientManagement.CreateUnitService#createUnit(com.bankMitra.model.clientManagement.request.CreateUnitRequest)
	 */
	@Override
	@Transactional
	public CreateUnitResponse createUnit(@Valid CreateUnitRequest createUnitRequest) throws APIException {
		CreateUnitResponse createUnitResponse = null;
		try {
			createUnitResponse  =  createUnitRepo.createUnit(createUnitRequest);
			final String dbResponseCode = createUnitResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				createUnitResponse.setMessageCode(filteredMsgData.getMessageCode());
				createUnitResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_UNIT_FAILURE);
		}
		return createUnitResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.clientManagement.CreateUnitService#getClientUnit(com.bankMitra.model.clientManagement.request.CreateUnitRequest)
	 */
	@Override
	@Transactional(readOnly=true)
	public CreateUnitResponse getClientUnit(@Valid CreateUnitRequest createUnitRequest) throws APIException {
		CreateUnitResponse unit = null;
		try {
			unit = createUnitRepo.getUnit(createUnitRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_UNIT_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_UNIT_FAILURE,e.getMessage());
		}
		return unit;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.clientManagement.CreateUnitService#getAllClientUnit(com.bankMitra.model.clientManagement.request.CreateUnitRequest)
	 */
	@Override
	@Transactional(readOnly=true)
	public List<CreateUnitResponse> getAllClientUnit(@Valid CreateUnitRequest createUnitRequest) throws APIException {
		List<CreateUnitResponse> listOfUnit = null;
		try {
			listOfUnit = createUnitRepo.getAllUnits(createUnitRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_UNITS_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_UNITS_FAILURE,e.getMessage());
		}
		return listOfUnit;
	}

}
