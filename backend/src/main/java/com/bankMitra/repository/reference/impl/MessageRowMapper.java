/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.MessageCode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MessageRowMapper implements RowMapper<MessageCode> {

    public MessageCode mapRow(ResultSet rs, int rowNum) throws SQLException {

    	MessageCode msgCode = new MessageCode();
    	msgCode.setMessageCode(rs.getString("return_code"));
    	msgCode.setMessageDescription(rs.getString("message"));
      
        return msgCode;

    }
}
