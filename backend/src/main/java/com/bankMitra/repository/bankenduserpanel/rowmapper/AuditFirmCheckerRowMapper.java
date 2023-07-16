/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.Checkers;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditFirmCheckerRowMapper implements RowMapper<Checkers> {

    public Checkers mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Checkers checker = new Checkers();
    	checker.setCheckerId(rs.getInt("user_id"));
    	checker.setCheckerName(rs.getString("username"));
      
        return checker;

    }
}
