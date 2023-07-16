package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.request.E2EFullReportHeader;

public class E2EFullReportHeaderLoanVariant implements RowMapper<E2EFullReportHeader>{

	@Override
	public E2EFullReportHeader mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		E2EFullReportHeader header = new E2EFullReportHeader();
		header.setLoanVariant(rs.getString("loan_variant_name"));
		return null;
	}

	

}
