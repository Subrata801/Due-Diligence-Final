/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.clientManagement.response.CreateUnitResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchUnitRowMapper implements RowMapper<CreateUnitResponse> {

    public CreateUnitResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	CreateUnitResponse searchUnitResponse = new CreateUnitResponse();
    	searchUnitResponse.setUnitType(String.valueOf(rs.getInt("client_group_type_id")));
    	searchUnitResponse.setClientGroupId(rs.getInt("client_group_id"));
    	searchUnitResponse.setUnitName(rs.getString("client_group_name"));
    	searchUnitResponse.setIfscCode(rs.getString("ifsc_code"));
    	searchUnitResponse.setCity(rs.getString("city"));
    	searchUnitResponse.setUnitStatus(rs.getString("status"));
    	searchUnitResponse.setCreatedBy(rs.getString("updated_by"));
    	searchUnitResponse.setLastUpdatedDate(rs.getDate("updated_date"));
    	searchUnitResponse.setClientGroupType(rs.getString("client_group_type"));
        return searchUnitResponse;

    }
}
