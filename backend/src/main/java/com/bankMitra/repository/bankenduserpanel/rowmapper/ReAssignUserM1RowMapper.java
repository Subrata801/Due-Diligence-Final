/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationM1Response;
import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReAssignUserM1RowMapper implements RowMapper<ReassignUserApplicationResponse> {

    public ReassignUserApplicationResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ReassignUserApplicationM1Response userApplicationResponse = new ReassignUserApplicationM1Response();
    	userApplicationResponse.setNameOfApplicant(rs.getString("loan_applicant_name"));
    	userApplicationResponse.setAppStatus(rs.getString("loan_status"));
    	userApplicationResponse.setAppFinalStatus(rs.getString("final_status"));
    	userApplicationResponse.setMaker(rs.getString("unit_maker"));
    	userApplicationResponse.setChecker(rs.getString("unit_checker"));
    	userApplicationResponse.setSanctioningAuth(rs.getString("loan_sanction_authority"));
    	userApplicationResponse.setReasonOfCancellation(rs.getString("initiate_ddp_comments"));
    	userApplicationResponse.setDate(rs.getDate("loan_application_date"));
    	userApplicationResponse.setE2eNum(rs.getString("e2e_no"));
    	
        return userApplicationResponse;
    }
    }
