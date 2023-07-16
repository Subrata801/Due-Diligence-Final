/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.LoanSchemeResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanSchemeRowMapper implements RowMapper<LoanSchemeResponse> {

    public LoanSchemeResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	LoanSchemeResponse loanScheme = new LoanSchemeResponse();
    	loanScheme.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	loanScheme.setLoanSchemeName(rs.getString("client_loan_scheme_name"));
      
        return loanScheme;

    }
}
