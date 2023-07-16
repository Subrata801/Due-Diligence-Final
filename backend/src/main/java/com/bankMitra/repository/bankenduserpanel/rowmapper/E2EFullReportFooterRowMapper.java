package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.request.E2EFullReportFooter;

public class E2EFullReportFooterRowMapper implements RowMapper<E2EFullReportFooter>{

	@Override
	public E2EFullReportFooter mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		E2EFullReportFooter footer = new E2EFullReportFooter();
		footer.setMaker(rs.getString("maker"));
		footer.setChecker(rs.getString("checker"));
		footer.setBranchManager(rs.getString("branch_manager"));
		return footer;
	}

}
