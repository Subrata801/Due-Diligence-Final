/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientDueDeligenceDownloadResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DueDeligenceSuccessRowMapper implements RowMapper<ClientDueDeligenceDownloadResponse> {

    public ClientDueDeligenceDownloadResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientDueDeligenceDownloadResponse downloadResponse = new ClientDueDeligenceDownloadResponse();
    	downloadResponse.setModule(rs.getString("module"));
    	downloadResponse.setHeader1(rs.getString("header1"));
    	downloadResponse.setHeader2(rs.getString("header2"));
    	downloadResponse.setHeader3(rs.getString("header3"));
    	downloadResponse.setHeader4(rs.getString("header4"));
    	downloadResponse.setDdId(rs.getInt("dd_id"));
    	downloadResponse.setHeaderSequence(rs.getInt("header_seq"));
    	downloadResponse.setDdSequence(rs.getInt("dd_sequence"));
    	downloadResponse.setDdParentSequence(rs.getInt("dd_parent_sequence"));
    	downloadResponse.setDdData(rs.getString("dd_data"));
    	downloadResponse.setGeneralOption(rs.getString("general_options"));
    	downloadResponse.setApplicantOption(rs.getString("applicant_options"));
    	downloadResponse.setCoApplicantOption(rs.getString("coapplicant_options"));
    	downloadResponse.setGuarantorOption(rs.getString("guarantor_options"));
    	downloadResponse.setConditions(rs.getString("conditions"));
    	downloadResponse.setCreditSectorId(rs.getString("credit_sector_id"));
    	downloadResponse.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	downloadResponse.setLoanVariant_keyword(rs.getString("loan_variant_keyword"));
    	downloadResponse.setBorrowerTypeId(rs.getInt("borrower_type_id"));
    	downloadResponse.setCriticaltyFactor(rs.getString("criticalty_factor"));
    	downloadResponse.setProfessionId(rs.getInt("profession_id"));
    	downloadResponse.setLoanApplicationTypeId(rs.getInt("loan_application_type_id"));
    	downloadResponse.setSecurityId(rs.getInt("security_id"));
    	downloadResponse.setSecurityTypeId(rs.getInt("security_type_id"));
    	downloadResponse.setSecuritySubtypeId(rs.getInt("security_subtype_id"));
    	downloadResponse.setApplicationTypeId(rs.getInt("applicant_type_id"));
    	downloadResponse.setAssetTypeId(rs.getInt("asset_type_id"));
    	downloadResponse.setRemarks(rs.getString("remarks"));
    	downloadResponse.setCreatedBy(rs.getString("created_by"));
    	downloadResponse.setCreatedDate(rs.getString("created_date"));
    	downloadResponse.setUpdatedBy(rs.getString("updated_by"));
    	downloadResponse.setUpdatedDate(String.valueOf(rs.getDate("updated_date")));
    	return downloadResponse;

    }
}
