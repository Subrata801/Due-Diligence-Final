/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.BranchCheckerResponse;
import com.bankMitra.model.bankenduserpanel.response.BranchSAResponse;
import com.bankMitra.model.bankenduserpanel.response.LoanSAResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanSARowMapper implements RowMapper<LoanSAResponse> {

    public LoanSAResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	LoanSAResponse branchchecker = new LoanSAResponse();
    	branchchecker.setUsername(rs.getString("username"));
    	branchchecker.setFullname(rs.getString("fullname"));
        return branchchecker;

    }
}
