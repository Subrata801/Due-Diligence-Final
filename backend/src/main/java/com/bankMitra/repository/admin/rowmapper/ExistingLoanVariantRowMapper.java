/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.LoanVariantResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistingLoanVariantRowMapper implements RowMapper<LoanVariantResponse> {

	 public LoanVariantResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

		LoanVariantResponse loanVariants = new LoanVariantResponse();
    	loanVariants.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	loanVariants.setLoanSchemeName(rs.getString("loan_scheme_name"));
    	loanVariants.setLoanVariantId(rs.getInt("loan_variant_id"));
    	loanVariants.setLoanVariantName(rs.getString("loan_variant"));
    	loanVariants.setKeyword(rs.getString("loan_variant_keyword"));
        return loanVariants;
    }
}
