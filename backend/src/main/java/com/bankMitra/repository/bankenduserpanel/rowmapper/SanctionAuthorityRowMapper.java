/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author Bank Maitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.SanctionAuthority;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SanctionAuthorityRowMapper implements RowMapper<SanctionAuthority> {

    public SanctionAuthority mapRow(ResultSet rs, int rowNum) throws SQLException {

    	SanctionAuthority sa = new SanctionAuthority();
    	sa.setSaId(rs.getInt("client_group_id"));
    	sa.setSaName(rs.getString(""));
      
        return sa;

    }
}
