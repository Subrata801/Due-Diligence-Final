/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMaitra
 *
 */
import org.springframework.jdbc.core.RowMapper;
import com.bankMitra.model.bankenduserpanel.response.E2ERealTimeDashboardResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class E2ERealTimeDashboardHeaderRowMapper implements RowMapper<E2ERealTimeDashboardResponse> {

    public E2ERealTimeDashboardResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	E2ERealTimeDashboardResponse headerDetails = new E2ERealTimeDashboardResponse();
    	headerDetails.setZoName(rs.getString("Zo_name"));
    	headerDetails.setCpcName(rs.getString("cpc_name"));
    	headerDetails.setBranchName(rs.getString("branch_name"));
    	headerDetails.setIfscCode(rs.getString("ifsc_code"));
    	
        return headerDetails;
    }
}
