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
import com.bankMitra.model.bankenduserpanel.request.CNCDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.CNCRealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.CNCDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.CNCRealTimeDashboardResponse;
import com.bankMitra.repository.bankenduserpanel.CNCDashboardRepository;
import com.bankMitra.service.bankenduserpanel.CNCDashboardService;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Service
public class CNCDashboardServiceImpl implements CNCDashboardService {

	@Autowired
	CNCDashboardRepository cncDashboardRepo;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.bankenduserpanel.CNCDashboardService#getAllDashboardData(com.bankMitra.model.bankenduserpanel.request.CNCDashboardRequest)
	 */
	@Override
	@Transactional(readOnly=true)
	public List<CNCDashboardResponse> getAllDashboardData(@Valid CNCDashboardRequest cncDashboardRequest)
			throws APIException {
		List<CNCDashboardResponse> listOfDashBoardResponse = null;
		try {
			listOfDashBoardResponse = cncDashboardRepo.getAllDashboardData(cncDashboardRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_DASHBOARDTASKS_FAILURE);
		}
		return listOfDashBoardResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public List<CNCRealTimeDashboardResponse> getAllRealTimeDashboardData(
			CNCRealTimeDashboardRequest cncDashboardRequest) throws APIException {
		List<CNCRealTimeDashboardResponse> listOfDashBoardResponse = null;
		try {
			listOfDashBoardResponse = cncDashboardRepo.getAllRealTimeDashboardData(cncDashboardRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_REALTIME_CNC_DASHBOARDTASKS_FAILURE);
		}
		return listOfDashBoardResponse;
	}

}
