/**
 * 
 */
package com.bankMitra.controller.bankenduserpanel;


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
import com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest;
import com.bankMitra.model.bankenduserpanel.response.CifRegistrationResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.bankenduserpanel.CifRegistrationService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.CifRegistrationValidator;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BankMitra
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/cifRegistraion")
public class CifRegistrationController {

	private static final Logger logger = LoggerFactory.getLogger(CifRegistrationController.class);
	
	@Autowired
	CifRegistrationService cifRegistrationService;
	
	@Autowired
	private CifRegistrationValidator cifRegistrationValidator;
	
	@ApiOperation(value = "Register CIF number", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_REGISTER_CIF, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<CifRegistrationResponse> registerCif
	(@Valid @RequestBody CifRegistrationRequest cifRegistrationRequest,BindingResult result) throws APIException {
		cifRegistrationValidator.validate(cifRegistrationRequest, result);

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
	    cifRegistrationRequest.setCreatedBy(userName);
		CifRegistrationResponse cifRegistrationResponse = cifRegistrationService.register(cifRegistrationRequest);
		if(null!=cifRegistrationResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(cifRegistrationResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,cifRegistrationResponse.getMessageDescription()),cifRegistrationResponse);
		} else {
			throw new APIException(cifRegistrationResponse.getMessageDescription());
		}
	}
}