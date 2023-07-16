/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.MovableProperty;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MovablePropertyRowMapper implements RowMapper<MovableProperty> {

    public MovableProperty mapRow(ResultSet rs, int rowNum) throws SQLException {

    	MovableProperty cat = new MovableProperty();
    	cat.setPropertyId(rs.getInt("security_subtype_id"));
    	cat.setPropertyName(rs.getString("security_sub_type"));
      
        return cat;

    }
}
