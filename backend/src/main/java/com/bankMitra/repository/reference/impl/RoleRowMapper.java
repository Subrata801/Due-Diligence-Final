/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.UserRoles;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<UserRoles> {

    public UserRoles mapRow(ResultSet rs, int rowNum) throws SQLException {

    	UserRoles role = new UserRoles();
    	role.setRoleId(rs.getInt("user_role_id"));
    	role.setUserTypeId(rs.getInt("client_type_id"));
    	role.setRoleName(rs.getString("user_role_name"));
      
        return role;

    }
}
