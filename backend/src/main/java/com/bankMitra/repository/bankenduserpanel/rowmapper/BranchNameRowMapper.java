/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.BranchNameResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BranchNameRowMapper implements RowMapper<BranchNameResponse> {

    public BranchNameResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	BranchNameResponse user = new BranchNameResponse();
    	user.setBranchId(rs.getInt("client_group_id"));
    	user.setBranchName(rs.getString("client_group_name"));
        return user;

    }
}
