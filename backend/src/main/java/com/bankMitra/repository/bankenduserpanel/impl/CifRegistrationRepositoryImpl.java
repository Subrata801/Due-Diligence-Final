/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest;
import com.bankMitra.model.bankenduserpanel.response.CifRegistrationResponse;
import com.bankMitra.repository.bankenduserpanel.CifRegistrationRepository;
import com.bankMitra.util.APIConstant;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class CifRegistrationRepositoryImpl implements CifRegistrationRepository {

    private static final Logger logger = LoggerFactory.getLogger(CifRegistrationRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.bankenduserpanel.CifRegistrationRepository#registerCIF(com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest)
	 */
	@Override
	public CifRegistrationResponse registerCIF(@Valid CifRegistrationRequest cifRegistrationRequest)
			throws DataAccessException {
		CifRegistrationResponse cifRegistrationResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ call bmadmin.funcaddcifnumber(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			cs.setString(1, cifRegistrationRequest.getCreatedBy());
			cs.setString(2, cifRegistrationRequest.getCifNum());
			if(!StringUtils.isEmpty(cifRegistrationRequest.getCustomerName()))
				cs.setString(3, cifRegistrationRequest.getCustomerName());
			else 
				cs.setString(3, "");
			cs.registerOutParameter(4, Types.VARCHAR);
			cs.executeUpdate();
			functionResult = cs.getString(4);
			logger.info("Function result code returned after execution of function funcaddcifnumber :",functionResult);
			cifRegistrationResponse = new CifRegistrationResponse();
			cifRegistrationResponse.setMessageCode(functionResult);
			return cifRegistrationResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcaddcifnumber",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funcaddcifnumber",e);
			throw new DataAccessException(APIConstant.MSG_REGISTER_CIF_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funcaddcifnumber");
			}
		}

	}

}
