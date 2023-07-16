/**
 * 
 */
package com.bankMitra.repository.clientManagement.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.CreateUnitRequest;
import com.bankMitra.model.clientManagement.response.CreateUnitResponse;
import com.bankMitra.repository.admin.rowmapper.SearchUnitRowMapper;
import com.bankMitra.repository.clientManagement.CreateUnitRepository;
import com.bankMitra.repository.clientManagement.rowmapper.CreateUnitRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author bankMitra
 *
 */
@Repository
public class CreateUnitRepositoryImpl implements CreateUnitRepository {

    private static final Logger logger = LoggerFactory.getLogger(CreateUnitRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.CreateUnitRepository#createUnit(com.bankMitra.model.clientManagement.request.CreateUnitRequest)
	 */
	@Override
	public CreateUnitResponse createUnit(CreateUnitRequest createUnitRequest) throws DataAccessException {
		CreateUnitResponse createUnitResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ call bmadmin.funcaddunit(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			cs.setString(1, createUnitRequest.getCreatedBy());
			if(!StringUtils.isEmpty(createUnitRequest.getUnitType()))
				cs.setInt(2, Integer.parseInt(createUnitRequest.getUnitType()));
			else
				cs.setInt(2, -1);
			if(!StringUtils.isEmpty(createUnitRequest.getUnitHO()))
				cs.setInt(3, createUnitRequest.getUnitHO());
			else 
				cs.setInt(3, -1);
			if(!StringUtils.isEmpty(createUnitRequest.getUnitZone()))
				cs.setInt(4, createUnitRequest.getUnitZone());
			else 
				cs.setInt(4, -1);
			if(!StringUtils.isEmpty(createUnitRequest.getUnitCPC()))
				cs.setInt(5, createUnitRequest.getUnitCPC());
			else 
				cs.setInt(5, -1);
			cs.setString(6, createUnitRequest.getUnitName());
			cs.setString(7, createUnitRequest.getIfscCode());
			cs.setString(8, createUnitRequest.getUnitAddress());
			cs.setString(9, createUnitRequest.getCity());
			if(!StringUtils.isEmpty(createUnitRequest.getPincode()))
				cs.setInt(10, Integer.parseInt(createUnitRequest.getPincode()));
			else
				cs.setInt(10,-1);
			cs.setString(11, createUnitRequest.getState());
			cs.setString(12, createUnitRequest.getUnitStatus());
			cs.registerOutParameter(13, Types.VARCHAR);
			cs.executeUpdate();
			functionResult = cs.getString(13);
			logger.info("Function result code returned after execution of function funcaddunit :",functionResult);
			createUnitResponse = new CreateUnitResponse();
			createUnitResponse.setMessageCode(functionResult);
			return createUnitResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcaddunit",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funcaddunit",e);
			throw new DataAccessException(APIConstant.MSG_CREATE_UNIT_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funcaddunit");
			}
		}

	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.CreateUnitRepository#getUnit(com.bankMitra.model.clientManagement.request.CreateUnitRequest)
	 */
	@Override
	public CreateUnitResponse getUnit(CreateUnitRequest createUnitRequest) throws DataAccessException {
		List<CreateUnitResponse> listOfUnitResponse =  null;
		try {
		if(null!=createUnitRequest) {
			if(!StringUtils.isEmpty(createUnitRequest.getClientGroupId())){
				listOfUnitResponse = jdbcTemplate.query(APIConstant.QUERY_GET_UNIT
						,new Object[]{	createUnitRequest.getClientGroupId()}, new CreateUnitRowMapper());
			} 
			if(null!=listOfUnitResponse && !CollectionUtils.isEmpty(listOfUnitResponse)) {
				return listOfUnitResponse.get(0);
			}
		}
		} catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_UNIT_FAILURE,ex);
			throw new DataAccessException(APIConstant.MSG_GET_UNIT_FAILURE);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.clientManagement.CreateUnitRepository#getAllUnits(com.bankMitra.model.clientManagement.request.CreateUnitRequest)
	 */
	@Override
	public List<CreateUnitResponse> getAllUnits(CreateUnitRequest createUnitRequest) throws DataAccessException {
		try {
			if(null!=createUnitRequest && !StringUtils.isEmpty(createUnitRequest.getSearchType())) {
				if(APIConstant.SEARCH_UNITTYPE.equalsIgnoreCase(createUnitRequest.getSearchType())){
					return jdbcTemplate.query(APIConstant.QUERY_GET_UNITS_BY_ALL_CRITERIA + " and   bcgt.client_group_type_id = ?"
							,new Object[]{createUnitRequest.getClientId(),Integer.parseInt(createUnitRequest.getUnitType())}, new SearchUnitRowMapper());
				} else if(APIConstant.SEARCH_UNITNAME.equalsIgnoreCase(createUnitRequest.getSearchType())){
					return jdbcTemplate.query(APIConstant.QUERY_GET_UNITS_BY_ALL_CRITERIA + " and  bcg.client_group_name like '%"+createUnitRequest.getSearchKeyword()+"%'"
							,new Object[]{createUnitRequest.getClientId()},new SearchUnitRowMapper());
				} else if(APIConstant.SEARCH_IFSCCODE.equalsIgnoreCase(createUnitRequest.getSearchType())){
					return jdbcTemplate.query(APIConstant.QUERY_GET_UNITS_BY_ALL_CRITERIA + " and  bcg.ifsc_code like '%"+createUnitRequest.getSearchKeyword()+"%'"
							,new Object[]{createUnitRequest.getClientId()},new SearchUnitRowMapper());
				}  
			}
		} catch (Exception ex) {
			logger.error(APIConstant.MSG_GET_UNITS_FAILURE, ex.getMessage());
			throw new DataAccessException(APIConstant.MSG_GET_UNITS_FAILURE);
		}
		return null;
	}

}
