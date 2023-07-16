/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.BranchUserRequest;
import com.bankMitra.model.clientManagement.response.BranchUserResponse;
import com.bankMitra.model.clientManagement.response.EmployeeNames;
import com.bankMitra.model.clientManagement.response.UnitNames;
import com.bankMitra.model.clientManagement.response.UserRole;
import com.bankMitra.repository.clientManagement.BranchUserRepository;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class BranchUserRepositoryImpl implements BranchUserRepository {

	private static final Logger logger = LoggerFactory.getLogger(BranchUserRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder encoder;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.BranchUserRepository#createBranchUser(com.bankMitra.model.clientManagement.request.BranchUserRequest)
	 */
	@Override
	public BranchUserResponse createBranchUser(BranchUserRequest branchUserRequest) throws DataAccessException {
		BranchUserResponse branchUserResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ call bmadmin.funccreatebranchuser(?,?,?,?,?,?,?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			if(!StringUtils.isEmpty(branchUserRequest.getUserRoleId()))
				cs.setInt(1, branchUserRequest.getUserRoleId());
			else
				cs.setInt(1, -1);
			if(!StringUtils.isEmpty(branchUserRequest.getClientId()))
				cs.setInt(2, branchUserRequest.getClientId());
			else 
				cs.setInt(2, -1);
			if(!StringUtils.isEmpty(branchUserRequest.getClientName()))
				cs.setString(3, branchUserRequest.getClientName());
			else 
				cs.setString(3, "");
			if(!StringUtils.isEmpty(branchUserRequest.getUnitName()))
				cs.setInt(4, Integer.parseInt(branchUserRequest.getUnitName()));
			else 
				cs.setInt(4, -1);			
			cs.setString(5, branchUserRequest.getEmployeeId());
			cs.setString(6, branchUserRequest.getEmployeeName());
			cs.setString(7, branchUserRequest.getUserName());
			if(!branchUserRequest.isEditUser())
				cs.setString(8, encoder.encode(branchUserRequest.getPassword()));
			else
				cs.setString(8, null);
			cs.setString(9, branchUserRequest.getE2eStatus());
			cs.setString(10, branchUserRequest.getCreatedBy());
			cs.registerOutParameter(11, Types.VARCHAR);
			cs.executeUpdate();
			functionResult = cs.getString(11);
			logger.info("Function result code returned after execution of function funccreatebranchuser :",functionResult);
			branchUserResponse = new BranchUserResponse();
			branchUserResponse.setMessageCode(functionResult);
			return branchUserResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funccreatebranchuser",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funccreatebranchuser",e);
			throw new DataAccessException(APIConstant.MSG_CREATE_UNIT_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funccreatebranchuser");
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.BranchUserRepository#getBranchUser(com.bankMitra.model.clientManagement.request.BranchUserRequest)
	 */
	@Override
	public BranchUserResponse getBranchUser(BranchUserRequest branchUserRequest) throws DataAccessException {
		List<BranchUserResponse> listOfUserResponse =  null;
		try {
		if(null!=branchUserRequest) {
			if(!StringUtils.isEmpty(branchUserRequest.getUserName())){
				listOfUserResponse = jdbcTemplate.query(APIConstant.QUERY_GET_BRANCH_USER_BY_EACHUSER
						,new Object[]{branchUserRequest.getUserName()}, new SingleBranchUserRowMapper());
			} 
			if(null!=listOfUserResponse && !CollectionUtils.isEmpty(listOfUserResponse)) {
				return listOfUserResponse.get(0);
			}
		}
		} catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_BRANCH_USER_FAILURE,ex);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.BranchUserRepository#getAllBranchUsers(com.bankMitra.model.clientManagement.request.BranchUserRequest)
	 */
	@Override
	public List<BranchUserResponse> getAllBranchUsers(BranchUserRequest searchUserRequest) throws DataAccessException {
		String userQuery = APIConstant.QUERY_GET_BRANCH_USER_BY_ALL_CRITERIA;
		try {
			if(null!=searchUserRequest && !StringUtils.isEmpty(searchUserRequest.getSearchType())){
				if(APIConstant.SEARCH_USERNAME.equalsIgnoreCase(searchUserRequest.getSearchType()))
					return jdbcTemplate.query(userQuery + "  and bmu.username like '%"+searchUserRequest.getSearchKeyword()+"%'",new Object[]{searchUserRequest.getClientId()},
							 new BranchUserSearchRowMapper());
				else if(APIConstant.SEARCH_EMPID.equalsIgnoreCase(searchUserRequest.getSearchType()))
					return jdbcTemplate.query(userQuery + "  and bmu.employee_id like '%"+searchUserRequest.getSearchKeyword()+"%'",new Object[]{searchUserRequest.getClientId()},
							 new BranchUserSearchRowMapper());
				else if(APIConstant.SEARCH_EMPNAME.equalsIgnoreCase(searchUserRequest.getSearchType()))
					return jdbcTemplate.query(userQuery + " and bmu.fullname like '%"+searchUserRequest.getSearchKeyword()+"%'",new Object[]{searchUserRequest.getClientId()},
							 new BranchUserSearchRowMapper());
									
			}  
		} catch (EmptyResultDataAccessException e) {
			logger.error("No user returned from db :",e);
			return new ArrayList<BranchUserResponse>();
	    } catch (Exception ex) {
			logger.error("Exception while getting list of user :" + ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_USER_SEARCH_FAILURE);
		}
		return null;

	}

	@Override
	public List<UnitNames> getListOfUnitNames(Integer clientId) throws DataAccessException {
		try {
		  return jdbcTemplate.query(APIConstant.GET_UNITNAME_LIST,new Object[]{clientId},new UnitNameRowMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No user returned from db for query :"+APIConstant.GET_UNITNAME_LIST+ " client id :"+clientId,e);
			return new ArrayList<UnitNames>();
	    } catch (Exception ex) {
			logger.error("Exception while getting list of unit name  :"+APIConstant.GET_UNITNAME_LIST+ " client id :"+clientId, ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_UNITNAME_SEARCH_FAILURE);
		}
	}

	@Override
	public List<UserRole> getListOfUserRoles(Integer unitId) throws DataAccessException {
		try {
			return jdbcTemplate.query(APIConstant.GET_USERROLE_LIST,new Object[]{unitId},new UserRoleRowMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("No user returned from db for query :"+APIConstant.GET_USERROLE_LIST+ " Unit id :"+unitId,e);
			return new ArrayList<UserRole>();
	    } catch (Exception ex) {
			logger.error("Exception while getting list of unit name  :"+APIConstant.GET_USERROLE_LIST+ " Unit id :"+unitId, ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_USERROLE_SEARCH_FAILURE);
		}
	}

	@Override
	public List<EmployeeNames> getEmployeeNames(String employeeId) throws DataAccessException {
		logger.info("Going to get employee  :"+APIConstant.GET_EMPLOYEE_LIST+ " Employee id :"+employeeId);
		return jdbcTemplate.query(APIConstant.GET_EMPLOYEE_LIST,new Object[]{employeeId},new EmployeeNameRowMapper());
	}

}
