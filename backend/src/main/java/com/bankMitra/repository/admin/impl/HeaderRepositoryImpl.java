/**
 * 
 */
package com.bankMitra.repository.admin.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.HeaderRequest;
import com.bankMitra.model.admin.response.HeaderResponse;
import com.bankMitra.repository.admin.HeaderRepository;
import com.bankMitra.repository.admin.rowmapper.HeaderRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author BankMitra
 *
 */
@Repository
public class HeaderRepositoryImpl implements HeaderRepository {

	private static final Logger logger = LoggerFactory.getLogger(HeaderRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.admin.HeaderRepository#updateHeader(com.bankMitra.model.admin.HeaderRequest)
	 */
	@Override
	public HeaderResponse updateHeader(HeaderRequest headerRequest) throws DataAccessException {
		HeaderResponse headerResponse = null;
		String runFunction = null;
		Connection connection = null;
		String functionResult = null;
		CallableStatement cs = null;
		String funcName = "";
		try {
			if(!StringUtils.isEmpty(headerRequest.getHeaderRequestType()) && APIConstant.HEADER_REQUEST_CREATE.equalsIgnoreCase(headerRequest.getHeaderRequestType())){
				runFunction = "{ ? = call bmadmin.funccreateheader(?,?,?) }";
    			funcName = "funccreateheader";
		    } else {
				runFunction = "{ ? = call bmadmin.funcupdateheader(?,?,?) }";
				funcName = "funcupdateheader";
		    }
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, headerRequest.getHeaderKey());
			cs.setString(3, headerRequest.getEnglishDescription());
			cs.setString(4, headerRequest.getNonEnglishDescription());
			cs.executeUpdate();
			functionResult = cs.getString(1);
			logger.info("Output of function ",funcName +":"+functionResult);			
			headerResponse = new HeaderResponse();
			headerResponse.setMessageCode(functionResult);
			return headerResponse;
		} catch (Exception ex) {
			logger.error("Unable to execute function :",funcName,ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (Exception e) {
				logger.error("unable to close the callable statement or connection for function :",funcName,e);
			}
		}
	}

	@Override
	public List<HeaderResponse> getListOfHeaders(String headerKey, String englishDescription, String nonEnglishDescription) throws DataAccessException {
		
		try {
			if(null!=headerKey && !StringUtils.isEmpty(headerKey) 
					&& null!=englishDescription && !StringUtils.isEmpty(englishDescription)
					&& null!=nonEnglishDescription && !StringUtils.isEmpty(nonEnglishDescription)) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_HEADER_KEY_WITHOUT_FILTER 
						+ " where UPPER(header_key) like '%"+headerKey.toUpperCase()+"%' AND UPPER(english_desc) like '%"
						+nonEnglishDescription.toUpperCase()+"%'"
								+"%' AND UPPER(other_desc) like '%"
								+englishDescription.toUpperCase()+"%'",new HeaderRowMapper());
			} else if (null!=headerKey && !StringUtils.isEmpty(headerKey) 
					&& null!=englishDescription && !StringUtils.isEmpty(englishDescription)) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_HEADER_KEY_WITHOUT_FILTER + " where UPPER(header_key) like '%"+headerKey.toUpperCase()+"%' AND UPPER(english_desc) like '%"+englishDescription.toUpperCase()+"%'",new HeaderRowMapper());
			} else if (null!=headerKey && !StringUtils.isEmpty(headerKey) ) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_HEADER_KEY_WITHOUT_FILTER + " where UPPER(header_key) like '%"+headerKey.toUpperCase()+"%'", new HeaderRowMapper());
			} else if (null!=englishDescription && !StringUtils.isEmpty(englishDescription) ) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_HEADER_KEY_WITHOUT_FILTER+ " where UPPER(english_desc) like '%"+englishDescription.toUpperCase()+"%'",new HeaderRowMapper());
			} else if (null!=nonEnglishDescription && !StringUtils.isEmpty(nonEnglishDescription) ) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_HEADER_KEY_WITHOUT_FILTER+ " where UPPER(other_desc) like '%"+nonEnglishDescription.toUpperCase()+"%'",new HeaderRowMapper());
			} else {
				return jdbcTemplate.query(APIConstant.QUERY_GET_HEADER_KEY_WITHOUT_FILTER,new HeaderRowMapper());
			}
			
		} catch (Exception ex) {
			logger.error("Exception while getting header :" + ex.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}

}
