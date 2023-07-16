package com.bankMitra.repository.admin;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.ClientUploadDueDeligenceRequest;
import com.bankMitra.model.admin.ImportTemplateRequest;
import com.bankMitra.model.admin.LoanSchemeRequest;
import com.bankMitra.model.admin.LoanVariantRequest;
import com.bankMitra.model.admin.RiskRatingRequest;
import com.bankMitra.model.admin.TemplateRequest;
import com.bankMitra.model.admin.response.ClientDueDeligenceDownloadResponse;
import com.bankMitra.model.admin.response.LoanSchemeResponse;
import com.bankMitra.model.admin.response.LoanVariantResponse;
import com.bankMitra.model.admin.response.RiskRatingResponse;
import com.bankMitra.model.admin.response.TemplateResponse;
import com.bankMitra.model.admin.response.TemplateUploadResponse;

/**
 * @author BankMitra
 *
 */
public interface TemplateRepository  {

	TemplateResponse storeTemplate(@Valid TemplateRequest templateRequest)  throws DataAccessException;

	LoanSchemeResponse createLoanSchemeWorkSheet(@Valid LoanSchemeRequest loanSchemeRequest)  throws DataAccessException;

	LoanSchemeResponse createNewLoanScheme(@Valid LoanSchemeRequest loanSchemeRequest) throws DataAccessException;

	LoanVariantResponse createNewLoanVariant(@Valid LoanVariantRequest loanVariantRequest) throws DataAccessException;

	RiskRatingResponse createRiskRatingAndColourCode(@Valid RiskRatingRequest riskRatingRequest)  throws DataAccessException;

	List<LoanSchemeResponse> getListOfLoanSchemes(LoanSchemeRequest loanSchemeRequest) throws DataAccessException;

	List<LoanVariantResponse> getListOfLoanVariants(LoanVariantRequest loanVariantRequest) throws DataAccessException;

	List<RiskRatingResponse> getRiskRatingAndColourCode(RiskRatingRequest riskRatingRequest)  throws DataAccessException;

	List<TemplateUploadResponse> uploadTemplate(@Valid int templateId,
			List<ClientUploadDueDeligenceRequest> clientDueDeligenceRequestList,String userName) throws DataAccessException;

	List<ClientDueDeligenceDownloadResponse> getImportSummary(String outputType, Integer ddId)
			throws DataAccessException;

	List<TemplateResponse> getLanguageTemplate(@Valid TemplateRequest templateRequest, boolean isFileUploadCheck)
			throws DataAccessException;

	List<TemplateUploadResponse> getListOfExistingTemplates(ImportTemplateRequest importTemplateRequest) throws DataAccessException;

}
