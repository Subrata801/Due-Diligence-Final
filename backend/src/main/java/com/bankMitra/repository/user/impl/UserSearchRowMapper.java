/**
 * 
 */
package com.bankMitra.repository.user.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.user.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserSearchRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
        User usr = new User();
        usr.setUserId(rs.getLong("user_id"));
        usr.setUserName(rs.getString("username"));
        usr.setFullName(rs.getString("fullname"));
        usr.setUserRoleId(rs.getInt("user_role_id"));
        usr.setEmail(rs.getString("email"));
        usr.setMobileNumber(rs.getLong("mobile_number"));
        usr.setUserStatus(rs.getString("userstatus"));
        usr.setEmployeeId(rs.getString("employee_id"));
        usr.setClientTypeId(rs.getInt("client_type_id"));
        usr.setClientName(rs.getString("client_name"));
        usr.setClientId(rs.getInt("client_id"));
        return usr;

    }
}
