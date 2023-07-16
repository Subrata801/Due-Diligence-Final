/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.Banks;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BankRowMapper implements RowMapper<Banks> {

    public Banks mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Banks bnks = new Banks();
    	bnks.setBankId(rs.getInt("client_id"));
    	bnks.setBankDesc(rs.getString("client_name"));
      
        return bnks;

    }
}
