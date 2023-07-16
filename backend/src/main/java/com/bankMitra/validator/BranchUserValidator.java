/**
 * 
 */
package com.bankMitra.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.clientManagement.request.BranchUserRequest;

/**
 * @author BankMitra
 *
 */
@Component
public class BranchUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return BranchUserValidator.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		BranchUserRequest branchUserRequest = (BranchUserRequest) target;
		
		if(branchUserRequest.isSearchOption()) {
			if(null==branchUserRequest.getSearchType() || StringUtils.isEmpty(branchUserRequest.getSearchType())) {
		    	errors.reject("searchtype.missing","One of the search criteria is required");
		    }
			if(null!=branchUserRequest.getSearchType() && !"unittypesearch".equalsIgnoreCase(branchUserRequest.getSearchType()) && (null==branchUserRequest.getSearchKeyword() || StringUtils.isEmpty(branchUserRequest.getSearchKeyword()))) {
		    	errors.reject("searchkeyword.missing","Search keyword is required");
		    }
			if(null!=branchUserRequest.getSearchType() && "unittypesearch".equalsIgnoreCase(branchUserRequest.getSearchType()) && (null==branchUserRequest.getUnitType() || StringUtils.isEmpty(branchUserRequest.getUnitType()))) {
		    	errors.reject("searchkeyword.missing","One of the unit Type is required");
		    }
	    } else {
		
			if(null==branchUserRequest.getUnitName() 
					|| StringUtils.isEmpty(branchUserRequest.getUnitName())) {
		    	errors.reject("unitName.missing","Unit Name is required");
		    }
			
			if(null==branchUserRequest.getUserRoleId() 
					|| StringUtils.isEmpty(branchUserRequest.getUserRoleId())) {
		    	errors.reject("userRole.missing","User Role is required");
		    }
			
			if(null==branchUserRequest.getEmployeeId() 
					|| StringUtils.isEmpty(branchUserRequest.getEmployeeId())) {
		    	errors.reject("employeeId.missing","Employee ID is required");
		    }
			
			if(null==branchUserRequest.getPassword() 
					|| StringUtils.isEmpty(branchUserRequest.getPassword()) && !branchUserRequest.isEditUser()) {
		    	errors.reject("password.missing","Password is required");
		    }
			if(null==branchUserRequest.getE2eStatus() 
					|| StringUtils.isEmpty(branchUserRequest.getE2eStatus())) {
		    	errors.reject("e2estatus.missing","E 2 E Status is required");
		    }
			/*if(null==branchUserRequest.getUserName() 
					|| StringUtils.isEmpty(branchUserRequest.getUserName())) {
		    	errors.reject("username.missing","User Name is required");
		    }
			if(null==branchUserRequest.getPassword() 
					|| StringUtils.isEmpty(branchUserRequest.getPassword())) {
		    	errors.reject("password.missing","Password is required");
		    }
			
			if(null==branchUserRequest.getE2eStatus() 
					|| StringUtils.isEmpty(branchUserRequest.getE2eStatus())) {
		    	errors.reject("e2estatus.missing","E 2 E Status is required");
		    }*/
	    }
	}

}
