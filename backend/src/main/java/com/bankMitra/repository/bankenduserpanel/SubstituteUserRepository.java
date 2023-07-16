/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.SubstituteUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserApplicationResponse;

/**
 * @author Bank Maitra
 *
 */
public interface SubstituteUserRepository {

	SubstituteUserApplicationResponse substituteUser(
			@Valid SubstituteUserApplicationRequest substituteUserApplicationRequest) throws DataAccessException;

	List<SubstituteUserApplicationResponse> getAllSubstituteUserList(
			SubstituteUserApplicationRequest substituteUserApplicationRequest) throws DataAccessException;

}
