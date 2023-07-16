/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.impl;

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
import com.bankMitra.model.bankenduserpanel.request.CNCDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.CNCRealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.CNCDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.CNCRealTimeDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDashboardResponse;
import com.bankMitra.repository.bankenduserpanel.CNCDashboardRepository;
import com.bankMitra.repository.bankenduserpanel.rowmapper.CNCDashboardRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2EDashboardRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class CNCDashboardRepositoryImpl implements CNCDashboardRepository {

    private static final Logger logger = LoggerFactory.getLogger(CNCDashboardRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	 
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.bankenduserpanel.CNCDashboardRepository#getAllDashboardData(com.bankMitra.model.bankenduserpanel.request.CNCDashboardRequest)
	 */
	@Override
	public List<CNCDashboardResponse> getAllDashboardData(@Valid CNCDashboardRequest cncDashboardRequest)
			throws DataAccessException {
		List<CNCDashboardResponse> listOfDashboardTask =  null;
		try {
			if(null!=cncDashboardRequest && !StringUtils.isEmpty(cncDashboardRequest.getModuleName()) 
					&& !StringUtils.isEmpty(cncDashboardRequest.getClientId()) 
					&&  !StringUtils.isEmpty(cncDashboardRequest.getUserName())) {
				  if(APIConstant.MODULE_NAME_M1.equalsIgnoreCase(cncDashboardRequest.getModuleName())){
					listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_CNC_DASHBOARD_TASKS_M1
							,new Object[]{Integer.parseInt(cncDashboardRequest.getClientId()),
							cncDashboardRequest.getUserName(),cncDashboardRequest.getUserName(),
							cncDashboardRequest.getUserName()}, new CNCDashboardRowMapper());
				  } else if(APIConstant.MODULE_NAME_M2.equalsIgnoreCase(cncDashboardRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_CNC_DASHBOARD_TASKS_M2
								,new Object[]{Integer.parseInt(cncDashboardRequest.getClientId()),
								cncDashboardRequest.getUserName(),cncDashboardRequest.getUserName(),
								cncDashboardRequest.getUserName()}, new CNCDashboardRowMapper());
				  } else if(APIConstant.MODULE_NAME_M3.equalsIgnoreCase(cncDashboardRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_CNC_DASHBOARD_TASKS_M3
								,new Object[]{Integer.parseInt(cncDashboardRequest.getClientId()),
								cncDashboardRequest.getUserName(),cncDashboardRequest.getUserName(),
								cncDashboardRequest.getUserName()}, new CNCDashboardRowMapper());
				  } else if(APIConstant.MODULE_NAME_M4.equalsIgnoreCase(cncDashboardRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_CNC_DASHBOARD_TASKS_M4
								,new Object[]{Integer.parseInt(cncDashboardRequest.getClientId()),
								cncDashboardRequest.getUserName(),cncDashboardRequest.getUserName(),
								cncDashboardRequest.getUserName()}, new CNCDashboardRowMapper());
				  } else if(APIConstant.MODULE_NAME_M5.equalsIgnoreCase(cncDashboardRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_CNC_DASHBOARD_TASKS_M5
								,new Object[]{Integer.parseInt(cncDashboardRequest.getClientId()),
								cncDashboardRequest.getUserName(),cncDashboardRequest.getUserName(),
								cncDashboardRequest.getUserName()}, new CNCDashboardRowMapper());
				  }
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error(APIConstant.MSG_GET_CNC_DASHBOARDTASKS_FAILURE,e);
			return new ArrayList<CNCDashboardResponse>();
	    } catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_CNC_DASHBOARDTASKS_FAILURE, ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_GET_CNC_DASHBOARDTASKS_FAILURE);
		}
		return listOfDashboardTask;
	}

	@Override
	public List<CNCRealTimeDashboardResponse> getAllRealTimeDashboardData(
			CNCRealTimeDashboardRequest cncDashboardRequest) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
