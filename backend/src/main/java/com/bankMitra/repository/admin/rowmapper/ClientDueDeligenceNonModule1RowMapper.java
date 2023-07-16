/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientDueDeligenceResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDueDeligenceNonModule1RowMapper implements RowMapper<ClientDueDeligenceResponse> {

    public ClientDueDeligenceResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientDueDeligenceResponse clientDueDeligenceResponse = new ClientDueDeligenceResponse();
    	clientDueDeligenceResponse.setDdSequence(rs.getInt("dd_sequence"));
    	clientDueDeligenceResponse.setDdParentSequence(rs.getInt("dd_parent_sequence"));
    	clientDueDeligenceResponse.setDdData(rs.getString("dd_data"));
    	clientDueDeligenceResponse.setComplianceOption(rs.getString("compliance_options"));
    	clientDueDeligenceResponse.setRemarks(rs.getString("remarks"));
        return clientDueDeligenceResponse;

    }
}
