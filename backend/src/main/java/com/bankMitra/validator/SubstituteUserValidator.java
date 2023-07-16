/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.bankenduserpanel.request.SubstituteUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserM1ApplicationDetails;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserM2ApplicationDetails;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserM3ApplicationDetails;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserM4ApplicationDetails;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserM5ApplicationDetails;

/**
 * @author BankMitra
 *
 */
@Component
public class SubstituteUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return SubstituteUserValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		SubstituteUserApplicationRequest substituteUserApplicationRequest = (SubstituteUserApplicationRequest) target;
		if(null==substituteUserApplicationRequest.getBankName() 
				|| StringUtils.isEmpty(substituteUserApplicationRequest.getBankName())) {
	    	errors.reject("bankname.missing","Bank Name is required");
	    }
		if(null!=substituteUserApplicationRequest.getModuleName() 
				&& !StringUtils.isEmpty(substituteUserApplicationRequest.getModuleName())){
				if("M1".equalsIgnoreCase(substituteUserApplicationRequest.getModuleName())) {
					for(SubstituteUserM1ApplicationDetails m1dtls : substituteUserApplicationRequest.getSubstitutem1ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfApplicant()) ||
						StringUtils.isEmpty(m1dtls.getMaker()) || StringUtils.isEmpty(m1dtls.getChecker()) ||
						StringUtils.isEmpty(m1dtls.getAppStatus()) || StringUtils.isEmpty(m1dtls.getAppFinalStatus()) ||
						StringUtils.isEmpty(m1dtls.getSanctioningAuth())) {
							errors.reject("m1userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
				if("M2".equalsIgnoreCase(substituteUserApplicationRequest.getModuleName())) {
					for(SubstituteUserM2ApplicationDetails m1dtls : substituteUserApplicationRequest.getSubstitutem2ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfBorrower()) ||
						StringUtils.isEmpty(m1dtls.getMaker()) || StringUtils.isEmpty(m1dtls.getChecker()) ||
						StringUtils.isEmpty(m1dtls.getAppStatus()) || StringUtils.isEmpty(m1dtls.getAppFinalStatus()) ||
						StringUtils.isEmpty(m1dtls.getSanctioningAuth())) {
							errors.reject("m2userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
				if("M3".equalsIgnoreCase(substituteUserApplicationRequest.getModuleName())) {
					for(SubstituteUserM3ApplicationDetails m1dtls : substituteUserApplicationRequest.getSubstitutem3ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfBorrower()) ||
						StringUtils.isEmpty(m1dtls.getCifNum()) || StringUtils.isEmpty(m1dtls.getMaker()) 
						|| StringUtils.isEmpty(m1dtls.getChecker())  ||
						StringUtils.isEmpty(m1dtls.getSanctioningAuth())) {
							errors.reject("m3userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
				if("M4".equalsIgnoreCase(substituteUserApplicationRequest.getModuleName())) {
					for(SubstituteUserM4ApplicationDetails m1dtls : substituteUserApplicationRequest.getSubstitutem4ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfBorrower()) ||
						StringUtils.isEmpty(m1dtls.getE2eReviewNum()) || StringUtils.isEmpty(m1dtls.getMaker()) 
						|| StringUtils.isEmpty(m1dtls.getChecker()) ||
						StringUtils.isEmpty(m1dtls.getAppStatus()) ||
						StringUtils.isEmpty(m1dtls.getSanctioningAuth())) {
							errors.reject("m4userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
				if("M5".equalsIgnoreCase(substituteUserApplicationRequest.getModuleName())) {
					for(SubstituteUserM5ApplicationDetails m1dtls : substituteUserApplicationRequest.getSubstitutem5ApplicationDetails()) {
						if(StringUtils.isEmpty(m1dtls.getE2eNum()) || StringUtils.isEmpty(m1dtls.getNameOfBorrower()) ||
						StringUtils.isEmpty(m1dtls.getE2eReviewNum()) || StringUtils.isEmpty(m1dtls.getMaker()) 
						|| StringUtils.isEmpty(m1dtls.getChecker()) ||
						StringUtils.isEmpty(m1dtls.getSanctioningAuth())) {
							errors.reject("m5userAppdetails.missing","Please fill the details before saving");
						}
					}
				}
			
	    }	   		
	}

}
