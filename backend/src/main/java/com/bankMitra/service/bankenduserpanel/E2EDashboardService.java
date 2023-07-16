/**
 * 
 */
package com.bankMitra.service.bankenduserpanel;


import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2EDetailRequest;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDetailResponse;


/**
 * @author BankMitra
 *
 */
public interface E2EDashboardService {

	List<E2EDashboardResponse> getAllDashboardData(@Valid E2EDashboardRequest e2eDashboardRequest) throws APIException;

	E2EDetailResponse updatee2eDetails(@Valid E2EDetailRequest e2eDetailRequest)  throws APIException;

	E2EDetailResponse deleteCommercialCreditFacility(@Valid E2EDetailRequest e2eDetailRequest)  throws APIException;

	E2EDetailResponse getE2EDetails(@Valid E2EDetailRequest e2eDetailRequest)  throws APIException;

	DashboardBankDetailResponse getDashboardBankDetails(@Valid E2EDashboardRequest e2eDashboardRequest) throws APIException;

	byte[] getE2EFullReportService (String fileName, String e2eNum, String moduleNume, String clientName) throws APIException;
}