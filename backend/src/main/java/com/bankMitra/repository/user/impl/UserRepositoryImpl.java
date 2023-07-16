/**
 * 
 */
package com.bankMitra.repository.user.impl;


import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.UserRequest;
import com.bankMitra.model.admin.response.ClientLoanSchemeResponse;
import com.bankMitra.model.auth.ResetPasswordRequest;
import com.bankMitra.model.reference.ClientGroup;
import com.bankMitra.model.user.User;
import com.bankMitra.repository.admin.rowmapper.ClientRowMapper;
import com.bankMitra.repository.reference.impl.ClientGroupRowMapper;
import com.bankMitra.repository.user.UserRepository;
import com.bankMitra.util.APIConstant;

/**
 * @author BankMitra
 *
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	PasswordEncoder encoder;
	
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplate = new JdbcTemplate(dataSource);
	   }
	
	private static final String GET_USER_BY_LOGGEDIN_USERNAME = "select BMU.user_id,BMU.username,BMU.password,BMU.userstatus,"
			+ "BMUR.user_role_name,BMU.client_id,BMU.client_name,BMU.email,BMU.fullname,BMU.last_login,BMU.mobile_number,"
			+ "BMUR.user_role_id,BMUR.client_type_id,bmucg.client_group_id from bmadmin.bmusers BMU, bmadmin.bmuserroles BMUR,"
			+ "bmadmin.bmclienttype BMUT, bmadmin.bmuserclientgroup bmucg where  BMU.user_role_id = BMUR.user_role_id "
			+ "and  BMU.user_id=bmucg.user_id and  BMUR.client_type_id = BMUT.client_type_id and    UPPER(BMU.username) = UPPER(?)";
	
	private static final String VALIDATE_USERNAME_PASSWORD = "select BMU.user_id,BMU.username,BMU.password,BMU.userstatus,"
			+ "BMUR.user_role_name,BMU.client_id,BMU.client_name,BMU.email,BMU.fullname,BMU.last_login,BMU.mobile_number,"
			+ "BMUR.user_role_id,BMUR.client_type_id,bmucg.client_group_id from bmadmin.bmusers BMU, bmadmin.bmuserroles BMUR,"
			+ "bmadmin.bmclienttype BMUT, bmadmin.bmuserclientgroup bmucg where  BMU.user_role_id = BMUR.user_role_id "
			+ "and  BMU.user_id=bmucg.user_id and  BMUR.client_type_id = BMUT.client_type_id and    UPPER(BMU.username) = UPPER(?)";
	
		
	private static final String GET_USER_BY_USERNAME_SECURITYQUEST = "select user_id from "
			+ "bmadmin.bmusersecuritydetails where user_id =? and security_question_id =? and answer= ?";
	
	private static final String INSERT_USER_QUERY = "insert into bmadmin.bmusers (user_id,username,fullname,user_role_id,password,"
			+ "email,mobile_number,userstatus,created_date,created_by,"
			+ " updated_date,updated_by,client_id,client_name) values (?, ?,?,?,?,?,?,?, sysdate,?,sysdate,?,?,?)";

	private static final String GET_CLIENTGROUP_LIST = "SELECT client_group_id,client_id,client_group_type_id,client_group_name FROM bmadmin.bmclientgroup where client_id = ?";


	@Override
	public User getUserByUserName(String userName) {
		return jdbcTemplate.queryForObject(GET_USER_BY_LOGGEDIN_USERNAME,
				new Object[]{userName}, new UserRowMapper());
	}

	private List<ClientGroup> getListOfClientGroup(Integer clientId) {
		return jdbcTemplate.query(GET_CLIENTGROUP_LIST,
				new Object[]{clientId},new ClientGroupRowMapper());
	}
	
	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String registerUser(User user,String adminUser) throws DataAccessException {
		Connection connection = null;
		String functionResult = null;
		CallableStatement cs = null;
		String funcName = "funccreateuser";
		try {
			if(user.getUserId()<=0) {
				funcName = "{ ? = call bmadmin.funccreateuser(?,?,?,?,?,?,?,?,?,?,?,?) }";
				connection = jdbcTemplate.getDataSource().getConnection();
				cs = connection.prepareCall(funcName);
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setInt(2, user.getUserRoleId());
		        cs.setInt(3, user.getClientId());
		        cs.setString(4, user.getClientName());
		        List<ClientGroup> clientGroupList = getListOfClientGroup(user.getClientId());
		        if(!CollectionUtils.isEmpty(clientGroupList)) {
			        Array intArr =  connection.createArrayOf("SMALLINT",new Integer[]{clientGroupList.get(0).getClienGroupId()});
			        cs.setArray(5, intArr);
		        } else {
		        	cs.setArray(5, connection.createArrayOf("SMALLINT",new Integer[]{1}));
		        }
				cs.setString(6, String.valueOf(user.getEmployeeId()));
				cs.setString(7, user.getFullName());
				cs.setString(8, user.getEmail());
				cs.setLong(9, user.getMobileNumber());
				cs.setString(10, user.getUserName());
				cs.setString(11, user.getPassword());
				cs.setString(12, user.getUserStatus());
				cs.setString(13, user.getCreatedBy());
				
				cs.executeUpdate();
				functionResult = cs.getString(1);
			} else {
				funcName = "{ ? = call bmadmin.funcupdateuser(?,?,?,?,?,?,?,?,?,?,?)}";
				connection = jdbcTemplate.getDataSource().getConnection();
				cs = connection.prepareCall(funcName);
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setInt(2, user.getUserRoleId());
				cs.setInt(3, user.getClientId());
				cs.setString(4, user.getClientName());
				List<ClientGroup> clientGroupList = getListOfClientGroup(user.getClientId());
		        if(!CollectionUtils.isEmpty(clientGroupList)) {
			        Array intArr =  connection.createArrayOf("SMALLINT",new Integer[]{clientGroupList.get(0).getClienGroupId()});
			        cs.setArray(5, intArr);
		        } else {
		        	cs.setArray(5, connection.createArrayOf("SMALLINT",new Integer[]{1}));
		        }
				cs.setString(6, user.getEmployeeId());
				cs.setString(7, user.getFullName());
				cs.setString(8, user.getEmail());
				cs.setLong(9, user.getMobileNumber());
				cs.setString(10, user.getUserName());
				cs.setString(11, user.getUserStatus());
				cs.setString(12, user.getCreatedBy());
				
				cs.executeUpdate();
				functionResult = cs.getString(1);
			}
		} catch (SQLException e) {
			logger.error("Failure while calling function funccreateuser :",e.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("unable to close the callable statement or connection for function :",funcName,e);
			}
		}
		return functionResult;
	}

	@Override
	public User checkSecurityQuestionDetails(Long userId,Integer securityQuestionId, String securityQuestionAnswer) {
		return jdbcTemplate.queryForObject(GET_USER_BY_USERNAME_SECURITYQUEST,
				new Object[]{userId,securityQuestionId,securityQuestionAnswer}, new UserRowMapper());
	}

	@Override
	public String resetPassword(ResetPasswordRequest resetPasswordRequest) throws DataAccessException {
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ ? = call bmadmin.funcresetpassword(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, resetPasswordRequest.getUsername());
			cs.setString(3, resetPasswordRequest.getSecurityQuestionId());
			cs.setString(4, resetPasswordRequest.getSecurityQuestionAnswer());
			cs.setString(5, encoder.encode(resetPasswordRequest.getNewPassword()));
			cs.executeUpdate();
			functionResult = cs.getString(1);
		} catch (Exception e) {
			logger.error("Failed while executing function funcresetpassword ",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (Exception e) {
				logger.error("unable to close the callable statement or connection for function funcresetpassword",e);
			}
		}
		return functionResult;
	}

	@Override
	public User authenticateUser(String username, String password) throws DataAccessException {
		User usrDetail = null;
		try {
			usrDetail = jdbcTemplate.queryForObject(VALIDATE_USERNAME_PASSWORD,
					new Object[]{username}, new UserRowMapper());
		} catch (Exception ex) {
			logger.error("Unable to find username ",ex.getMessage());
			usrDetail = new User();
			usrDetail.setOutputCode(APIConstant.LOGIN_FAILURE_CODE);
			return usrDetail;
		}
		
		try {
			if(null!=usrDetail) {
			    boolean isPasswordMatch = encoder.matches(password, usrDetail.getPassword());
				if(null!=usrDetail && !StringUtils.isEmpty(usrDetail.getUserName()) && isPasswordMatch) {
					List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.VARCHAR));
					Map<String, Object> result = jdbcTemplate.call(new CallableStatementCreator() {
				      @Override
				      public CallableStatement createCallableStatement(Connection con) throws SQLException {
				        CallableStatement cs = con.prepareCall("{call bmadmin.funcuserlogin(?,?)}");
				        cs.setString(1, username);
				        cs.setString(2, password);
				        return cs;
				      }
				    }, parameters);  
					
					List<Map<String, Object>> results = (List<Map<String, Object>>) result.get("#result-set-1");
					String functionResult = null;
					for(Map resultMap : results) {
						System.out.println(resultMap.get("op_return_code"));
						functionResult = String.valueOf(resultMap.get("op_return_code"));
						if(!StringUtils.isEmpty(functionResult)) {
							usrDetail = new User();
							if(APIConstant.SUCCESS_CODE.equalsIgnoreCase(functionResult)) {
								usrDetail.setUserTypeId(Integer.parseInt(String.valueOf(resultMap.get("op_client_type_id"))));
								usrDetail.setUserTypeName(String.valueOf(resultMap.get("op_client_type_name")));
								usrDetail.setClientId(Integer.parseInt(String.valueOf(resultMap.get("op_client_id"))));
								usrDetail.setClientName(String.valueOf(resultMap.get("op_client_name")));
								usrDetail.setUserRoleName(String.valueOf(resultMap.get("op_user_role")));
								usrDetail.setUserStatus(String.valueOf(resultMap.get("op_user_status")));
								usrDetail.setCustomerLogoPath(String.valueOf(resultMap.get("op_customer_logo_path")));
								usrDetail.setLastLogin((Date) resultMap.get("op_last_login"));
								usrDetail.setOutputCode(functionResult);
							} else {
								usrDetail.setOutputCode(functionResult);
							}
						} else {
							throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
						}
					}
					//usrDetail.setOutputCode(APIConstant.SUCCESS_CODE);
				} else {
					usrDetail.setOutputCode(APIConstant.LOGIN_FAILURE_CODE);
				}
			} else {
				usrDetail.setOutputCode(APIConstant.LOGIN_FAILURE_CODE);
			}
		} catch (Exception e) {
			logger.error("Failed while executing  authenticating user ",e.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			
		} 
		return usrDetail;
	}

	@Override
	public String updatedPassword(ResetPasswordRequest updatePasswordRequest) throws DataAccessException {
		Connection connection = null;
		String functionResult = null;
		CallableStatement cs = null;
		try {
			String runFunction = "{ ? = call bmadmin.funcupdatepassword(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, updatePasswordRequest.getUsername());
			cs.setString(3, updatePasswordRequest.getSecurityQuestionId());
			cs.setString(4, updatePasswordRequest.getSecurityQuestionAnswer());
			cs.setString(5, encoder.encode(updatePasswordRequest.getNewPassword()));
			cs.executeUpdate();
			functionResult = cs.getString(1);
			//System.out.println(functionResult);
			//functionResult = APIConstant.SUCCESS_CODE;
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (Exception e) {
				logger.error("unable to close the callable statement or connection for function funcupdatepassword",e);
			}
		}
		return functionResult;
	}

	@Override
	public String updateUserDetails(User userDetailRequest) throws DataAccessException {
		Connection connection = null;
		String functionResult = null;
		CallableStatement cs = null;
		try {
			String runFunction = "{ ? = call bmadmin.funcupdateuser(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, userDetailRequest.getUserName());
			cs.setString(3, userDetailRequest.getFullName());
			cs.setLong(4, userDetailRequest.getMobileNumber());
			cs.setString(5, userDetailRequest.getEmail());
			cs.executeUpdate();
			functionResult = cs.getString(1);
			System.out.println(functionResult);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (Exception e) {
				logger.error("unable to close the callable statement or connection for function funcupdateuser",e);
			}
		}
		return functionResult;
	}

	@Override
	public List<User> getListOfUsers(UserRequest searchUserRequest) throws DataAccessException {
		String userQuery = APIConstant.QUERY_GET_USER_BY_ALL_CRITERIA;
		try {
			if(null!=searchUserRequest && !StringUtils.isEmpty(searchUserRequest.getKeywordType())){
				if(APIConstant.USER_SEARCH_TYPE_BY_USERID.equalsIgnoreCase(searchUserRequest.getKeywordType()))
					return jdbcTemplate.query(userQuery + " and user_id = ? ",new Object[]{searchUserRequest.getUserId()},
							 new UserSearchRowMapper());
				else if(APIConstant.USER_SEARCH_TYPE_BY_USERNAME.equalsIgnoreCase(searchUserRequest.getKeywordType()))
					return jdbcTemplate.query(userQuery + " and UPPER(username) like '%"+searchUserRequest.getKeyword().toUpperCase()+"%' order by bmu.username",
							 new UserSearchRowMapper());
				else if(APIConstant.USER_SEARCH_TYPE_BY_FULLNAME.equalsIgnoreCase(searchUserRequest.getKeywordType()))
					return jdbcTemplate.query(userQuery +" and UPPER(fullname) like '%"+searchUserRequest.getKeyword().toUpperCase()+"%'  order by bmu.username", new UserSearchRowMapper());
				else if(APIConstant.USER_SEARCH_TYPE_BY_EMAIL.equalsIgnoreCase(searchUserRequest.getKeywordType()))
					return jdbcTemplate.query(userQuery +" and UPPER(email) like '%"+searchUserRequest.getKeyword().toUpperCase()+"%'  order by bmu.username", new UserSearchRowMapper());
				else if(APIConstant.USER_SEARCH_TYPE_BY_MOBILE.equalsIgnoreCase(searchUserRequest.getKeywordType()))
					return jdbcTemplate.query(userQuery +" and mobile_number = ? ",new Object[]{Long.parseLong(searchUserRequest.getKeyword())}, new UserSearchRowMapper());
				else if(APIConstant.USER_SEARCH_TYPE_BY_USERTYPE.equalsIgnoreCase(searchUserRequest.getKeywordType())) {
					if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0  && 
							searchUserRequest.getClientId()!=null && searchUserRequest.getClientId() >0 && 
							searchUserRequest.getClientGroupId() !=null && searchUserRequest.getClientGroupId() >0 
									&& searchUserRequest.getUserRoleId()!=null && searchUserRequest.getUserRoleId() >0) {
						userQuery = APIConstant.QUERY_GET_AUDITUSER_BY_ALL_CRITERIA;
						return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmu.client_id = ? and bmur.user_role_id = ? and client_group_id = ? order by bmu.username",
							   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getClientId(),searchUserRequest.getUserRoleId(),searchUserRequest.getClientGroupId()}, new UserSearchRowMapper());
					} else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0  && 
							searchUserRequest.getClientId()!=null && searchUserRequest.getClientId() >0 && 
									 searchUserRequest.getUserRoleId()!=null && searchUserRequest.getUserRoleId() >0)
						   return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmu.client_id = ? and bmur.user_role_id = ? order by bmu.username",
								   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getClientId(),searchUserRequest.getUserRoleId()}, new UserSearchRowMapper());
					else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0  && 
							searchUserRequest.getClientId()!=null && searchUserRequest.getClientId() >0 && 
							searchUserRequest.getClientGroupId() !=null && searchUserRequest.getClientGroupId() >0 ) {
						userQuery = APIConstant.QUERY_GET_AUDITUSER_BY_ALL_CRITERIA;
						return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmu.client_id = ? and client_group_id = ? order by bmu.username",
							   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getClientId(),searchUserRequest.getClientGroupId()}, new UserSearchRowMapper());
					} else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0  && 
							searchUserRequest.getClientId()!=null && searchUserRequest.getClientId() >0)
						   return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmu.client_id = ? order by bmu.username",
								   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getClientId()}, new UserSearchRowMapper());
					else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0 && searchUserRequest.getUserRoleId()!=null && searchUserRequest.getUserRoleId()>0)
						   return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? and bmur.user_role_id = ? order by bmu.username",
								   new Object[]{searchUserRequest.getClientTypeId(),searchUserRequest.getUserRoleId()}, new UserSearchRowMapper());
					else if(searchUserRequest.getClientTypeId() !=null && searchUserRequest.getClientTypeId()>0)
						   return jdbcTemplate.query(userQuery +" and bmct.client_type_id = ? order by bmu.username",
								   new Object[]{searchUserRequest.getClientTypeId()}, new UserSearchRowMapper());
					else
						return jdbcTemplate.query(userQuery + " order by bmu.username ", new UserSearchRowMapper());
					
				} else if(APIConstant.USER_SEARCH_TYPE_BY_USERROLE.equalsIgnoreCase(searchUserRequest.getKeywordType()))
					return jdbcTemplate.query(userQuery +" and bmur.user_role_id = ? order by bmu.username",new Object[]{Long.parseLong(searchUserRequest.getKeyword())}, new UserSearchRowMapper());
			}  
		} catch (EmptyResultDataAccessException e) {
			logger.error("No user returned from db :",e);
			return new ArrayList<User>();
	    } catch (Exception ex) {
			logger.error("Exception while getting list of user :" + ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_USER_SEARCH_FAILURE);
		}
		return null;
	}
	
}

