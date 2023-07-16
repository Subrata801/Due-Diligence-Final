/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.RiskRatingResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RiskRatingResponseRowMapper implements RowMapper<RiskRatingResponse> {

    public RiskRatingResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	RiskRatingResponse riskRatingResponse = new RiskRatingResponse();
    	riskRatingResponse.setResponseId(rs.getInt("response_id"));
    	riskRatingResponse.setResponseKey(rs.getString("response_key"));
    	riskRatingResponse.setResponseDesc(rs.getString("response_description"));
    	riskRatingResponse.setColorCode(rs.getString("response_color"));
    	riskRatingResponse.setGeneralScore(rs.getInt("scheme_norms"));
    	riskRatingResponse.setApplicantScore(rs.getInt("applicant_score"));
    	riskRatingResponse.setCoApplicantScore(rs.getInt("co_applicant_score"));
    	riskRatingResponse.setGuarantorScore(rs.getInt("guarantor_score"));
        return riskRatingResponse;

    }
}
