/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.UnitChecker;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UnitCheckerRowMapper implements RowMapper<UnitChecker> {

    public UnitChecker mapRow(ResultSet rs, int rowNum) throws SQLException {

    	UnitChecker checker = new UnitChecker();
    	checker.setUserName(rs.getString("username"));
    	checker.setFullName(rs.getString("fullname"));
      
        return checker;

    }
}
