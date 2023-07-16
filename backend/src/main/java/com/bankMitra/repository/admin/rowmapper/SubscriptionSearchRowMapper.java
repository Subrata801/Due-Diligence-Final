/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.subscription.response.SubscriptionResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionSearchRowMapper implements RowMapper<SubscriptionResponse> {

    public SubscriptionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	SubscriptionResponse subscriptionRepsonse = new SubscriptionResponse();
    	subscriptionRepsonse.setProductTypeId(String.valueOf(rs.getInt("product_id")));
    	subscriptionRepsonse.setSubscriptionTypeId(String.valueOf(rs.getInt("subscription_type_id")));
    	subscriptionRepsonse.setSubscriptionSubTypeId(rs.getInt("subscription_sub_type_id"));
    	subscriptionRepsonse.setSubscriptionName(rs.getString("subscription_name"));
    	subscriptionRepsonse.setSubscriptionPeriod(rs.getInt("subscription_period"));
    	subscriptionRepsonse.setMaxBranches(rs.getInt("max_clinet_group_allowed"));
    	subscriptionRepsonse.setMaxNumOfLoanSchemes(rs.getInt("max_loan_scheme_allowed"));
    	subscriptionRepsonse.setSubscriptionId(rs.getInt("subscription_id"));
    	subscriptionRepsonse.setRenewalReminderDate(rs.getInt("reminder_before"));
    	subscriptionRepsonse.setDataValidityPeriod(rs.getInt("data_validity_period"));
    	subscriptionRepsonse.setPricePerMonth(rs.getInt("price_per_month"));
    	subscriptionRepsonse.setSubscriptionTypeName(rs.getString("subscription_type"));
    	subscriptionRepsonse.setSubscriptionSubTypeName(rs.getString("subscription_sub_type_name"));
    	subscriptionRepsonse.setProductName(rs.getString("product_name"));
        return subscriptionRepsonse;

    }
}
