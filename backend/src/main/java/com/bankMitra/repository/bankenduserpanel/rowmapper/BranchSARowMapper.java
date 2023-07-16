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

import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchSARowMapper implements RowMapper<BranchSAResponse> {

    public BranchSAResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	BranchSAResponse branchchecker = new BranchSAResponse();
    	branchchecker.setUsername(rs.getString("username"));
    	branchchecker.setFullname(rs.getString("fullname"));
        return branchchecker;

    }
}
