/**
 * 
 */
package com.bankMitra.service.clientManagement.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.bankenduserpanel.response.Makers;
import com.bankMitra.model.clientManagement.request.BranchUserRequest;
import com.bankMitra.model.clientManagement.response.BranchUserResponse;
import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;
import com.bankMitra.model.clientManagement.response.EmployeeNames;
import com.bankMitra.model.clientManagement.response.UnitNames;
import com.bankMitra.model.clientManagement.response.UserRole;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.clientManagement.BranchUserRepository;
import com.bankMitra.repository.clientManagement.impl.BranchUserRepositoryImpl;
import com.bankMitra.service.clientManagement.BranchUserService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author bankMitra
 *
 */
@Service
public class BranchUserServiceImpl implements BranchUserService {
	private static final Logger logger = LoggerFactory.getLogger(BranchUserServiceImpl.class);
	@Autowired
	BranchUserRepository branchUserRepository;
	
	@Autowired
	ReferenceService refService;
	
	
	private MessageCode getMessageDescription(String dbResponseCode) throws ResourceNotFoundException {
		MessageCode msgOutPut = null;
		List<MessageCode> msgCodes = refService.getListOfMessageCode();
		for(MessageCode msg : msgCodes) {
			if(msg.getMessageCode().equalsIgnoreCase(dbResponseCode)) {
				msgOutPut =  msg;
				break;
			}
		}
		return msgOutPut;
	}


	@Override
	@Transactional
	public BranchUserResponse createBranchUser(BranchUserRequest branchUserRequest) throws APIException {
		BranchUserResponse branchUserResponse = null;
		try {
			branchUserResponse  =  branchUserRepository.createBranchUser(branchUserRequest);
			final String dbResponseCode = branchUserResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				branchUserResponse.setMessageCode(filteredMsgData.getMessageCode());
				branchUserResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_BRANCH_USER_FAILURE);
		}
		return branchUserResponse;
	}


	@Override
	@Transactional(readOnly=true)
	public BranchUserResponse getBranchUser(BranchUserRequest branchUserRequest) throws APIException {
		BranchUserResponse userResponse = null;
		try {
			userResponse = branchUserRepository.getBranchUser(branchUserRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_BRANCH_USER_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_BRANCH_USER_FAILURE,e.getMessage());
		}
		return userResponse;
	}


	@Override
	@Transactional(readOnly=true)
	public List<BranchUserResponse> getAllBranchUsers(BranchUserRequest branchUserRequest) throws APIException {
		List<BranchUserResponse> listOfBranchUsers = null;
		try {
			listOfBranchUsers = branchUserRepository.getAllBranchUsers(branchUserRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_BRANCH_LIST_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_BRANCH_LIST_FAILURE,e.getMessage());
		}
		return listOfBranchUsers;
	}


	@Override
	@Transactional(readOnly=true)
	public List<UnitNames> getListOfUnitNames(Integer clientId) throws APIException {
		List<UnitNames> unitNameList = null;
		try {
			unitNameList = branchUserRepository.getListOfUnitNames(clientId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_UNITNAME_FAILURE);
		} 
		if(!Optional.ofNullable(unitNameList).isPresent() || unitNameList.isEmpty() )
			unitNameList = new ArrayList<UnitNames>();
		
		return unitNameList;
	}


	@Override
	@Transactional(readOnly=true)
	public List<UserRole> getListOfUserRoles(Integer unitId) throws APIException {
		List<UserRole> userRoleList = null;
		try {
			userRoleList = branchUserRepository.getListOfUserRoles(unitId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_USERROLE_FAILURE);
		} 
		if(!Optional.ofNullable(userRoleList).isPresent() || userRoleList.isEmpty() )
			userRoleList = new ArrayList<UserRole>();
		
		return userRoleList;
	}


	@Override
	@Transactional(readOnly=true)
	public List<EmployeeNames> getEmployeeNames(String emplId) throws APIException {
		List<EmployeeNames> employeeList = null;
		try {
			employeeList = branchUserRepository.getEmployeeNames(emplId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			logger.error("BranchUserServiceImpl:getEmployeeNames:exception occurred:"+e);
			throw new APIException(APIConstant.MSG_GET_EMPLOYEE_FAILURE);
		} 
		if(!Optional.ofNullable(employeeList).isPresent() || employeeList.isEmpty() )
			employeeList = new ArrayList<EmployeeNames>();
		
		return employeeList;
	}

}
