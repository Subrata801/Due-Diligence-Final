/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.CNCDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.CNCRealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.CNCDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.CNCRealTimeDashboardResponse;

/**
 * @author Bank Maitra
 *
 */
public interface CNCDashboardRepository {

	List<CNCDashboardResponse> getAllDashboardData(@Valid CNCDashboardRequest cncDashboardRequest) throws DataAccessException;

	List<CNCRealTimeDashboardResponse> getAllRealTimeDashboardData(CNCRealTimeDashboardRequest cncDashboardRequest) throws DataAccessException;

}
