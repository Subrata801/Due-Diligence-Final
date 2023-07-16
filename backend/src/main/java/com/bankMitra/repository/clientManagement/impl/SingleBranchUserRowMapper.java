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

public class SingleBranchUserRowMapper implements RowMapper<BranchUserResponse> {

    public BranchUserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
    	BranchUserResponse usr = new BranchUserResponse();
    	usr.setE2eStatus(rs.getString("userstatus"));
    	usr.setClientGroupId(rs.getInt("client_group_id"));
        usr.setPassword(rs.getString("password"));
        usr.setUserRoleId(rs.getInt("user_role_id"));
        usr.setEmployeeName(rs.getString("fullname"));
        usr.setEmployeeId(rs.getString("employee_id"));
        usr.setUserName(rs.getString("username"));
        usr.setEmployeeMail(rs.getString("email"));
        return usr;

    }
}
