package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.ReportingActionResponse;

public class ReportingActionRowMapper implements RowMapper<ReportingActionResponse>{

	@Override
	public ReportingActionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ReportingActionResponse reportingActionResponse = new ReportingActionResponse();
		reportingActionResponse.setActionId(Integer.parseInt(rs.getString("action_id")));
		reportingActionResponse.setActionName(rs.getString("action_name"));
		return reportingActionResponse;
	}

}
