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
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2ERealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2ERealTimeDashboardResponse;
import com.bankMitra.repository.bankenduserpanel.E2ERealTimeDashboardRepository;
import com.bankMitra.service.bankenduserpanel.E2ERealTimeDashboardService;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Service
public class E2ERealTimeDashboardServiceImpl implements E2ERealTimeDashboardService {

	@Autowired
	E2ERealTimeDashboardRepository e2eDashboardRepo;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.bankenduserpanel.E2ERealTimeDashboardService#getE2ERealTimeDashboardTasks(com.bankMitra.model.bankenduserpanel.request.E2ERealTimeDashboardRequest)
	 */
	@Override
	@Transactional(readOnly=true)
	public List<E2ERealTimeDashboardResponse> getE2ERealTimeDashboardTasks(
			@Valid E2ERealTimeDashboardRequest e2eDashboardRequest) throws APIException {
		List<E2ERealTimeDashboardResponse> listOfDashBoardResponse = null;
		try {
			listOfDashBoardResponse = e2eDashboardRepo.getE2ERealTimeDashboardTasks(e2eDashboardRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_DASHBOARDTASKS_FAILURE);
		}
		return listOfDashBoardResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public E2ERealTimeDashboardResponse getDashBoardHeaders(E2ERealTimeDashboardRequest e2eDashboardRequest)
			throws APIException {
		E2ERealTimeDashboardResponse bankDetailResponse = null;
		try {
			bankDetailResponse = e2eDashboardRepo.getDashBoardHeaders(e2eDashboardRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_BANKDETAILS_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_BANKDETAILS_FAILURE,e.getMessage());
		}
		return bankDetailResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public DashboardBankDetailResponse getDashboardBankDetails(E2EDashboardRequest e2eDashboardRequest)
			throws APIException {
		DashboardBankDetailResponse bankDetailResponse = null;
		try {
			bankDetailResponse = e2eDashboardRepo.getDashboardBankDetails(e2eDashboardRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_BANKDETAILS_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_BANKDETAILS_FAILURE,e.getMessage());
		}
		return bankDetailResponse;
	}

}
