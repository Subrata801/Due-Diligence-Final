/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author Bank Maitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.Checkers;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckerRowMapper implements RowMapper<Checkers> {

    public Checkers mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Checkers checkers = new Checkers();
    	checkers.setCheckerId(rs.getInt("client_group_id"));
    	checkers.setCheckerName(rs.getString(""));
      
        return checkers;

    }
}
