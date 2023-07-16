/**
 * 
 */
package com.bankMitra.repository.bankenduserpanel;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2EDetailRequest;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportFooter;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportHeader;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportTable;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDetailResponse;

/**
 * @author Bank Maitra
 *
 */
public interface E2EDashboardRepository {

	List<E2EDashboardResponse> getAllDashboardData(@Valid E2EDashboardRequest e2eDashboardRequest) throws DataAccessException;

	E2EDetailResponse updatee2eDetails(E2EDetailRequest e2eDetailRequest) throws DataAccessException;

	E2EDetailResponse deleteCommercialCreditFacility(E2EDetailRequest e2eDetailRequest) throws DataAccessException;

	E2EDetailResponse getE2EDetails(E2EDetailRequest e2eDetailRequest) throws DataAccessException;

	DashboardBankDetailResponse getDashboardBankDetails(E2EDashboardRequest e2eDashboardRequest) throws DataAccessException;

	E2EFullReportHeader getFullReportHeader(String e2eNum) throws DataAccessException;

	String getLoanVariant(String queryFullReportLoanVariantRetail, String e2eNum) throws DataAccessException;
	
	E2EFullReportFooter getFullReportFooter(String e2eNum) throws DataAccessException;

	List<E2EFullReportTable> getE2EFullReportTableData(String e2eNum, String moduleName) throws DataAccessException;
}
