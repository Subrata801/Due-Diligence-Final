/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.AuditFirm;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditFirmRowMapper implements RowMapper<AuditFirm> {

    public AuditFirm mapRow(ResultSet rs, int rowNum) throws SQLException {

    	AuditFirm auditFirm = new AuditFirm();
    	auditFirm.setAuditFirmId(rs.getInt("client_id"));
    	auditFirm.setAuditFirmName(rs.getString("client_name"));
      
        return auditFirm;

    }
}
