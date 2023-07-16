/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.Profession;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessionRowMapper implements RowMapper<Profession> {

    public Profession mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Profession profession = new Profession();
    	profession.setProfessionId(rs.getInt("profession_id"));
    	profession.setProfessionName(rs.getString("profession_name"));
      
        return profession;

    }
}
