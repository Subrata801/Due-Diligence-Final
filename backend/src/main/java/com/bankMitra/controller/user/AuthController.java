package com.bankMitra.controller.user;


import javax.validation.Valid;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

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
import com.bankMitra.model.auth.LoginRequest;
import com.bankMitra.model.auth.ResetPasswordRequest;
import com.bankMitra.model.auth.SignupRequest;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.response.JwtResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.repository.user.UserRepository;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.user.AuthService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.PasswordValidator;
import com.bankMitra.validator.RegisterClientValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author BankMitra
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	UserRepository userRepository;

	/*@Autowired
    private GenericValidator genericValidator;*/
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	
	@Autowired
	AuthService authService;
	
	public AuthController()
    {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        //validator = validatorFactory.getValidator();
    }

    @ApiOperation(value = "User login",notes="This method is used for authentication of user",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved user details"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @RequestMapping(value = APIConstant.SERVICE_LOGIN_USER, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<JwtResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws APIException {

    	//try {
	    	JwtResponse userDetails = authService.authenticate(loginRequest);
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Authentication done successfully"),userDetails);
    	/*} catch (APIException e) {
			return new ResponseWrapperNoPagination<>(new MetaData(false,e.getMessage()),null);
		}*/
	}


    
    @ApiOperation(value = "Reset Password of user", notes="This method is used to reset password of a user",produces = "application/json")
    @ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_RESET_PASSWORD, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<MessageCode> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest,BindingResult result) throws APIException {
    	//try {
    		passwordValidator.validate(resetPasswordRequest, result);

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
			MessageCode resetPasswordResponse = authService.resetPassword(resetPasswordRequest);
			if(null!=resetPasswordResponse && resetPasswordResponse.getMessageCode().equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,resetPasswordResponse.getMessageDescription()),resetPasswordResponse);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(false,resetPasswordResponse.getMessageDescription()),resetPasswordResponse);
			}
    }

}
