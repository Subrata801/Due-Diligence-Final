/**
 * 
 */
package com.bankMitra.controller.admin;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.admin.ClientAuditFirmBankRequest;
import com.bankMitra.model.admin.ClientConfigRequest;
import com.bankMitra.model.admin.ClientDeleteDueDeligenceRequest;
import com.bankMitra.model.admin.ClientDueDeligenceRequest;
import com.bankMitra.model.admin.ClientLoanSchemeRequest;
import com.bankMitra.model.admin.ClientLoanVariantRequest;
import com.bankMitra.model.admin.ClientNewSubscriptionRequest;
import com.bankMitra.model.admin.ClientSubscriptionRequest;
import com.bankMitra.model.admin.ClientTemplateRequest;
import com.bankMitra.model.admin.DeleteBankDetails;
import com.bankMitra.model.admin.response.ActiveClient;
import com.bankMitra.model.admin.response.ClientBankResponse;
import com.bankMitra.model.admin.response.ClientConfigResponse;
import com.bankMitra.model.admin.response.ClientCustomizeTemplateResponse;
import com.bankMitra.model.admin.response.ClientDueDeligenceResponse;
import com.bankMitra.model.admin.response.ClientLoanSchemeResponse;
import com.bankMitra.model.admin.response.ClientLoanVariantResponse;
import com.bankMitra.model.admin.response.ClientModuleHeaderResponse;
import com.bankMitra.model.admin.response.ClientResponse;
import com.bankMitra.model.admin.response.ClientSubscriptionHistoryResponse;
import com.bankMitra.model.admin.response.ClientSubscriptionResponse;
import com.bankMitra.model.admin.response.RegistrationClientResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.admin.ClientConfigService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.AddBankValidator;
import com.bankMitra.validator.CreateClientLoanSchemeValidator;
import com.bankMitra.validator.CreateClientLoanVariantValidator;
import com.bankMitra.validator.CreateClientSubscriptionVariantValidator;
import com.bankMitra.validator.CreateClientValidator;
import com.bankMitra.validator.UpdateClientSubscriptionValidator;

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
@RequestMapping("/clientConfiguration")
public class ClientController {

	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	@Autowired
	ClientConfigService clientConfigService;
	
	@Autowired
	private CreateClientValidator createClientValidator;
	
	@Autowired
	private AddBankValidator addBankValidator;
	
	@Autowired
	private CreateClientLoanSchemeValidator createClientLoanSchemeValidator;
	
	@Autowired
	private CreateClientLoanVariantValidator createClientVariantValidator;
	
	@Autowired
	private CreateClientSubscriptionVariantValidator createClientSubscriptionValidator;
	
	@Autowired
	private UpdateClientSubscriptionValidator updateClientSubscriptionValidator;
	
	
	@ApiOperation(value = "Create new client", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_CREATE_CLIENT, method = RequestMethod.POST, produces = "application/json")
	// @PreAuthorize("hasRole('VIEW_ACCOUNT')")
	public ResponseWrapperNoPagination<ClientConfigResponse> createNewClient(@Valid @RequestBody ClientConfigRequest clientConfigRequest,BindingResult result) throws APIException {
		createClientValidator.validate(clientConfigRequest, result);

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
	    clientConfigRequest.setCreatedBy(userName);
		ClientConfigResponse clientConfigResponse = clientConfigService.createClient(clientConfigRequest);
		if(null!=clientConfigResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(clientConfigResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,clientConfigResponse.getMessageDescription()),clientConfigResponse);
		} else {
			throw new APIException(clientConfigResponse.getMessageDescription());
		}
	}
	
	@ApiOperation(value = "Add Bank details", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_ADD_BANK_DETAILS, method = RequestMethod.POST, produces = "application/json")
	// @PreAuthorize("hasRole('VIEW_ACCOUNT')")
	public ResponseWrapperNoPagination<ClientConfigResponse> addBankDetails(
			@Valid @RequestBody ClientAuditFirmBankRequest auditBankDetailRequest,BindingResult result,
			@PathVariable(value = "clientTypeId")Integer clientTypeId) throws APIException {
		addBankValidator.validate(auditBankDetailRequest, result);

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
	    auditBankDetailRequest.setCreatedBy(userName);
	    auditBankDetailRequest.setClientTypeId(clientTypeId);
		ClientConfigResponse clientConfigResponse = clientConfigService.addBankDetails(auditBankDetailRequest);
		if(null!=clientConfigResponse && clientConfigResponse.getMessageCode().equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,clientConfigResponse.getMessageDescription()),clientConfigResponse);
		} else {
			throw new APIException(clientConfigResponse.getMessageDescription());
		}
		

	}
	
    @ApiOperation(value = "Create new Loan Schemes for client",notes= "This method is used to create new loan scheme for specific client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created loan schemes"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_CREATE_CLIENT_LOANSCHEME, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientLoanSchemeResponse> createNewLoanScheme(@Valid @RequestBody List<ClientLoanSchemeRequest> loanSchemeRequest,BindingResult result) throws APIException {
    	if(null!=loanSchemeRequest) {
    		String errMsg = "";
    		List<ClientLoanSchemeRequest> reqForValidation = new ArrayList<>();
    		for(ClientLoanSchemeRequest req :loanSchemeRequest) {
    			reqForValidation.add(req);
    		}
    		ClientLoanSchemeRequest schemeReq = new ClientLoanSchemeRequest();
    		schemeReq.setSchemeRequestForValidation(reqForValidation);
    		createClientLoanSchemeValidator.validate(schemeReq, result);
			if (result.hasErrors()) {
				
				for(Object err :result.getAllErrors()) {
	        		if(err instanceof ObjectError ) {
	        			if(null!=((ObjectError)err).getDefaultMessage())
	        				errMsg= errMsg + ((ObjectError)err).getDefaultMessage() + " , ";
	        		} else
	        			errMsg= errMsg + ((FieldError)err).getDefaultMessage() + " , ";
	        	}
				throw new APIException(errMsg.substring(0,errMsg.lastIndexOf(",")));
			}
    	}
    	/*createClientLoanSchemeValidator.validate(loanSchemeRequest, result);

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
		}*/	
    	UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String userName = user.getUserName();
			
			ClientLoanSchemeResponse loanSchemeResponse = clientConfigService.createNewLoanScheme(loanSchemeRequest,userName);
			if(null!=loanSchemeResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(loanSchemeResponse.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully created loan schemes"),loanSchemeResponse);
			} else {
				throw new APIException(loanSchemeResponse.getMessageDescription());
			} 
	}

    @ApiOperation(value = "Delete Loan Schemes for client",notes= "This method is used to delete new loan scheme for specific client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted loan schemes"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_DELETE_CLIENT_LOANSCHEME, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientLoanSchemeResponse> deleteClientLoanScheme(@Valid @RequestBody ClientLoanSchemeRequest loanSchemeRequest) throws APIException {
			ClientLoanSchemeResponse loanSchemeResponse = clientConfigService.deleteClientLoanScheme(loanSchemeRequest);
			if(null!=loanSchemeResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(loanSchemeResponse.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully deleted loan schemes"),loanSchemeResponse);
			} else {
				throw new APIException(loanSchemeResponse.getMessageDescription());
			} 
	}
    
    @ApiOperation(value = "Delete due deligience for client",notes= "This method is used to delete due deligience for specific client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted loan schemes"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_DELETE_CLIENT_DUE_DELIGIENCE, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientDueDeligenceResponse> deleteDueDeligence(@PathVariable("module") String module,
			@PathVariable("ddId") Integer ddId,@Valid @RequestBody ClientDeleteDueDeligenceRequest dueDeligenceRequest) throws APIException {
    	dueDeligenceRequest.setModuleName(module);
    	dueDeligenceRequest.setDdId(ddId);
    	ClientDueDeligenceResponse deleteDueDeligenceResp = clientConfigService.deleteDueDeligence(dueDeligenceRequest);
			if(null!=deleteDueDeligenceResp && APIConstant.SUCCESS_CODE.equalsIgnoreCase(deleteDueDeligenceResp.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully deleted due deligence"),deleteDueDeligenceResp);
			} else {
				throw new APIException("Unable to delete selected due deligence");
			} 
	}
    
    @ApiOperation(value = "Create new Loan variant for client",notes= "This method is used to create new loan variant for specific client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created loan variant"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_CREATE_CLIENT_LOANSVARIANT, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientLoanVariantResponse> createNewLoanVariant(@Valid @RequestBody ClientConfigRequest loanVariantRequest,BindingResult result) throws APIException {
    	createClientVariantValidator.validate(loanVariantRequest, result);

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
			ClientLoanVariantResponse loanVariantResponse = clientConfigService.createNewLoanVariant(loanVariantRequest,userName);
			if(null!=loanVariantResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(loanVariantResponse.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully created loan variant for client"),loanVariantResponse);
			} else {
				throw new APIException(loanVariantResponse.getMessageDescription());
			} 
	}
    
    @ApiOperation(value = "Delete Loan variant for client",notes= "This method is used to delete new loan variant for specific client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted loan variant"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_DELETE_CLIENT_LOANSVARIANT, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientLoanVariantResponse> deleteLoanVariant(@Valid @RequestBody ClientConfigRequest loanVariantRequest) throws APIException {
		ClientLoanVariantResponse loanVariantResponse = clientConfigService.deleteLoanVariant(loanVariantRequest);
		if(null!=loanVariantResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(loanVariantResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully deleted loan variant for client"),loanVariantResponse);
		} else {
			throw new APIException(loanVariantResponse.getMessageDescription());
		}
	}
    
    @ApiOperation(value = "Get client subscription details",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_LOAD_CLIENT_SUBSCRIPTION, method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<ClientSubscriptionResponse> getClientSubscription(@RequestParam(value = "clientId",required=true)String clientId)
    		throws ResourceNotFoundException, APIException{
        ClientSubscriptionResponse clientSubscriptionResponse = clientConfigService.getClientSubscription(clientId);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved subscrtion of client successfully"),clientSubscriptionResponse);
        
    }

    @ApiOperation(value = "Create client subscription",notes= "This method is used to create client subscription")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created client subscription"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_CREATE_CLIENT_SUBSCRIPTION, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientSubscriptionResponse> createClientSubscription(@Valid @RequestBody ClientNewSubscriptionRequest clientSubscriptionRequest,BindingResult result) throws APIException {
    	createClientSubscriptionValidator.validate(clientSubscriptionRequest, result);

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
	    clientSubscriptionRequest.setCreatedBy(userName);
		ClientSubscriptionResponse clientSubscriptionResponse = clientConfigService.createClientSubscription(clientSubscriptionRequest);
		if(null!=clientSubscriptionResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(clientSubscriptionResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully created client subscription"),clientSubscriptionResponse);
		} else {
			throw new APIException(clientSubscriptionResponse.getMessageDescription());
		}
	}
    
    @ApiOperation(value = "Update client subscription",notes= "This method is used to update client subscription")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated client subscription"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_UPDATE_CLIENT_SUBSCRIPTION, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientSubscriptionResponse> updateClientSubscription(@PathVariable("typeofrequest") String typeofrequest,@Valid @RequestBody ClientSubscriptionRequest clientSubscriptionRequest,BindingResult result) throws APIException {
    	clientSubscriptionRequest.setTypeofrequest(typeofrequest);
    	updateClientSubscriptionValidator.validate(clientSubscriptionRequest, result);

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
		    clientSubscriptionRequest.setCreatedBy(userName);
		    clientSubscriptionRequest.setTypeofrequest(typeofrequest);
			ClientSubscriptionResponse clientSubscriptionResponse = clientConfigService.updateClientSubscription(clientSubscriptionRequest);
			if(null!=clientSubscriptionResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(clientSubscriptionResponse.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully updated client subscription"),clientSubscriptionResponse);
			} else {
				throw new APIException(clientSubscriptionResponse.getMessageDescription());
			}
	}
    
    @ApiOperation(value = "Get client subscription history",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_SUBSCRIPTION_HISTORY, method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ClientSubscriptionHistoryResponse>> getClientSubscriptionHistory(@RequestParam(value = "clientId",required=true)String clientId)
    		throws ResourceNotFoundException, APIException{
    	List<ClientSubscriptionHistoryResponse> clientSubscriptionHistoryList = null;
		try {
			clientSubscriptionHistoryList = clientConfigService.getClientSubscriptionHistory(clientId);
			if(CollectionUtils.isNotEmpty(clientSubscriptionHistoryList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of subscription for client successfully"),clientSubscriptionHistoryList);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"No subscription history for client"),new ArrayList<ClientSubscriptionHistoryResponse>());
			}
		} catch (APIException e) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"No subscription history for client"),new ArrayList<ClientSubscriptionHistoryResponse>());
		}
        
    }
    
    @ApiOperation(value = "Get list of clients",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENTS, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ClientResponse>> getListOfClients(@Valid @RequestBody ClientConfigRequest clientConfigRequest)
    		throws ResourceNotFoundException, APIException{
    	List<ClientResponse> clientList = null;
		try {
			clientList = clientConfigService.getListOfClients(clientConfigRequest);
			if(CollectionUtils.isNotEmpty(clientList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of clients successfully"),clientList);
			} else {
				throw new APIException("No clients found");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }
    
    @ApiOperation(value = "Get list of active clients",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_ACTIVE_CLIENTS, method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ActiveClient>> getListOfActiveClients()
    		throws ResourceNotFoundException, APIException{
    	List<ActiveClient> clientList = null;
		try {
			clientList = clientConfigService.getListOfActiveClients();
			if(CollectionUtils.isNotEmpty(clientList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of clients successfully"),clientList);
			} else {
				throw new APIException("No clients found");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }
    
    
    @ApiOperation(value = "Get list of client on the basis on client type id",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_BYCLIENTTYPEID, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<RegistrationClientResponse>> getListOfClientByClientTypeId(@Valid @RequestBody ClientConfigRequest clientConfigRequest)
    		throws ResourceNotFoundException, APIException{
    	List<RegistrationClientResponse> clientList = null;
		try {
			clientList = clientConfigService.getListOfClientByClientTypeId(clientConfigRequest);
			if(CollectionUtils.isNotEmpty(clientList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of clients successfully"),clientList);
			} else {
				throw new APIException("No client found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }
    
    @ApiOperation(value = "Get list of existing loan schemes for clients",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_EXISTING_LOANSCHEMES, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ClientLoanSchemeResponse>> getListOfLoanSchemes(@Valid @RequestBody ClientLoanSchemeRequest loanSchemeRequest) throws APIException{
        List<ClientLoanSchemeResponse> loanSchemeList = null;
		//try {
			loanSchemeList = clientConfigService.getListOfLoanSchemes(loanSchemeRequest);
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of loan schemes for clients successfully"),loanSchemeList);
			/*if(CollectionUtils.isNotEmpty(loanSchemeList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of loan schemes for clients successfully"),loanSchemeList);
			} else {
				throw new APIException("No loan schemes configured for client");
			}*/
		/*} catch (APIException e) {
			throw new APIException(e.getMessage());
		}*/
        
    }
    
    @ApiOperation(value = "Get client customize template",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_CUSTOMIZE_TEMPLATE, method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ClientCustomizeTemplateResponse>> getClientCustomizeTemplate(@RequestParam(value = "clientId",required=true)Integer clientId,
    		@RequestParam(value = "clientTypeId",required=false)String requestClientTypeId)
    		throws ResourceNotFoundException, APIException{
    	List<ClientCustomizeTemplateResponse> clientCustomizeTemplateList = null;
    	Integer clientTypeId = null;
    	if(StringUtils.isEmpty(requestClientTypeId) || "null".equalsIgnoreCase(requestClientTypeId))
    		clientTypeId = -1;
    	else
    		clientTypeId = Integer.parseInt(requestClientTypeId);
		clientCustomizeTemplateList = clientConfigService.getClientCustomizeTemplate(clientId,clientTypeId);
		if(CollectionUtils.isNotEmpty(clientCustomizeTemplateList)) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of templates for client successfully"),clientCustomizeTemplateList);
		} else {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of templates for client successfully"),new ArrayList<ClientCustomizeTemplateResponse>());
		}
    }
    
    @ApiOperation(value = "Create new template version for client",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_CREATE_CLIENT_TEMPLATE_NEW_VERSION, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<ClientCustomizeTemplateResponse> createNewClientTemplate(@Valid @RequestBody ClientTemplateRequest clientTemplateRequest) throws APIException{
        ClientCustomizeTemplateResponse newClientTemplateResponse = null;
        UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    clientTemplateRequest.setUserName(userName);
		newClientTemplateResponse = clientConfigService.createNewClientTemplate(clientTemplateRequest);
		if(null!=newClientTemplateResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(newClientTemplateResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Created new version of template for client successfully"),newClientTemplateResponse);
		} else {
			throw new APIException(newClientTemplateResponse.getMessageDescription());
		}
        
    }

    @ApiOperation(value = "Get client module header",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_MODULE_HEADER, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<List<ClientModuleHeaderResponse>> getClientModuleHeader(
    		@PathVariable(value = "ddId")Integer ddId,@PathVariable(value = "moduleName")String moduleName)
    		throws ResourceNotFoundException, APIException{
    	List<ClientModuleHeaderResponse> clientModuleHeaderList = null;
		clientModuleHeaderList = clientConfigService.getClientModuleHeader(ddId,moduleName);
		//if(CollectionUtils.isNotEmpty(clientModuleHeaderList)) {
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of module headers for client successfully"),clientModuleHeaderList);
		//} else {
		//	throw new APIException("No module headers configured");
		//}
		
    }
    
    @ApiOperation(value = "Get due deligence",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_CLIENT_DUE_DELIGENCE, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<List<ClientDueDeligenceResponse>> getClientDueDeligence(
    		@RequestBody ClientDueDeligenceRequest clientDueDeligenceRequest)
    		throws ResourceNotFoundException, APIException{
    	List<ClientDueDeligenceResponse> clientDueDeligenceList = null;
    	if(null!=clientDueDeligenceRequest  && !StringUtils.isEmpty(clientDueDeligenceRequest.getHeaderKey())) {
    		String[] data = clientDueDeligenceRequest.getHeaderKey().split("_");
    		clientDueDeligenceRequest.setModuleName(data[0]);
    		clientDueDeligenceRequest.setDdSequence(Integer.parseInt(data[1]));
    		clientDueDeligenceRequest.setDdId(Integer.parseInt(data[2]));
    		clientDueDeligenceRequest.setHeader1(data[3]);
    		clientDueDeligenceRequest.setHeader2(data[4]);
    		clientDueDeligenceRequest.setHeader3(data[5]);
    		clientDueDeligenceRequest.setHeader4(data[6]);
    	}
		clientDueDeligenceList = clientConfigService.getClientDueDeligence(clientDueDeligenceRequest);
		return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of dueDeligence for client successfully"),clientDueDeligenceList);
		
    }
    
    @ApiOperation(value = "Update due deligence",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_SAVE_CLIENT_DUE_DELIGENCE, method= RequestMethod.POST, produces = "application/json")
    public ResponseWrapperNoPagination<ClientDueDeligenceResponse> saveClientDueDeligence(@PathVariable("action") String action,
    		@PathVariable("headerKey") String headerKey,
    		@RequestBody ClientDueDeligenceRequest clientDueDeligenceRequest)
    		throws ResourceNotFoundException, APIException{
    	ClientDueDeligenceResponse clientDueDeligence = null;
    	String[] dtls = null;
    	String ddSequence = "";
    	String ddId = "";
    	String moduleName = "";
    	String header1 = "";
    	String header2 = "";
    	String header3 = "";
    	String header4 = "";
    	clientDueDeligenceRequest.setAction(action);
    	if(!StringUtils.isEmpty(headerKey)) {
    		dtls = headerKey.split("_");
    		moduleName = dtls[0];
    		ddSequence = dtls[1];
    		ddId = dtls[2];
    		header1 = dtls[3];
    		header2 = dtls[4];
    		header3 = dtls[5];
    		header4 = dtls[6];
    	}
    	clientDueDeligenceRequest.setDdId(Integer.parseInt(ddId));
    	clientDueDeligenceRequest.setModuleName(moduleName);
    	if(!StringUtils.isEmpty(header1) && !"null".equalsIgnoreCase(header1))
    		clientDueDeligenceRequest.setHeader1(header1);
    	if(!StringUtils.isEmpty(header2) && !"null".equalsIgnoreCase(header2))
    		clientDueDeligenceRequest.setHeader2(header2);
    	if(!StringUtils.isEmpty(header3) && !"null".equalsIgnoreCase(header3))
    		clientDueDeligenceRequest.setHeader3(header3);
    	if(!StringUtils.isEmpty(header4) && !"null".equalsIgnoreCase(header4))
    		clientDueDeligenceRequest.setHeader4(header4);
    		
    	UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    clientDueDeligenceRequest.setUserName(userName);
		clientDueDeligence = clientConfigService.saveClientDueDeligence(clientDueDeligenceRequest);
		if(null!=clientDueDeligence && APIConstant.SUCCESS_CODE.equalsIgnoreCase(clientDueDeligence.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,clientDueDeligence.getMessageDescription()),clientDueDeligence);
		} else {
			throw new APIException(APIConstant.MSG_UPDATE_CLIENT_DUE_DELIGENCE);
		}
    }
    
    @ApiOperation(value = "Get information of client",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_INFO, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<ClientResponse> getClientInformation(@Valid @RequestBody ClientConfigRequest clientConfigRequest)
    		throws ResourceNotFoundException, APIException{
    	ClientResponse clientDetails = null;
		clientDetails = clientConfigService.getClientInformation(clientConfigRequest);
		if(null!=clientDetails) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved details of client successfully"),clientDetails);
		} else {
			throw new APIException("No client found as per the criteria");
		}
		
    }
    
    @ApiOperation(value = "Get Bank Details",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_BANK_DETAILS, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ClientBankResponse>> getBankDetails(@Valid @RequestBody ClientConfigRequest clientConfigRequest)
    		throws ResourceNotFoundException, APIException{
    	List<ClientBankResponse> clientBankDetails = null;
		clientBankDetails = clientConfigService.getBankDetails(clientConfigRequest);
		if(null!=clientBankDetails) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved bank details of client successfully"),clientBankDetails);
		} else {
			throw new APIException("No bank detail found");
		}
    }
    
    @ApiOperation(value = "Get CLient LoanVariant Details",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_CLIENT_LOANVARIANT, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ClientLoanVariantResponse>> getClientLoanVariant(@Valid @RequestBody ClientConfigRequest clientConfigRequest)
    		throws ResourceNotFoundException, APIException{
    	List<ClientLoanVariantResponse> clientLoanVariantDetails = null;
		clientLoanVariantDetails = clientConfigService.getClientLoanVariant(clientConfigRequest);
		if(null!=clientLoanVariantDetails) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved loan variant of client successfully"),clientLoanVariantDetails);
		} else {
			throw new APIException("No loan variant for the client found");
		}
    }
    
    @ApiOperation(value = "Get CLient LoanVariant Details",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_NEW_DUE_DELIEGENCE, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<Long> getNewDueDeligence(@PathVariable("ddId") Integer ddId)
    		throws ResourceNotFoundException, APIException{
    	Long newDDSequence = -1L;
    	newDDSequence = clientConfigService.getNewDueDeligence(ddId);
		if(newDDSequence > 0 ) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved new DD Sequence successfully"),newDDSequence);
		} else {
			throw new APIException("Unable to retrieve new DD Sequence");
		}
    }

    @ApiOperation(value = "Delete bank for client",notes= "This method is used to delete bank for specific client")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted loan schemes"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_DELETE_CLIENT_BANK, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<ClientBankResponse> deleteClientBank(@Valid @RequestBody DeleteBankDetails bankRequest) throws APIException {
    	ClientBankResponse deleteBankResponse = clientConfigService.deleteClientBank(bankRequest);
			if(null!=deleteBankResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(deleteBankResponse.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Successfully deleted bank"),deleteBankResponse);
			} else {
				throw new APIException(deleteBankResponse.getMessageDescription());
			} 
	}

}