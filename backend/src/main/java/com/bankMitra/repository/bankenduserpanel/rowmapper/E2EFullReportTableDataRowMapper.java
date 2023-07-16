package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.request.E2EFullReportTable;

public class E2EFullReportTableDataRowMapper implements RowMapper<E2EFullReportTable>{

	@Override
	public E2EFullReportTable mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		E2EFullReportTable tableData = new E2EFullReportTable();
		tableData.setDdSequence(rs.getInt("dd_sequence"));
		tableData.setDdData(rs.getString("dd_data"));
		tableData.setSchemeNormColor(rs.getString("schmema_norm_color"));
		tableData.setApplicantColor(rs.getString("applicant_color"));
		tableData.setCoapplicantColor(rs.getString("coapplicant_color"));
		tableData.setCoapplicant1Color(rs.getString("coapplicant1_color"));
		tableData.setCoapplicant2Color(rs.getString("coapplicant2_color"));
		tableData.setCoapplicant3Color(rs.getString("coapplicant3_color"));
		tableData.setCoapplicant4Color(rs.getString("coapplicant4_color"));
		tableData.setGurantorColor(rs.getString("guarantor_color"));
		tableData.setGurantor1Color(rs.getString("guarantor1_color"));
		tableData.setGurantor2Color(rs.getString("guarantor2_color"));
		tableData.setGurantor3Color(rs.getString("guarantor3_color"));
		tableData.setGurantor4Color(rs.getString("guarantor4_color"));
		return tableData;
	}

}
