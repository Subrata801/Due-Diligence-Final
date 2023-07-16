package com.bankMitra.controller.user;


import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.admin.UserRequest;
import com.bankMitra.model.auth.ResetPasswordRequest;
import com.bankMitra.model.auth.SignupRequest;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.response.JwtResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.model.user.User;
import com.bankMitra.repository.user.UserRepository;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.user.AuthService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.PasswordValidator;
import com.bankMitra.validator.RegisterClientValidator;
import com.bankMitra.validator.SearchUserValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author BankMitra
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	@Autowired
	private SearchUserValidator searchUserValidator;
	
	@Autowired
	AuthService authService;
	
	@Autowired
	private RegisterClientValidator registerClientValidator;

    @ApiOperation(value = "Update Passsword of User",notes="This method is used for update password of user",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user details"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @RequestMapping(value = APIConstant.SERVICE_UPDATE_PASSWORD_OF_USER, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<JwtResponse> updatePassword(@Valid @RequestBody ResetPasswordRequest updatePassword,BindingResult result) throws APIException {
        //try {
	    	passwordValidator.validate(updatePassword, result);
	
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
    		
			JwtResponse updatePasswordResponse = authService.updatePassword(updatePassword);
	    	return new ResponseWrapperNoPagination<>(new MetaData(true,"Authentication done successfully"),updatePasswordResponse);
			/*if(null!=updatePasswordResponse && updatePasswordResponse.getMessageCode().equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,updatePasswordResponse.getMessageDescription()),updatePasswordResponse);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(false,updatePasswordResponse.getMessageDescription()),updatePasswordResponse);
			}*/
	}

    @ApiOperation(value = "Update details of a user",notes= "This method is used to update details of user",produces = "application/json")
    @ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
    @RequestMapping(value = APIConstant.SERVICE_UPDATE_USER, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<MessageCode> updateUser(@Valid @RequestBody User userDetailRequest) throws APIException {
			MessageCode registrationResponse = authService.updateUserDetails(userDetailRequest);
			if(null!=registrationResponse && registrationResponse.getMessageCode().equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,registrationResponse.getMessageDescription()),registrationResponse);
			} else {
				throw new APIException(registrationResponse.getMessageDescription());
			}
		
	}

    @ApiOperation(value = "Get details of a user",notes= "This method is used to get details of user",produces = "application/json")
    @ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
    @RequestMapping(value = APIConstant.SERVICE_USER_DETAILS, method= RequestMethod.GET, produces = "application/json")
	public ResponseWrapperNoPagination<User> getUserInfo() throws APIException {
	    	UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String userName = user.getUserName();
		    User userDetailRequest = new User();
		    userDetailRequest.setUserName(userName);
			User userInfo = authService.getUserDetails(userDetailRequest);
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved user info successfully"),userInfo);
		
	}
    
    @ApiOperation(value = "Registration of a user",notes= "This method is used to register user",produces = "application/json")
    @ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
    @RequestMapping(value = APIConstant.SERVICE_REGISTER_USER, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<MessageCode> registerUser(@Valid @RequestBody SignupRequest signUpRequest,BindingResult result,
			@PathVariable(value = "userId")String userId) throws APIException {
		//try {
	    	if(!StringUtils.isEmpty(userId) && null!=userId && !"null".equalsIgnoreCase(userId))
	    		signUpRequest.setUserId(Integer.parseInt(userId));
    	    registerClientValidator.validate(signUpRequest, result);
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
			signUpRequest.setCreatedBy(userName);
			MessageCode registrationResponse = authService.registerUser(signUpRequest);
			if(null!=registrationResponse && registrationResponse.getMessageCode().equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,registrationResponse.getMessageDescription()),registrationResponse);
			} else {
				throw new APIException(registrationResponse.getMessageDescription());
			}
		
	}
    
    @ApiOperation(value = "Get list of users",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_USERS, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<User>> getListOfUsers(@RequestBody UserRequest searchUserRequest,BindingResult result)
    		throws ResourceNotFoundException, APIException{
    	List<User> userList = null;
		try {
			searchUserValidator.validate(searchUserRequest, result);
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
			userList = authService.getListOfUsers(searchUserRequest);
			if(CollectionUtils.isNotEmpty(userList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of users successfully"),userList);
			} else {
				throw new APIException("No user found for the search criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }

}
