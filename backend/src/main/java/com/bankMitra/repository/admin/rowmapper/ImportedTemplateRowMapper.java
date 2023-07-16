/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.TemplateUploadResponse;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ImportedTemplateRowMapper implements RowMapper<TemplateUploadResponse> {

    public TemplateUploadResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	TemplateUploadResponse languageTempl = new TemplateUploadResponse();
        languageTempl.setDdId(String.valueOf(rs.getInt("dd_id")));
        languageTempl.setNumOfDDaps(rs.getString("total_ddaps"));
        languageTempl.setSuccessCount(String.valueOf(rs.getInt("success")));
        languageTempl.setFailureCount(String.valueOf(rs.getInt("failure")));
        languageTempl.setWorkSheetName(rs.getString("template_name"));
        if(null!=rs.getTimestamp("imported_date")) {
	        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        // you can change format of date
	        Date date = null;
	        String finalStringDate = null;
	        Timestamp ts =  rs.getTimestamp("imported_date");
			 date = new Date(ts.getTime());
			 finalStringDate = formatter.format(date);
	        languageTempl.setImportedDate(finalStringDate);
        } else {
        	 languageTempl.setImportedDate("");
        }
        //languageTempl.setImportedDate(String.valueOf(rs.getTimestamp("imported_date")));
        return languageTempl;

    }
}
