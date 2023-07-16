/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.bankMitra.model.admin.response.ClientCustomizeTemplateResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientCustomizeTemplateRowMapper implements RowMapper<ClientCustomizeTemplateResponse> {

    public ClientCustomizeTemplateResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientCustomizeTemplateResponse clientTemplateResponse = new ClientCustomizeTemplateResponse();
    	clientTemplateResponse.setDdId(rs.getInt("dd_id"));
    	clientTemplateResponse.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	clientTemplateResponse.setClientGroupId(rs.getInt("client_group_id"));
    	clientTemplateResponse.setStartDate(String.valueOf(rs.getDate("start_date")));
    	if(!StringUtils.isEmpty(String.valueOf(rs.getDate("end_date"))) && !"null".equalsIgnoreCase(String.valueOf(rs.getDate("end_date"))))
    		clientTemplateResponse.setEndDate(String.valueOf(rs.getDate("end_date")));
    	else 
    		clientTemplateResponse.setEndDate("");
    	clientTemplateResponse.setTemplateStatus(rs.getString("status"));
    	clientTemplateResponse.setClientLoanSchemeName(rs.getString("client_loan_scheme_name"));
        return clientTemplateResponse;

    }
}
