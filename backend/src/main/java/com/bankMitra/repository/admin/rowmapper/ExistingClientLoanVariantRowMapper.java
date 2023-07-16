/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientLoanSchemeResponse;
import com.bankMitra.model.admin.response.ClientLoanVariantResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistingClientLoanVariantRowMapper implements RowMapper<ClientLoanVariantResponse> {

    public ClientLoanVariantResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientLoanVariantResponse loanVariants = new ClientLoanVariantResponse();
    	loanVariants.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	loanVariants.setLoanSchemeName(rs.getString("loan_scheme_name"));
    	loanVariants.setLoanVariantId(rs.getInt("loan_variant_id"));
    	loanVariants.setLoanVariantName(rs.getString("client_loan_variant_name"));
    	loanVariants.setClientGroupId(rs.getInt("client_group_id"));
    	loanVariants.setPreferredLoanVariantName(rs.getString("client_loan_variant_name"));
    	loanVariants.setLoanVariantKeyword(rs.getString("client_loan_variant_keyword"));
        return loanVariants;
        
    }
}
