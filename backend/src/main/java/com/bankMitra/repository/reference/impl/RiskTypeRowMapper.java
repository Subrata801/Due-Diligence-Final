/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.RiskType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RiskTypeRowMapper implements RowMapper<RiskType> {

    public RiskType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	RiskType riskType = new RiskType();
    	riskType.setRiskTypeId(rs.getInt("risk_type_id"));
    	riskType.setRiskTypeName(rs.getString("risk_type_name"));
      
        return riskType;

    }
}
