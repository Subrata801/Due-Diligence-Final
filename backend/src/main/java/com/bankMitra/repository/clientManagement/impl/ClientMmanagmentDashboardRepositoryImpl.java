/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.ClientManagementDashBoardTaskRequest;
import com.bankMitra.model.clientManagement.response.ClientManagementDashBoardTaskResponse;
import com.bankMitra.repository.clientManagement.ClientMmanagmentDashboardRepository;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class ClientMmanagmentDashboardRepositoryImpl implements ClientMmanagmentDashboardRepository {

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.ClientMmanagmentDashboardRepository#getClientAvailableDashBoardTask()
	 */
	@Override
	public List<ClientManagementDashBoardTaskResponse> getClientAvailableDashBoardTask() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientManagementDashBoardTaskResponse updateDashBoardTask(
			ClientManagementDashBoardTaskRequest clientManagementDashBoardTaskRequest) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientManagementDashBoardTaskResponse getTaskDetails(
			ClientManagementDashBoardTaskRequest dashBoardTaskRequest) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
