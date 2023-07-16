/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.SubscriptionModelResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionRowMapper implements RowMapper<SubscriptionModelResponse> {

    public SubscriptionModelResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	SubscriptionModelResponse subscriptionRepsonse = new SubscriptionModelResponse();
    	subscriptionRepsonse.setSubscriptionModelId(rs.getInt("subscription_id"));
    	subscriptionRepsonse.setSubscriptionModeDesc(rs.getString("subscription_name"));
        return subscriptionRepsonse;

    }
}
