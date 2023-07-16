/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.Makers;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuditFirmMakerRowMapper implements RowMapper<Makers> {

    public Makers mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Makers makers = new Makers();
    	makers.setMakerid(rs.getInt("user_id"));
    	makers.setMakerName(rs.getString("username"));
      
        return makers;

    }
}
