/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.BorrowerCategory;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BorrowerCategoryRowMapper implements RowMapper<BorrowerCategory> {

    public BorrowerCategory mapRow(ResultSet rs, int rowNum) throws SQLException {

    	BorrowerCategory cat = new BorrowerCategory();
    	cat.setBorrowerCategoryId(rs.getInt("profession_id"));
    	cat.setBorrowerCategoryName(rs.getString("profession_name"));
      
        return cat;

    }
}
