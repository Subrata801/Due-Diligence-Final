/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest;
import com.bankMitra.model.bankenduserpanel.request.ReassignUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.request.UserM1ApplicationDetails;
import com.bankMitra.model.bankenduserpanel.request.UserM2ApplicationDetails;
import com.bankMitra.model.bankenduserpanel.request.UserM3ApplicationDetails;
import com.bankMitra.model.bankenduserpanel.request.UserM4ApplicationDetails;

/**
 * @author BankMitra
 *
 */
@Component
public class ReassignUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ReassignUserValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ReassignUserApplicationRequest reassignUserApplicationRequest = (ReassignUserApplicationRequest) target;
		if(null==reassignUserApplicationRequest.getBankName() 
				|| StringUtils.isEmpty(reassignUserApplicationRequest.getBankName())) {
	    	errors.reject("cifnumber.missing","CIF Number is required");
	    }
		if(null!=reassignUserApplicationRequest.getModuleName() 
				&& !StringUtils.isEmpty(reassignUserApplicationRequest.getModuleName())){
				if("M1".equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())) {
					for(UserM1ApplicationDetails m1dtls : reassignUserApplicationRequest.getM1ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfApplicant()) ||
						StringUtils.isEmpty(m1dtls.getMaker()) || StringUtils.isEmpty(m1dtls.getChecker()) ||
						StringUtils.isEmpty(m1dtls.getAppStatus()) || StringUtils.isEmpty(m1dtls.getAppFinalStatus()) ||
						StringUtils.isEmpty(m1dtls.getSanctioningAuth())) {
							errors.reject("m1userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
				if("M2".equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())) {
					for(UserM2ApplicationDetails m1dtls : reassignUserApplicationRequest.getM2ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfBorrower()) ||
						StringUtils.isEmpty(m1dtls.getMaker()) || StringUtils.isEmpty(m1dtls.getChecker()) ||
						StringUtils.isEmpty(m1dtls.getAppStatus()) || StringUtils.isEmpty(m1dtls.getAppFinalStatus()) ||
						StringUtils.isEmpty(m1dtls.getSanctioningAuth())) {
							errors.reject("m2userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
				if("M3".equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())) {
					for(UserM3ApplicationDetails m1dtls : reassignUserApplicationRequest.getM3ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfBorrower()) ||
						StringUtils.isEmpty(m1dtls.getAccountNum()) || StringUtils.isEmpty(m1dtls.getMaker()) 
						|| StringUtils.isEmpty(m1dtls.getChecker()) ||
						StringUtils.isEmpty(m1dtls.getAppStatus()) ||
						StringUtils.isEmpty(m1dtls.getSanctionAuthority())) {
							errors.reject("m3userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
				if("M4".equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())) {
					for(UserM4ApplicationDetails m1dtls : reassignUserApplicationRequest.getM4ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfBorrower()) ||
						StringUtils.isEmpty(m1dtls.getE2eM4ReviewNum()) || StringUtils.isEmpty(m1dtls.getMaker()) 
						|| StringUtils.isEmpty(m1dtls.getChecker()) ||
						StringUtils.isEmpty(m1dtls.getAppStatus()) ||
						StringUtils.isEmpty(m1dtls.getSanctioningAuthority())) {
							errors.reject("m4userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
			
	    }	   		
	}

}
