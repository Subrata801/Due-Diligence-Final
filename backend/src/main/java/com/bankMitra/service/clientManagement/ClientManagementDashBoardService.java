/**
 * 
 */
package com.bankMitra.service.clientManagement;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.clientManagement.request.ClientManagementDashBoardTaskRequest;
import com.bankMitra.model.clientManagement.response.ClientManagementDashBoardTaskResponse;


/**
 * @author BankMitra
 *
 */
public interface ClientManagementDashBoardService {

	ClientManagementDashBoardTaskResponse updateDashBoardTask(@Valid ClientManagementDashBoardTaskRequest clientManagementDashBoardTaskRequest) throws APIException;

	List<ClientManagementDashBoardTaskResponse> getClientAvailableDashBoardTask() throws APIException;

	ClientManagementDashBoardTaskResponse getTaskDetails(
			@Valid ClientManagementDashBoardTaskRequest dashBoardTaskRequest)  throws APIException;
	
}