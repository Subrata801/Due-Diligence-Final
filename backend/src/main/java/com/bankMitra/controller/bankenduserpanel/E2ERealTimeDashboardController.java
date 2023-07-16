/**
 * 
 */
package com.bankMitra.controller.bankenduserpanel;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2ERealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2ERealTimeDashboardResponse;
import com.bankMitra.model.clientManagement.request.ClientManagementDashBoardTaskRequest;
import com.bankMitra.model.clientManagement.response.ClientManagementDashBoardTaskResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.bankenduserpanel.E2ERealTimeDashboardService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.E2ERealTimeDetailValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bank Maitra
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/e2eRealtimeDashboard")
public class E2ERealTimeDashboardController {

	private static final Logger logger = LoggerFactory.getLogger(E2ERealTimeDashboardController.class);
	
	@Autowired
	E2ERealTimeDashboardService e2eDashboardService;
	
	@Autowired
	E2ERealTimeDetailValidator e2eDetailValidator;
	
	@ApiOperation(value = "Get E2E Real Time Dashboard tasks", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_GET_E2E_REALTIME_DASHBOARD_TASKS, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<List<E2ERealTimeDashboardResponse>> getE2ERealTimeDashboardTasks
	(@Valid @RequestBody E2ERealTimeDashboardRequest e2eDashboardRequest,BindingResult result) throws APIException {
		UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    e2eDashboardRequest.setCreatedBy(userName);
		try {
			List<E2ERealTimeDashboardResponse> e2eDashboardTaskList = e2eDashboardService.getE2ERealTimeDashboardTasks(e2eDashboardRequest);
			if(CollectionUtils.isNotEmpty(e2eDashboardTaskList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all e2e realtime dashboard tasks successfully"),e2eDashboardTaskList);
			} else {
				throw new APIException("No e2edashboard task found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
	}
	
	@ApiOperation(value = "Get e2e dashboard header details",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_E2E_REALTIME_HEADER_DASHBOARD, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<E2ERealTimeDashboardResponse> getDashBoardHeaders(@Valid @RequestBody E2ERealTimeDashboardRequest e2eDashboardRequest)
    		throws ResourceNotFoundException, APIException{
		E2ERealTimeDashboardResponse dashBoardHeaderResponse = e2eDashboardService.getDashBoardHeaders(e2eDashboardRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved headers of e2e real time dashboard successfully"),dashBoardHeaderResponse);
        
    }
	
	@ApiOperation(value = "Get Bank Details", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_GET_DASHBOARD_REALTIME_BANK_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<DashboardBankDetailResponse> getDashboardBankDetails
	(@Valid @RequestBody E2EDashboardRequest e2eDashboardRequest,BindingResult result) throws APIException {
		UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    e2eDashboardRequest.setCreatedBy(userName);
		DashboardBankDetailResponse bankDetailResponse = e2eDashboardService.getDashboardBankDetails(e2eDashboardRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved bank details successfully"),bankDetailResponse);
	}
}