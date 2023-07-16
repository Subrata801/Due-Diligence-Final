/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.ClientGroup;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientGroupRowMapper implements RowMapper<ClientGroup> {

    public ClientGroup mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientGroup clientGroup = new ClientGroup();
    	clientGroup.setClienGroupId(rs.getInt("client_group_id"));
    	clientGroup.setClientId(rs.getInt("client_id"));
    	clientGroup.setClienGroupTypeId(rs.getInt("client_group_type_id"));
    	clientGroup.setClienGroupName(rs.getString("client_group_name"));
      
        return clientGroup;

    }
}
