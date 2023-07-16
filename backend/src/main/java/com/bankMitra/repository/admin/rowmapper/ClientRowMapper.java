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

import com.bankMitra.model.admin.response.ClientResponse;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientRowMapper implements RowMapper<ClientResponse> {

    public ClientResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientResponse clientResponse = new ClientResponse();
    	clientResponse.setStatus(rs.getString("status"));
    	clientResponse.setClientId(rs.getString("client_id"));
    	clientResponse.setClientType(rs.getString("client_type_id"));
    	clientResponse.setClientName(rs.getString("client_name"));
    	clientResponse.setCreateDate(String.valueOf(rs.getDate("created_date")));
    	
    	if(!StringUtils.isEmpty(String.valueOf(rs.getTimestamp("updated_date"))) && !"null".equalsIgnoreCase(String.valueOf(rs.getTimestamp("updated_date")))) {
	        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        // you can change format of date
	        Date date = null;
	        String finalStringDate = null;
	        Timestamp ts =  rs.getTimestamp("updated_date");
			 date = new Date(ts.getTime());
			 finalStringDate = formatter.format(date);
			 clientResponse.setLastUpdatedDate(finalStringDate);
        } else {
        	clientResponse.setLastUpdatedDate("");
        }
    	
    	/*if(!StringUtils.isEmpty(String.valueOf(rs.getDate("updated_date"))) && !"null".equalsIgnoreCase(String.valueOf(rs.getDate("updated_date"))))
    		clientResponse.setLastUpdatedDate(String.valueOf(rs.getDate("updated_date")));
    	else 
    		clientResponse.setLastUpdatedDate("");*/
    	clientResponse.setClientPrefix(rs.getString("clinet_prefix"));
    	clientResponse.setUpdatedBy(rs.getString("updated_by"));
    	clientResponse.setClientTemplateStatus(rs.getString("templatestatus"));
    	clientResponse.setClientLoanSchemeName(rs.getString("client_loan_scheme_name"));
        return clientResponse;

    }
}


