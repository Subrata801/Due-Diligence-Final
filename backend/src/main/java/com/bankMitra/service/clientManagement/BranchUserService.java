/**
 * 
 */
package com.bankMitra.service.clientManagement;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.clientManagement.request.BranchUserRequest;
import com.bankMitra.model.clientManagement.response.BranchUserResponse;
import com.bankMitra.model.clientManagement.response.EmployeeNames;
import com.bankMitra.model.clientManagement.response.UnitNames;
import com.bankMitra.model.clientManagement.response.UserRole;


/**
 * @author BankMitra
 *
 */
public interface BranchUserService {

	BranchUserResponse createBranchUser(@Valid BranchUserRequest branchUserRequest) throws APIException;

	BranchUserResponse getBranchUser(@Valid BranchUserRequest branchUserRequest) throws APIException;

	List<BranchUserResponse> getAllBranchUsers(@Valid BranchUserRequest branchUserRequest) throws APIException;

	List<UnitNames> getListOfUnitNames(Integer clientId) throws APIException;

	List<UserRole> getListOfUserRoles(Integer unitId) throws APIException;

	List<EmployeeNames> getEmployeeNames(String empId) throws APIException;
	
}