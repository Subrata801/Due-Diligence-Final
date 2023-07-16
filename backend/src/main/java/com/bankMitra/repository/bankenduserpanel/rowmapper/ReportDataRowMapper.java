package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.ReportData;

public class ReportDataRowMapper implements RowMapper<ReportData>{

	@Override
	public ReportData mapRow(ResultSet rs, int rowNum) throws SQLException {
		ReportData reportData = new ReportData();
		reportData.setHeader1Desc(rs.getString("header1_desc"));
		reportData.setHeader2Desc(rs.getString("header2_desc"));
		reportData.setHeader3Desc(rs.getString("header3_desc"));
		reportData.setHeader4Desc(rs.getString("header4_desc"));
		reportData.setDdData(rs.getString("dd_data"));
		reportData.setResponse(rs.getString("response"));
		return reportData;
	}

}
