package com.bankMitra.repository.reference.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.RiskType;

public class RiskType2RowMapper implements RowMapper<RiskType>{

	@Override
	public RiskType mapRow(ResultSet rs, int rowNum) throws SQLException {
		RiskType riskType = new RiskType();
		riskType.setRiskTypeId(rs.getInt("risk_type_id"));
		return riskType;
	}

}
