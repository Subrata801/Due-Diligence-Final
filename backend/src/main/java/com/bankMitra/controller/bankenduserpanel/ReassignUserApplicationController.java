/**
 * 
 */
package com.bankMitra.controller.bankenduserpanel;


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
import com.bankMitra.model.bankenduserpanel.request.ReassignUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.request.SaveReassignUserRequest;
import com.bankMitra.model.bankenduserpanel.response.Checkers;
import com.bankMitra.model.bankenduserpanel.response.Makers;
import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationResponse;
import com.bankMitra.model.bankenduserpanel.response.SanctionAuthority;
import com.bankMitra.model.bankenduserpanel.response.SaveReassignUserResponse;
import com.bankMitra.model.bankenduserpanel.response.SaveViewDDRequest;
import com.bankMitra.model.bankenduserpanel.response.SaveViewDDResponse;
import com.bankMitra.model.reference.Language;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.bankenduserpanel.ReassignUserService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.ReassignUserValidator;

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
@RequestMapping("/reassignuserapplication")
public class ReassignUserApplicationController {

	private static final Logger logger = LoggerFactory.getLogger(ReassignUserApplicationController.class);
	
	@Autowired
	ReassignUserService reassignUserService;
	
	@Autowired
	private ReassignUserValidator reassignUserValidator;
	
	@ApiOperation(value = "Reassign or cancel user application", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_REASSIGN_USER_APP, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ReassignUserApplicationResponse> reassignUser
	(@Valid @RequestBody ReassignUserApplicationRequest reassignUserApplicationRequest,BindingResult result) throws APIException {
		reassignUserValidator.validate(reassignUserApplicationRequest, result);

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
	    reassignUserApplicationRequest.setCreatedBy(userName);
	    ReassignUserApplicationResponse reassignUserApplicationResponse = reassignUserService.reassignUser(reassignUserApplicationRequest);
		if(null!=reassignUserApplicationResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(reassignUserApplicationResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,reassignUserApplicationResponse.getMessageDescription()),reassignUserApplicationResponse);
		} else {
			throw new APIException(reassignUserApplicationResponse.getMessageDescription());
		}
	}
	
	@ApiOperation(value = "Get Module specific User details", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_GET_REASSIGN_USER_APP, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<List<ReassignUserApplicationResponse>> getAllUserList
	(@Valid @RequestBody ReassignUserApplicationRequest reassignUserApplicationRequest,BindingResult result) throws APIException {

		try {
			UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String userName = user.getUserName();
		    reassignUserApplicationRequest.setCreatedBy(userName);
			List<ReassignUserApplicationResponse> reassignUserList = reassignUserService.getAllUserList(reassignUserApplicationRequest);
			if(CollectionUtils.isNotEmpty(reassignUserList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all reassign users successfully"),reassignUserList);
			} else {
				throw new APIException("No users found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
	}
	
    @ApiOperation(value = "Get list of makers",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = APIConstant.SERVICE_GET_MAKERS, method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<Makers>> getListOfMakers(@RequestBody ReassignUserApplicationRequest reassignUserApplicationRequest) throws APIException{
        List<Makers> makerList = reassignUserService.getListOfMakers(reassignUserApplicationRequest.getClientGroupId());
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved makers successfully"),makerList);
    }

    @ApiOperation(value = "Get list of makers",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = APIConstant.SERVICE_GET_CHECKERS, method= RequestMethod.GET, produces = "application/json")
    public ResponseWrapperNoPagination<List<Checkers>> getListOfCheckers(@RequestBody ReassignUserApplicationRequest reassignUserApplicationRequest) throws APIException{
        List<Checkers> checkerList = reassignUserService.getListOfCheckers(reassignUserApplicationRequest.getClientGroupId());
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved checkers successfully"),checkerList);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = APIConstant.SERVICE_GET_SANCTIONING_AUTH, method= RequestMethod.GET, produces = "application/json")
    public ResponseWrapperNoPagination<List<SanctionAuthority>> getListOfSanctioningAuthority(@RequestBody ReassignUserApplicationRequest reassignUserApplicationRequest) throws APIException{
        List<SanctionAuthority> saList = reassignUserService.getListOfSanctioningAuthority(
        		reassignUserApplicationRequest.getClientGroupId(),reassignUserApplicationRequest.getZoClientGroupId(),
        		reassignUserApplicationRequest.getHoClientGroupId(),reassignUserApplicationRequest.getCpcClientGroupId());
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved sanctioningAuthority successfully"),saList);
    }
    //get-reassign-userapp
    @ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = APIConstant.SERVICE_SAVE_REASSIGN_USER, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<SaveReassignUserResponse> saveViewDD
	(@Valid @RequestBody SaveReassignUserRequest saveReassignUserRequest) throws APIException {
		UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    saveReassignUserRequest.setUserName(userName);
		SaveReassignUserResponse saveResponse = reassignUserService.saveReassignUser(saveReassignUserRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Saved View DD successfully"),saveResponse);
	}
}