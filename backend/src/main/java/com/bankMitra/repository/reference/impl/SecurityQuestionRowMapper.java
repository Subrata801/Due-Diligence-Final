/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.SecurityQuestions;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SecurityQuestionRowMapper implements RowMapper<SecurityQuestions> {

    public SecurityQuestions mapRow(ResultSet rs, int rowNum) throws SQLException {

    	SecurityQuestions secQuest = new SecurityQuestions();
    	secQuest.setSecurityQuestionId(rs.getInt("security_question_id"));
    	secQuest.setSecurityQuestionName(rs.getString("security_question"));
      
        return secQuest;

    }
}
