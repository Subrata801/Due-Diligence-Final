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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.admin.HeaderRequest;
import com.bankMitra.model.admin.LoanSchemeRequest;
import com.bankMitra.model.admin.LoanVariantRequest;
import com.bankMitra.model.admin.RiskRatingRequest;
import com.bankMitra.model.admin.TemplateRequest;
import com.bankMitra.model.admin.response.HeaderResponse;
import com.bankMitra.model.admin.response.LoanSchemeResponse;
import com.bankMitra.model.admin.response.LoanVariantResponse;
import com.bankMitra.model.admin.response.RiskRatingResponse;
import com.bankMitra.model.admin.response.TemplateResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.admin.TemplateService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.AddHeaderValidator;
import com.bankMitra.validator.CreateLoanSchemeValidator;
import com.bankMitra.validator.CreateLoanVariantValidator;

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
@RequestMapping("/template")
public class TemplateController {

	private static final Logger logger = LoggerFactory.getLogger(TemplateController.class);
	
	@Autowired
	TemplateService templateService;
	
	@Autowired
	private AddHeaderValidator addheaderValidator;
	
	@Autowired
	private CreateLoanVariantValidator createLoanValidator;
	
	@Autowired
	private CreateLoanSchemeValidator createLoanSchemeValidator;
	
	@ApiOperation(value = "Add Header",notes= "This method is used to add header")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added header"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_ADD_HEADER, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<HeaderResponse> updateHeader(@Valid @RequestBody HeaderRequest headerRequest,BindingResult result) throws APIException {
		addheaderValidator.validate(headerRequest, result);

		if (result.hasErrors()) {
			MessageCode msg= new MessageCode();
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
		HeaderResponse headerResponse = templateService.updateHeader(headerRequest);
		if(null!=headerResponse && headerResponse.getMessageCode().equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,headerResponse.getMessageDescription()),headerResponse);
		} else {
			throw new APIException(headerResponse.getMessageDescription());
		}
		
	}
	
    @ApiOperation(value = "Get list of header keys",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_HEADER, method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<HeaderResponse>> getListOfHeader(@RequestParam(value = "headerKey",required=false)String headerKey,
    		@RequestParam(value = "englishDescription",required=false) String englishDescription,
    	    @RequestParam(value = "nonEnglishDescription",required=false) String nonEnglishDescription)
    		throws ResourceNotFoundException, APIException{
        List<HeaderResponse> headerList = null;
		try {
			headerList = templateService.getListOfHeader(headerKey,englishDescription,nonEnglishDescription);
			if(CollectionUtils.isNotEmpty(headerList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of headers successfully"),headerList);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"No headers configured"),headerList);
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
    }
    
    @ApiOperation(value = "Generate Template Name",notes= "This method is used to generate template name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully generated template name"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_GENERATE_TEMPLATE_NAME, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<TemplateResponse> generateTemplateName(@Valid @RequestBody TemplateRequest templateRequest) {
    	try {
    		TemplateResponse templateResponse = templateService.generateTemplateName(templateRequest);
			if(null!=templateResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(templateResponse.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,templateResponse.getMessageDescription()),templateResponse);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(false,templateResponse.getMessageDescription()),templateResponse);
			}
		} catch (APIException e) {
			logger.error("Unable to generate template name : ",e);
			return new ResponseWrapperNoPagination<>(new MetaData(false,e.getMessage()),null);
		}
	}

    @ApiOperation(value = "Create new Template ",notes= "This method is used to create new template")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully create template"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_CREATE_TEMPLATE, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<TemplateResponse> createTemplate(@Valid @RequestBody TemplateRequest templateRequest) throws APIException {
		TemplateResponse templateResponse = templateService.storeTemplate(templateRequest);
		if(null!=templateResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(templateResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,templateResponse.getMessageDescription()),templateResponse);
		} else {
			throw new APIException(templateResponse.getMessageDescription());
		}
		
	}

    @ApiOperation(value = "Get list of language template",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_LANGUAGE_TEMPLATE, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<TemplateResponse>> getLanguageTemplate(@Valid @RequestBody TemplateRequest templateRequest)
    		throws ResourceNotFoundException, APIException{
        List<TemplateResponse> languageTemplateList;
		try {
			languageTemplateList = templateService.getLanguageTemplate(templateRequest);
			if(CollectionUtils.isNotEmpty(languageTemplateList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of language templates successfully"),languageTemplateList);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"No language templates configured"),languageTemplateList);
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }
 
    @ApiOperation(value = "Get list of existing loan schemes",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_EXISTING_LOANSCHEMES, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<LoanSchemeResponse>> getListOfLoanSchemes(@Valid @RequestBody LoanSchemeRequest loanSchemeRequest) throws APIException{
        List<LoanSchemeResponse> loanSchemeList = null;
		try {
			loanSchemeList = templateService.getListOfLoanSchemes(loanSchemeRequest);
			if(CollectionUtils.isNotEmpty(loanSchemeList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of loan schemes successfully"),loanSchemeList);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"No loan schemes configured"),loanSchemeList);
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
        
    }
    
    @ApiOperation(value = "Create new Loan Schemes worksheetName",notes= "This method is used to create new loan scheme worksheet name")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully generated loan schemes worksheet"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_LOANSCHEME_WORKSHEET_NAME, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<LoanSchemeResponse> createLoanSchemeWorkSheet(@Valid @RequestBody LoanSchemeRequest loanSchemeRequest) {
		try {
			LoanSchemeResponse loanSchemeResponse = templateService.createLoanSchemeWorkSheet(loanSchemeRequest);
			if(null!=loanSchemeResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(loanSchemeResponse.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,loanSchemeResponse.getMessageDescription()),loanSchemeResponse);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(false,loanSchemeResponse.getMessageDescription()),loanSchemeResponse);
			}
		} catch (APIException e) {
			logger.error("Unable to create loanscheme worksheet name: ",e);
			return new ResponseWrapperNoPagination<>(new MetaData(false,e.getMessage()),null);
		}
	}

    @ApiOperation(value = "Create new Loan Schemes",notes= "This method is used to store new loan scheme")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created loan schemes"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_LOANSCHEME, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<LoanSchemeResponse> createNewLoanScheme(@Valid @RequestBody LoanSchemeRequest loanSchemeRequest,BindingResult result) throws APIException {
    	createLoanSchemeValidator.validate(loanSchemeRequest, result);

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
	    loanSchemeRequest.setCreatedBy(userName);
		LoanSchemeResponse loanSchemeResponse = templateService.createNewLoanScheme(loanSchemeRequest);
		if(null!=loanSchemeResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(loanSchemeResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Created loan scheme successfully"),loanSchemeResponse);
		} else {
			throw new APIException((null!=loanSchemeResponse.getMessageDescription() 
					&& !StringUtils.isEmpty(loanSchemeResponse.getMessageDescription())) ?loanSchemeResponse.getMessageDescription() : "Unable to create loan Scheme");
		}
		
	}
    @ApiOperation(value = "Get list of existing loan variants",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_EXISTING_LOANVARIANTS, method= RequestMethod.POST, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<LoanVariantResponse>> getListOfLoanVariants(@Valid @RequestBody LoanVariantRequest loanVariantRequest) throws APIException{
        List<LoanVariantResponse> loanVariantList = null;
		try {
			loanVariantList = templateService.getListOfLoanVariants(loanVariantRequest);
			if(CollectionUtils.isNotEmpty(loanVariantList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of loan variants successfully"),loanVariantList);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"No loan variants configured"),loanVariantList);
			}
		} catch (APIException e) {
			logger.error("Unable to get existing loan variants: ",e);
			throw new APIException(e.getMessage());
		}
        
    }
    
    @ApiOperation(value = "Create new Loan variant",notes= "This method is used to create new loan variant")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully created loan variant"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_LOANVARIANT, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<LoanVariantResponse> createNewLoanVariant(@Valid @RequestBody LoanVariantRequest loanVariantRequest,BindingResult result) throws APIException {
    	createLoanValidator.validate(loanVariantRequest, result);

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
	    loanVariantRequest.setCreatedBy(userName);
		LoanVariantResponse loanVariantResponse = templateService.createNewLoanVariant(loanVariantRequest);
		if(null!=loanVariantResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(loanVariantResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Created loan variant successfully"),loanVariantResponse);
		} else {
			throw new APIException(loanVariantResponse.getMessageDescription());
		}
		
	}

    @ApiOperation(value = "Get risk rating and colour code",notes= "This method is used to get risk rating and colour code")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully defined risk rating and colour code"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_GET_RISKRATING_COLOR, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<List<RiskRatingResponse>> getRiskRatingAndColourCode(@Valid @RequestBody RiskRatingRequest riskRatingRequest) {
    	List<RiskRatingResponse> riskRatingResponse = null;
    	try {
			riskRatingResponse = templateService.getRiskRatingAndColourCode(riskRatingRequest);
			if(CollectionUtils.isNotEmpty(riskRatingResponse)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of risk rating score successfully"),riskRatingResponse);
			} else {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"No risk rating score configured"),riskRatingResponse);
			}
		} catch (APIException e) {
			logger.error("Unable to get risk rating colour: ",e);
			return new ResponseWrapperNoPagination<>(new MetaData(false,e.getMessage()),null);
		}
	}
    
    @ApiOperation(value = "Define risk rating and colour code",notes= "This method is used to define risk rating and colour code")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully defined risk rating and colour code"),
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    })
    @RequestMapping(value = APIConstant.SERVICE_CREATE_RISKRATING_COLOR, method= RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<RiskRatingResponse> createRiskRatingAndColourCode(@Valid @RequestBody RiskRatingRequest riskRatingRequest) throws APIException {
			UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		    String userName = user.getUserName();
		    riskRatingRequest.setCreatedBy(userName);
			RiskRatingResponse riskRatingResponse = templateService.createRiskRatingAndColourCode(riskRatingRequest);
			if(null!=riskRatingResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(riskRatingResponse.getMessageCode())) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,riskRatingResponse.getMessageDescription()),riskRatingResponse);
			} else {
				throw new APIException(riskRatingResponse.getMessageDescription());
			}
		
	}
}
