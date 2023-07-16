/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import com.bankMitra.model.admin.response.ClientDueDeligenceResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientDueDeligenceRowMapper implements RowMapper<ClientDueDeligenceResponse> {

    public ClientDueDeligenceResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientDueDeligenceResponse clientDueDeligenceResponse = new ClientDueDeligenceResponse();
    	clientDueDeligenceResponse.setHeaderSequence(rs.getInt("header_seq"));
    	clientDueDeligenceResponse.setDdSequence(rs.getInt("dd_sequence"));
    	clientDueDeligenceResponse.setDdParentSequence(rs.getInt("dd_parent_sequence"));
    	clientDueDeligenceResponse.setDdData(rs.getString("dd_data"));
    	if(!StringUtils.isEmpty(rs.getString("general_options"))) {
    		String[] genOption = rs.getString("general_options").split(",");
    		clientDueDeligenceResponse.setGeneralOptionArr(genOption);
    	}
    	if(!StringUtils.isEmpty(rs.getString("applicant_options"))) {
    		String[] applicantOption = rs.getString("applicant_options").split(",");
    		clientDueDeligenceResponse.setApplicantOptionArr(applicantOption);
    	}
    	if(!StringUtils.isEmpty(rs.getString("coapplicant_options"))) {
    		String[] coApplicantOption = rs.getString("coapplicant_options").split(",");
    		clientDueDeligenceResponse.setCoApplicantOptionArr(coApplicantOption);
    	}
    	if(!StringUtils.isEmpty(rs.getString("guarantor_options"))) {
    		String[] guarantorOption = rs.getString("guarantor_options").split(",");
    		clientDueDeligenceResponse.setGuarantorOptionArr(guarantorOption);
    	}
    	clientDueDeligenceResponse.setGeneralOption(rs.getString("general_options"));
    	clientDueDeligenceResponse.setApplicantOption(rs.getString("applicant_options"));
    	clientDueDeligenceResponse.setCoApplicantOption(rs.getString("coapplicant_options"));
    	clientDueDeligenceResponse.setGuarantorOption(rs.getString("guarantor_options"));
    	clientDueDeligenceResponse.setComplianceOption(rs.getString("compliance_options"));
    	clientDueDeligenceResponse.setRemarks(rs.getString("remarks"));
    	clientDueDeligenceResponse.setConditions(rs.getString("conditions"));
    	clientDueDeligenceResponse.setCreditSectorId(rs.getString("credit_sector_id"));
    	clientDueDeligenceResponse.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	clientDueDeligenceResponse.setLoanVariant_keyword(rs.getString("loan_variant_keyword"));
    	clientDueDeligenceResponse.setBorrowerTypeId(rs.getInt("borrower_type_id"));
    	clientDueDeligenceResponse.setCriticaltyFactor(rs.getString("criticalty_factor"));
    	clientDueDeligenceResponse.setProfessionId(rs.getInt("profession_id"));
    	clientDueDeligenceResponse.setLoanApplicationTypeId(rs.getInt("loan_application_type_id"));
    	clientDueDeligenceResponse.setSecurityId(rs.getInt("security_id"));
    	clientDueDeligenceResponse.setSecurityTypeId(rs.getInt("security_type_id"));
    	clientDueDeligenceResponse.setApplicationTypeId(rs.getInt("applicant_type_id"));
    	clientDueDeligenceResponse.setAssetTypeId(rs.getInt("asset_type_id"));
    	
        return clientDueDeligenceResponse;

    }
}
