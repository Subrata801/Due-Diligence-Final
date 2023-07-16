/**
 * 
 */
package com.bankMitra.service.bankenduserpanel;


import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.bankenduserpanel.request.CifRegistrationRequest;
import com.bankMitra.model.bankenduserpanel.response.CifRegistrationResponse;


/**
 * @author BankMitra
 *
 */
public interface CifRegistrationService {

	CifRegistrationResponse register(@Valid CifRegistrationRequest cifRegistrationRequest) throws APIException;

}