/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationM5Response;
import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReAssignUserM5RowMapper implements RowMapper<ReassignUserApplicationResponse> {

    public ReassignUserApplicationResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ReassignUserApplicationM5Response userApplicationResponse = new ReassignUserApplicationM5Response();
    	userApplicationResponse.setClientId(rs.getString("client_id"));
    	userApplicationResponse.setClientGroupId(rs.getString("client_group_id"));
    	userApplicationResponse.setNameOfApplicant(rs.getString("loan_applicant_name"));
    	userApplicationResponse.setAppStatus(rs.getString("loan_status"));
    	userApplicationResponse.setAppFinalStatus(rs.getString("loan_status"));
    	userApplicationResponse.setAppStatus(rs.getString("loan_status"));
    	userApplicationResponse.setMaker(rs.getString("maker"));
    	userApplicationResponse.setChecker(rs.getString("checker"));
    	userApplicationResponse.setSanctioningAuth(rs.getString("sanction_authority"));
    	userApplicationResponse.setReasonOfCancellation(rs.getString("cancellation_reason"));
    	userApplicationResponse.setDate(rs.getDate("loan_application_date"));
    	userApplicationResponse.setE2eNum(rs.getString("loan_application_no"));
    	
        return userApplicationResponse;
    }
    }
