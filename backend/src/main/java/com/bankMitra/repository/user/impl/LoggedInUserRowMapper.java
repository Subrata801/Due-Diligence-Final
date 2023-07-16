/**
 * 
 */
package com.bankMitra.repository.user.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.bankMitra.model.reference.UserRoles;
import com.bankMitra.model.user.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LoggedInUserRowMapper implements RowMapper<User> {

    public User mapRow(ResultSet result, int rowNum) throws SQLException {

    	User usrDetail = new User();
        if(!StringUtils.isEmpty(String.valueOf(result.getString("op_return_code")))) {
        	
			usrDetail.setUserTypeId(Integer.parseInt(String.valueOf(result.getInt("op_user_type_id"))));
			usrDetail.setUserTypeName(String.valueOf(result.getString("op_user_type_name")));
			usrDetail.setClientId(Integer.parseInt(String.valueOf(result.getInt("op_client_id"))));
			usrDetail.setClientName(String.valueOf(result.getString("op_client_name")));
			usrDetail.setUserRoleName(String.valueOf(result.getString("op_user_role")));
			usrDetail.setUserStatus(String.valueOf(result.getString("op_user_status")));
			usrDetail.setCustomerLogoPath(String.valueOf(result.getString("op_customer_logo_path")));
			usrDetail.setLastLogin((Date) result.getDate("op_last_login"));
			usrDetail.setOutputCode(String.valueOf(result.getString("op_return_code")));
		    
        }
        return usrDetail;
    }
}
