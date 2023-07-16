/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.E2EDashboardResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class E2EDashboardRowMapper implements RowMapper<E2EDashboardResponse> {

    public E2EDashboardResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	E2EDashboardResponse e2eDashboardResponse = new E2EDashboardResponse();
    	e2eDashboardResponse.setE2eNum(rs.getString("e2e_no"));
    	e2eDashboardResponse.setDateField(rs.getDate("loan_application_date"));
    	e2eDashboardResponse.setLoanApplicationNum(rs.getString("loan_application_no"));
    	e2eDashboardResponse.setBorrowerName(rs.getString("loan_applicant_name"));
    	e2eDashboardResponse.setCifNumber(rs.getString("cif_no"));
    	e2eDashboardResponse.setReviewScheduleDate(rs.getDate("e2e_m4_review_date"));
    	e2eDashboardResponse.setApplicationStatus(rs.getString("loan_status"));
    	e2eDashboardResponse.setUserName(rs.getString("assigned_to"));
    	e2eDashboardResponse.setApplicationFinalStatus(rs.getString("final_status"));
        return e2eDashboardResponse;
    }
}
