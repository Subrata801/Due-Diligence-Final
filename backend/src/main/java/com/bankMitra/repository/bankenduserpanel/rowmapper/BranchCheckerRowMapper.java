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

import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchCheckerRowMapper implements RowMapper<BranchCheckerResponse> {

    public BranchCheckerResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	BranchCheckerResponse branchchecker = new BranchCheckerResponse();
    	branchchecker.setUsername(rs.getString("username"));
    	branchchecker.setFullname(rs.getString("fullname"));
        return branchchecker;

    }
}
