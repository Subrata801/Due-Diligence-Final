/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author Bank Maitra
 *
 */
import org.springframework.jdbc.core.RowMapper;
import com.bankMitra.model.reference.HO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HoRowMapper implements RowMapper<HO> {

    public HO mapRow(ResultSet rs, int rowNum) throws SQLException {

    	HO hoData = new HO();
    	hoData.setHoId(rs.getInt("client_group_id"));
    	hoData.setClientId(rs.getInt("client_id"));
    	hoData.setHoName(rs.getString("client_group_name"));
      
        return hoData;

    }
}
