/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.ViewDueDeligenceResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DueDiligenceHeaderRowMapper implements RowMapper<ViewDueDeligenceResponse> {

    public ViewDueDeligenceResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ViewDueDeligenceResponse header = new ViewDueDeligenceResponse();
    	header.setLoanApplicationId(rs.getString("loan_application_id"));
    	header.setHeader1(rs.getString("header1"));
    	header.setHeader1desc(rs.getString("header1_desc"));
    	header.setHeader2(rs.getString("header2"));
    	header.setHeader2desc(rs.getString("header2_desc"));
    	header.setHeader3(rs.getString("header3"));
    	header.setHeader3desc(rs.getString("header3_desc"));
    	header.setHeader4(rs.getString("header4"));
    	header.setHeader4desc(rs.getString("header4_desc"));
    	header.setDdSequence(rs.getString("dd_sequence"));
    	header.setTotalResponseExpected(rs.getString("Total_response_expected"));
    	header.setTotalResponseFilled(rs.getString("total_response_filled"));
        return header;
    }
}
