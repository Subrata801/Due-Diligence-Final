/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.LoanSchemeResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistingLoanSchemeWithoutTemplateRowMapper implements RowMapper<LoanSchemeResponse> {

    public LoanSchemeResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	LoanSchemeResponse loanschemes = new LoanSchemeResponse();
    	loanschemes.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	loanschemes.setLoanSchemeName(rs.getString("loan_scheme_name"));
    	loanschemes.setKeyword(rs.getString("loan_scheme_keyword"));
        return loanschemes;

    }
}
