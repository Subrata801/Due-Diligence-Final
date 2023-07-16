/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.SubscriptionSubType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubsciptionSubTypeRowMapper implements RowMapper<SubscriptionSubType> {

    public SubscriptionSubType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	SubscriptionSubType subscriptionSubType = new SubscriptionSubType();
    	subscriptionSubType.setSubscriptionSubTypeId(rs.getInt("subscription_sub_type_id"));
    	subscriptionSubType.setSubscriptionSubTypeName(rs.getString("subscription_sub_type_name"));
    	subscriptionSubType.setSubscriptionTypeId(rs.getInt("subscription_type_id"));
        return subscriptionSubType;

    }
}
