/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.ClientType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientTypeRowMapper implements RowMapper<ClientType> {

    public ClientType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientType clientType = new ClientType();
    	clientType.setClientTypeId(rs.getInt("client_type_id"));
    	clientType.setClientTypeName(rs.getString("client_name"));
      
        return clientType;

    }
}
