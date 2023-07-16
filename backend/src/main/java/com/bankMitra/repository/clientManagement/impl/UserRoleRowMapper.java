/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRoleRowMapper implements RowMapper<UserRole> {

    public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {

    	UserRole role = new UserRole();
    	role.setUserRoleId(rs.getInt("user_role_id"));
    	role.setUserRoleName(rs.getString("user_role_name"));
      
        return role;

    }
}
