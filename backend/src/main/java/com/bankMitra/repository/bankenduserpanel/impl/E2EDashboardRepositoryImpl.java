/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.impl;

import java.util.ArrayList;
import java.util.Date;
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

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2EDetailRequest;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportFooter;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportHeader;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportTable;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDetailResponse;
import com.bankMitra.model.clientManagement.response.CreateUnitResponse;
import com.bankMitra.repository.bankenduserpanel.E2EDashboardRepository;
import com.bankMitra.repository.bankenduserpanel.rowmapper.BankDetailRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2EDashboardRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2EFullReportFooterRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2EFullReportHeaderLoanVariant;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2EFullReportHeaderRowMapper;
import com.bankMitra.repository.bankenduserpanel.rowmapper.E2EFullReportTableDataRowMapper;
import com.bankMitra.repository.clientManagement.rowmapper.CreateUnitRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class E2EDashboardRepositoryImpl implements E2EDashboardRepository {

    private static final Logger logger = LoggerFactory.getLogger(E2EDashboardRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.bankenduserpanel.E2EDashboardRepository#getAllDashboardData(com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest)
	 */
	@Override
	public List<E2EDashboardResponse> getAllDashboardData(@Valid E2EDashboardRequest e2eDashboardRequest)
			throws DataAccessException {
		List<E2EDashboardResponse> listOfDashboardTask =  null;
		try {
			if(null!=e2eDashboardRequest && !StringUtils.isEmpty(e2eDashboardRequest.getModuleName()) 
					&& !StringUtils.isEmpty(e2eDashboardRequest.getClientId()) &&  !StringUtils.isEmpty(e2eDashboardRequest.getClientGroupId())) {
				  if(APIConstant.MODULE_NAME_M1.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
					listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_DASHBOARD_TASKS_M1
							,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
							e2eDashboardRequest.getCreatedBy(),e2eDashboardRequest.getCreatedBy(),
							e2eDashboardRequest.getCreatedBy(), e2eDashboardRequest.getCreatedBy()}, new E2EDashboardRowMapper());
				  } else if(APIConstant.MODULE_NAME_M2.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_DASHBOARD_TASKS_M2
								,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
								e2eDashboardRequest.getCreatedBy(),e2eDashboardRequest.getCreatedBy(),
								e2eDashboardRequest.getCreatedBy(), e2eDashboardRequest.getCreatedBy()}, new E2EDashboardRowMapper());
				  } else if(APIConstant.MODULE_NAME_M3.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_DASHBOARD_TASKS_M3
								,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
								e2eDashboardRequest.getCreatedBy(),e2eDashboardRequest.getCreatedBy(),
								e2eDashboardRequest.getCreatedBy(), e2eDashboardRequest.getCreatedBy()}, new E2EDashboardRowMapper());
				  } else if(APIConstant.MODULE_NAME_M4.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_DASHBOARD_TASKS_M4
								,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
								e2eDashboardRequest.getCreatedBy(),e2eDashboardRequest.getCreatedBy(),
								e2eDashboardRequest.getCreatedBy(), e2eDashboardRequest.getCreatedBy()}, new E2EDashboardRowMapper());
				  } else if(APIConstant.MODULE_NAME_M5.equalsIgnoreCase(e2eDashboardRequest.getModuleName())){
						listOfDashboardTask = jdbcTemplate.query(APIConstant.QUERY_GET_E2E_DASHBOARD_TASKS_M5
								,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientId()),Integer.parseInt(e2eDashboardRequest.getClientGroupId()),
								e2eDashboardRequest.getCreatedBy(),e2eDashboardRequest.getCreatedBy(),
								e2eDashboardRequest.getCreatedBy(), e2eDashboardRequest.getCreatedBy()}, new E2EDashboardRowMapper());
				  }
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error(APIConstant.MSG_GET_DASHBOARDTASKS_FAILURE,e);
			return new ArrayList<E2EDashboardResponse>();
	    } catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_DASHBOARDTASKS_FAILURE, ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_GET_DASHBOARDTASKS_FAILURE);
		}
		return listOfDashboardTask;
	}

	@Override
	public E2EDetailResponse updatee2eDetails(E2EDetailRequest e2eDetailRequest) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E2EDetailResponse deleteCommercialCreditFacility(E2EDetailRequest e2eDetailRequest)
			throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E2EDetailResponse getE2EDetails(E2EDetailRequest e2eDetailRequest) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DashboardBankDetailResponse getDashboardBankDetails(E2EDashboardRequest e2eDashboardRequest)
			throws DataAccessException {
		List<DashboardBankDetailResponse> listOfBankDetailsResponse =  null;
		try {
		if(null!=e2eDashboardRequest) {
			if(!StringUtils.isEmpty(e2eDashboardRequest.getClientGroupId())){
				listOfBankDetailsResponse = jdbcTemplate.query(APIConstant.QUERY_GET_BANK_BRANCH_IFSC
						,new Object[]{Integer.parseInt(e2eDashboardRequest.getClientGroupId())}, new BankDetailRowMapper());
			} 
			if(null!=listOfBankDetailsResponse && !CollectionUtils.isEmpty(listOfBankDetailsResponse)) {
				return listOfBankDetailsResponse.get(0);
			}
		}
		} catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_BANKDETAILS_FAILURE+ex);
		}
		return null;
	}
	
	@Override
	public E2EFullReportHeader getFullReportHeader(String e2eNum) throws DataAccessException {
		
		E2EFullReportHeader header = null;
		try {
			header = jdbcTemplate.queryForObject(APIConstant.QUERY_FULL_REPORT_HEADER, 
					new Object[]{e2eNum},new E2EFullReportHeaderRowMapper());
		} catch (EmptyResultDataAccessException e) {
			logger.error("E2EDashboardRepositoryImpl:getFullReportHeader:No records found for e2eNum:"+e2eNum+":exception message:"+e);
			throw new DataAccessException("No header details found for this e2eNum:"+e2eNum);
		} catch (Exception e) {
			logger.error("E2EDashboardRepositoryImpl:getFullReportHeader:exception occurred for e2eNum:"+e2eNum+":exception message:"+e);
			throw new DataAccessException("Error occurred please contact system administrator");
		}
		return header;
	}
	
	@Override
	public String getLoanVariant(String sqlQuery, String e2eNum) throws DataAccessException{
		List<E2EFullReportHeader> headers = null;
		try {
			headers =  jdbcTemplate.query(sqlQuery, new Object[]{e2eNum}, new E2EFullReportHeaderLoanVariant());
			if(CollectionUtils.isNotEmpty(headers)) {
				return headers.get(0).getLoanVariant();
			}
		}catch (EmptyResultDataAccessException e) {
			logger.error("E2EDashboardRepositoryImpl:getLoanVariant:No records found for e2eNum:"+e2eNum+":exception message:"+e);
			throw new DataAccessException("No loan variant details found for this e2eNum:"+e2eNum);
		} catch (Exception e) {
			logger.error("E2EDashboardRepositoryImpl:getLoanVariant:exception occurred for e2eNum:"+e2eNum+":exception message:"+e);
			throw new DataAccessException("Error occurred please contact system administrator");
		}
		return "";
	}
	
	@Override
	public E2EFullReportFooter getFullReportFooter(String e2eNum) throws DataAccessException{
		List<E2EFullReportFooter> footer = null;
		try {
			footer =  jdbcTemplate.query(APIConstant.QUERY_FULL_REPORT_FOOTER, new Object[]{e2eNum}, new E2EFullReportFooterRowMapper());
			if(CollectionUtils.isNotEmpty(footer)) {
				return footer.get(0);
			}
		}catch (EmptyResultDataAccessException e) {
			logger.error("E2EDashboardRepositoryImpl:getFullReportFooter:No records found for e2eNum:"+e2eNum+":exception message:"+e);
			throw new DataAccessException("No footer details found for this e2eNum:"+e2eNum);
		} catch (Exception e) {
			logger.error("E2EDashboardRepositoryImpl:getFullReportFooter:exception occurred for e2eNum:"+e2eNum+":exception message:"+e);
			throw new DataAccessException("Error occurred please contact system administrator");
		}
		return null;
	}
	
	@Override
	public List<E2EFullReportTable> getE2EFullReportTableData(String e2eNum, String moduleName) throws DataAccessException{
		try {
			if("M1".equals(moduleName)) {
				return jdbcTemplate.query(APIConstant.QUERY_FULL_REPORT_TABLE_DATA, new Object[]{e2eNum}, new E2EFullReportTableDataRowMapper());
			}
			if("M2".equals(moduleName)) {
				return jdbcTemplate.query(APIConstant.QUERY_FULL_REPORT_TABLE_DATA_M2, new Object[]{e2eNum}, new E2EFullReportTableDataRowMapper());
			}
			if("M3".equals(moduleName)) {
				return jdbcTemplate.query(APIConstant.QUERY_FULL_REPORT_TABLE_DATA_M3, new Object[]{e2eNum}, new E2EFullReportTableDataRowMapper());
			}
			if("M4".equals(moduleName)) {
				return jdbcTemplate.query(APIConstant.QUERY_FULL_REPORT_TABLE_DATA_M4, new Object[]{e2eNum}, new E2EFullReportTableDataRowMapper());
			}
			if("M5".equals(moduleName)) {
				return jdbcTemplate.query(APIConstant.QUERY_FULL_REPORT_TABLE_DATA_M5, new Object[]{e2eNum}, new E2EFullReportTableDataRowMapper());
			}
			return jdbcTemplate.query(APIConstant.QUERY_FULL_REPORT_TABLE_DATA, new Object[]{e2eNum}, new E2EFullReportTableDataRowMapper());
		}catch (Exception e) {
			logger.error("E2EDashboardRepositoryImpl:getE2EFullReportTableData:exception occurred for e2eNum:"+e2eNum+":exception message:"+e);
			throw new DataAccessException("Error occurred please contact system administrator");
		}
	}

}
