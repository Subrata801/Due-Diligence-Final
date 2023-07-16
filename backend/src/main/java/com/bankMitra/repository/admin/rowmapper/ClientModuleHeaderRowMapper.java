/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientModuleHeaderResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientModuleHeaderRowMapper implements RowMapper<ClientModuleHeaderResponse> {

    public ClientModuleHeaderResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientModuleHeaderResponse clientModuleHeaderResponse = new ClientModuleHeaderResponse();
    	clientModuleHeaderResponse.setDdSequence(rs.getInt("dd_seq"));
    	clientModuleHeaderResponse.setDdId(rs.getInt("dd_id"));
    	clientModuleHeaderResponse.setHeader1(rs.getString("header1"));
    	clientModuleHeaderResponse.setHeader1Description(rs.getString("header1_desc"));
    	clientModuleHeaderResponse.setHeader2(rs.getString("header2"));
    	clientModuleHeaderResponse.setHeader2Description(rs.getString("header2_desc"));
    	clientModuleHeaderResponse.setHeader3(rs.getString("header3"));
    	clientModuleHeaderResponse.setHeader3Description(rs.getString("header3_desc"));
    	clientModuleHeaderResponse.setHeader4(rs.getString("header4"));
    	clientModuleHeaderResponse.setHeader4Description(rs.getString("header4_desc"));
        return clientModuleHeaderResponse;

    }
}
