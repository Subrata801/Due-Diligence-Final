/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.ReassignUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.request.SaveReassignUserRequest;
import com.bankMitra.model.bankenduserpanel.response.Checkers;
import com.bankMitra.model.bankenduserpanel.response.Makers;
import com.bankMitra.model.bankenduserpanel.response.ReassignUserApplicationResponse;
import com.bankMitra.model.bankenduserpanel.response.SanctionAuthority;
import com.bankMitra.model.bankenduserpanel.response.SaveReassignUserResponse;

/**
 * @author Bank Maitra
 *
 */
public interface ReassignUserRepository {

	ReassignUserApplicationResponse reassignUser(@Valid ReassignUserApplicationRequest reassignUserApplicationRequest) throws DataAccessException;

	List<ReassignUserApplicationResponse> getAllUserList(ReassignUserApplicationRequest reassignUserApplicationRequest) throws DataAccessException;

	List<Makers> getListOfMakers(String clientGroupId) throws DataAccessException;

	List<Checkers> getListOfCheckers(String clientGroupId) throws DataAccessException;

	List<SanctionAuthority> getListOfSanctioningAuthority(String clientGroupIdString, String zo_client_group_id,
			String cpc_client_group_id, String ho_client_group_id) throws DataAccessException;
	SaveReassignUserResponse saveReassignUserDB(SaveReassignUserRequest saveReassignUserRequest) throws DataAccessException;
}
