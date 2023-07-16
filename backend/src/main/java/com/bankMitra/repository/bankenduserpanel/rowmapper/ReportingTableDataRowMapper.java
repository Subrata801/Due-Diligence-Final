package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.ReportingTableData;

public class ReportingTableDataRowMapper implements RowMapper<ReportingTableData>{

	@Override
	public ReportingTableData mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ReportingTableData reportingTableData = new ReportingTableData();
		reportingTableData.setParicularOfResponse(rs.getString("particular_of_response"));
		reportingTableData.setPositiveYAndN(rs.getInt("positive_y_and_n"));
		reportingTableData.setNeutralRiskPositiveResponse(rs.getInt("neutral_risk_positive_response"));
		reportingTableData.setLowRiskLr(rs.getInt("low_risk_lr"));
		reportingTableData.setMediumRiskMr(rs.getInt("medium_risk_mr"));
		reportingTableData.setHighRiskHr(rs.getInt("high_risk_hr"));
		reportingTableData.setNa(rs.getInt("na"));
		reportingTableData.setOpen(rs.getInt("open"));
		reportingTableData.setTotalDdaps(rs.getInt("total_ddaps"));
		reportingTableData.setTotalResponded(rs.getInt("total_responded"));
		reportingTableData.setNonComplianceRisk(rs.getInt("non_compliance_risk"));
		reportingTableData.setRiskScore(rs.getInt("risk_score"));
		return reportingTableData;
	}

}
