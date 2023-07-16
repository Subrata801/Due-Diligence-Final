/**
 * 
 */
package com.bankMitra.controller.admin;

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
import com.bankMitra.model.admin.SubscriptionModel;
import com.bankMitra.model.admin.SubscriptionSearchRequest;
import com.bankMitra.model.admin.response.SubscriptionModelResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.model.subscription.SubscriptionRequest;
import com.bankMitra.model.subscription.response.SubscriptionResponse;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.admin.SubscriptionService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.CreateAdminSubscriptionValidator;
import com.bankMitra.validator.SearchSubscriptionValidator;

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
@RequestMapping("/subscription")
public class SubscriptionController {

	private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);
	
	@Autowired
	SubscriptionService subscriptionService;
	
	@Autowired
	SearchSubscriptionValidator searchSubscriptionValidator;
	
	@Autowired
	private CreateAdminSubscriptionValidator createAdminSubscriptionValidator;

	@ApiOperation(value = "Create the subscription of user", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_CREATE_SUBSCRIPTION, method = RequestMethod.POST, produces = "application/json")
	// @PreAuthorize("hasRole('VIEW_ACCOUNT')")
	public ResponseWrapperNoPagination<SubscriptionResponse> createSubscription(@Valid @RequestBody SubscriptionRequest subscriptionRequest,
			BindingResult result,@PathVariable(value = "subscriptionId")String subscriptionId) throws APIException {
		createAdminSubscriptionValidator.validate(subscriptionRequest, result);

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
	    subscriptionRequest.setCreatedBy(userName);
	    if(!StringUtils.isEmpty(subscriptionId) && null!=subscriptionId &&  !"null".equalsIgnoreCase(subscriptionId))
	    	subscriptionRequest.setSubscriptionId(Integer.parseInt(subscriptionId));
		SubscriptionResponse subscriptionResponse = subscriptionService.createSubscription(subscriptionRequest);
		if(null!=subscriptionResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(subscriptionResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,subscriptionResponse.getMessageDescription()),subscriptionResponse);
		} else {
			throw new APIException(subscriptionResponse.getMessageDescription());
		}
	}
	
    @ApiOperation(value = "Get list of subscription model",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_SUBSCRIPTION_MODEL, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<SubscriptionModelResponse>> getListOfSubscriptionModel(@Valid @RequestBody SubscriptionModel subscriptionModel)
    		throws ResourceNotFoundException, APIException{
        List<SubscriptionModelResponse> subscriptionModelList = null;
        
        try {
        	subscriptionModelList = subscriptionService.getListOfSubscriptionModel(subscriptionModel);
        	if(CollectionUtils.isNotEmpty(subscriptionModelList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of subscription Models successfully"),subscriptionModelList);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"No subscription Models configured"),subscriptionModelList);
			}
		} catch (APIException e) {
			logger.error("Unable to get subscription model : ",e);
			throw new APIException(e.getMessage());
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
    @RequestMapping(value = APIConstant.SERVICE_GET_SUBSCRIPTION, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<SubscriptionResponse>> getListOfSubscriptions(@RequestBody SubscriptionSearchRequest searchUserRequest,BindingResult result)
    		throws ResourceNotFoundException, APIException{
    	List<SubscriptionResponse> subscriptionList = null;
		try {
			searchSubscriptionValidator.validate(searchUserRequest, result);
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
			subscriptionList = subscriptionService.getListOfSubscriptions(searchUserRequest);
			if(CollectionUtils.isNotEmpty(subscriptionList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of subscription successfully"),subscriptionList);
			} else {
				throw new APIException("No subscription found for the search criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }


}
