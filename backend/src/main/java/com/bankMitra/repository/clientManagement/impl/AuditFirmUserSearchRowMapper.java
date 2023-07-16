/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditFirmUserSearchRowMapper implements RowMapper<CreateAuditFirmUserResponse> {

    public CreateAuditFirmUserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
    	
    	CreateAuditFirmUserResponse usr = new CreateAuditFirmUserResponse();
        usr.setUserId(rs.getLong("user_id"));
        usr.setUserName(rs.getString("username"));
        usr.setEmployeeName(rs.getString("fullname"));
        usr.setUserRoleId(rs.getInt("user_role_id"));
        usr.setEmployeeMail(rs.getString("email"));
        usr.setMobileNum(rs.getLong("mobile_number"));
        usr.setCncStatus(rs.getString("userstatus"));
        usr.setEmployeeId(rs.getString("employee_id"));
        usr.setClientTypeId(rs.getInt("client_type_id"));
        usr.setClientName(rs.getString("client_name"));
        usr.setClientId(rs.getInt("client_id"));
        return usr;

    }
}
