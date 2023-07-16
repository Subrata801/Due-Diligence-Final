/**
 * 
 */
package com.bankMitra.service.bankenduserpanel;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2ERealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2ERealTimeDashboardResponse;

/**
 * @author Bank Maitra
 *
 */
public interface E2ERealTimeDashboardService {

	List<E2ERealTimeDashboardResponse> getE2ERealTimeDashboardTasks(
			@Valid E2ERealTimeDashboardRequest e2eDashboardRequest) throws APIException;

	E2ERealTimeDashboardResponse getDashBoardHeaders(@Valid E2ERealTimeDashboardRequest e2eDashboardRequest) throws APIException;

	DashboardBankDetailResponse getDashboardBankDetails(@Valid E2EDashboardRequest e2eDashboardRequest) throws APIException;

}
