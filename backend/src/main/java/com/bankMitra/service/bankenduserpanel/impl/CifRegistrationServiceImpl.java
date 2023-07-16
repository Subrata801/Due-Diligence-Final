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
import com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest;
import com.bankMitra.model.bankenduserpanel.response.CifRegistrationResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.bankenduserpanel.CifRegistrationRepository;
import com.bankMitra.service.bankenduserpanel.CifRegistrationService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Service
public class CifRegistrationServiceImpl implements CifRegistrationService {

	@Autowired
	CifRegistrationRepository cifRegistrationRepo;
	
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
	 * @see com.bankMitra.service.bankenduserpanel.CifRegistrationService#register(com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest)
	 */
	@Override
	@Transactional
	public CifRegistrationResponse register(@Valid CifRegistrationRequest cifRegistrationRequest) throws APIException {
		CifRegistrationResponse cifRegistrationResponse = null;
		try {
			cifRegistrationResponse  =  cifRegistrationRepo.registerCIF(cifRegistrationRequest);
			final String dbResponseCode = cifRegistrationResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				cifRegistrationResponse.setMessageCode(filteredMsgData.getMessageCode());
				cifRegistrationResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_REGISTER_CIF_FAILURE);
		}
		return cifRegistrationResponse;
	}

}
