/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.clientManagement.request.CreateUnitRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class ClientManagementCreateUnitValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ClientManagementCreateUnitValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		CreateUnitRequest createUnitRequest = (CreateUnitRequest) target;
		
		if(createUnitRequest.isSearchOption()) { 
			if(null==createUnitRequest.getSearchType() || StringUtils.isEmpty(createUnitRequest.getSearchType())) {
				errors.reject("searchtype.missing","One of the search criteria is required");
			}
			if(null!=createUnitRequest.getSearchType() && !"unittypesearch".equalsIgnoreCase(createUnitRequest.getSearchType()) && (null==createUnitRequest.getSearchKeyword() || StringUtils.isEmpty(createUnitRequest.getSearchKeyword()))) {
		    	errors.reject("searchkeyword.missing","Search keyword is required");
		    }
			if(null!=createUnitRequest.getSearchType() && "unittypesearch".equalsIgnoreCase(createUnitRequest.getSearchType()) && (null==createUnitRequest.getUnitType() || StringUtils.isEmpty(createUnitRequest.getUnitType()))) {
		    	errors.reject("searchkeyword.missing","One of the unit Type is required");
		    }
	    } else {
		
			if(null==createUnitRequest.getUnitType() 
					|| StringUtils.isEmpty(createUnitRequest.getUnitType())) {
		    	errors.reject("unitType.missing","Unit Type is required");
		    }
			if(null!=createUnitRequest.getUnitType() 
					&& !StringUtils.isEmpty(createUnitRequest.getUnitType())) {
				if("2".equalsIgnoreCase(createUnitRequest.getUnitType()) && 
						(null==createUnitRequest.getUnitHO() || StringUtils.isEmpty(createUnitRequest.getUnitHO())))
					errors.reject("ho.forzo.missing","For ZO creation - Select HO/CORP/CO is required");
				if("3".equalsIgnoreCase(createUnitRequest.getUnitType()) && 
						(null==createUnitRequest.getUnitHO() || StringUtils.isEmpty(createUnitRequest.getUnitHO())))
					errors.reject("ho.forcpc.missing","For CPC creation - Select HO/CORP/CO is required");
				if("4".equalsIgnoreCase(createUnitRequest.getUnitType()) && 
						(null==createUnitRequest.getUnitHO() || StringUtils.isEmpty(createUnitRequest.getUnitHO())))
					errors.reject("ho.forbranch.missing","For Branch creation - Select HO/CORP/CO is required");
		    }
			if(null==createUnitRequest.getUnitName() 
					|| StringUtils.isEmpty(createUnitRequest.getUnitName())) {
		    	errors.reject("unitName.missing","Unit Name is required");
		    }
			if(null!=createUnitRequest.getUnitName() && !StringUtils.isEmpty(createUnitRequest.getUnitName())) {
				if(createUnitRequest.getUnitName().length()>100)
					errors.reject("unitName.maxlength","Max length of Unit Name can be 100 charecters");
		    }
			if(null!=createUnitRequest.getUnitAddress() && !StringUtils.isEmpty(createUnitRequest.getUnitAddress())) {
				if(createUnitRequest.getUnitAddress().length()>255)
					errors.reject("uniAddress.maxlength","Max length of Unit Address can be 255 charecters");
		    }
			if(null==createUnitRequest.getPincode() 
					|| StringUtils.isEmpty(createUnitRequest.getPincode())) {
		    	errors.reject("pincode.missing","Pincode is required");
		    }
			
			if (null!=createUnitRequest.getPincode() && !StringUtils.isEmpty(createUnitRequest.getPincode())) { 
	    		try{
					if(!String.valueOf(createUnitRequest.getPincode()).matches("[0-9]+") || 6!=String.valueOf(createUnitRequest.getPincode()).length()) {
						errors.reject(
				                "pincode.validation", "PinCode should be a number and should have length of 6 digits");
		    		}
	    		} catch (Exception e) {
	    			errors.reject(
			                "pincode.validation", "PinCode should be a number and should have length of 6 digits");
	    		}
			}
			if(null==createUnitRequest.getIfscCode()
					|| StringUtils.isEmpty(createUnitRequest.getIfscCode())) {
		    	errors.reject("ifsc.missing","IFSC Code is required");
		    }
			if(null==createUnitRequest.getState() 
					|| StringUtils.isEmpty(createUnitRequest.getState())) {
		    	errors.reject("state.missing","State is required");
		    }
			if(null!=createUnitRequest.getState() 
					&& !StringUtils.isEmpty(createUnitRequest.getState()) && !isStringOnlyAlphabet(createUnitRequest.getState())) {
		    	errors.reject("state.onlyalphabets","State can have only alphabets");
		    }
			if(null==createUnitRequest.getCity() 
					|| StringUtils.isEmpty(createUnitRequest.getCity())) {
		    	errors.reject("city.missing","City is required");
		    }
			if(null!=createUnitRequest.getCity() 
					&& !StringUtils.isEmpty(createUnitRequest.getCity()) && !isStringOnlyAlphabet(createUnitRequest.getCity())) {
		    	errors.reject("city.onlyalphabets","City can have only alphabets");
		    }
			if(null==createUnitRequest.getUnitStatus() || StringUtils.isEmpty(createUnitRequest.getUnitStatus())) {
		    	errors.reject("unitStatus.missing","Unit Status is required");
		    }
		}
	}
	
	private boolean isStringOnlyAlphabet(String str) 
	{
	    return ((!str.equals(""))
	            && (str != null)
	            && (str.matches("^[a-zA-Z]*$")));
	}
}
