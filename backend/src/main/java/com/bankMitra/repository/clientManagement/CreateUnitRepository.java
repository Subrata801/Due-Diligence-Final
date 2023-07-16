/**
 * 
 */
package com.bankMitra.repository.clientManagement;

import java.util.List;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.CreateUnitRequest;
import com.bankMitra.model.clientManagement.response.CreateUnitResponse;

/**
 * @author bankMitra
 *
 */
public interface CreateUnitRepository {

	CreateUnitResponse createUnit(CreateUnitRequest createUnitRequest) throws DataAccessException;

	CreateUnitResponse getUnit(CreateUnitRequest createUnitRequest) throws DataAccessException;
	
	List<CreateUnitResponse> getAllUnits(CreateUnitRequest createUnitRequest) throws DataAccessException;
}
