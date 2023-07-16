/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.DueDeligenceCoApplicantGurantorResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DueDiligenceCoAppGurantorResponseRowMapper implements RowMapper<DueDeligenceCoApplicantGurantorResponse> {

    public DueDeligenceCoApplicantGurantorResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	DueDeligenceCoApplicantGurantorResponse dueDeligence = new DueDeligenceCoApplicantGurantorResponse();
    	
    	dueDeligence.setGuarantor(rs.getString("guarantor"));
    	dueDeligence.setGuarantor1(rs.getString("guarantor_1"));
    	dueDeligence.setGuarantor2(rs.getString("guarantor_2"));
    	dueDeligence.setGuarantor3(rs.getString("guarantor_3"));
    	dueDeligence.setGuarantor4(rs.getString("guarantor_4"));
        return dueDeligence;

    }
}
