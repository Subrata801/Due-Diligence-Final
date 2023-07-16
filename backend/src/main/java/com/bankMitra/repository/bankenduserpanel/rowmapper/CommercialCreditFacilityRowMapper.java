/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.ComercialCreditFacilityDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommercialCreditFacilityRowMapper implements RowMapper<ComercialCreditFacilityDetails> {

    public ComercialCreditFacilityDetails mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ComercialCreditFacilityDetails facilities = new ComercialCreditFacilityDetails();
    	facilities.setLoanAppId(rs.getString("loan_application_id"));
    	facilities.setAccountNum(rs.getString("loan_account_number"));
    	facilities.setDateOfSanction(rs.getDate("date_of_sanction"));
    	facilities.setFacility(rs.getInt("facility_id"));
    	facilities.setSanctionedLimit(rs.getInt("sanctioned_limit"));
    	facilities.setSanctionedLimitWords(rs.getString("sanctioned_limit_in_words"));
    	facilities.setLoanTenor(rs.getInt("loan_tenor"));
        return facilities;
        
    }
}
