/**
 * 
 */
package com.bankMitra.controller.clientManagement;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.clientManagement.request.ClientManagementDashBoardTaskRequest;
import com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest;
import com.bankMitra.model.clientManagement.response.ClientManagementDashBoardTaskResponse;
import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.clientManagement.ClientManagementDashBoardService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.ClientManagementDashBoardValidator;

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
@RequestMapping("/clientManagementDashBoard")
public class ClientManagementDashBoardController {

	private static final Logger logger = LoggerFactory.getLogger(ClientManagementDashBoardController.class);
	
	@Autowired
	ClientManagementDashBoardService clientManagementDashBoardService;
	
	@Autowired
	private ClientManagementDashBoardValidator clientManagementDashBoardValidator;
	
	@ApiOperation(value = "Process client management dashboard task", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_DASHBOARD_TASK, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientManagementDashBoardTaskResponse> createNewClient
	(@Valid @RequestBody ClientManagementDashBoardTaskRequest clientManagementDashBoardTaskRequest,BindingResult result) throws APIException {
		clientManagementDashBoardValidator.validate(clientManagementDashBoardTaskRequest, result);

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
	    clientManagementDashBoardTaskRequest.setCreatedBy(userName);
		ClientManagementDashBoardTaskResponse clientManagementDashBoardTaskResponse = clientManagementDashBoardService.updateDashBoardTask(clientManagementDashBoardTaskRequest);
		if(null!=clientManagementDashBoardTaskResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(clientManagementDashBoardTaskResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,clientManagementDashBoardTaskResponse.getMessageDescription()),clientManagementDashBoardTaskResponse);
		} else {
			throw new APIException(clientManagementDashBoardTaskResponse.getMessageDescription());
		}
	}
	
	@ApiOperation(value = "Get client management specific task details",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_MANAGEMENT_TASK, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<ClientManagementDashBoardTaskResponse> getTaskDetails(@Valid @RequestBody ClientManagementDashBoardTaskRequest dashBoardTaskRequest)
    		throws ResourceNotFoundException, APIException{
		ClientManagementDashBoardTaskResponse dashBoardTaskResponse = clientManagementDashBoardService.getTaskDetails(dashBoardTaskRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved audit firm user successfully"),dashBoardTaskResponse);
        
    }
	
    @ApiOperation(value = "Get client management dashboard task",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_MANAGEMENT_DASHBOARD_TASKS, method= RequestMethod.GET, produces = "application/json")
    public ResponseWrapperNoPagination<List<ClientManagementDashBoardTaskResponse>> getClientAvailableDashBoardTask()
    		throws ResourceNotFoundException, APIException{
    	List<ClientManagementDashBoardTaskResponse> clientManagementDashBoardTaskResponse = clientManagementDashBoardService.getClientAvailableDashBoardTask();
    	try {
    		if(CollectionUtils.isNotEmpty(clientManagementDashBoardTaskResponse)) {
    			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved dashboard tasks successfully"),clientManagementDashBoardTaskResponse);
			} else {
				throw new APIException("No audit firm user found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}	
		
        
    }

}