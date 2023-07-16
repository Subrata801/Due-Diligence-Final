/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.LoanSchemeDetails;
import com.bankMitra.model.admin.LoanSchemeRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CreateLoanSchemeValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return LoanSchemeRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		LoanSchemeRequest loanSchemeRequest = (LoanSchemeRequest) target;
		if(null ==loanSchemeRequest  || 
				StringUtils.isEmpty(loanSchemeRequest.getClientTypeId()) ||
				StringUtils.isEmpty(loanSchemeRequest.getCreditScoreTypeId())||
				StringUtils.isEmpty(loanSchemeRequest.getRiskTypeId())||
				StringUtils.isEmpty(loanSchemeRequest.getTemplateId()) || loanSchemeRequest.getTemplateId() <1 ) {
			errors.reject(
	                "loanSchemeBasicDetails", "BM Default DDAP Bank ,Credit Sector ,Template Option and Language Template are required before proceeding");
		} else if (null!=loanSchemeRequest && loanSchemeRequest.getLoanSchemeDetails().size() ==0) {
			errors.reject(
	                "loanSchemeAddDetails", "There is no new loan scheme added.Please add one before proceeding.");
		} else if (null!=loanSchemeRequest && loanSchemeRequest.getLoanSchemeDetails().size() >0) {
			for(LoanSchemeDetails dtls : loanSchemeRequest.getLoanSchemeDetails()) {
				if(StringUtils.isEmpty(dtls.getLoanSchemeId()) || StringUtils.isEmpty(dtls.getKeyword()) 
						|| StringUtils.isEmpty(dtls.getWorksheetName())) {
					errors.reject(
			         "newloanSchemeDetails", "Scheme Name,keyword and worksheet name are required for all new loan scheme request before proceeding");
					break;
				}
			}
		}
		
		
	}

}
