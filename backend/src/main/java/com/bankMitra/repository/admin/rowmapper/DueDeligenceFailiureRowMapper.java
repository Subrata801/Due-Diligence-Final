/**
 * 
 */
package com.bankMitra.repository.admin.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.admin.response.ClientDueDeligenceDownloadResponse;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DueDeligenceFailiureRowMapper implements RowMapper<ClientDueDeligenceDownloadResponse> {

    public ClientDueDeligenceDownloadResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

    	ClientDueDeligenceDownloadResponse downloadResponse = new ClientDueDeligenceDownloadResponse();
    	
    	downloadResponse.setDdId(rs.getInt("dd_id"));
    	downloadResponse.setModule(rs.getString("module"));
    	downloadResponse.setTemplateName(rs.getString("template_name"));
    	downloadResponse.setWorksheetName(rs.getString("worksheet_name"));
    	downloadResponse.setHeader1(rs.getString("header1"));
    	downloadResponse.setHeader2(rs.getString("header2"));
    	downloadResponse.setHeader3(rs.getString("header3"));
    	downloadResponse.setHeader4(rs.getString("header4"));
    	downloadResponse.setDdSequence(rs.getInt("dd_seq"));
    	downloadResponse.setDdParentSequence(rs.getInt("dd_parent_seq"));
    	downloadResponse.setRemarks(rs.getString("remarks"));
        return downloadResponse;

    }
}
