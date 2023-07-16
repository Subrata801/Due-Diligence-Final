/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.LoanVariantResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanVariantRowMapper implements RowMapper<LoanVariantResponse> {

    public LoanVariantResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	LoanVariantResponse loanVariant = new LoanVariantResponse();
    	loanVariant.setLoanVariantId(rs.getInt("loan_variant_id"));
    	loanVariant.setLoanVariantName(rs.getString("client_loan_variant_name"));
    	loanVariant.setLoanSchemeId(rs.getInt("loan_scheme_id"));
        return loanVariant;

    }
}
