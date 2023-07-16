/**
 * 
 */
package com.bankMitra.controller.bankenduserpanel;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2EDetailRequest;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDetailResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.model.user.User;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.bankenduserpanel.E2EDashboardService;
import com.bankMitra.service.user.AuthService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.E2EDetailValidator;

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
@RequestMapping("/e2eDashboardController")
public class E2EDashboardController {

	private static final Logger logger = LoggerFactory.getLogger(CifRegistrationController.class);
	
	@Autowired
	E2EDashboardService e2eDashboardService;
	
	@Autowired
	E2EDetailValidator e2eDetailValidator;
	
	@Autowired
	AuthService authService;
	
	@ApiOperation(value = "Get E2EDashboard tasks", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_GET_E2E_DASHBOARD_TASKS, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<List<E2EDashboardResponse>> getE2EDashboardTasks
	(@Valid @RequestBody E2EDashboardRequest e2eDashboardRequest,BindingResult result) throws APIException {

		try {
			UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String userName = user.getUserName();
		    e2eDashboardRequest.setCreatedBy(userName);
		    
			List<E2EDashboardResponse> e2eDashboardTaskList = e2eDashboardService.getAllDashboardData(e2eDashboardRequest);
			if(CollectionUtils.isNotEmpty(e2eDashboardTaskList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all e2edashboard tasks successfully"),e2eDashboardTaskList);
			} else {
				throw new APIException("No e2edashboard task found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
	}
	
	@ApiOperation(value = "Get Bank Details", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_GET_DASHBOARD_BANK_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<DashboardBankDetailResponse> getDashboardBankDetails
	(@Valid @RequestBody E2EDashboardRequest e2eDashboardRequest,BindingResult result) throws APIException {
		DashboardBankDetailResponse bankDetailResponse = e2eDashboardService.getDashboardBankDetails(e2eDashboardRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved bank details successfully"),bankDetailResponse);
	}
	
    @ApiOperation(value = "Get e2e details",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_E2E_DETAILS, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<E2EDetailResponse> getE2EDetails(@Valid @RequestBody E2EDetailRequest e2eDetailRequest)
    		throws ResourceNotFoundException, APIException{
    	E2EDetailResponse e2eDetailResponse = e2eDashboardService.getE2EDetails(e2eDetailRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved e2e details successfully"),e2eDetailResponse);
        
    }
    
	@ApiOperation(value = "Update E 2 E Details", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_UPDATE_E2E_DETAILS, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<E2EDetailResponse> updatee2eDetails
	(@Valid @RequestBody E2EDetailRequest e2eDetailRequest,BindingResult result) throws APIException {
		e2eDetailValidator.validate(e2eDetailRequest, result);

		if (result.hasErrors()) {
			String errMsg = "";
			for(Object err :result.getAllErrors()) {
        		if(err instanceof ObjectError ) {
        			if(null!=((ObjectError)err).getDefaultMessage())
        				errMsg= errMsg + ((ObjectError)err).getDefaultMessage() + " , ";
        		} else
        			errMsg= errMsg + ((FieldError)err).getDefaultMessage() + " , ";
        	}
			throw new APIException(errMsg.substring(0,errMsg.lastIndexOf(",")));
		}
		UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    e2eDetailRequest.setCreatedBy(userName);
	    E2EDetailResponse e2eDetailResponse = e2eDashboardService.updatee2eDetails(e2eDetailRequest);
		if(null!=e2eDetailResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(e2eDetailResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,e2eDetailResponse.getMessageDescription()),e2eDetailResponse);
		} else {
			throw new APIException(e2eDetailResponse.getMessageDescription());
		}
	}
	
    @ApiOperation(value = "Delete commercial credit facility",notes= "This method is used to delete commercial credit facility")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted loan schemes"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_DELETE_E2E_COMERCIAL_CREDIT_FACILITY, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<E2EDetailResponse> deleteCommercialCreditFacility(@Valid @RequestBody E2EDetailRequest e2eDetailRequest) throws APIException {
    	E2EDetailResponse e2eDetailResponse = e2eDashboardService.deleteCommercialCreditFacility(e2eDetailRequest);
		if(null!=e2eDetailResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(e2eDetailResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully deleted commercial facility"),e2eDetailResponse);
		} else {
			throw new APIException(e2eDetailResponse.getMessageDescription());
		} 
	}
    
    @RequestMapping(value = APIConstant.SERVICE_E2E_FULL_REPORT, method= RequestMethod.GET, produces = "application/json")
    public @ResponseBody ResponseEntity<byte[]> getE2EFullReport(@RequestParam(value = "e2eNum",required=true)String e2eNum,
    		@RequestParam(value = "moduleNum",required=true)String moduleNum) throws APIException {
    	
    	UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    User userDetailRequest = new User();
	    userDetailRequest.setUserName(userName);
		User userInfo = authService.getUserDetails(userDetailRequest);
    	
    	String fileName =e2eNum+"_FullReport.xlsx";
    	byte[] content = e2eDashboardService.getE2EFullReportService(fileName,e2eNum, moduleNum, userInfo.getClientName());
    	
    	HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.setContentType(MediaType.parseMediaType("application/octet-stream"));
		httpHeader.setContentDispositionFormData("filename", fileName);
		return new ResponseEntity<>(content, httpHeader, HttpStatus.OK);
    }

}