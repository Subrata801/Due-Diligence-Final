/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.CoApplicant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CoaApplicantRowMapper implements RowMapper<CoApplicant> {

    public CoApplicant mapRow(ResultSet rs, int rowNum) throws SQLException {

    	CoApplicant coApplicant = new CoApplicant();
//    	coApplicant.setCoapplicantId(rs.getInt("loan_variant_id"));
//    	coApplicant.setCoapplicantName(rs.getString("client_loan_variant_name"));
    	coApplicant.setProfessionId(rs.getInt("profession_id"));
    	coApplicant.setProfessionName(rs.getString("profession_name"));
        return coApplicant;

    }
}
