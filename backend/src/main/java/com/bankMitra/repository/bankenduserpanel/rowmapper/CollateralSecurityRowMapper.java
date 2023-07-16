/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.DueDeligenceCoApplicantResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CollateralSecurityRowMapper implements RowMapper<DueDeligenceCoApplicantResponse> {

    public DueDeligenceCoApplicantResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	DueDeligenceCoApplicantResponse collateralSecurity = new DueDeligenceCoApplicantResponse();
    	collateralSecurity.setSecurityid(rs.getInt("security_id"));
    	collateralSecurity.setSecuritytypeid(rs.getInt("security_type_id"));
      
        return collateralSecurity;

    }
}
