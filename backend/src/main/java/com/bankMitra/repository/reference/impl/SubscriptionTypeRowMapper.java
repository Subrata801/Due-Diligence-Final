/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.SubscriptionType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubscriptionTypeRowMapper implements RowMapper<SubscriptionType> {

    public SubscriptionType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	SubscriptionType subscriptionType = new SubscriptionType();
    	subscriptionType.setSubscriptionTypeId(rs.getInt("subscription_type_id"));
    	subscriptionType.setSubscriptionTypeName(rs.getString("subscription_type"));
      
        return subscriptionType;

    }
}
