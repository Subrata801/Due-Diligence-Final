package com.bankMitra.repository.bankenduserpanel.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.request.DueDeligenceCoApplicantRequest;

import io.micrometer.core.instrument.util.StringUtils;

public class DueDeligenceCoAppRowMapper implements RowMapper<DueDeligenceCoApplicantRequest>{

	@Override
	public DueDeligenceCoApplicantRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DueDeligenceCoApplicantRequest dueDeligenceCoApplicantRequest = new DueDeligenceCoApplicantRequest();
		dueDeligenceCoApplicantRequest.setCoapplicantName(rs.getString("co_applicant"));
		dueDeligenceCoApplicantRequest.setCoapplicantName1(rs.getString("co_applicant_1"));
		dueDeligenceCoApplicantRequest.setCoapplicantName2(rs.getString("co_applicant_2"));
		dueDeligenceCoApplicantRequest.setCoapplicantName3(rs.getString("co_applicant_3"));
		dueDeligenceCoApplicantRequest.setCoapplicantName4(rs.getString("co_applicant_4"));
		dueDeligenceCoApplicantRequest.setCoappDesignation(getCoAppDesignationId(rs.getString("co_applicant_designation")));
		dueDeligenceCoApplicantRequest.setCoappDesignation1(getCoAppDesignationId(rs.getString("co_applicant1_designation")));
		dueDeligenceCoApplicantRequest.setCoappDesignation2(getCoAppDesignationId(rs.getString("co_applicant2_designation")));
		dueDeligenceCoApplicantRequest.setCoappDesignation3(getCoAppDesignationId(rs.getString("co_applicant3_designation")));
		dueDeligenceCoApplicantRequest.setCoappDesignation4(getCoAppDesignationId(rs.getString("co_applicant4_designation")));
		dueDeligenceCoApplicantRequest.setGuarantorName(rs.getString("guarantor"));
		dueDeligenceCoApplicantRequest.setGuarantorName1(rs.getString("guarantor_1"));
		dueDeligenceCoApplicantRequest.setGuarantorName2(rs.getString("guarantor_2"));
		dueDeligenceCoApplicantRequest.setGuarantorName3(rs.getString("guarantor_3"));
		dueDeligenceCoApplicantRequest.setGuarantorName4(rs.getString("guarantor_4"));
		dueDeligenceCoApplicantRequest.setLoanSecurity(String.valueOf(rs.getInt("security_id")));
		dueDeligenceCoApplicantRequest.setSecurityType(String.valueOf(rs.getInt("security_type_id")));
		return dueDeligenceCoApplicantRequest;
	}
	
	private Integer getCoAppDesignationId(String coAppDesignationName) {
		if(StringUtils.isNotBlank(coAppDesignationName)) {
			return Integer.parseInt(coAppDesignationName);
		} else {
			return 0;
		}
	}

}
