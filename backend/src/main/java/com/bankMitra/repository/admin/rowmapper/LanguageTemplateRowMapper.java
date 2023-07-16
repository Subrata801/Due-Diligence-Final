/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.TemplateResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LanguageTemplateRowMapper implements RowMapper<TemplateResponse> {

    public TemplateResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

        TemplateResponse languageTempl = new TemplateResponse();
        languageTempl.setTemplateId(rs.getInt("template_id"));
        languageTempl.setImportTemplateName(rs.getString("import_template_name"));
        languageTempl.setClientTypeId(rs.getInt("client_type_id"));
        languageTempl.setCreditScoreTypeId(rs.getInt("credit_sector_type_id"));
        languageTempl.setRiskTypeId(rs.getInt("risk_type_id"));
        languageTempl.setLanguageId(rs.getInt("language_id"));
        languageTempl.setLanguageName(rs.getString("language_name"));
        return languageTempl;

    }
}
