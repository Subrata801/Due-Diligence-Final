/**
 * 
 */
package com.bankMitra.service.bankenduserpanel;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.bankenduserpanel.request.CNCDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.CNCRealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.CNCDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.CNCRealTimeDashboardResponse;

/**
 * @author Bank Maitra
 *
 */
public interface CNCDashboardService {

	List<CNCDashboardResponse> getAllDashboardData(@Valid CNCDashboardRequest cncDashboardRequest) throws APIException;

	List<CNCRealTimeDashboardResponse> getAllRealTimeDashboardData(
			@Valid CNCRealTimeDashboardRequest cncDashboardRequest) throws APIException;

}
