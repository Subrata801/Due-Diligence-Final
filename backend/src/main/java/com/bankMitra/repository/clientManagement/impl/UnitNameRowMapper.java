/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.Makers;
import com.bankMitra.model.clientManagement.response.UnitNames;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitNameRowMapper implements RowMapper<UnitNames> {

    public UnitNames mapRow(ResultSet rs, int rowNum) throws SQLException {

    	UnitNames unit = new UnitNames();
    	unit.setUnitId(rs.getInt("client_group_id"));
    	unit.setUnitName(rs.getString("client_group_name"));
      
        return unit;

    }
}
