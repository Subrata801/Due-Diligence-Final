/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientSubscriptionResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientBasicSubscriptionRowMapper implements RowMapper<ClientSubscriptionResponse> {

    public ClientSubscriptionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientSubscriptionResponse clientSubscriptionResponse = new ClientSubscriptionResponse();
    	clientSubscriptionResponse.setClientId(rs.getInt("client_id"));
    	return clientSubscriptionResponse;
    }
}

