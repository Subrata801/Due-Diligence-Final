/**
 * 
 */
package com.bankMitra.repository.clientManagement.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.BranchUserResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchUserRowMapper implements RowMapper<BranchUserResponse> {

    public BranchUserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	BranchUserResponse user = new BranchUserResponse();
    	user.setUnitName(rs.getString("client_name"));
    	user.setUserRoleId(rs.getInt("user_role_id"));
    	user.setEmployeeId(rs.getString("employee_id"));
    	user.setEmployeeName(rs.getString("fullname"));
    	user.setUserName(rs.getString("username"));
    	//user.setPassword(rs.getString("updated_date"));
    	user.setE2eStatus(rs.getString("userstatus"));
        return user;

    }
}
