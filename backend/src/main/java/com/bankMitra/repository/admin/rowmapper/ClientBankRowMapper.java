/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientBankResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientBankRowMapper implements RowMapper<ClientBankResponse> {

    public ClientBankResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
    	ClientBankResponse clientResponse = new ClientBankResponse();
    	clientResponse.setClientId(rs.getInt("client_id"));
    	clientResponse.setClientGroupId(rs.getInt("client_group_id"));
    	clientResponse.setBankName(rs.getString("Bank_Name"));
    	clientResponse.setAddress(rs.getString("address"));
    	clientResponse.setCity(rs.getString("city"));
    	clientResponse.setPincode(rs.getInt("pincode"));
    	clientResponse.setState(rs.getString("state"));
    	//clientResponse.setStatus(rs.getString("status"));
    	clientResponse.setCreateDate(String.valueOf(rs.getDate("created_date")));
    	clientResponse.setCreatedBy(rs.getString("created_by"));
    	clientResponse.setUpdatedDate(String.valueOf(rs.getDate("updated_date")));
    	clientResponse.setUpdatedBy(rs.getString("updated_by"));
    	
    	
        return clientResponse;
    }
}
