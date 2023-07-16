/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.HeaderKey;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HeaderKeyRowMapper implements RowMapper<HeaderKey> {

    public HeaderKey mapRow(ResultSet rs, int rowNum) throws SQLException {

    	HeaderKey headerKey = new HeaderKey();
    	headerKey.setHeaderKey(rs.getInt("header_key"));
    	headerKey.setHeaderKeyDescription(rs.getString("header_Description"));
        return headerKey;

    }
}
