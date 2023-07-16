package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.ReportHeaderResponse;

public class ReportingHeaderRowMapper implements RowMapper<ReportHeaderResponse>{

	@Override
	public ReportHeaderResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		ReportHeaderResponse reportHeaderResponse = new ReportHeaderResponse();
		reportHeaderResponse.setApplicantName(rs.getString("applicant_name"));
		reportHeaderResponse.setE2eNumber(rs.getString("e2e_no"));
		reportHeaderResponse.setCifNumber(rs.getString("cif_no"));
		reportHeaderResponse.setLoanDate(rs.getString("e2e_date"));
		reportHeaderResponse.setLoanUnit(rs.getString("unit"));
		reportHeaderResponse.setLoanUser(rs.getString("username"));
		reportHeaderResponse.setLoanScheme(rs.getString("loan_scheme"));
		reportHeaderResponse.setLoanVariant(rs.getString("loan_variant"));
		return reportHeaderResponse;
	}

}
