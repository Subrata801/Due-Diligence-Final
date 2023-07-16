/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientInfoRowMapper implements RowMapper<ClientResponse> {

    public ClientResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientResponse clientResponse = new ClientResponse();
    	clientResponse.setClientId(rs.getString("client_id"));
    	clientResponse.setClientType(rs.getString("client_type_id"));
    	clientResponse.setClientPrefix(rs.getString("clinet_prefix"));
    	clientResponse.setClientName(rs.getString("client_name"));
    	clientResponse.setCreateDate(String.valueOf(rs.getDate("client_start_date")));
    	clientResponse.setAddress(rs.getString("address"));
    	clientResponse.setCity(rs.getString("city"));
    	clientResponse.setPincode(rs.getInt("pincode"));
    	clientResponse.setState(rs.getString("state"));
    	clientResponse.setGstNum(rs.getString("gstn_no"));
    	clientResponse.setPrimaryPoc(rs.getString("primary_poc"));
    	clientResponse.setPrimaryPocNum(rs.getString("primary_poc_number"));
    	clientResponse.setPrimaryPocDesignation(rs.getString("primary_poc_designation"));
    	clientResponse.setPrimaryPocEmail(rs.getString("primary_poc_email"));
    	clientResponse.setSecondaryPoc(rs.getString("secondary_poc"));
    	clientResponse.setSecondaryPocNum(rs.getString("secondary_poc_number"));
    	clientResponse.setSecondaryPocDesignation(rs.getString("secondary_poc_designation"));
    	clientResponse.setSecondaryPocEmail(rs.getString("secondary_poc_email"));
    	clientResponse.setClientLogo(rs.getString("client_logo"));
    	clientResponse.setCreatedDate(String.valueOf(rs.getDate("created_date")));
    	clientResponse.setCreatedBy(rs.getString("created_by"));
    	clientResponse.setLastUpdatedDate(String.valueOf(rs.getDate("updated_date")));
    	clientResponse.setUpdatedBy(rs.getString("updated_by"));
    	clientResponse.setLanguageId(rs.getInt("language_id"));
    	clientResponse.setStatus(rs.getString("status"));
    	clientResponse.setRiskTypeId(String.valueOf(rs.getInt("risk_type_id")));
    	
        return clientResponse;
    }
}
