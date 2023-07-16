/**
 * 
 */
package com.bankMitra.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.*;

import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.reference.ApplicantType;
import com.bankMitra.model.reference.AuditFirm;
import com.bankMitra.model.reference.Banks;
import com.bankMitra.model.reference.BorrowerType;
import com.bankMitra.model.reference.CPC;
import com.bankMitra.model.reference.ClientGroup;
import com.bankMitra.model.reference.ClientType;
import com.bankMitra.model.reference.CreditSector;
import com.bankMitra.model.reference.HO;
import com.bankMitra.model.reference.HeaderKey;
import com.bankMitra.model.reference.Language;
import com.bankMitra.model.reference.Profession;
import com.bankMitra.model.reference.RiskType;
import com.bankMitra.model.reference.SecurityQuestions;
import com.bankMitra.model.reference.SecurityType;
import com.bankMitra.model.reference.SubscriptionSubType;
import com.bankMitra.model.reference.SubscriptionType;
import com.bankMitra.model.reference.UnitType;
import com.bankMitra.model.reference.UserRoles;
import com.bankMitra.model.reference.ZO;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

/**
 * @author BankMitra
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/references")
public class ReferenceController {
	
	@Autowired
	ReferenceService refService;

    @ApiOperation(value = "View a list of available security Questions",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-securityquestions", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<SecurityQuestions>> getListOfSecurityQuestions() throws ResourceNotFoundException{
        List<SecurityQuestions> securityQuestionList = refService.getListOfSecurityQuestions();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved Security Questions successfully"),securityQuestionList);
    }
    
    @ApiOperation(value = "View a list of available languages",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = APIConstant.SERVICE_GET_LANGUAGES, method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<Language>> getListOfLanguages() throws ResourceNotFoundException{
        List<Language> languageList = refService.getListOfLanguages();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved languages successfully"),languageList);
    }
    
    @ApiOperation(value = "View a list of available riskType",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-riskTypes", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<RiskType>> getListOfRiskTypes() throws ResourceNotFoundException{
        List<RiskType> riskTypeList = refService.getListOfRiskTypes();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved Risk Type successfully"),riskTypeList);
    }

    @ApiOperation(value = "View a list of available applicantTypes",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-applicantTypes", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ApplicantType>> getListOfApplicantTypes() throws ResourceNotFoundException{
        List<ApplicantType> applicantTypeList = refService.getListOfApplicantTypes();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved ApplicantType successfully"),applicantTypeList);
    }

    @ApiOperation(value = "View a list of available borrowerTypes",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-borrowerTypes", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<BorrowerType>> getListOfBorrowerTypes() throws ResourceNotFoundException{
        List<BorrowerType> borrowerTypeList = refService.getListOfBorrowerTypes();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved borrowerTypes successfully"),borrowerTypeList);
    }

    @ApiOperation(value = "View a list of available CreditScoreTypes",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-creditSectorTypes", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<CreditSector>> getListOfCreditSector() throws ResourceNotFoundException{
        List<CreditSector> creditSectorList = refService.getListOfCreditScoreTypes();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved Credit Sector successfully"),creditSectorList);
    }

    @ApiOperation(value = "View a list of available Professions",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-professions", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<Profession>> getListOfProfessions() throws ResourceNotFoundException{
        List<Profession> professionList = refService.getListOfProfessions();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved professions successfully"),professionList);
    }

    @ApiOperation(value = "View a list of available roles",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-roles", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<UserRoles>> getListOfRoles(@RequestParam(value = "clientTypeId",required=true)Integer clientTypeId) throws ResourceNotFoundException{
        List<UserRoles> roleList = refService.getListOfRoles(clientTypeId);
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved user Roles successfully"),roleList);
    }

    @ApiOperation(value = "View a list of available subscriptionTypes",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-subscriptionType", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<SubscriptionType>> getListOfSubscriptionTypes(@RequestParam(value = "productTypeId",required=false)Integer productTypeId) throws ResourceNotFoundException{
        List<SubscriptionType> subscriptionTypeList = refService.getListOfSubscriptionTypes(productTypeId);
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved subscription type successfully"),subscriptionTypeList);
    }

    @ApiOperation(value = "View a list of available subscriptionTypes",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-subscriptionSubType", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<SubscriptionSubType>> getListOfSubscriptionSubTypes(@RequestParam(value = "subscriptionTypeId",required=false)Integer subscriptionTypeId) throws ResourceNotFoundException{
        List<SubscriptionSubType> subscriptionSubTypeList = refService.getListOfSubscriptionSubTypes(subscriptionTypeId);
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved Subscription sub type successfully"),subscriptionSubTypeList);
    }

    @ApiOperation(value = "View a list of available securityTypes",produces = "application/json")
    @ApiResponses(value = {
    		@ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    }
    )
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-securityType", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<SecurityType>> getListOfSecurityTypes() throws ResourceNotFoundException{
        List<SecurityType> securityTypes = refService.getListOfSecurityTypes();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved security Types succcessfully"),securityTypes);
    }
    
    @ApiOperation(value = "View a list of available headerKeys",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = "/reference-headerkey", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<HeaderKey>> getListOfHeaderKeys() throws ResourceNotFoundException{
        List<HeaderKey> headerKeyList = refService.getListOfHeaderKeys();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved Header Keys successfully"),headerKeyList);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-auditfirms", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<AuditFirm>> getListOfAuditFirms() throws ResourceNotFoundException{
        List<AuditFirm> auditFirmList = refService.getListOfAuditFirms();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved Audit Firms successfully"),auditFirmList);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-banks", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<Banks>> getListOfBanks() throws ResourceNotFoundException{
        List<Banks> bankList = refService.getListOfBanks();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of Banks successfully"),bankList);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-clientgroup", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ClientGroup>> getListOfClientGroup(@RequestParam(value = "clientId",required=true)Integer clientId) throws ResourceNotFoundException{
        List<ClientGroup> clientGroupList = refService.getListOfClientGroup(clientId);
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of Client Group successfully"),clientGroupList);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-clienttype", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ClientType>> getListOfClientType() throws ResourceNotFoundException{
        List<ClientType> clientTypeList = refService.getListOfClientType();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of Client Type successfully"),clientTypeList);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-ho", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<HO>> getListOfHO(@RequestParam(value = "clientId",required=true)Integer clientId) throws ResourceNotFoundException{
        List<HO> hoList = refService.getListOfHO(clientId);
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of HO successfully"),hoList);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-zo", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<ZO>> getListOfZO(@RequestParam(value = "clientId",required=true)String clientId,@RequestParam(value = "hoId",required=true)String hoId) throws ResourceNotFoundException{
        List<ZO> zoList = refService.getListOfZO(Integer.parseInt(clientId),Integer.parseInt(hoId));
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of ZO successfully"),zoList);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-cpc", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<CPC>> getListOfCPC(@RequestParam(value = "clientId",required=true)String clientId,@RequestParam(value = "zoId",required=true)String zoId) throws ResourceNotFoundException{
        List<CPC> cpcList = refService.getListOfCPC(Integer.parseInt(clientId),Integer.parseInt(zoId));
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of CPC successfully"),cpcList);
    }
    
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/reference-unitType", method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<UnitType>> getListOfUnitTypes() throws ResourceNotFoundException{
        List<UnitType> unitTypeList = refService.getListOfUnitTypes();
        return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of Unit Type successfully"),unitTypeList);
    }

}
