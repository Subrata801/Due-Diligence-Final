/**
 * 
 */
package com.bankMitra.repository.clientManagement;

import java.util.List;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest;
import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;

/**
 * @author Bank Maitra
 *
 */
public interface CreateAuditFirmUserRepository {

	CreateAuditFirmUserResponse createAuditFirmUser(CreateAuditFirmUserRequest createAuditFirmRequest) throws DataAccessException;

	CreateAuditFirmUserResponse getAuditFirmUser(CreateAuditFirmUserRequest createAuditFirmRequest) throws DataAccessException;
	
	List<CreateAuditFirmUserResponse> getAllAuditFirmUsers(CreateAuditFirmUserRequest createAuditFirmRequest) throws DataAccessException;
}
