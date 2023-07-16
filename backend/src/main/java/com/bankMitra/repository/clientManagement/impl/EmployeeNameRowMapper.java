/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.EmployeeNames;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeNameRowMapper implements RowMapper<EmployeeNames> {

    public EmployeeNames mapRow(ResultSet rs, int rowNum) throws SQLException {

    	EmployeeNames emp = new EmployeeNames();
    	emp.setEmployeeId(rs.getString("employee_id"));
    	emp.setEmployeeName(rs.getString("employee_name"));
      
        return emp;

    }
}
