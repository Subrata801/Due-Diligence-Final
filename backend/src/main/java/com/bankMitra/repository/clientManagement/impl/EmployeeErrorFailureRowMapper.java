/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.EmpErrorDownloadResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeErrorFailureRowMapper implements RowMapper<EmpErrorDownloadResponse> {

    public EmpErrorDownloadResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	EmpErrorDownloadResponse downloadResponse = new EmpErrorDownloadResponse();
    	
    	downloadResponse.setEmployeeID(rs.getString("employee_id"));
    	downloadResponse.setEmployeeName(rs.getString("employee_name"));
    	downloadResponse.setIfscCode(rs.getString("ifsc_code"));
    	downloadResponse.setMobileNumber(rs.getString("mobile_number"));
    	downloadResponse.setClientId(rs.getInt("client_id"));
    	downloadResponse.setErrorDescription(rs.getString("error_desc"));
        return downloadResponse;

    }
}
