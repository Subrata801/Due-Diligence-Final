/**
 * 
 */
package com.bankMitra.controller.clientManagement;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.clientManagement.request.BranchUserRequest;
import com.bankMitra.model.clientManagement.response.BranchUserResponse;
import com.bankMitra.model.clientManagement.response.EmployeeNames;
import com.bankMitra.model.clientManagement.response.UnitNames;
import com.bankMitra.model.clientManagement.response.UserRole;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.clientManagement.BranchUserService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.BranchUserValidator;

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
@RequestMapping("/clientManagementBranchUser")
public class BranchUserController {

	private static final Logger logger = LoggerFactory.getLogger(BranchUserController.class);
	
	@Autowired
	BranchUserService branchUserService;
	
	@Autowired
	private BranchUserValidator branchUserValidator;
	
	@ApiOperation(value = "Create branch user", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_CREATE_BRANCH_USER, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<BranchUserResponse> createBranchUser
	(@Valid @RequestBody BranchUserRequest branchUserRequest,BindingResult result) throws APIException {
		branchUserRequest.setSearchOption(false);
		branchUserValidator.validate(branchUserRequest, result);

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
	    branchUserRequest.setCreatedBy(userName);
	    BranchUserResponse branchUserResponse = branchUserService.createBranchUser(branchUserRequest);
		if(null!=branchUserResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(branchUserResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,branchUserResponse.getMessageDescription()),branchUserResponse);
		} else {
			throw new APIException(branchUserResponse.getMessageDescription());
		}
	}
	
	    
    @ApiOperation(value = "Get branch user",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_GET_BRANCH_USER, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<BranchUserResponse> getBranchUser(@Valid @RequestBody BranchUserRequest branchUserRequest)
    		throws ResourceNotFoundException, APIException{
    	BranchUserResponse branchUserResponse = branchUserService.getBranchUser(branchUserRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved branch user successfully"),branchUserResponse);
        
    }
    
    @ApiOperation(value = "Get list of branch users",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_GET_BRANCH_USERS, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<List<BranchUserResponse>> getAllBranchUsers
       (@Valid @RequestBody BranchUserRequest branchUserRequest,BindingResult result)
    		throws ResourceNotFoundException, APIException{
    	List<BranchUserResponse> branchUserResponseList = null;
    	try {
    		branchUserRequest.setSearchOption(true);
    		branchUserValidator.validate(branchUserRequest, result);

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
    		branchUserResponseList = branchUserService.getAllBranchUsers(branchUserRequest);
			if(CollectionUtils.isNotEmpty(branchUserResponseList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all branch users successfully"),branchUserResponseList);
			} else {
				throw new APIException("No matching User found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }
    
    @ApiOperation(value = "Get list of unit Name",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = APIConstant.SERVICE_GET_UNIT_NAMES, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<UnitNames>> getListOfUnitNames(@Valid @RequestBody BranchUserRequest branchUserRequest) throws APIException{
        List<UnitNames> unitNameList = branchUserService.getListOfUnitNames(branchUserRequest.getClientId());
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved unit Names successfully"),unitNameList);
    }
    
    @ApiOperation(value = "Get list of roles",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = APIConstant.SERVICE_GET_USER_ROLES, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<UserRole>> getListOfUserRoles(@Valid @RequestBody BranchUserRequest branchUserRequest) throws APIException{
        List<UserRole> userRoleList = branchUserService.getListOfUserRoles(branchUserRequest.getClientGroupId());
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved user roles successfully"),userRoleList);
    }
    
    @ApiOperation(value = "Get list of employee Name",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = APIConstant.SERVICE_GET_EMPLOYEE_NAMES, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<EmployeeNames>> getEmployeeNames(@Valid @RequestBody BranchUserRequest branchUserRequest) throws APIException{
        List<EmployeeNames> employeeList = branchUserService.getEmployeeNames(branchUserRequest.getEmployeeId());
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved employee Names successfully"),employeeList);
    }

}