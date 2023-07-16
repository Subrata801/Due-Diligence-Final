/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.DueDeligenceGeneralInfoResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DueDiligenceResponseRowMapper implements RowMapper<DueDeligenceGeneralInfoResponse> {

    public DueDeligenceGeneralInfoResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	DueDeligenceGeneralInfoResponse dueDeligence = new DueDeligenceGeneralInfoResponse();
    	
    	dueDeligence.setCifFlag(rs.getString("cif_flag"));
    	dueDeligence.setCifNo(rs.getString("cif_no"));
    	dueDeligence.setLoanApplnNumber2(rs.getString("loan_application_no"));
    	dueDeligence.setLoanApplicantName(rs.getString("loan_applicant_name"));
    	dueDeligence.setLoanSchemeId(rs.getString("loan_scheme_name"));
    	dueDeligence.setLoanVariantId(rs.getString("loan_variant_name"));
    	dueDeligence.setLoanAccountNo(rs.getString("loan_account_no"));
    	dueDeligence.setLoanSanctionedDate(String.valueOf(rs.getDate("loan_sanctioned_date")));
    	dueDeligence.setSanctionedLoanAmount(String.valueOf(rs.getInt("loan_amount")));
    	dueDeligence.setSanctionedLoanAmountWords(rs.getString("loan_amount_in_words"));
    	dueDeligence.setLoanTenure2(String.valueOf(rs.getInt("loan_tenor")));
    	dueDeligence.setRevisedLoanTenure2(String.valueOf(rs.getInt("revised_loan_tenor")));
    	dueDeligence.setDisbursementDate(String.valueOf(rs.getDate("disbursement_date")));
    	dueDeligence.setM4CurrentReviewSanctionDate(String.valueOf(rs.getDate("m4_current_review_sanction_date")));
    	dueDeligence.setSelectCreditSector2(String.valueOf(rs.getInt("credit_sector_type_id")));
    	
    	dueDeligence.setAssetTypeId(String.valueOf(rs.getInt("asset_type_id")));
    	dueDeligence.setReleaseOfSecurityOnAccountClosure(rs.getString("release_of_security_on_account_closure"));
    	dueDeligence.setDateOfClosureOfLoan(String.valueOf(rs.getDate("date_of_closure_of_loan")));
    	dueDeligence.setSelectedAccountType(rs.getInt("account_type_id"));
    	dueDeligence.setSelectedBorrowerType(rs.getInt("borrower_type_id"));
    	dueDeligence.setProfessionId(rs.getInt("profession_id"));
      
        return dueDeligence;

    }
}
