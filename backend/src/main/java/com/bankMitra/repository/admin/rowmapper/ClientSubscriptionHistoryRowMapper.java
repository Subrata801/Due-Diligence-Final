/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientSubscriptionHistoryResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientSubscriptionHistoryRowMapper implements RowMapper<ClientSubscriptionHistoryResponse> {

    public ClientSubscriptionHistoryResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientSubscriptionHistoryResponse clientSubscriptionHistoryResponse = new ClientSubscriptionHistoryResponse();
    	clientSubscriptionHistoryResponse.setSubscriptionName(rs.getString("subscription_name"));
    	clientSubscriptionHistoryResponse.setTax(rs.getInt("tax_percentage"));
    	clientSubscriptionHistoryResponse.setGst(rs.getInt("gst_percentage"));
    	clientSubscriptionHistoryResponse.setPrice(rs.getInt("price_package"));
    	clientSubscriptionHistoryResponse.setTotalAmount(rs.getInt("total_amount"));
    	clientSubscriptionHistoryResponse.setStartDate(rs.getDate("subscription_start_date"));
    	clientSubscriptionHistoryResponse.setEndDate(rs.getDate("subscription_end_date"));
        return clientSubscriptionHistoryResponse;

    }
}
