/**
 * 
 */
package com.bankMitra.controller.bankenduserpanel;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.bankenduserpanel.request.CNCRealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.CNCRealTimeDashboardResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.service.bankenduserpanel.CNCDashboardService;
import com.bankMitra.util.APIConstant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BankMitra
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cncrealtimedashboard")
public class CNCRealTimeDashboardController {

	private static final Logger logger = LoggerFactory.getLogger(CNCRealTimeDashboardController.class);
	
	@Autowired
	CNCDashboardService cncDashboardService;
	
	@ApiOperation(value = "Get CNC Real Time Dashboard tasks", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_GET_CNC_REALTIME_DASHBOARD_TASKS, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<List<CNCRealTimeDashboardResponse>> getE2EDashboardTasks
	(@Valid @RequestBody CNCRealTimeDashboardRequest cncDashboardRequest,BindingResult result) throws APIException {

		try {
			List<CNCRealTimeDashboardResponse> cncDashboardTaskList = cncDashboardService.getAllRealTimeDashboardData(cncDashboardRequest);
			if(CollectionUtils.isNotEmpty(cncDashboardTaskList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all real time cncdashboard tasks successfully"),cncDashboardTaskList);
			} else {
				throw new APIException("No cncdashboard task found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
	}
}