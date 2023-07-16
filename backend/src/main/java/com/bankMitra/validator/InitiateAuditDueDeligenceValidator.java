/**
 * 
 */
package com.bankMitra.validator;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.bankenduserpanel.request.DueDeligenceAuditProcessRequest;
import com.bankMitra.model.bankenduserpanel.response.CoApplicantDetails;
import com.bankMitra.model.bankenduserpanel.response.ComercialCreditFacilityDetails;
import com.bankMitra.model.bankenduserpanel.response.GuarantorDetails;

/**
 * @author BankMitra
 *
 */
@Component
public class InitiateAuditDueDeligenceValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return InitiateAuditDueDeligenceValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		DueDeligenceAuditProcessRequest dueDeligenceProcessRequest = (DueDeligenceAuditProcessRequest) target;
		if(null==dueDeligenceProcessRequest.getSelectModule() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getSelectModule())) {
	    	errors.reject("module.missing","Module Name is required");
	    }
		if(null==dueDeligenceProcessRequest.getCncNumber() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getCncNumber())) {
	    	errors.reject("cncnumber.missing","CNC number is required");
	    }
		if(null==dueDeligenceProcessRequest.getCncDate() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getCncDate())) {
	    	errors.reject("cncdate.missing","CNC Date is required");
	    }
		/*if(null==dueDeligenceProcessRequest.getBranchName() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getBranchName())) {
	    	errors.reject("branchname.missing","Branch Name is required");
	    }*/
		if(null==dueDeligenceProcessRequest.getIfscCode() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getIfscCode())) {
	    	errors.reject("ifsccode.missing","IFSC code is required");
	    }
		/*if(null==dueDeligenceProcessRequest.getAuditFirmChecker() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getAuditFirmChecker())) {
	    	errors.reject("auditfirmchecker.missing","Audit Firm Checker is required");
	    }*/
		/*if(null==dueDeligenceProcessRequest.getAuditControlAuthority() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getAuditControlAuthority())) {
	    	errors.reject("auditfirmcontrolauth.missing","Audit Firm Control Authority is required");
	    }*/
		if(null==dueDeligenceProcessRequest.getBorrowerName() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getBorrowerName())) {
	    	errors.reject("borrowerName.missing","Borrower Name is required");
	    }
		if(null==dueDeligenceProcessRequest.getCifNumber() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getCifNumber())) {
	    	errors.reject("cifnum.missing","CIF Number is required");
	    }
		/*if(null==dueDeligenceProcessRequest.getCreditSector() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getCreditSector())) {
	    	errors.reject("creditsector.missing","Credit Sector is required");
	    }
		if(null==dueDeligenceProcessRequest.getLoanVariantName() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getLoanVariantName())) {
	    	errors.reject("loanVariant.missing","Loan Variant is required");
	    }*/
		if(null==dueDeligenceProcessRequest.getLoanAccountNum() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getLoanAccountNum())) {
	    	errors.reject("loanaccountnum.missing","Loan Account Number is required");
	    }
		if(null==dueDeligenceProcessRequest.getTypeOfBorrower() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getTypeOfBorrower())) {
	    	errors.reject("typeofborrower.missing","Type Of borrower is required");
	    }
		if(null==dueDeligenceProcessRequest.getBorrowerCategory() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getBorrowerCategory())) {
	    	errors.reject("borrowercategory.missing","Borrower Category is required");
	    }
		/*if(null==dueDeligenceProcessRequest.getFacilityDetails() 
				|| CollectionUtils.isEmpty(dueDeligenceProcessRequest.getFacilityDetails())) {
	    	errors.reject("commercialCreditFacilities.missing","Commercial Credit Facility is required");
	    } 
		if(!CollectionUtils.isEmpty(dueDeligenceProcessRequest.getFacilityDetails())) {
			for(ComercialCreditFacilityDetails facilityDtl : dueDeligenceProcessRequest.getFacilityDetails()) {
				if(StringUtils.isEmpty(facilityDtl.getFacility()) || StringUtils.isEmpty(facilityDtl.getAccountNum()) || 
				   StringUtils.isEmpty(facilityDtl.getDateOfSanction()) || StringUtils.isEmpty(facilityDtl.getSanctionedLimit()) || 
				   StringUtils.isEmpty(facilityDtl.getSanctionedLimitWords()) || StringUtils.isEmpty(facilityDtl.getLoanTenor())) {
					errors.reject("commercialCreditFacilitiesDtls.missing","Please  fill details of commercial Credit Facility");			
				}
			}
	    }
	    if(null==dueDeligenceProcessRequest.getListOfCoApplicantDetails() 
				|| CollectionUtils.isEmpty(dueDeligenceProcessRequest.getListOfCoApplicantDetails())) {
	    	errors.reject("coapplicantdetails.missing","Co-Applicant detail is required");
	    }
		if(!CollectionUtils.isEmpty(dueDeligenceProcessRequest.getListOfCoApplicantDetails())) {
			for(CoApplicantDetails coAppDtls : dueDeligenceProcessRequest.getListOfCoApplicantDetails()) {
				if(StringUtils.isEmpty(coAppDtls.getNameOfCoApplicant()) || StringUtils.isEmpty(coAppDtls.getDesignation())) {
					errors.reject("coappdetails.missing","Please  fill details of co-applicant details");			
				}
			}
	    } */
		/*if(null==dueDeligenceProcessRequest.getListOfGuarantorDetails() 
				|| CollectionUtils.isEmpty(dueDeligenceProcessRequest.getListOfGuarantorDetails())) {
	    	errors.reject("guarantordetails.missing","Guarantor detail is required");
	    }
		if(!CollectionUtils.isEmpty(dueDeligenceProcessRequest.getListOfGuarantorDetails())) {
			for(GuarantorDetails gurantorDtls : dueDeligenceProcessRequest.getListOfGuarantorDetails()) {
				if(StringUtils.isEmpty(gurantorDtls.getNameOfGuarantor())) {
					errors.reject("gurantorDtls.missing","Please  fill details of Guarantor details");			
				}
			}
	    }
		if(StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypeBankDeposit()) &&
				StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypebookDebts()) &&
				StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypegoldJwellery()) &&
				StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypeGoodsStock()) &&
				StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypeLic()) &&
				StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypeNsc()) &&
				StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypePlantMachinery()) &&
				StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypeRecievables()) &&
				StringUtils.isEmpty(dueDeligenceProcessRequest.getMovablePropTypeVechile()) ) {
					errors.reject("movableproperty.missing","Either of the movable proiperty is required");
		}*/
	}

}
