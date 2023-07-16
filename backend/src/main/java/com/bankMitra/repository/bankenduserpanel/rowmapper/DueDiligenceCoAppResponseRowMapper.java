/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.DueDeligenceCoApplicantResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DueDiligenceCoAppResponseRowMapper implements RowMapper<DueDeligenceCoApplicantResponse> {

    public DueDeligenceCoApplicantResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	DueDeligenceCoApplicantResponse dueDeligence = new DueDeligenceCoApplicantResponse();
    	
    	dueDeligence.setCoapplicant(rs.getString("co_applicant"));
    	dueDeligence.setCoapplicantdesignation(rs.getString("co_applicant_designation"));
    	dueDeligence.setCoapplicant1(rs.getString("co_applicant_1"));
    	dueDeligence.setCoapplicant1designation(rs.getString("co_applicant1_designation"));
    	dueDeligence.setCoapplicant2(rs.getString("co_applicant_2"));
    	dueDeligence.setCoapplicant2designation(rs.getString("co_applicant2_designation"));
    	dueDeligence.setCoapplicant3(rs.getString("co_applicant_3"));
    	dueDeligence.setCoapplicant3designation(rs.getString("co_applicant3_designation"));
    	dueDeligence.setCoapplicant4(rs.getString("co_applicant_4"));
    	dueDeligence.setCoapplicant4designation(rs.getString("co_applicant4_designation"));
        return dueDeligence;

    }
}
