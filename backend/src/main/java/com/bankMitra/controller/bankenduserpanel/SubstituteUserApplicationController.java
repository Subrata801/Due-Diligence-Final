/**
 * 
 */
package com.bankMitra.controller.bankenduserpanel;


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
import com.bankMitra.model.bankenduserpanel.request.SubstituteUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserApplicationResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.bankenduserpanel.SubstituteUserService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.SubstituteUserValidator;

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
@RequestMapping("/substitue-userapplication")
public class SubstituteUserApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(SubstituteUserApplicationController.class);
	
	@Autowired
	SubstituteUserService substituteUserService;
	
	@Autowired
	private SubstituteUserValidator substituteUserValidator;
	
	@ApiOperation(value = "Substitute or cancel user application", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_SUBSTITUTE_USER_APP, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<SubstituteUserApplicationResponse> substituteUser
	(@Valid @RequestBody SubstituteUserApplicationRequest substituteUserApplicationRequest,BindingResult result) throws APIException {
		substituteUserValidator.validate(substituteUserApplicationRequest, result);

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
	    substituteUserApplicationRequest.setCreatedBy(userName);
	    SubstituteUserApplicationResponse substituteUserResponse = substituteUserService.substituteUser(substituteUserApplicationRequest);
		if(null!=substituteUserResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(substituteUserResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,substituteUserResponse.getMessageDescription()),substituteUserResponse);
		} else {
			throw new APIException(substituteUserResponse.getMessageDescription());
		}
	}
	
	@ApiOperation(value = "Get Module specific User details", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_GET_SUBSTITUTE_USER_APP, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<List<SubstituteUserApplicationResponse>> getAllUserList
	(@Valid @RequestBody SubstituteUserApplicationRequest substituteUserApplicationRequest,BindingResult result) throws APIException {

		try {
			List<SubstituteUserApplicationResponse> substituteUserList = substituteUserService.getAllSubstituteUserList(substituteUserApplicationRequest);
			if(CollectionUtils.isNotEmpty(substituteUserList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all reassign users successfully"),substituteUserList);
			} else {
				throw new APIException("No users found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
	}

}