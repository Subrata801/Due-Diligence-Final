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
import com.bankMitra.model.clientManagement.request.CreateUnitRequest;
import com.bankMitra.model.clientManagement.response.CreateUnitResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.clientManagement.CreateUnitService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.ClientManagementCreateUnitValidator;

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
@RequestMapping("/clientManagementCreateUnit")
public class CreateUnitController {

	private static final Logger logger = LoggerFactory.getLogger(CreateUnitController.class);
	
	@Autowired
	CreateUnitService createUnitService;
	
	@Autowired
	private ClientManagementCreateUnitValidator createUnitValidator;
	
	@ApiOperation(value = "Create client management unit", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_CREATE_UNIT, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<CreateUnitResponse> createNewClient
	(@Valid @RequestBody CreateUnitRequest createUnitRequest,BindingResult result) throws APIException {
		createUnitValidator.validate(createUnitRequest, result);

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
	    createUnitRequest.setCreatedBy(userName);
	    CreateUnitResponse createUnitResponse = createUnitService.createUnit(createUnitRequest);
		if(null!=createUnitResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(createUnitResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,createUnitResponse.getMessageDescription()),createUnitResponse);
		} else {
			throw new APIException(createUnitResponse.getMessageDescription());
		}
	}
	
	    
    @ApiOperation(value = "Get client management unit",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_GET_UNIT, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<CreateUnitResponse> getClientUnit(@Valid @RequestBody CreateUnitRequest createUnitRequest)
    		throws ResourceNotFoundException, APIException{
    	CreateUnitResponse createUnitResponse = createUnitService.getClientUnit(createUnitRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved client management unit successfully"),createUnitResponse);
        
    }
    
    @ApiOperation(value = "Get list of client management unit",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_GET_UNITS, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<List<CreateUnitResponse>> getAllClientUnit
      (@Valid @RequestBody CreateUnitRequest createUnitRequest,BindingResult result) throws APIException {
		
    	List<CreateUnitResponse> createUnitResponseList = null;
    	try {
    		createUnitRequest.setSearchOption(true);
    		createUnitValidator.validate(createUnitRequest, result);
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
    		createUnitResponseList = createUnitService.getAllClientUnit(createUnitRequest);
			if(CollectionUtils.isNotEmpty(createUnitResponseList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all client management units successfully"),createUnitResponseList);
			} else {
				throw new APIException("No unit found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }

}