/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.ManageEmployeeResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<ManageEmployeeResponse> {

    public ManageEmployeeResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ManageEmployeeResponse employeeResponse = new ManageEmployeeResponse();
    	employeeResponse.setUnitType(rs.getString("client_group_type"));
    	employeeResponse.setUnitName(rs.getString("client_group_name"));
    	employeeResponse.setIfscCode(rs.getString("ifsc_code"));
    	employeeResponse.setEmployeeName(rs.getString("employee_name"));
    	employeeResponse.setEmployeeId(rs.getString("employee_id"));
    	//employeeResponse.setEmployeeDesignation(rs.getString("employee_designation"));
    	employeeResponse.setStatus(rs.getString("status"));
    	employeeResponse.setUpdatedDate(rs.getDate("updated_date"));
    	employeeResponse.setCreatedBy(rs.getString("updated_by"));
        return employeeResponse;

    }
}
