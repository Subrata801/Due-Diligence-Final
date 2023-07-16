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
import com.bankMitra.model.reference.UnitType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitTypeRowMapper implements RowMapper<UnitType> {

    public UnitType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	UnitType unitTypeData = new UnitType();
    	unitTypeData.setUnitTypeId(rs.getInt("client_group_type_id"));
    	unitTypeData.setUnitTypeName(rs.getString("client_group_type_desc"));
      
        return unitTypeData;

    }
}
