/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel.impl;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.SubstituteUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserApplicationResponse;
import com.bankMitra.repository.bankenduserpanel.SubstituteUserRepository;

/**
 * @author Bank Maitra
 *
 */
@Repository
public class SubstituteUserRepositoryImpl implements SubstituteUserRepository {

    private static final Logger logger = LoggerFactory.getLogger(SubstituteUserRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.bankenduserpanel.SubstituteUserRepository#substituteUser(com.bankMitra.model.bankenduserpanel.request.SubstituteUserApplicationRequest)
	 */
	@Override
	public SubstituteUserApplicationResponse substituteUser(
			@Valid SubstituteUserApplicationRequest substituteUserApplicationRequest) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubstituteUserApplicationResponse> getAllSubstituteUserList(
			SubstituteUserApplicationRequest substituteUserApplicationRequest) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
