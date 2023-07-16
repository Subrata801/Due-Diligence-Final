/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.BranchMakerResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchMakerRowMapper implements RowMapper<BranchMakerResponse> {

    public BranchMakerResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	BranchMakerResponse branchMaker = new BranchMakerResponse();
    	branchMaker.setUsername(rs.getString("username"));
    	branchMaker.setFullname(rs.getString("fullname"));
        return branchMaker;

    }
}
