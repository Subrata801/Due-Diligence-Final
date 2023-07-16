/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.bankenduserpanel.request.NewDueDeligenceProcessRequest;

/**
 * @author Bank Maitra
 *
 */
@Component
public class InitiateDueDeligenceValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return InitiateDueDeligenceValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		NewDueDeligenceProcessRequest dueDeligenceProcessRequest = (NewDueDeligenceProcessRequest) target;
		if(null==dueDeligenceProcessRequest.getAvailabilityOfCifNum() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getAvailabilityOfCifNum())) {
	    	errors.reject("cifnumavailable.missing","Availability of CIF No is required");
	    }
		if(null!=dueDeligenceProcessRequest.getAvailabilityOfCifNum() 
				&& !StringUtils.isEmpty(dueDeligenceProcessRequest.getAvailabilityOfCifNum())
				&& "Y".equalsIgnoreCase(dueDeligenceProcessRequest.getAvailabilityOfCifNum())
				&& (StringUtils.isEmpty(dueDeligenceProcessRequest.getCifNum()))) {
	    	errors.reject("cifnum.missing","Select CIF No is required");
	    }
		if(null!=dueDeligenceProcessRequest.getAvailabilityOfCifNum() 
				&& !StringUtils.isEmpty(dueDeligenceProcessRequest.getAvailabilityOfCifNum())
				&& "N".equalsIgnoreCase(dueDeligenceProcessRequest.getAvailabilityOfCifNum())
				&& (StringUtils.isEmpty(dueDeligenceProcessRequest.getBoorrowerName()))) {
	    	errors.reject("borrowername.missing","Applicant/Borrower Name is required");
	    }
		if(null==dueDeligenceProcessRequest.getSelectCreditSector() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getSelectCreditSector())) {
	    	errors.reject("creditsector.missing","Select Credit Sector is required");
	    }
		if(null==dueDeligenceProcessRequest.getSelectLoanScheme() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getSelectLoanScheme())) {
	    	errors.reject("typeloanscheme.missing","Select Loan Scheme is required");
	    }
		
		if(null==dueDeligenceProcessRequest.getSelectLoanVariant() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getSelectLoanVariant())) {
	    	errors.reject("loanVariant.missing","Select Loan Variant is required");
	    }
		
		if(null==dueDeligenceProcessRequest.getAssignBranchMaker() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getAssignBranchMaker())) {
	    	errors.reject("BranchMaker.missing","Assign Unit Maker is required");
	    }
		
		/*if(null==dueDeligenceProcessRequest.getE2eNumber() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getE2eNumber())) {
	    	errors.reject("e2e.missing","E 2 E is required");
	    }*/
		if(null==dueDeligenceProcessRequest.getDueDeligenceOfNewApp() 
				|| StringUtils.isEmpty(dueDeligenceProcessRequest.getDueDeligenceOfNewApp())) {
	    	errors.reject("moduleName.missing","Module Name is required");
	    }
	}
}
