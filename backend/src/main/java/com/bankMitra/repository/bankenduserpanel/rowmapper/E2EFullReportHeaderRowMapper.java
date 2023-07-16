package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.request.E2EFullReportHeader;

public class E2EFullReportHeaderRowMapper implements RowMapper<E2EFullReportHeader>{

	@Override
	public E2EFullReportHeader mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		E2EFullReportHeader header = new E2EFullReportHeader();
		header.setUnitType(rs.getString("unit_type"));
		header.setNameOfBranch(rs.getString("unit_name"));
		header.setE2eNum(rs.getString("e2e_no"));
		header.setE2eDate(String.valueOf(rs.getDate("e2e_date")));
		header.setApplicantName(rs.getString("applicant_name"));
		header.setDateOfReceiptOfApplication(String.valueOf(rs.getDate("date_of_receipt_of_application")));
		header.setDateOfSanction(String.valueOf(rs.getDate("date_of_sanction")));
		header.setSanctionedAuthority(rs.getString("sanctioning_authority"));
		header.setLoanType(rs.getString("loan_type"));
		header.setLoanScheme(rs.getString("loan_scheme"));
		return header;
	}
	
}
