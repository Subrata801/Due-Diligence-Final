/**
 * 
 */
package com.bankMitra.repository.clientManagement;

import java.util.List;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.BranchUserRequest;
import com.bankMitra.model.clientManagement.response.BranchUserResponse;
import com.bankMitra.model.clientManagement.response.EmployeeNames;
import com.bankMitra.model.clientManagement.response.UnitNames;
import com.bankMitra.model.clientManagement.response.UserRole;

/**
 * @author BankMitra
 *
 */
public interface BranchUserRepository {

	BranchUserResponse createBranchUser(BranchUserRequest branchUserRequest) throws DataAccessException;

	BranchUserResponse getBranchUser(BranchUserRequest branchUserRequest) throws DataAccessException;
	
	List<BranchUserResponse> getAllBranchUsers(BranchUserRequest branchUserRequest) throws DataAccessException;

	List<UnitNames> getListOfUnitNames(Integer clientId) throws DataAccessException;

	List<UserRole> getListOfUserRoles(Integer clientId) throws DataAccessException;

	List<EmployeeNames> getEmployeeNames(String clientId) throws DataAccessException;

}
