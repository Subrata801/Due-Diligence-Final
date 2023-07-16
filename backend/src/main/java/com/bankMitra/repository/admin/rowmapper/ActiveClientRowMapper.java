/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ActiveClient;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActiveClientRowMapper implements RowMapper<ActiveClient> {

    public ActiveClient mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ActiveClient client = new ActiveClient();
    	client.setClientId(rs.getInt("client_id"));
    	client.setClientName(rs.getString("client_name"));
      
        return client;

    }
}
