/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.SecurityType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SecurityTypeRowMapper implements RowMapper<SecurityType> {

    public SecurityType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	SecurityType secType = new SecurityType();
    	secType.setSecurityTypeId(rs.getInt("security_type_id"));
    	secType.setSecurityTypeName(rs.getString("security_type_name"));
      
        return secType;

    }
}
