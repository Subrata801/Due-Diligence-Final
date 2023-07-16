/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMaitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class E2EBankDetailRowMapper implements RowMapper<DashboardBankDetailResponse> {

    public DashboardBankDetailResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	DashboardBankDetailResponse bankDetails = new DashboardBankDetailResponse();
    	bankDetails.setBranchName(rs.getString("branch_name"));
    	bankDetails.setIfscCode(rs.getString("ifsc_code"));
    	bankDetails.setZoName(rs.getString("Zo_name"));
    	bankDetails.setCpcName(rs.getString("cpc_name"));
    	
        return bankDetails;
    }
}
