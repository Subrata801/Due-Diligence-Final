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

public class DueDeligenceRowMapper implements RowMapper<ViewDueDeligenceResponse> {

    public ViewDueDeligenceResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ViewDueDeligenceResponse clientDueDeligenceResponse = new ViewDueDeligenceResponse();
    	clientDueDeligenceResponse.setDdSequence(rs.getString("dd_sequence"));
    	clientDueDeligenceResponse.setDdParentSequence(rs.getString("dd_parent_sequence"));
    	clientDueDeligenceResponse.setDdData(rs.getString("dd_data"));
    	clientDueDeligenceResponse.setSchmemaNormPlaceHolderValues(rs.getString("schmema_norm_place_holder_values"));
    	clientDueDeligenceResponse.setSchmemaNormUiValidValue(rs.getString("schmema_norm_ui_valid_value"));
    	clientDueDeligenceResponse.setSchmemaNormColor(rs.getString("schmema_norm_color"));
    	clientDueDeligenceResponse.setApplicantPlaceHolderValues(rs.getString("applicant_place_holder_values"));
    	clientDueDeligenceResponse.setApplicantUiValidValue(rs.getString("applicant_ui_valid_value"));
    	clientDueDeligenceResponse.setApplicantColor(rs.getString("applicant_color"));
    	clientDueDeligenceResponse.setCoapplicantplaceholdervalues(rs.getString("coapplicant_place_holder_values"));
    	clientDueDeligenceResponse.setCoapplicantuivalidvalue(rs.getString("coapplicant_ui_valid_value"));
    	clientDueDeligenceResponse.setCoapplicantcolor(rs.getString("coapplicant_color"));
    	clientDueDeligenceResponse.setCoapplicant1placeholdervalues(rs.getString("coapplicant1_place_holder_values"));
    	clientDueDeligenceResponse.setCoapplicant1uivalidvalue(rs.getString("coapplicant1_ui_valid_value"));
    	clientDueDeligenceResponse.setCoapplicant1color(rs.getString("coapplicant1_color"));
    	clientDueDeligenceResponse.setCoapplicant2placeholdervalues(rs.getString("coapplicant2_place_holder_values"));
    	clientDueDeligenceResponse.setCoapplicant2uivalidvalue(rs.getString("coapplicant2_ui_valid_value"));
    	clientDueDeligenceResponse.setCoapplicant2color(rs.getString("coapplicant2_color"));
    	clientDueDeligenceResponse.setCoapplicant3placeholdervalues(rs.getString("coapplicant3_place_holder_values"));
    	clientDueDeligenceResponse.setCoapplicant3uivalidvalue(rs.getString("coapplicant3_ui_valid_value"));
    	clientDueDeligenceResponse.setCoapplicant3color(rs.getString("coapplicant3_color"));
    	clientDueDeligenceResponse.setCoapplicant4placeholdervalues(rs.getString("coapplicant4_place_holder_values"));
    	clientDueDeligenceResponse.setCoapplicant4uivalidvalue(rs.getString("coapplicant4_ui_valid_value"));
    	clientDueDeligenceResponse.setCoapplicant4color(rs.getString("coapplicant4_color"));
    	clientDueDeligenceResponse.setGuarantorplaceholdervalues(rs.getString("guarantor_place_holder_values"));
    	clientDueDeligenceResponse.setGuarantoruivalidvalue(rs.getString("guarantor_ui_valid_value"));
    	clientDueDeligenceResponse.setGuarantorcolor(rs.getString("guarantor_color"));
    	clientDueDeligenceResponse.setGuarantor1placeholdervalues(rs.getString("guarantor1_place_holder_values"));
    	clientDueDeligenceResponse.setGuarantor1uivalidvalue(rs.getString("guarantor1_ui_valid_value"));
    	clientDueDeligenceResponse.setGuarantor1color(rs.getString("guarantor1_color"));
    	clientDueDeligenceResponse.setGuarantor2placeholdervalues(rs.getString("guarantor2_place_holder_values"));
    	clientDueDeligenceResponse.setGuarantor2uivalidvalue(rs.getString("guarantor2_ui_valid_value"));
    	clientDueDeligenceResponse.setGuarantor2color(rs.getString("guarantor2_color"));
    	clientDueDeligenceResponse.setGuarantor3placeholdervalues(rs.getString("guarantor3_place_holder_values"));
    	clientDueDeligenceResponse.setGuarantor3uivalidvalue(rs.getString("guarantor3_ui_valid_value"));
    	clientDueDeligenceResponse.setGuarantor3color(rs.getString("guarantor3_color"));
    	clientDueDeligenceResponse.setGuarantor4placeholdervalues(rs.getString("guarantor4_place_holder_values"));
    	clientDueDeligenceResponse.setGuarantor4uivalidvalue(rs.getString("guarantor4_ui_valid_value"));
    	clientDueDeligenceResponse.setGuarantor4color(rs.getString("guarantor4_color"));
        return clientDueDeligenceResponse;

    }
}
