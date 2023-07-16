/**
 * 
 */
package com.bankMitra.repository.user.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.UserRoles;
import com.bankMitra.model.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User usr = new User();
        usr.setUserId(rs.getLong("user_id"));
        usr.setUserName(rs.getString("username"));
        usr.setUserStatus(rs.getString("userstatus"));
        usr.setClientId(rs.getInt("client_id"));
        usr.setClientName(rs.getString("client_name"));
        usr.setEmail(rs.getString("email"));
        usr.setFullName(rs.getString("fullname"));
        usr.setLastLogin(rs.getDate("last_login"));
        usr.setPassword(rs.getString("password"));
        usr.setMobileNumber(rs.getLong("mobile_number"));
        usr.setClientGroupId(rs.getInt("client_group_id"));
        
        List<UserRoles> roles = new ArrayList<UserRoles>();
        UserRoles role = new UserRoles();
        role.setRoleId(rs.getInt("user_role_id"));
        role.setRoleName(rs.getString("user_role_name"));
        role.setUserTypeId(rs.getInt("client_type_id"));
        roles.add(role);
        usr.setRoles(roles);
        return usr;

    }
}
