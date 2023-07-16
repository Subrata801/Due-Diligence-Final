/**
 * 
 */
package com.bankMitra.service.admin.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
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
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.admin.HeaderRepository;
import com.bankMitra.repository.admin.TemplateRepository;
import com.bankMitra.service.admin.TemplateService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BankMitra
 *
 */
@Service
@Slf4j
public class TemplateServiceImpl implements TemplateService {
	
	@Autowired
	TemplateRepository templateRepo;
	
	@Autowired
	HeaderRepository headerRepo;
	
	@Autowired
	ReferenceService refService;

	

	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.TemplateService#storeTemplate(com.bankMitra.model.template.TemplateRequest)
	 */
	@Override
	@Transactional
	public TemplateResponse storeTemplate(@Valid TemplateRequest templateRequest) throws APIException {
		MessageCode msgOutput = null;
		TemplateResponse templateResponse = null;
		try {
			templateResponse =  templateRepo.storeTemplate(templateRequest);
			final String dbResponseCode = templateResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				templateResponse.setMessageCode(filteredMsgData.getMessageCode());
				templateResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATETEMPLATE_FAILURE);
		}
		return templateResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.TemplateService#createLoanSchemeWorkSheet(com.bankMitra.model.template.LoanSchemeRequest)
	 */
	@Override
	@Transactional
	public LoanSchemeResponse createLoanSchemeWorkSheet(@Valid LoanSchemeRequest loanSchemeRequest) throws APIException {
		MessageCode msgOutput = null;
		LoanSchemeResponse loanSchemeResponse = null;
		try {
			loanSchemeResponse =  templateRepo.createLoanSchemeWorkSheet(loanSchemeRequest);
			final String dbResponseCode = loanSchemeResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				loanSchemeResponse.setMessageCode(filteredMsgData.getMessageCode());
				loanSchemeResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_CREATE_LOANSCHEME_WORKSHEET_FAILURE,e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_CREATE_LOANSCHEME_WORKSHEET_FAILURE,e.getMessage());
		}
		return loanSchemeResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.TemplateService#createNewLoanScheme(com.bankMitra.model.template.LoanSchemeRequest)
	 */
	@Override
	@Transactional
	public LoanSchemeResponse createNewLoanScheme(@Valid LoanSchemeRequest loanSchemeRequest) throws APIException {
		LoanSchemeResponse loanSchemeResponse = null;
		Map<String,String> loanSchemeMessageResponse = null;
		try {
			loanSchemeResponse =  templateRepo.createNewLoanScheme(loanSchemeRequest);
			loanSchemeMessageResponse = new HashMap<String,String>();
			for (Map.Entry<String,String> entry : loanSchemeResponse.getLoanSchemeGenerationResponse().entrySet())  {
	            MessageCode filteredMsgData = getMessageDescription(entry.getValue());
				if(null!=filteredMsgData){
					loanSchemeMessageResponse.put(entry.getKey(), filteredMsgData.getMessageDescription());
				}
			}
			if(loanSchemeResponse.getLoanSchemeGenerationResponse().size()==0)
				loanSchemeResponse.setMessageCode(APIConstant.SUCCESS_CODE);
			loanSchemeResponse.setLoanSchemeGenerationResponse(loanSchemeMessageResponse);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_LOAN_SCHEME_FAILURE);
		}
		return loanSchemeResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.TemplateService#createNewLoanVariant(com.bankMitra.model.template.LoanVariantRequest)
	 */
	@Override
	@Transactional
	public LoanVariantResponse createNewLoanVariant(@Valid LoanVariantRequest loanVariantRequest) throws APIException {
		MessageCode msgOutput = null;
		LoanVariantResponse loanVariantResponse = null;
		Map<String,String> loanVariantMessageResponse = null;
		try {
			loanVariantResponse =  templateRepo.createNewLoanVariant(loanVariantRequest);
			loanVariantMessageResponse = new HashMap<String,String>();
			for (Map.Entry<String,String> entry : loanVariantResponse.getLoanVariantGenerationResponse().entrySet())  {
				MessageCode filteredMsgData = getMessageDescription(entry.getValue());
				if(null!=filteredMsgData){
					loanVariantMessageResponse.put(entry.getKey(), filteredMsgData.getMessageDescription());
				}
			}
			if(loanVariantResponse.getLoanVariantGenerationResponse().size()==0)
				loanVariantResponse.setMessageCode(APIConstant.SUCCESS_CODE);
			loanVariantResponse.setLoanVariantGenerationResponse(loanVariantMessageResponse);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_CREATE_LOAN_VARIANT_FAILURE);
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_LOAN_VARIANT_FAILURE);
		}
		return loanVariantResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.TemplateService#createRiskRatingAndColourCode(com.bankMitra.model.template.RiskRatingRequest)
	 */
	@Override
	@Transactional
	public RiskRatingResponse createRiskRatingAndColourCode(@Valid RiskRatingRequest riskRatingRequest) throws APIException {
		MessageCode msgOutput = null;
		RiskRatingResponse riskRatingResponse = null;
		try {
			riskRatingResponse =  templateRepo.createRiskRatingAndColourCode(riskRatingRequest);
			final String dbResponseCode = riskRatingResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				riskRatingResponse.setMessageCode(filteredMsgData.getMessageCode());
				riskRatingResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_CREATE_RISKRATING_FAILURE,e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_CREATE_RISKRATING_FAILURE,e.getMessage());
		}
		return riskRatingResponse;
	}
	
	private MessageCode getMessageDescription(String dbResponseCode) throws ResourceNotFoundException {
		MessageCode msgOutPut = null;
		List<MessageCode> msgCodes = refService.getListOfMessageCode();
		for(MessageCode msg : msgCodes) {
			if(msg.getMessageCode().equalsIgnoreCase(dbResponseCode)) {
				msgOutPut =  msg;
				break;
			}
		}
		return msgOutPut;
	}

	@Override
	@Transactional
	public HeaderResponse updateHeader(HeaderRequest headerRequest) throws APIException {
		HeaderResponse headerResponse = null;
		try {
			headerResponse =  headerRepo.updateHeader(headerRequest);
			final String dbResponseCode = headerResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				headerResponse.setMessageCode(filteredMsgData.getMessageCode());
				headerResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_UPDATE_HEADER_FAILURE);
		}
		return headerResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public List<HeaderResponse> getListOfHeader(String headerKey, String englishDescription,String nonEnglishDescription) throws APIException {
		List<HeaderResponse> listOfHeaders = null;
		try {
			listOfHeaders = headerRepo.getListOfHeaders(headerKey,englishDescription,nonEnglishDescription);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_HEADER_FAILURE);
		}
		return listOfHeaders;
	}

	@Override
	@Transactional(readOnly=true)
	public List<TemplateResponse> getLanguageTemplate(@Valid TemplateRequest templateRequest) throws APIException {
		List<TemplateResponse> templateResponse = null;
		try {
			templateResponse = templateRepo.getLanguageTemplate(templateRequest,false);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_LANGUAGE_TEMPLATE_FAILURE);
		}
		return templateResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public List<LoanSchemeResponse> getListOfLoanSchemes(LoanSchemeRequest loanSchemeRequest) throws APIException {
		List<LoanSchemeResponse> listOfLoanSchemes = null;
		try {
			listOfLoanSchemes = templateRepo.getListOfLoanSchemes(loanSchemeRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_LOAN_SCHEMES_FAILURE);
		}
		return listOfLoanSchemes;
	}

	@Override
	@Transactional(readOnly=true)
	public List<LoanVariantResponse> getListOfLoanVariants(LoanVariantRequest loanVariantRequest) throws APIException {
		List<LoanVariantResponse> listOfLoanVariants = null;
		try {
			listOfLoanVariants = templateRepo.getListOfLoanVariants(loanVariantRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_LOAN_SCHEMES_FAILURE);
		}
		return listOfLoanVariants;
	}

	@Override
	public TemplateResponse generateTemplateName(TemplateRequest templateRequest) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RiskRatingResponse> getRiskRatingAndColourCode(RiskRatingRequest riskRatingRequest) throws APIException {
		List<RiskRatingResponse> riskRatingResponseList = null;
		try {
			riskRatingResponseList = templateRepo.getRiskRatingAndColourCode(riskRatingRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_RISKRATING_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_RISKRATING_FAILURE,e.getMessage());
		}
		return riskRatingResponseList;
	}

}
