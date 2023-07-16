/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.rowmapper;

/**
 * @author BankMitra
 *
 */
import org.springframework.jdbc.core.RowMapper;

import com.bankMitra.model.bankenduserpanel.response.Module;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ModuleRowMaper implements RowMapper<Module> {

    public Module mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Module loanApp = new Module();
    	loanApp.setModuleName(rs.getString("moduleName"));
      
        return loanApp;

    }
}
