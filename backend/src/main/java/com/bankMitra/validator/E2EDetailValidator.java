/**
 * 
 */
package com.bankMitra.validator;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.bankenduserpanel.request.E2EDetailRequest;
import com.bankMitra.model.bankenduserpanel.response.ComercialCreditFacilityDetails;

/**
 * @author BankMitra
 *
 */
@Component
public class E2EDetailValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return E2EDetailValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		E2EDetailRequest e2eDetailRequest = (E2EDetailRequest) target;
		if(null==e2eDetailRequest.getE2eNum() 
				|| StringUtils.isEmpty(e2eDetailRequest.getE2eNum())) {
	    	errors.reject("e2eNum.missing","E2E Number is required");
	    }
		if(null==e2eDetailRequest.getE2eDate() 
				|| StringUtils.isEmpty(e2eDetailRequest.getE2eDate())) {
	    	errors.reject("e2eDate.missing","E2E Date is required");
	    }
		if(null==e2eDetailRequest.getBranchName() 
				|| StringUtils.isEmpty(e2eDetailRequest.getBranchName())) {
	    	errors.reject("e2eBranchName.missing","Branch Name is required");
	    }
		if(null==e2eDetailRequest.getSecurity() 
				|| StringUtils.isEmpty(e2eDetailRequest.getSecurity())) {
	    	errors.reject("e2eSecurity.missing","Security is required");
	    }
		if(null==e2eDetailRequest.getComercialCreditFacilities() 
				|| CollectionUtils.isEmpty(e2eDetailRequest.getComercialCreditFacilities())) {
	    	errors.reject("commercialCreditFacilities.missing","Commercial Credit Facility is required");
	    } 
		if(!CollectionUtils.isEmpty(e2eDetailRequest.getComercialCreditFacilities())) {
			for(ComercialCreditFacilityDetails facilityDtl : e2eDetailRequest.getComercialCreditFacilities()) {
				if(StringUtils.isEmpty(facilityDtl.getFacility()) || StringUtils.isEmpty(facilityDtl.getAccountNum()) || 
				   StringUtils.isEmpty(facilityDtl.getDateOfSanction()) || StringUtils.isEmpty(facilityDtl.getSanctionedLimit()) || 
				   StringUtils.isEmpty(facilityDtl.getSanctionedLimitWords()) || StringUtils.isEmpty(facilityDtl.getLoanTenor())) {
					errors.reject("commercialCreditFacilitiesDtls.missing","Please  fill details of commercial Credit Facility");			
				}
			}
	    } 
		if(null==e2eDetailRequest.getListOfCoApplicantDetails() 
				|| CollectionUtils.isEmpty(e2eDetailRequest.getListOfCoApplicantDetails())) {
	    	errors.reject("coapplicantdetails.missing","Co-Applicant detail is required");
	    }
		if(null==e2eDetailRequest.getListOfGuarantorDetails() 
				|| CollectionUtils.isEmpty(e2eDetailRequest.getListOfGuarantorDetails())) {
	    	errors.reject("guarantordetails.missing","Guarantor detail is required");
	    }
		if(null==e2eDetailRequest.getSecurityType() 
				|| StringUtils.isEmpty(e2eDetailRequest.getSecurityType())) {
	    	errors.reject("e2eSecurityType.missing","Security Type is required");
	    }
		if(StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypeBankDeposit()) &&
			StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypebookDebts()) &&
			StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypegoldJwellery()) &&
			StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypeGoodsStock()) &&
			StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypeLic()) &&
			StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypeNsc()) &&
			StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypePlantMachinery()) &&
			StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypeRecievables()) &&
			StringUtils.isEmpty(e2eDetailRequest.getMovablePropTypeVechile())) {
				errors.reject("movableproperty.missing","Either of the movable proiperty is required");
	    }
	}

}
