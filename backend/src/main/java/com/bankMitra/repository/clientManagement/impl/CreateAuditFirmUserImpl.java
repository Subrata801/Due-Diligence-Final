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
import com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest;
import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;
import com.bankMitra.model.clientManagement.response.CreateUnitResponse;
import com.bankMitra.repository.clientManagement.CreateAuditFirmUserRepository;
import com.bankMitra.repository.clientManagement.rowmapper.CreateAuditFirmUserRowMapper;
import com.bankMitra.repository.clientManagement.rowmapper.CreateUnitRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class CreateAuditFirmUserImpl implements CreateAuditFirmUserRepository {

    private static final Logger logger = LoggerFactory.getLogger(CreateUnitRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder encoder;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.CreateAuditFirmUserRepository#createAuditFirmUser(com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest)
	 */
	@Override
	public CreateAuditFirmUserResponse createAuditFirmUser(CreateAuditFirmUserRequest createAuditFirmRequest)
			throws DataAccessException {
		CreateAuditFirmUserResponse createAuditFirmUserResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ call bmadmin.funccreateaudituser(?,?,?,?,?,?,?,?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			
			if(!StringUtils.isEmpty(createAuditFirmRequest.getUserRoleId()))
				cs.setInt(1, createAuditFirmRequest.getUserRoleId());
			else
				cs.setInt(1, -1);
			if(!StringUtils.isEmpty(createAuditFirmRequest.getClientId()))
				cs.setInt(2, createAuditFirmRequest.getClientId());
			else 
				cs.setInt(2, -1);
			if(!StringUtils.isEmpty(createAuditFirmRequest.getClientName()))
				cs.setString(3, createAuditFirmRequest.getClientName());
			else 
				cs.setString(3, "");
			/*if(!StringUtils.isEmpty(createAuditFirmRequest.getClientGroupId()))
				cs.setInt(4, createAuditFirmRequest.getClientGroupId());
			else 
				cs.setInt(4, -1);*/
			cs.setString(4, createAuditFirmRequest.getEmployeeId());
			cs.setString(5, createAuditFirmRequest.getEmployeeName());
			cs.setString(6, createAuditFirmRequest.getEmployeeMail());
			cs.setLong(7, createAuditFirmRequest.getMobileNum());
			cs.setString(8, createAuditFirmRequest.getUserName());
			cs.setString(9, encoder.encode(createAuditFirmRequest.getPassword()));
			cs.setString(10, createAuditFirmRequest.getCncStatus());
			cs.setString(11, createAuditFirmRequest.getCreatedBy());
			cs.registerOutParameter(12, Types.VARCHAR);
			cs.executeUpdate();
			functionResult = cs.getString(12);
			logger.info("Function result code returned after execution of function funccreateaudituser :",functionResult);
			createAuditFirmUserResponse = new CreateAuditFirmUserResponse();
			createAuditFirmUserResponse.setMessageCode(functionResult);
			return createAuditFirmUserResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funccreateaudituser",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funccreateaudituser",e);
			throw new DataAccessException(APIConstant.MSG_GET_AUDIT_FIRM_USERS_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funccreateaudituser");
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.CreateAuditFirmUserRepository#getAuditFirmUser(com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest)
	 */
	@Override
	public CreateAuditFirmUserResponse getAuditFirmUser(CreateAuditFirmUserRequest createAuditFirmRequest)
			throws DataAccessException {
		List<CreateAuditFirmUserResponse> listOfAuditUserResponse =  null;
		try {
		if(null!=createAuditFirmRequest) {
			if(!StringUtils.isEmpty(createAuditFirmRequest.getUserName()) && !StringUtils.isEmpty(createAuditFirmRequest.getEmployeeId())){
				listOfAuditUserResponse = jdbcTemplate.query(APIConstant.QUERY_GET_USER_BY_ALL_CRITERIA 
						+ " and bmu.username = ? and bmu.employee_id = ?"
						,new Object[]{createAuditFirmRequest.getUserName(),createAuditFirmRequest.getEmployeeId()}, new CreateAuditFirmUserRowMapper());
			} 
			if(null!=listOfAuditUserResponse && CollectionUtils.isEmpty(listOfAuditUserResponse)) {
				return listOfAuditUserResponse.get(0);
			}
		}
		} catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_AUDIT_FIRM_USER_FAILURE,ex);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.CreateAuditFirmUserRepository#getAllAuditFirmUsers(com.bankMitra.model.clientManagement.request.CreateAuditFirmUserRequest)
	 */
	@Override
	public List<CreateAuditFirmUserResponse> getAllAuditFirmUsers(CreateAuditFirmUserRequest searchUserRequest)
			throws DataAccessException {
		String userQuery = APIConstant.QUERY_GET_USER_BY_ALL_CRITERIA;
		try {
			if(null!=searchUserRequest && !StringUtils.isEmpty(searchUserRequest.getSearchType())){
				if(APIConstant.USER_SEARCH_TYPE_BY_USERNAME.equalsIgnoreCase(searchUserRequest.getSearchType()))
					return jdbcTemplate.query(userQuery + " and UPPER(username) like '%"+searchUserRequest.getSearchKeyword().toUpperCase()+"%' order by bmu.username",
							 new AuditFirmUserSearchRowMapper());
				else if(APIConstant.USER_SEARCH_TYPE_BY_FULLNAME.equalsIgnoreCase(searchUserRequest.getSearchType()))
					return jdbcTemplate.query(userQuery +" and UPPER(fullname) like '%"+searchUserRequest.getSearchKeyword().toUpperCase()+"%'  order by bmu.username", new AuditFirmUserSearchRowMapper());
				else if(APIConstant.USER_SEARCH_TYPE_BY_USERTYPE.equalsIgnoreCase(searchUserRequest.getSearchType())) {
					if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0  && 
							searchUserRequest.getClientId()!=null && searchUserRequest.getClientId() >0 && 
							searchUserRequest.getClientGroupId() !=null && searchUserRequest.getClientGroupId() >0 
									&& searchUserRequest.getUserRoleId()!=null && searchUserRequest.getUserRoleId() >0) {
						userQuery = APIConstant.QUERY_GET_AUDITUSER_BY_ALL_CRITERIA;
						return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmu.client_id = ? and bmur.user_role_id = ? and client_group_id = ? order by bmu.username",
							   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getClientId(),searchUserRequest.getUserRoleId(),searchUserRequest.getClientGroupId()}, new AuditFirmUserSearchRowMapper());
					} else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0  && 
							searchUserRequest.getClientId()!=null && searchUserRequest.getClientId() >0 && 
									 searchUserRequest.getUserRoleId()!=null && searchUserRequest.getUserRoleId() >0)
						   return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmu.client_id = ? and bmur.user_role_id = ? order by bmu.username",
								   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getClientId(),searchUserRequest.getUserRoleId()}, new AuditFirmUserSearchRowMapper());
					else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0  && 
							searchUserRequest.getClientId()!=null && searchUserRequest.getClientId() >0 && 
							searchUserRequest.getClientGroupId() !=null && searchUserRequest.getClientGroupId() >0 ) {
						userQuery = APIConstant.QUERY_GET_AUDITUSER_BY_ALL_CRITERIA;
						return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmu.client_id = ? and client_group_id = ? order by bmu.username",
							   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getClientId(),searchUserRequest.getClientGroupId()}, new AuditFirmUserSearchRowMapper());
					} else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0  && 
							searchUserRequest.getClientId()!=null && searchUserRequest.getClientId() >0)
						   return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmu.client_id = ? order by bmu.username",
								   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getClientId()}, new AuditFirmUserSearchRowMapper());
					else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0 && searchUserRequest.getUserRoleId()!=null && searchUserRequest.getUserRoleId()>0)
						   return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmur.user_role_id = ? order by bmu.username",
								   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getUserRoleId()}, new AuditFirmUserSearchRowMapper());
					else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0)
						   return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? order by bmu.username",
								   new Object[]{searchUserRequest.getClientTypeId()}, new AuditFirmUserSearchRowMapper());
					else
						return jdbcTemplate.query(userQuery + " order by bmu.username ", new AuditFirmUserSearchRowMapper());
					
				}
			}  
		} catch (EmptyResultDataAccessException e) {
			logger.error("No user returned from db :",e);
			return new ArrayList<CreateAuditFirmUserResponse>();
	    } catch (Exception ex) {
			logger.error("Exception while getting list of user :" + ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_USER_SEARCH_FAILURE);
		}
		return null;
	}

}
