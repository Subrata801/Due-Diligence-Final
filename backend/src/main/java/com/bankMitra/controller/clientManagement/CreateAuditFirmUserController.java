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
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest;
import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.clientManagement.CreateAuditFirmUserService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.CreateAuditFirmUserValidator;

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
@RequestMapping("/clientManagementAuditFirm")
public class CreateAuditFirmUserController {

	private static final Logger logger = LoggerFactory.getLogger(CreateAuditFirmUserController.class);
	
	@Autowired
	CreateAuditFirmUserService createAuditFirmUserService;
	
	@Autowired
	private CreateAuditFirmUserValidator createAuditFirmUserValidator;
	
	@ApiOperation(value = "Create audit firm user", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_CREATE_AUDITFIRM_USER, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<CreateAuditFirmUserResponse> createAuditFormUser
	(@Valid @RequestBody CreateAuditFirmUserRequest createAuditFirmUserRequest,BindingResult result) throws APIException {
		createAuditFirmUserValidator.validate(createAuditFirmUserRequest, result);

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
	    createAuditFirmUserRequest.setCreatedBy(userName);
	    CreateAuditFirmUserResponse createAuditFirmUserResponse = createAuditFirmUserService.createAuditFirmUser(createAuditFirmUserRequest);
		if(null!=createAuditFirmUserResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(createAuditFirmUserResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,createAuditFirmUserResponse.getMessageDescription()),createAuditFirmUserResponse);
		} else {
			throw new APIException(createAuditFirmUserResponse.getMessageDescription());
		}
	}
	
	    
    @ApiOperation(value = "Get client management audit firm user",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_GET_AUDITFIRM_USER, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<CreateAuditFirmUserResponse> getAuditFirmUser(@Valid @RequestBody CreateAuditFirmUserRequest createAuditFirmUserRequest)
    		throws ResourceNotFoundException, APIException{
    	CreateAuditFirmUserResponse createAuditFirmUserResponse = createAuditFirmUserService.getAuditFirmUser(createAuditFirmUserRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved audit firm user successfully"),createAuditFirmUserResponse);
        
    }
    
    @ApiOperation(value = "Get list of client management audit firm users",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_GET_AUDITFIRM_USERS, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<List<CreateAuditFirmUserResponse>> getAllAuditFirmUser
       (@Valid @RequestBody CreateAuditFirmUserRequest createAuditFirmUserRequest,BindingResult result)
    		throws ResourceNotFoundException, APIException{
    	List<CreateAuditFirmUserResponse> createAuditFirmUserResponseList = null;
    	try {
    		createAuditFirmUserRequest.setSearchOption(true);
    		createAuditFirmUserValidator.validate(createAuditFirmUserRequest, result);
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
    		createAuditFirmUserResponseList = createAuditFirmUserService.getAllAuditFirmUser(createAuditFirmUserRequest);
			if(CollectionUtils.isNotEmpty(createAuditFirmUserResponseList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all client management audit users successfully"),createAuditFirmUserResponseList);
			} else {
				throw new APIException("No audit firm user found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
    }

}