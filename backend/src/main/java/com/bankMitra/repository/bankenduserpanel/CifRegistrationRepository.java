/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel;

import javax.validation.Valid;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest;
import com.bankMitra.model.bankenduserpanel.response.CifRegistrationResponse;

/**
 * @author Bank Maitra
 *
 */
public interface CifRegistrationRepository {

	CifRegistrationResponse registerCIF(@Valid CifRegistrationRequest cifRegistrationRequest)  throws DataAccessException;

}
