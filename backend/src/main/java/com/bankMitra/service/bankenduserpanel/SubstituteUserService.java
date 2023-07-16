/**
 * 
 */
package com.bankMitra.service.bankenduserpanel;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.bankenduserpanel.request.SubstituteUserApplicationRequest;
import com.bankMitra.model.bankenduserpanel.response.SubstituteUserApplicationResponse;

/**
 * @author Bank Maitra
 *
 */
public interface SubstituteUserService {

	SubstituteUserApplicationResponse substituteUser(
			@Valid SubstituteUserApplicationRequest substituteUserApplicationRequest) throws APIException;

	List<SubstituteUserApplicationResponse> getAllSubstituteUserList(
			@Valid SubstituteUserApplicationRequest substituteUserApplicationRequest) throws APIException;

}
