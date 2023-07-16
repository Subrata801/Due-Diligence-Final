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
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistingClientLoanSchemeRowMapper implements RowMapper<ClientLoanSchemeResponse> {

    public ClientLoanSchemeResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientLoanSchemeResponse loanschemes = new ClientLoanSchemeResponse();
    	loanschemes.setLoanSchemeNameKeyword(rs.getString("loan_scheme_keyword"));
    	loanschemes.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	loanschemes.setClientLoanSchemeName(rs.getString("client_loan_scheme_name"));
    	loanschemes.setClientGroupId(rs.getInt("client_group_id"));
    	loanschemes.setLoanSchemeName(rs.getString("loan_scheme_name"));
        return loanschemes;
        
    }
}
