/**
 * 
 */
package com.bankMitra.service.clientManagement;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest;
import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;

/**
 * @author BankMitra
 *
 */
public interface CreateAuditFirmUserService {

	CreateAuditFirmUserResponse createAuditFirmUser(@Valid CreateAuditFirmUserRequest createAuditFirmUserRequest) throws APIException;

	CreateAuditFirmUserResponse getAuditFirmUser(@Valid CreateAuditFirmUserRequest createAuditFirmUserRequest) throws APIException;

	List<CreateAuditFirmUserResponse> getAllAuditFirmUser(@Valid CreateAuditFirmUserRequest createAuditFirmUserRequest) throws APIException;
	
}