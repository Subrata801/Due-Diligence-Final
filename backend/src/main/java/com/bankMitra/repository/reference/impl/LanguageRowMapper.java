/**
 * 
 */
package com.bankMitra.repository.reference.impl;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.reference.Language;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageRowMapper implements RowMapper<Language> {

    public Language mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Language langs = new Language();
    	langs.setLanguageId(rs.getInt("language_id"));
    	langs.setLanguageName(rs.getString("language_name"));
      
        return langs;

    }
}
