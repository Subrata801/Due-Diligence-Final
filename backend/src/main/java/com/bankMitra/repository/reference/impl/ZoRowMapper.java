/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author Bank Maitra
 *
 */
import org.springframework.jdbc.core.RowMapper;
import com.bankMitra.model.reference.ZO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ZoRowMapper implements RowMapper<ZO> {

    public ZO mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ZO zoData = new ZO();
    	zoData.setZoId(rs.getInt("client_group_id"));
    	zoData.setClientId(rs.getInt("client_id"));
    	zoData.setZoName(rs.getString("client_group_name"));
      
        return zoData;

    }
}
