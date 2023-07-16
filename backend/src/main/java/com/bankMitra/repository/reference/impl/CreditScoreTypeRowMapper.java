/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.CreditSector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditScoreTypeRowMapper implements RowMapper<CreditSector> {

    public CreditSector mapRow(ResultSet rs, int rowNum) throws SQLException {

    	CreditSector creditScoreType = new CreditSector();
    	creditScoreType.setCreditSectorId(rs.getInt("credit_sector_id"));
    	creditScoreType.setCreditSectorName(rs.getString("client_sector_desc"));
      
        return creditScoreType;

    }
}
