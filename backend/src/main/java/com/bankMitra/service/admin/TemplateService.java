/**
 * 
 */
package com.bankMitra.service.admin;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.admin.HeaderRequest;
import com.bankMitra.model.admin.LoanSchemeRequest;
import com.bankMitra.model.admin.LoanVariantRequest;
import com.bankMitra.model.admin.RiskRatingRequest;
import com.bankMitra.model.admin.TemplateRequest;
import com.bankMitra.model.admin.response.HeaderResponse;
import com.bankMitra.model.admin.response.LoanSchemeResponse;
import com.bankMitra.model.admin.response.LoanVariantResponse;
import com.bankMitra.model.admin.response.RiskRatingResponse;
import com.bankMitra.model.admin.response.TemplateResponse;

/**
 * @author BankMitra
 *
 */
public interface TemplateService {

	TemplateResponse generateTemplateName(@Valid TemplateRequest templateRequest) throws APIException;

	TemplateResponse storeTemplate(@Valid TemplateRequest templateRequest)  throws APIException;

	LoanSchemeResponse createLoanSchemeWorkSheet(@Valid LoanSchemeRequest loanSchemeRequest) throws APIException;

	LoanSchemeResponse createNewLoanScheme(@Valid LoanSchemeRequest loanSchemeRequest) throws APIException;

	LoanVariantResponse createNewLoanVariant(@Valid LoanVariantRequest loanVariantRequest) throws APIException;

	RiskRatingResponse createRiskRatingAndColourCode(@Valid RiskRatingRequest riskRatingRequest)  throws APIException;

	HeaderResponse updateHeader(@Valid HeaderRequest headerRequest)  throws APIException;

	List<TemplateResponse> getLanguageTemplate(@Valid TemplateRequest templateRequest)  throws APIException;

	List<LoanSchemeResponse> getListOfLoanSchemes(@Valid LoanSchemeRequest headerRequest) throws APIException;

	List<LoanVariantResponse> getListOfLoanVariants(@Valid LoanVariantRequest loanVariantRequest)  throws APIException;

	List<HeaderResponse> getListOfHeader(String headerKey, String englishDescription, String nonEnglishDescription) throws APIException;

	List<RiskRatingResponse> getRiskRatingAndColourCode(@Valid RiskRatingRequest riskRatingRequest) throws APIException;
	
}
