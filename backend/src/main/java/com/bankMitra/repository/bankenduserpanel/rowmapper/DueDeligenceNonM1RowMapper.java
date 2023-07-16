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

public class DueDeligenceNonM1RowMapper implements RowMapper<ViewDueDeligenceResponse> {

    public ViewDueDeligenceResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ViewDueDeligenceResponse clientDueDeligenceResponse = new ViewDueDeligenceResponse();
    	clientDueDeligenceResponse.setDdSequence(rs.getString("dd_sequence"));
    	clientDueDeligenceResponse.setDdParentSequence(rs.getString("dd_parent_sequence"));
    	clientDueDeligenceResponse.setDdData(rs.getString("dd_data"));
    	clientDueDeligenceResponse.setCompliancePlaceholdervalues(rs.getString("compliance_place_holder_values"));
    	clientDueDeligenceResponse.setComplianceUivalidvalue(rs.getString("compliance_ui_valid_value"));
    	clientDueDeligenceResponse.setComplianceColor(rs.getString("compliance_color"));
    	return clientDueDeligenceResponse;

    }
}
