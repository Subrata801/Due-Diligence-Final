/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.BorrowerType;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowerTypeRowMapper implements RowMapper<BorrowerType> {

    public BorrowerType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	BorrowerType borrowerType = new BorrowerType();
    	borrowerType.setBorrowerTypeId(rs.getInt("borrower_type_id"));
    	borrowerType.setBorrowerTypeName(rs.getString("borrower_type_name"));
      
        return borrowerType;

    }
}
