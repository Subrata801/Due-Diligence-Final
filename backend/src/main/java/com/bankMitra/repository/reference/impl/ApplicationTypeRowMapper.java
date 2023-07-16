/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.ApplicantType;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ApplicationTypeRowMapper implements RowMapper<ApplicantType> {

    public ApplicantType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ApplicantType appType = new ApplicantType();
    	appType.setApplicantTypeId(rs.getInt("applicant_type_id"));
    	appType.setApplicantTypeName(rs.getString("applicant_type"));
      
        return appType;

    }
}
