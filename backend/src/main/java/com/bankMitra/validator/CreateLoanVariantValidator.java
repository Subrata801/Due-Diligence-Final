/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.LoanVariantDetails;
import com.bankMitra.model.admin.LoanVariantRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class CreateLoanVariantValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return LoanVariantRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		
		LoanVariantRequest loanVariantRequest = (LoanVariantRequest) target;
		if(null ==loanVariantRequest  || 
				StringUtils.isEmpty(loanVariantRequest.getLoanSchemeId()) || loanVariantRequest.getLoanSchemeId() <1 ) {
			errors.reject(
	                "loanSchemeVariantDetails", "Loan Scheme or New Loan Variant details are required before proceeding");
		} else if (null!=loanVariantRequest && loanVariantRequest.getLoanVariantDetails().size() ==0) {
			errors.reject(
	                "loanVariantAddDetails", "There is no new loan variant added.Please add one before proceeding.");
		} else if (null!=loanVariantRequest && loanVariantRequest.getLoanVariantDetails().size() >0) {
			for(LoanVariantDetails dtls : loanVariantRequest.getLoanVariantDetails()) {
				if(StringUtils.isEmpty(dtls.getLoanVariantId()) || StringUtils.isEmpty(dtls.getKeyword())) {
					errors.reject(
			         "loanVariantDetails", "Scheme and keyword are required for all new loan variants before proceeding");
					break;
				}
			}
		}
		
		
	}

}
