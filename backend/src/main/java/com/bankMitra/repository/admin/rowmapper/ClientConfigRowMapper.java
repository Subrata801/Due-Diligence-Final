/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientConfigResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientConfigRowMapper implements RowMapper<ClientConfigResponse> {

    public ClientConfigResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientConfigResponse clientConfigResponse = new ClientConfigResponse();
    	clientConfigResponse.setClientId(rs.getInt("client_id"));
        return clientConfigResponse;

    }
}
