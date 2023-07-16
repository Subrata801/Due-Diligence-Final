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

public class ExistingLoanSchemeRowMapper implements RowMapper<LoanSchemeResponse> {

    public LoanSchemeResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	LoanSchemeResponse loanschemes = new LoanSchemeResponse();
    	loanschemes.setTemplateId(rs.getInt("template_id"));
    	loanschemes.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	loanschemes.setLoanSchemeName(rs.getString("loan_scheme_name"));
    	loanschemes.setKeyword(rs.getString("loan_scheme_keyword"));
    	loanschemes.setWorksheetName(rs.getString("import_temp_loan_scheme_name"));
        return loanschemes;

    }
}
