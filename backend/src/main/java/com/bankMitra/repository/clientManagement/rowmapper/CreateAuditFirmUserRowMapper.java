/**
 * 
 */
package com.bankMitra.repository.clientManagement.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.CreateAuditFirmUserResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateAuditFirmUserRowMapper implements RowMapper<CreateAuditFirmUserResponse> {

    public CreateAuditFirmUserResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	CreateAuditFirmUserResponse auditFirmUser = new CreateAuditFirmUserResponse();
    	auditFirmUser.setUserRoleId(rs.getInt("user_role_id"));
    	auditFirmUser.setEmployeeId(rs.getString("employee_id"));
    	auditFirmUser.setEmployeeName(rs.getString("fullname"));
    	auditFirmUser.setEmployeeMail(rs.getString("email"));
    	auditFirmUser.setMobileNum(rs.getLong("mobile_number"));
    	auditFirmUser.setUserName(rs.getString("username"));
    	//auditFirmUser.setPassword(rs.getString("updated_date"));
    	auditFirmUser.setCncStatus(rs.getString("userstatus"));
        return auditFirmUser;

    }
}
