/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.CNCDashboardResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CNCDashboardRowMapper implements RowMapper<CNCDashboardResponse> {

    public CNCDashboardResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	CNCDashboardResponse e2eDashboardResponse = new CNCDashboardResponse();
    	e2eDashboardResponse.setDateField(rs.getDate("loan_application_date"));
    	//e2eDashboardResponse.setBankName(rs.getString("loan_application_no"));
    	e2eDashboardResponse.setBranchName(rs.getString("bank_branch_name"));
    	e2eDashboardResponse.setIfscCode(rs.getString("ifsc_code"));
    	e2eDashboardResponse.setCncNum(rs.getString("cnc_no"));
    	e2eDashboardResponse.setBorrowerName(rs.getString("name_of_the_borrower"));
    	e2eDashboardResponse.setCifNumber(rs.getString("cif_no"));
    	e2eDashboardResponse.setUserName(rs.getString("assigned_to"));
    	//e2eDashboardResponse.setAuditStatus(rs.getString("loan_status"));    	
    	e2eDashboardResponse.setApplicationFinalStatus(rs.getString("loan_status"));
        return e2eDashboardResponse;
    }
}

