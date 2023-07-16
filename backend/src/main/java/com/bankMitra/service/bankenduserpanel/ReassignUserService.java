/**
 * 
 */
package com.bankMitra.service.bankenduserpanel;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
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
public interface ReassignUserService {

	ReassignUserApplicationResponse reassignUser(@Valid ReassignUserApplicationRequest reassignUserApplicationRequest) throws APIException;

	List<ReassignUserApplicationResponse> getAllUserList(
			@Valid ReassignUserApplicationRequest reassignUserApplicationRequest) throws APIException;

	List<Makers> getListOfMakers(String clientGroupId) throws APIException;

	List<Checkers> getListOfCheckers(String clientGroupId) throws APIException;

	List<SanctionAuthority> getListOfSanctioningAuthority(String clientGroupId, String zoClientGroupId,
			String hoClientGroupId, String cpcClientGroupId) throws APIException;
	
	SaveReassignUserResponse saveReassignUser(SaveReassignUserRequest saveReassignUserRequest) throws APIException;

}
