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

public class DefaultUnitCheckerRowMapper implements RowMapper<UnitChecker> {

    public UnitChecker mapRow(ResultSet rs, int rowNum) throws SQLException {

    	UnitChecker checker = new UnitChecker();
    	checker.setUnitMaker(rs.getString("unit_maker"));
    	checker.setUnitChecker(rs.getString("unit_checker"));
    	checker.setUnitSanctionAuthority(rs.getString("unit_sanction_authority"));
    	checker.setLoanSanctionAuthority(rs.getString("loan_sanction_authority"));
    	checker.setNumberOfReviewsCompleted(String.valueOf(rs.getInt("number_of_reviews_completed")));
      
        return checker;

    }
}
