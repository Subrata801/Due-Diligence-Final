/**
 * 
 */
package com.bankMitra.repository.clientManagement.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.CreateUnitResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateUnitRowMapper implements RowMapper<CreateUnitResponse> {

    public CreateUnitResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	CreateUnitResponse searchUnitResponse = new CreateUnitResponse();
    	searchUnitResponse.setClientGroupId(rs.getInt("client_group_id"));
    	searchUnitResponse.setClientId(rs.getInt("client_id"));
    	searchUnitResponse.setUnitType(String.valueOf(rs.getInt("client_group_type_id")));
    	searchUnitResponse.setUnitCPC(rs.getInt("cpc_client_group_id"));
    	searchUnitResponse.setUnitAddress(rs.getString("address"));
    	searchUnitResponse.setState(rs.getString("state"));
    	searchUnitResponse.setUnitName(rs.getString("client_group_name"));
    	searchUnitResponse.setIfscCode(rs.getString("ifsc_code"));
    	searchUnitResponse.setPincode(rs.getInt("pincode"));
    	searchUnitResponse.setCity(rs.getString("city"));
    	searchUnitResponse.setUnitZone(rs.getInt("zo_client_group_id"));
    	searchUnitResponse.setUnitHO(rs.getInt("ho_client_group_id"));
    	searchUnitResponse.setUnitStatus(rs.getString("status"));
    	searchUnitResponse.setCreatedBy(rs.getString("created_by"));
    	searchUnitResponse.setLastUpdatedDate(rs.getDate("created_date"));
        return searchUnitResponse;
        
    }
}
