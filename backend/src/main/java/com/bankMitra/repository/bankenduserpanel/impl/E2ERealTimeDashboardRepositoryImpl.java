/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2ERealTimeDashboardRequest;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2ERealTimeDashboardResponse;
import com.bankMitra.model.user.User;
import com.bankMitra.repository.bankenduserpanel.E2ERealTimeDashboardRepository;
import com.bankMitra.repository.bankenduserpanel.rowmapper.BankDetailRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2EBankDetailRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2ERealTimeDashboardHeaderRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2ERealTimeDashboardRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class E2ERealTimeDashboardRepositoryImpl implements E2ERealTimeDashboardRepository {

	private static final Logger logger = LoggerFactory.getLogger(E2ERealTimeDashboardRepositoryImpl.class);
		
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.bankenduserpanel.E2ERealTimeDashboardRepository#getE2ERealTimeDashboardTasks(com.bankMitra.model.bankenduserpanel.request.E2ERealTimeDashboardRequest)
	 */
	@Override
	public List<E2ERealTimeDashboardResponse> getE2ERealTimeDashboardTasks(
			@Valid E2ERealTimeDashboardRequest e2eDashboardRequest) throws DataAccessException {
		List<E2ERealTimeDashboardResponse> listOfE2ETasks =  null;
		try {
			if(null!=e2eDashboardRequest && !StringUtils.isEmpty(e2eDashboardRequest.getModuleName())) {
				if(APIConstant.MODULE_NAME_M1.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
					listOfE2ETasks = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_TASKS_M1
							,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId())}, new E2ERealTimeDashboardRowMapper());
				} else if(APIConstant.MODULE_NAME_M2.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
					listOfE2ETasks = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_TASKS_M2
							,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId())}, new E2ERealTimeDashboardRowMapper());
				} else if(APIConstant.MODULE_NAME_M3.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
					listOfE2ETasks = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_TASKS_M3
							,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId())}, new E2ERealTimeDashboardRowMapper());
				} else if(APIConstant.MODULE_NAME_M4.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
					listOfE2ETasks = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_TASKS_M4
							,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId())}, new E2ERealTimeDashboardRowMapper());
				} else if(APIConstant.MODULE_NAME_M5.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
					listOfE2ETasks = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_TASKS_M5
							,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
									Integer.parseInt(e2eDashboardRequest.getClientGroupId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId())}, new E2ERealTimeDashboardRowMapper());
				}
				
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No list of e2e real time dashboard task from db :",e);
			return new ArrayList<E2ERealTimeDashboardResponse>();
	    } catch (Exception ex) {
			logger.error("Exception while getting list of e2e real time dashboard task :" + ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_GET_E2E_TAKS_FAILURE);
		}
		return listOfE2ETasks;
	}

	@Override
	public E2ERealTimeDashboardResponse getDashBoardHeaders(E2ERealTimeDashboardRequest e2eDashboardRequest)
			throws DataAccessException {
		List<E2ERealTimeDashboardResponse> listOfBankDetailsResponse =  null;
		try {
		if(null!=e2eDashboardRequest) {
			if(StringUtils.isEmpty(e2eDashboardRequest.getClientGroupId())){
				listOfBankDetailsResponse = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_DASHBOARD_HEADER_DTLS
						,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientGroupId())}, new E2ERealTimeDashboardHeaderRowMapper());
			} 
			if(null!=listOfBankDetailsResponse && CollectionUtils.isEmpty(listOfBankDetailsResponse)) {
				return listOfBankDetailsResponse.get(0);
			}
		}
		} catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_E2E_DASHBOARD_HEADER_FAILURE,ex);
		}
		return null;
	}

	@Override
	public DashboardBankDetailResponse getDashboardBankDetails(E2EDashboardRequest e2eDashboardRequest)
			throws DataAccessException {
		List<DashboardBankDetailResponse> listOfBankDetailsResponse =  null;
		try {
		if(null!=e2eDashboardRequest) {
			if(!StringUtils.isEmpty(e2eDashboardRequest.getClientGroupId())){
				listOfBankDetailsResponse = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_REALTIME_BANK_BRANCH_IFSC
						,new Object[]{e2eDashboardRequest.getCreatedBy()}, new E2EBankDetailRowMapper());
			} 
			if(null!=listOfBankDetailsResponse && !CollectionUtils.isEmpty(listOfBankDetailsResponse)) {
				return listOfBankDetailsResponse.get(0);
			}
		}
		} catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_BANKDETAILS_FAILURE,ex);
		}
		return null;
	}

}
