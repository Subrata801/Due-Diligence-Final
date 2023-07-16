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

public class ClientNewDueDeligenceRowMapper implements RowMapper<ClientDueDeligenceResponse> {

    public ClientDueDeligenceResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientDueDeligenceResponse clientDueDeligenceResponse = new ClientDueDeligenceResponse();
    	clientDueDeligenceResponse.setDdSequence(rs.getInt("dd_sequence"));
    	    	
        return clientDueDeligenceResponse;

    }
}
