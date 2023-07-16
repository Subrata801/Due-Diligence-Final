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

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.EmployeeDetails;
import com.bankMitra.model.clientManagement.request.EmployeeUploadArray;
import com.bankMitra.model.clientManagement.request.ManageEmployeeRequest;
import com.bankMitra.model.clientManagement.response.EmpErrorDownloadResponse;
import com.bankMitra.model.clientManagement.response.EmployeeUploadResponse;
import com.bankMitra.model.clientManagement.response.ManageEmployeeResponse;
import com.bankMitra.repository.admin.rowmapper.ClientDueDeligenceRowMapper;
import com.bankMitra.repository.admin.rowmapper.DueDeligenceFailiureRowMapper;
import com.bankMitra.repository.admin.rowmapper.DueDeligenceSuccessRowMapper;
import com.bankMitra.repository.clientManagement.ViewEmployeeRepository;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class ViewEmployeeRepositoryImpl implements ViewEmployeeRepository {

    private static final Logger logger = LoggerFactory.getLogger(ViewEmployeeRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.ViewEmployeeRepository#getAllEmployees(com.bankMitra.model.clientManagement.request.ManageEmployeeRequest)
	 */
	@Override
	public List<ManageEmployeeResponse> getAllEmployees(@Valid ManageEmployeeRequest manageEmployeeRequest)
			throws DataAccessException {
		try {
			if(null!=manageEmployeeRequest) {
				if(!StringUtils.isEmpty(manageEmployeeRequest.getIfscCode()) && !StringUtils.isEmpty(manageEmployeeRequest.getUnitName())){
					
					return jdbcTemplate.query(APIConstant.QUERY_GET_EMPLOYEES_BY_ALL_CRITERIA + " and bem.client_id in (select client_id from bmadmin.bmusers where username='" + manageEmployeeRequest.getCreatedBy() + "' )" +
							" and UPPER(bmcg.client_group_name) like '%"+manageEmployeeRequest.getUnitName().toUpperCase()+"%' and bem.ifsc_code like '%"+manageEmployeeRequest.getIfscCode().toUpperCase()+"%'"
							,new EmployeeRowMapper());
				} else if(!StringUtils.isEmpty(manageEmployeeRequest.getUnitName())){
					return jdbcTemplate.query(APIConstant.QUERY_GET_EMPLOYEES_BY_ALL_CRITERIA + " and bem.client_id in (select client_id from bmadmin.bmusers where username='" + manageEmployeeRequest.getCreatedBy() + "' )" +
							" and UPPER(bmcg.client_group_name) like '%"+manageEmployeeRequest.getUnitName().toUpperCase()+"%' "
							, new EmployeeRowMapper());
				} else if(!StringUtils.isEmpty(manageEmployeeRequest.getIfscCode())){
					return jdbcTemplate.query(APIConstant.QUERY_GET_EMPLOYEES_BY_ALL_CRITERIA + " and bem.client_id in (select client_id from bmadmin.bmusers where username='" + manageEmployeeRequest.getCreatedBy() + "' )" +
							" and bem.ifsc_code like '%"+manageEmployeeRequest.getIfscCode().toUpperCase()+"%'", new EmployeeRowMapper());
				}  
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No employees present with  unit Name and ifsc code :"+manageEmployeeRequest.getUnitName(), manageEmployeeRequest.getIfscCode(),e);
			return new ArrayList<ManageEmployeeResponse>();
	    } catch (Exception ex) {
			logger.error("Unable to get employees with  unit Name and ifsc code :"+manageEmployeeRequest.getUnitName(), manageEmployeeRequest.getIfscCode(),ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return null;
	}


	@Override
	public ManageEmployeeResponse manageEmployee(ManageEmployeeRequest manageEmployeeRequest)
			throws DataAccessException {
		ManageEmployeeResponse manageEmployeeResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ call bmadmin.funcmanageemployees(?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			cs.setString(1, manageEmployeeResponse.getCreatedBy());
			int i = 0;
			if(null!=manageEmployeeRequest.getEmployeInfo() && manageEmployeeRequest.getEmployeInfo().size()>0) {
				String[] arrEmployee =  new String[manageEmployeeRequest.getEmployeInfo().size()];
				for(EmployeeDetails arr: manageEmployeeRequest.getEmployeInfo()) {
					String inputData = "("+"\""+arr.getIfscCode()+"\","
			        		+"\""+arr.getEmployeeName()+"\","
			        		+"\""+arr.getEmployeeId()+"\","
			        		+"\""+arr.getMobileNum()+")";
					arrEmployee[i] = inputData;
					i++;
				}
				
				cs.setArray(2,connection.createArrayOf("bmadmin.obj_manage_employee",arrEmployee));
			} else {
				cs.setArray(2,connection.createArrayOf("bmadmin.obj_manage_employee",new String[]{}));
			}
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.executeUpdate();
			functionResult = cs.getString(3);
			logger.info("Function result code returned after execution of function funcmanageemployees :",functionResult);
			manageEmployeeResponse = new ManageEmployeeResponse();
			manageEmployeeResponse.setMessageCode(functionResult);
			return manageEmployeeResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcmanageemployees",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funcmanageemployees",e);
			throw new DataAccessException(APIConstant.MSG_MANAGE_EMPLOYEE_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funcmanageemployees");
			}
		}

	}


	@Override
	public EmployeeUploadResponse uploadTemplate(String clientId, List<EmployeeUploadArray> employeeList,
			String userName) throws DataAccessException {
		Connection connection = null;
		EmployeeUploadResponse resp = null;
		CallableStatement cs = null;
		String functionResult = null; 
		try {
			String runFunction = "{ ? = call bmadmin.funcmanageemployees(?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, userName);
			int i = 0;
			String[] arrDueDeligenceString =  new String[employeeList.size()];
			for(EmployeeUploadArray arr: employeeList) {
				String inputData = "("+arr.getIfscCode()+","
						+arr.getEmployeeName()+","
						+arr.getEmployeeID()+","
						+arr.getMobileNum()+")";
				arrDueDeligenceString[i] = inputData;
				i++;
			}
			cs.setArray(3, connection.createArrayOf(  
				      "bmadmin.obj_manage_employee",arrDueDeligenceString));
			
			
			cs.executeUpdate();
			functionResult = cs.getString(1);
			logger.info("Function result code returned after execution of function funcmanageemployees :",functionResult);
			resp = new EmployeeUploadResponse();
			resp.setMessageCode(functionResult);
		} catch (Exception ex) {
			logger.error("Exception while upload employee for function funcmanageemployees :" + ex);
			throw new DataAccessException(APIConstant.MSG_UPLOAD_EMPLOYEE_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
			    logger.error("Unable to close connection for function funcmanageemployees",e);
			}
			
		}
		return resp;
	}


	@Override
	public ManageEmployeeResponse updateEmployee(ManageEmployeeRequest manageEmployeeRequest)
			throws DataAccessException {
		ManageEmployeeResponse empResponse =  new ManageEmployeeResponse();
		try {
			if(null!=manageEmployeeRequest && !StringUtils.isEmpty(manageEmployeeRequest.getEmployeeId())
					&& !StringUtils.isEmpty(manageEmployeeRequest.getStatus())) {
				int updateStatus = jdbcTemplate.update(APIConstant.QUERY_UPDATE_EMPLOYEE_STATUS, new Object[]{
						manageEmployeeRequest.getStatus(),manageEmployeeRequest.getEmployeeId()});
				if(updateStatus > 0)
					empResponse.setMessageCode(APIConstant.SUCCESS_CODE);
				else 
					throw new DataAccessException(APIConstant.MSG_UPDATE_EMPLOYEE_FAILURE) ;
			}
		} catch (Exception ex) {
			logger.error("Unable to update employee of employeed Id :"+manageEmployeeRequest.getEmployeeId(),ex);
			throw new DataAccessException(APIConstant.MSG_UPDATE_EMPLOYEE_FAILURE);
		}
	    return empResponse;      	 
					
	}


	@Override
	public List<EmpErrorDownloadResponse> getErrorRecords(String clientId) throws DataAccessException {
		try {
			return jdbcTemplate.query(APIConstant.QUERY_GET_DOWNLOAD_EMP_ERROR_FAILURE_RECORDS,
					new Object[]{Integer.parseInt(clientId)}, new EmployeeErrorFailureRowMapper());
		} catch (Exception ex) {
			logger.error("Unable to execute query for downloading the summary",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_DOWNLOAD_IMPORT_SUMMARY);
		}
	}

}
