/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientSubscriptionResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientSubscriptionRowMapper implements RowMapper<ClientSubscriptionResponse> {

    public ClientSubscriptionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientSubscriptionResponse clientSubscriptionResponse = new ClientSubscriptionResponse();
    	clientSubscriptionResponse.setProductId(rs.getInt("product_id"));
    	clientSubscriptionResponse.setProductName(rs.getString("product_name"));
    	clientSubscriptionResponse.setSubscriptionName(rs.getString("subscription_name"));
    	clientSubscriptionResponse.setSubscriptionType(rs.getString("subscription_type"));
    	clientSubscriptionResponse.setSubscriptionTypeId(rs.getInt("subscription_type_id"));
    	clientSubscriptionResponse.setSubscriptionSubTypeId(rs.getInt("subscription_sub_type_id"));
    	clientSubscriptionResponse.setSubscriptionSubTypeName(rs.getString("subscription_sub_type_name"));
    	clientSubscriptionResponse.setSubscriptionId(rs.getInt("subscription_id"));
    	clientSubscriptionResponse.setClientId(rs.getInt("client_id"));
    	clientSubscriptionResponse.setStartDate(rs.getDate("subscription_start_date"));
    	clientSubscriptionResponse.setSubscriptionStatus(rs.getString("subscription_status"));
    	
    	clientSubscriptionResponse.setSubscriptionPeriod(rs.getInt("subscription_period"));
    	clientSubscriptionResponse.setMaxNumberOfBranches(rs.getInt("max_clinet_group_allowed"));
    	clientSubscriptionResponse.setMaxLoanSchemeAllowed(rs.getInt("max_loan_scheme_allowed"));
    	clientSubscriptionResponse.setRenewalReminderActivation(rs.getInt("reminder_before"));
    	clientSubscriptionResponse.setDataValidityPeriod(rs.getInt("data_validity_period"));
    	clientSubscriptionResponse.setPricePerMonth(rs.getInt("price_per_month"));
    	clientSubscriptionResponse.setPricePackage(rs.getInt("price_package"));
    	clientSubscriptionResponse.setTax(rs.getInt("tax_percentage"));
    	clientSubscriptionResponse.setGst(rs.getInt("gst_percentage"));
    	clientSubscriptionResponse.setTotalAmount(rs.getInt("total_amount"));
    	
    	clientSubscriptionResponse.setEndDate(rs.getDate("subscription_end_date"));
    	clientSubscriptionResponse.setRenewalReminderDate(rs.getDate("renewal_reminder_date"));
    	//clientSubscriptionResponse.setClientTypeId(rs.getInt("client_type_id"));
        return clientSubscriptionResponse;
    }
}

