/**
 * 
 */
package com.bankMitra.repository.clientManagement;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.ClientManagementDashBoardTaskRequest;
import com.bankMitra.model.clientManagement.response.ClientManagementDashBoardTaskResponse;

/**
 * @author Bank Maitra
 *
 */
public interface ClientMmanagmentDashboardRepository {

	List<ClientManagementDashBoardTaskResponse> getClientAvailableDashBoardTask() throws DataAccessException;

	ClientManagementDashBoardTaskResponse updateDashBoardTask(
			@Valid ClientManagementDashBoardTaskRequest clientManagementDashBoardTaskRequest) throws DataAccessException;

	ClientManagementDashBoardTaskResponse getTaskDetails(ClientManagementDashBoardTaskRequest dashBoardTaskRequest) throws DataAccessException;

}
