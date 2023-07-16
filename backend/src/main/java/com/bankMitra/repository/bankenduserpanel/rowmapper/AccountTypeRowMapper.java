/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.AccountType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountTypeRowMapper implements RowMapper<AccountType> {

    public AccountType mapRow(ResultSet rs, int rowNum) throws SQLException {

    	AccountType acType = new AccountType();
    	acType.setAccountTypeId(rs.getInt("account_type_id"));
    	acType.setAccountTypeName(rs.getString("account_type_name"));
      
        return acType;

    }
}
