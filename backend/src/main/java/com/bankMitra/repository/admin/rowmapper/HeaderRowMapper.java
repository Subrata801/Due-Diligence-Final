/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.HeaderResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HeaderRowMapper implements RowMapper<HeaderResponse> {

    public HeaderResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	HeaderResponse headerResp = new HeaderResponse();
    	headerResp.setHeaderKey(rs.getString("header_key"));
    	headerResp.setEnglishDescription(rs.getString("english_desc"));
    	headerResp.setNonEnglishDescription(rs.getString("other_desc"));
        return headerResp;

    }
}
