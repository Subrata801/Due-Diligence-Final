/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.DueDeligenceProcessResponse;

import io.micrometer.core.instrument.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DueDiligenceRowMapper implements RowMapper<DueDeligenceProcessResponse> {

    public DueDeligenceProcessResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	DueDeligenceProcessResponse dueDeligence = new DueDeligenceProcessResponse();
    	
    	dueDeligence.setLoanApplicationId(String.valueOf(rs.getInt("loan_application_id")));
    	dueDeligence.setClientId(String.valueOf(rs.getInt("client_id")));
    	dueDeligence.setClientGroupId(String.valueOf(rs.getInt("client_group_id")));
    	dueDeligence.setStartModule(rs.getString("start_module"));
    	dueDeligence.setLoanApplicationNo(rs.getString("loan_application_no"));
    	dueDeligence.setLoanApplicationDate(rs.getDate("loan_application_date"));
    	dueDeligence.setCifFlag(rs.getString("cif_flag"));
    	//dueDeligence.setCifNo(getValidCifNumber(rs.getString("cif_no")));
    	dueDeligence.setCifNo(rs.getString("cif_no"));
    	dueDeligence.setLoanStatus(rs.getString("loan_status"));
    	dueDeligence.setLoanApplicantName(rs.getString("loan_applicant_name"));
    	dueDeligence.setCreditSectorTypeId(String.valueOf(rs.getInt("credit_sector_type_id")));
    	dueDeligence.setLoanSchemeId(rs.getInt("loan_scheme_id"));
    	dueDeligence.setLoanVariantId(rs.getInt("loan_variant_id"));
    	dueDeligence.setUnitMaker(rs.getString("unit_maker"));
    	dueDeligence.setInitiateDdpComments(rs.getString("initiate_ddp_comments"));
      
        return dueDeligence;

    }

	private Integer getValidCifNumber(String cifNo) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotBlank(cifNo)) {
			return Integer.parseInt(cifNo);
		}
		return null;
	}
}
