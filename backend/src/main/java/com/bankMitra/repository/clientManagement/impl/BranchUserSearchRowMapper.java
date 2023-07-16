/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.BranchUserResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchUserSearchRowMapper implements RowMapper<BranchUserResponse> {

    public BranchUserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
    	BranchUserResponse usr = new BranchUserResponse();
    	usr.setClientGroupId(rs.getInt("client_group_id"));
        //usr.setPassword(rs.getString("password"));
        //usr.setUserRoleId(rs.getInt("user_role_id"));
        usr.setEmployeeName(rs.getString("fullname"));
        usr.setE2eStatus(rs.getString("userstatus"));
        usr.setEmployeeId(rs.getString("employee_id"));
        usr.setUserName(rs.getString("username"));
        usr.setUnitName(rs.getString("client_group_name"));
        if(String.valueOf(rs.getDate("updated_date"))!=null && !"null".equalsIgnoreCase(String.valueOf(rs.getDate("updated_date"))))
        	usr.setUpdatedDate(String.valueOf(rs.getDate("updated_date")));
        else
        	usr.setUpdatedDate("");
        return usr;

    }
}
