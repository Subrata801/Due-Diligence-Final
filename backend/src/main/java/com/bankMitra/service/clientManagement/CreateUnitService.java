/**
 * 
 */
package com.bankMitra.service.clientManagement;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.clientManagement.request.CreateUnitRequest;
import com.bankMitra.model.clientManagement.response.CreateUnitResponse;


/**
 * @author BankMitra
 *
 */
public interface CreateUnitService {

	CreateUnitResponse createUnit(@Valid CreateUnitRequest createUnitRequest) throws APIException;

	CreateUnitResponse getClientUnit(@Valid CreateUnitRequest createUnitRequest) throws APIException;

	List<CreateUnitResponse> getAllClientUnit(@Valid CreateUnitRequest createUnitRequest) throws APIException;
	
}