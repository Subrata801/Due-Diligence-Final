/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.RegistrationClientResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientListRowMapper implements RowMapper<RegistrationClientResponse> {

    public RegistrationClientResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	RegistrationClientResponse clientResponse = new RegistrationClientResponse();
    	clientResponse.setClientId(rs.getInt("client_id"));
    	clientResponse.setClientName(rs.getString("client_name"));
        return clientResponse;

    }
}
