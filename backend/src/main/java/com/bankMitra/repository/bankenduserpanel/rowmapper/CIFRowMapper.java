/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.CifRegistrationResponse;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CIFRowMapper implements RowMapper<CifRegistrationResponse> {

    public CifRegistrationResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	CifRegistrationResponse user = new CifRegistrationResponse();
    	user.setCifNum(rs.getString("cif_number"));
    	user.setCustomerName(rs.getString("customer_name"));
        return user;

    }
}
