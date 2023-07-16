/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author Bank Maitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.CPC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CPCRowMapper implements RowMapper<CPC> {

    public CPC mapRow(ResultSet rs, int rowNum) throws SQLException {

    	CPC cpcData = new CPC();
    	cpcData.setCpcId(rs.getInt("client_group_id"));
    	cpcData.setClientId(rs.getInt("client_id"));
    	cpcData.setCpcName(rs.getString("client_group_name"));
      
        return cpcData;

    }
}
