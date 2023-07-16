/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.ReassignUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.request.SaveReassignUserRequest;
import com.bankMitra.model.bankenduserpanel.response.Checkers;
import com.bankMitra.model.bankenduserpanel.response.E2EDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.Makers;
import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationResponse;
import com.bankMitra.model.bankenduserpanel.response.SanctionAuthority;
import com.bankMitra.model.bankenduserpanel.response.SaveReassignUserResponse;
import com.bankMitra.repository.bankenduserpanel.ReassignUserRepository;
import com.bankMitra.repository.bankenduserpanel.rowmapper.CheckerRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.MakerRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.ReAssignUserM1RowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.ReAssignUserM2RowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.ReAssignUserM3RowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.ReAssignUserM4RowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.ReAssignUserM5RowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.SanctionAuthorityRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class ReassignUserRepositoryImpl implements ReassignUserRepository {

	private static final Logger logger = LoggerFactory.getLogger(ReassignUserRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.bankenduserpanel.ReassignUserRepository#reassignUser(com.bankMitra.model.bankenduserpanel.request.ReassignUserApplicationRequest)
	 */
	@Override
	public ReassignUserApplicationResponse reassignUser(
			@Valid ReassignUserApplicationRequest reassignUserApplicationRequest) throws DataAccessException {
		ReassignUserApplicationResponse userAppResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ call bmadmin.funcreassincancelapplication(?,?,?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			cs.setString(1, reassignUserApplicationRequest.getCreatedBy());
			if(!StringUtils.isEmpty(reassignUserApplicationRequest.getE2eNum()))
				cs.setInt(2, Integer.parseInt(reassignUserApplicationRequest.getE2eNum()));
			else
				cs.setInt(2, -1);
			cs.setString(3, reassignUserApplicationRequest.getMaker());
			cs.setString(4, reassignUserApplicationRequest.getChecker());
			cs.setString(5, reassignUserApplicationRequest.getSanctioningAuth());
			cs.setString(6, reassignUserApplicationRequest.getReasonOfCancellation());
			cs.registerOutParameter(7,Types.VARCHAR);
			cs.executeUpdate();
			functionResult = cs.getString(7);
			logger.info("Function result code returned after execution of function funcreassincancelapplication :",functionResult);
			userAppResponse = new ReassignUserApplicationResponse();
			userAppResponse.setMessageCode(functionResult);
			return userAppResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcreassincancelapplication",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funcreassincancelapplication",e);
			throw new DataAccessException(APIConstant.MSG_REASSIGN_USER_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funcreassincancelapplication");
			}
		}
	}

	@Override
	public List<ReassignUserApplicationResponse> getAllUserList(
			ReassignUserApplicationRequest reassignUserApplicationRequest) throws DataAccessException {
		List<ReassignUserApplicationResponse> listOfDashboardTask =  null;
		try {
			if(null!=reassignUserApplicationRequest && !StringUtils.isEmpty(reassignUserApplicationRequest.getModuleName())) {
				  if(APIConstant.MODULE_NAME_M1.equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())){
					  listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_REASSIGN_TASKS_M1
							,new Object[]{Integer.parseInt(reassignUserApplicationRequest.getClientId()),
									Integer.parseInt(reassignUserApplicationRequest.getClientGroupId()),
									reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy(), 
									reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy()}, new ReAssignUserM1RowMapper());
				  } else if(APIConstant.MODULE_NAME_M2.equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())){
					  listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_REASSIGN_TASKS_M2
								,new Object[]{Integer.parseInt(reassignUserApplicationRequest.getClientId()),
										Integer.parseInt(reassignUserApplicationRequest.getClientGroupId()),
										reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy(), 
										reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy()}, new ReAssignUserM1RowMapper());
				  } else if(APIConstant.MODULE_NAME_M3.equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_REASSIGN_TASKS_M3
								,new Object[]{Integer.parseInt(reassignUserApplicationRequest.getClientId()),
										Integer.parseInt(reassignUserApplicationRequest.getClientGroupId()),
										reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy(), 
										reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy()}, new ReAssignUserM1RowMapper());
				  } else if(APIConstant.MODULE_NAME_M4.equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_REASSIGN_TASKS_M4
								,new Object[]{Integer.parseInt(reassignUserApplicationRequest.getClientId()),
										Integer.parseInt(reassignUserApplicationRequest.getClientGroupId()),
										reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy(), 
										reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy()}, new ReAssignUserM1RowMapper());
				  } else if(APIConstant.MODULE_NAME_M5.equalsIgnoreCase(reassignUserApplicationRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_REASSIGN_TASKS_M5
								,new Object[]{Integer.parseInt(reassignUserApplicationRequest.getClientId()),
										Integer.parseInt(reassignUserApplicationRequest.getClientGroupId()),
										reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy(), 
										reassignUserApplicationRequest.getCreatedBy(), reassignUserApplicationRequest.getCreatedBy()}, new ReAssignUserM1RowMapper());
				  }
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error(APIConstant.MSG_GET_REASSIGNUSERS_TASKS_FAILURE+e);
			return new ArrayList<ReassignUserApplicationResponse>();
	    } catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_REASSIGNUSERS_TASKS_FAILURE+ ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_GET_DASHBOARDTASKS_FAILURE);
		} 
		return listOfDashboardTask;

	}

	@Override
	public List<Makers> getListOfMakers(String clientGroupId) throws DataAccessException {
		return jdbcTemplate.query(APIConstant.GET_MAKERS_LIST,new Object[]{clientGroupId},new MakerRowMapper());
	}

	@Override
	public List<Checkers> getListOfCheckers(String clientGroupId) throws DataAccessException {
		return jdbcTemplate.query(APIConstant.GET_CHECKERS_LIST,new Object[]{clientGroupId},new CheckerRowMapper());
	}

	@Override
	public List<SanctionAuthority> getListOfSanctioningAuthority(String clientGroupId,String zo_client_group_id,
			String cpc_client_group_id,String ho_client_group_id) throws DataAccessException {
		return jdbcTemplate.query(APIConstant.GET_SA_LIST,new Object[]{clientGroupId,zo_client_group_id,
				cpc_client_group_id,ho_client_group_id},new SanctionAuthorityRowMapper());
	}
	
	@Override
	public SaveReassignUserResponse saveReassignUserDB(SaveReassignUserRequest request) throws DataAccessException {
		SaveReassignUserResponse saveReassignUserResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		
		try {
			String runFunction = "{ call bmadmin.funcreassincancelapplication(?,?,?,?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			cs.setString(1, request.getUserName());
			cs.setString(2, request.getE2e());
			
			if(!StringUtils.isEmpty(request.getBranchMaker()))
				cs.setString(3, request.getBranchMaker());
			else 
				cs.setString(3, "");
			
			if(!StringUtils.isEmpty(request.getUnitChecker()))
				cs.setString(4, request.getUnitChecker());
			else 
				cs.setString(4, "");
			if(!StringUtils.isEmpty(request.getSanctionedAuthority()))
				cs.setString(5, request.getSanctionedAuthority());
			else 
				cs.setString(5, "");
			
			if(!StringUtils.isEmpty(request.getIsCancel()))
				cs.setString(6, request.getIsCancel());
			else 
				cs.setString(6, "");
			if(!StringUtils.isEmpty(request.getCancelReason()))
				cs.setString(7, request.getCancelReason());
			else 
				cs.setString(7, "");
			
			cs.registerOutParameter(8, Types.VARCHAR);
			cs.executeUpdate();
			functionResult = cs.getString(8);
			logger.info("Function result code returned after execution of function funcreassincancelapplication :{}",functionResult);
			saveReassignUserResponse = new SaveReassignUserResponse();
			saveReassignUserResponse.setMessageCode(functionResult);
			return saveReassignUserResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcreassincancelapplication",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funcreassincancelapplication",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funcreassincancelapplication");
			}
		}
	}

}
