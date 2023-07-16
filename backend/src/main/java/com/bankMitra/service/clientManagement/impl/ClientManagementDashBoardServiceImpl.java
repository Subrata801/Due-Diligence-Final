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
import com.bankMitra.model.clientManagement.request.ClientManagementDashBoardTaskRequest;
import com.bankMitra.model.clientManagement.response.ClientManagementDashBoardTaskResponse;
import com.bankMitra.model.clientManagement.response.CreateUnitResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.clientManagement.ClientMmanagmentDashboardRepository;
import com.bankMitra.service.clientManagement.ClientManagementDashBoardService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author admin
 *
 */
@Service
public class ClientManagementDashBoardServiceImpl implements ClientManagementDashBoardService {

	@Autowired
	ClientMmanagmentDashboardRepository dashboardRepo;
	
	@Autowired
	ReferenceService refService;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.clientManagement.ClientManagementDashBoardService#updateDashBoardTask(com.bankMitra.model.clientManagement.request.ClientManagementDashBoardTaskRequest)
	 */
	@Override
	@Transactional
	public ClientManagementDashBoardTaskResponse updateDashBoardTask(
			@Valid ClientManagementDashBoardTaskRequest clientManagementDashBoardTaskRequest) throws APIException {
		ClientManagementDashBoardTaskResponse taskResponse = null;
		try {
			taskResponse  =  dashboardRepo.updateDashBoardTask(clientManagementDashBoardTaskRequest);
			final String dbResponseCode = taskResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				taskResponse.setMessageCode(filteredMsgData.getMessageCode());
				taskResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_UPDATE_TASK_FAILURE);
		}
		return taskResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientManagementDashBoardTaskResponse> getClientAvailableDashBoardTask() throws APIException {
		List<ClientManagementDashBoardTaskResponse> listOfAvailableTasks = null;
		try {
			listOfAvailableTasks = dashboardRepo.getClientAvailableDashBoardTask();
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_DASHBOARD_TASKS_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_DASHBOARD_TASKS_FAILURE,e.getMessage());
		}
		return listOfAvailableTasks;
	}

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

	@Override
	@Transactional(readOnly=true)
	public ClientManagementDashBoardTaskResponse getTaskDetails(
			ClientManagementDashBoardTaskRequest dashBoardTaskRequest) throws APIException {
		ClientManagementDashBoardTaskResponse taskResponse = null;
		try {
			taskResponse = dashboardRepo.getTaskDetails(dashBoardTaskRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_DASHBOARD_TASK_DETAILS_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_DASHBOARD_TASK_DETAILS_FAILURE,e.getMessage());
		}
		return taskResponse;
	}
}
