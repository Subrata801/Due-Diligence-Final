/**
 * 
 */
package com.bankMitra.repository.admin.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.postgresql.util.PGobject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.ClientDueDeligenceArray;
import com.bankMitra.model.admin.ClientUploadDueDeligenceRequest;
import com.bankMitra.model.admin.ImportTemplateRequest;
import com.bankMitra.model.admin.LoanSchemeDetails;
import com.bankMitra.model.admin.LoanSchemeRequest;
import com.bankMitra.model.admin.LoanVariantDetails;
import com.bankMitra.model.admin.LoanVariantRequest;
import com.bankMitra.model.admin.RiskRatingRequest;
import com.bankMitra.model.admin.RiskScore;
import com.bankMitra.model.admin.TemplateRequest;
import com.bankMitra.model.admin.response.ClientConfigResponse;
import com.bankMitra.model.admin.response.ClientDueDeligenceDownloadResponse;
import com.bankMitra.model.admin.response.LoanSchemeResponse;
import com.bankMitra.model.admin.response.LoanVariantResponse;
import com.bankMitra.model.admin.response.RiskRatingResponse;
import com.bankMitra.model.admin.response.TemplateResponse;
import com.bankMitra.model.admin.response.TemplateUploadResponse;
import com.bankMitra.repository.admin.TemplateRepository;
import com.bankMitra.repository.admin.rowmapper.DueDeligenceFailiureRowMapper;
import com.bankMitra.repository.admin.rowmapper.DueDeligenceSuccessRowMapper;
import com.bankMitra.repository.admin.rowmapper.ExistingLoanSchemeRowMapper;
import com.bankMitra.repository.admin.rowmapper.ExistingLoanSchemeWithoutTemplateRowMapper;
import com.bankMitra.repository.admin.rowmapper.ExistingLoanVariantRowMapper;
import com.bankMitra.repository.admin.rowmapper.ImportedTemplateRowMapper;
import com.bankMitra.repository.admin.rowmapper.LanguageTemplateRowMapper;
import com.bankMitra.repository.admin.rowmapper.RiskRatingResponseRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author BankMitra
 *
 */
@Repository
public class TemplateRepositoryImpl implements TemplateRepository {
	
	private static final Logger logger = LoggerFactory.getLogger(TemplateRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.admin.TemplateRepository#generateTemplateName(com.bankMitra.model.template.TemplateRequest)
	 */
	@Override
	public List<TemplateResponse> getLanguageTemplate(@Valid TemplateRequest templateRequest,boolean isFileUploadCheck) throws DataAccessException {
		try {
			if(!isFileUploadCheck)
				return jdbcTemplate.query(APIConstant.QUERY_GET_TEMPLATE_NAME,
						new Object[]{templateRequest.getClientTypeId(),
								templateRequest.getRiskTypeId(),templateRequest.getCreditSectorId()}, new LanguageTemplateRowMapper());
			else 
				return jdbcTemplate.query(APIConstant.QUERY_GET_ACTUAL_TEMPLATE_NAME,
						new Object[]{templateRequest.getClientTypeId(),templateRequest.getCreditSectorId(),templateRequest.getImportTemplateName()}, new LanguageTemplateRowMapper());
		} catch (Exception ex) {
			logger.error("Unable to get language template",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.admin.TemplateRepository#storeTemplate(com.bankMitra.model.template.TemplateRequest)
	 */
	@Override
	public TemplateResponse storeTemplate(@Valid TemplateRequest templateRequest) throws DataAccessException {
		TemplateResponse templateResponse = null;
		try {
			final SimpleJdbcCall createTemplateCall = 
					new SimpleJdbcCall(jdbcTemplate).withFunctionName("FuncGenerateLanguageTemplateWB");
			final Map<String, Object> params = new HashMap<>();
			params.put("ip_client_type_id", templateRequest.getClientTypeId());
			params.put("ip_credit_score_type_id", templateRequest.getCreditSectorId());
			params.put("ip_risk_type_id", templateRequest.getRiskTypeId());
			params.put("ip_language_id", templateRequest.getLanguageId());
			params.put("ip_create_by",templateRequest.getCreatedBy());
			params.put("ip_created_date",templateRequest.getCreatedDate());
			params.put("ip_updated_by",templateRequest.getUpdatedBy());
			params.put("ip_updated_date",templateRequest.getUpdatedDate());
			params.put("ip_import_temp_name",templateRequest.getImportTemplateName());
			params.put("ip_inc_import_temp_name",templateRequest.getIncrementImportTemplateName());
			
			final Map<String, Object> result = createTemplateCall.execute(params);
			System.out.println(result.get("op_return_code"));
			if(!StringUtils.isEmpty(String.valueOf(result.get("op_return_code")))) {
				templateResponse = new TemplateResponse();
				templateResponse.setMessageCode(String.valueOf(result.get("op_return_code")));
				return templateResponse;
			} else {
				logger.error("Unable to execute the function :FuncGenerateLanguageTemplateWB as there is no output of function");
				throw new DataAccessException(APIConstant.ERROR_CODE_CREATE_TEMPLATE);
			}
		} catch (Exception ex) {
			logger.error("Unable to execute the function :FuncGenerateLanguageTemplateWB",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.admin.TemplateRepository#createLoanSchemeWorkSheet(com.bankMitra.model.template.LoanSchemeRequest)
	 */
	@Override
	public LoanSchemeResponse createLoanSchemeWorkSheet(@Valid LoanSchemeRequest loanSchemeRequest) throws DataAccessException {
		LoanSchemeResponse loanSchemeResponse = null;
		try {
			final SimpleJdbcCall createLoanSchemeWorkSheetCall = 
					new SimpleJdbcCall(jdbcTemplate).withFunctionName("FuncGenerateLoanShemeWS");
			final Map<String, Object> params = new HashMap<>();
			params.put("ip_client_type_id", loanSchemeRequest.getClientTypeId());
			params.put("ip_credit_score_type_id", loanSchemeRequest.getCreditScoreTypeId());
			params.put("ip_risk_type_id", loanSchemeRequest.getRiskTypeId());
			params.put("ip_template_id", loanSchemeRequest.getRiskTypeId());
			params.put("ip_loanscheme_id", loanSchemeRequest.getLoanSchemeId());
			final Map<String, Object> result = createLoanSchemeWorkSheetCall.execute(params);
			logger.info("Output of function FuncGenerateLoanShemeWS :",result.get("op_return_code"));
			if(!StringUtils.isEmpty(String.valueOf(result.get("op_return_code")))) {
				loanSchemeResponse = new LoanSchemeResponse();
				loanSchemeResponse.setMessageCode(String.valueOf(result.get("op_return_code")));
				loanSchemeResponse.setWorksheetName(String.valueOf(result.get("op_import_temp_name")));
				return loanSchemeResponse;
			} else {
				throw new DataAccessException(APIConstant.ERROR_CODE_CREATE_LOANSCHEME_WS_NAME);
			}
		} catch (Exception ex) {
			logger.error("Unable to execute the function :FuncGenerateLoanShemeWS",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_CREATE_LOANSCHEME_WS_NAME);
		}
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.admin.TemplateRepository#createNewLoanScheme(com.bankMitra.model.template.LoanSchemeRequest)
	 */
	@Override
	public LoanSchemeResponse createNewLoanScheme(@Valid LoanSchemeRequest loanSchemeRequest) throws DataAccessException {
		LoanSchemeResponse loanSchemeResponse = null;
		Map<String,String> dbResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ ? = call bmadmin.funccreateloanscheme(?,?,?,?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			
			//cs.registerOutParameter(1, Types.VARCHAR);
			dbResponse = new HashMap<String,String>();
			for(LoanSchemeDetails loanDetails : loanSchemeRequest.getLoanSchemeDetails()) {
				cs = connection.prepareCall(runFunction);
				cs.registerOutParameter(1, Types.VARCHAR);
				
				cs.setInt(2, loanDetails.getLoanSchemeId());
				cs.setString(3, loanDetails.getLoanSchemeName());
				cs.setString(4, loanDetails.getKeyword());
				cs.setInt(5, loanSchemeRequest.getTemplateId());
				cs.setInt(6, loanSchemeRequest.getClientTypeId());
				cs.setInt(7, loanSchemeRequest.getCreditScoreTypeId());
				cs.setInt(8, loanSchemeRequest.getRiskTypeId());
				cs.setString(9, loanSchemeRequest.getCreatedBy());
				cs.executeUpdate();
				functionResult = cs.getString(1);
				logger.info("Output of function :funccreateloanscheme :",functionResult);
				if(!StringUtils.isEmpty(functionResult) && !APIConstant.SUCCESS_CODE.equalsIgnoreCase(functionResult)) {
					dbResponse.put(loanDetails.getLoanSchemeName(), functionResult);
				} 
			}
			loanSchemeResponse = new LoanSchemeResponse();
			loanSchemeResponse.setClientTypeId(loanSchemeRequest.getClientTypeId());
			loanSchemeResponse.setCreditScoreTypeId(loanSchemeRequest.getCreditScoreTypeId());
			loanSchemeResponse.setRiskTypeId(loanSchemeRequest.getRiskTypeId());
			loanSchemeResponse.setTemplateId(loanSchemeRequest.getTemplateId());
			loanSchemeResponse.setLoanSchemeGenerationResponse(dbResponse);
		} catch (Exception e) {
			logger.error("unable to execute the function funccreateloanscheme",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection",e);
			}
			
		}
		
		return loanSchemeResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.admin.TemplateRepository#createNewLoanVariant(com.bankMitra.model.template.LoanVariantRequest)
	 */
	@Override
	public LoanVariantResponse createNewLoanVariant(@Valid LoanVariantRequest loanVariantRequest) throws DataAccessException {
		LoanVariantResponse loanVariantResponse = null;
		Map<String,String> dbResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ ? = call bmadmin.funccreateloanvariant(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			for(LoanVariantDetails loanVariantDetails : loanVariantRequest.getLoanVariantDetails()) {
				dbResponse = new HashMap<String,String>();
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setInt(2, loanVariantRequest.getLoanSchemeId());
				cs.setString(3, loanVariantDetails.getLoanVariantName());
				cs.setString(4, loanVariantDetails.getKeyword());
				cs.setString(5,loanVariantRequest.getCreatedBy());
			
				cs.executeUpdate();
				functionResult = cs.getString(1);
				logger.info("Output of function :funccreateloanvariant :",functionResult);
				if(!StringUtils.isEmpty(functionResult) && !APIConstant.SUCCESS_CODE.equalsIgnoreCase(functionResult)) {
					dbResponse.put(loanVariantDetails.getLoanVariantName(), functionResult);
				} 
			}
			loanVariantResponse = new LoanVariantResponse();
			loanVariantResponse.setLoanVariantGenerationResponse(dbResponse);
			loanVariantResponse.setLoanSchemeId(loanVariantRequest.getLoanSchemeId());
		} catch (Exception e) {
			logger.error("unable to execute the function funccreateloanvariant :",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection",e);
			}
			
		}
		
		return loanVariantResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.admin.TemplateRepository#createRiskRatingAndColourCode(com.bankMitra.model.template.RiskRatingRequest)
	 */
	@Override
	public RiskRatingResponse createRiskRatingAndColourCode(@Valid RiskRatingRequest riskRatingRequest) throws DataAccessException {
		RiskRatingResponse riskRatingResponse = null;
		Connection connection = null;
		RiskRatingResponse resp = null;
		CallableStatement cs = null;
		String functionResult = null; 
		try {
			String runFunction = "{ call bmadmin.funcdefineriskrating(?,?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			cs.setString(1, riskRatingRequest.getCreatedBy());
			cs.setInt(2, riskRatingRequest.getClientTypeId());
			cs.setInt(3, riskRatingRequest.getClientId());
			cs.setInt(4, riskRatingRequest.getClientGroupId());
			int i =0;
			String[] arrRiskScore =  new String[riskRatingRequest.getRiskScoreList().size()];
			for(RiskScore arr: riskRatingRequest.getRiskScoreList()) {
				if(null!=arr.getResponseId() && !StringUtils.isEmpty(arr.getResponseId())){
					String inputData = "("+arr.getResponseId()+","
			        		+arr.getGeneralScore()+","
							+arr.getApplicantScore()+","
							+arr.getCoApplicantScore()+","
							+arr.getGuarantorScore()+")";
					arrRiskScore[i] = inputData;
					i++;
				}
			}
			cs.setArray(5, connection.createArrayOf(  
				      "bmadmin.obj_define_risk_score",arrRiskScore));
			
			cs.registerOutParameter(6, Types.VARCHAR);
			cs.executeUpdate();
			functionResult = cs.getString(6);
			logger.info("Function result code returned after execution of function funcdefineriskrating:",functionResult);
			riskRatingResponse = new RiskRatingResponse();
			riskRatingResponse.setMessageCode(functionResult);
			
			return riskRatingResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcdefineriskrating",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funcdefineriskrating",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_CREATE_RISKRATING);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funcdefineriskrating");
			}
		}

	}

	@Override
	public List<LoanSchemeResponse> getListOfLoanSchemes(LoanSchemeRequest loanSchemeRequest)
			throws DataAccessException {
		try {
			if(null!=loanSchemeRequest && !StringUtils.isEmpty(loanSchemeRequest.getTemplateId()))
				return jdbcTemplate.query(APIConstant.QUERY_GET_AVAILABLE_LOAN_SCHEMES,
					new Object[]{loanSchemeRequest.getTemplateId()}, new ExistingLoanSchemeRowMapper());
			else 
				return jdbcTemplate.query(
						APIConstant.QUERY_GET_AVAILABLE_LOAN_SCHEMES_WITHOUT_CRITERIA,new ExistingLoanSchemeWithoutTemplateRowMapper());
		} catch (Exception ex) {
			logger.error("unable to execute query for getListOfLoanSchemes :",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}

	@Override
	public List<LoanVariantResponse> getListOfLoanVariants(LoanVariantRequest loanVariantRequest) throws DataAccessException {
		try {
			if(null!=loanVariantRequest && !StringUtils.isEmpty(loanVariantRequest.getLoanSchemeId()))
				return jdbcTemplate.query(APIConstant.QUERY_GET_AVAILABLE_LOAN_VARIANTS,
					new Object[]{loanVariantRequest.getLoanSchemeId()},new ExistingLoanVariantRowMapper());
			else 
				return new ArrayList<LoanVariantResponse>();
		} catch (Exception ex) {
			logger.error("unable to execute query for getListOfLoanVariants :",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}

	@Override
	public List<RiskRatingResponse> getRiskRatingAndColourCode(RiskRatingRequest riskRatingRequest)
			throws DataAccessException {
		try {
			if(null!=riskRatingRequest.getClientTypeId() && 2 == riskRatingRequest.getClientTypeId()) {
				return jdbcTemplate.query(
							APIConstant.QUERY_GET_RISK_RATING_SCORE,new Object[]{riskRatingRequest.getClientId()},new RiskRatingResponseRowMapper());
			} else if(null!=riskRatingRequest.getClientTypeId() && 3 == riskRatingRequest.getClientTypeId()) {
				return jdbcTemplate.query(
						APIConstant.QUERY_GET_RISK_RATING_SCORE_AUDIT_FIRM,new Object[]{riskRatingRequest.getClientId(),riskRatingRequest.getFirmId()},new RiskRatingResponseRowMapper());
			}
		} catch (Exception ex) {
			logger.error("unable to execute query for getRiskRatingAndColourCode :",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_GET_RISK_SCORE);
		}
		return null;
	}

	@Override
	public List<TemplateUploadResponse> uploadTemplate(int templateId,
			List<ClientUploadDueDeligenceRequest> clientDueDeligenceRequest,String userName) throws DataAccessException {
		List<TemplateUploadResponse> uploadResponseList = new ArrayList<TemplateUploadResponse>();
		Connection connection = null;
		TemplateUploadResponse resp = null;
		CallableStatement cs = null;
		try {
			String runFunction = "{ ? = call bmadmin.funcimporttemplate(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.OTHER);
			for(ClientUploadDueDeligenceRequest req : clientDueDeligenceRequest) {
				resp = new TemplateUploadResponse();
				cs.setString(2, userName);
				cs.setInt(3, templateId);
				cs.setString(4, req.getLoanSchemeKeyword());
				//String inputData = "";
				int cntLoanSchemes = 1;
				int i = 0;
				String[] arrDueDeligenceString =  new String[req.getDueDelegencyList().size()];
				for(ClientDueDeligenceArray arr: req.getDueDelegencyList()) {
					String inputData = "("+arr.getModuleName()+","
			        		+arr.getHeader1()+","
							+arr.getHeader2()+","
							+arr.getHeader3()+","
							+arr.getHeader4()+","
							+(arr.getDdSequence() != null ? arr.getDdSequence() : -1)+","
							+(arr.getDdParentSequence() != null ? arr.getDdParentSequence() : -1)+","
							+"\""+arr.getDd_data()+"\","
							+"\""+arr.getGeneralOption()+"\","
							+"\""+arr.getApplicantOption()+"\","
							+"\""+arr.getCoApplicantOption()+"\","
							+"\""+arr.getGuarantorOption()+"\","
							+"\""+arr.getConditions()+"\","
							+"\""+arr.getLoanVariant_keyword()+"\","
							+(arr.getBorrowerTypeId() != null ? arr.getBorrowerTypeId() : -1)+","
							+"\""+arr.getCriticaltyFactor()+"\","
							+(arr.getProfessionId() != null ? arr.getProfessionId() : -1)+","
							+(arr.getLoanSchemeId()!= null ? arr.getLoanSchemeId() : -1)+","
							+(arr.getSecurityId()!= null ? arr.getSecurityId() : -1)+","
							+(arr.getSecurityTypeId()!= null ? arr.getSecurityTypeId() : -1)+","
							+(arr.getSecurity_subtype_id()!= null ? arr.getSecurity_subtype_id() : -1)+","
							+(arr.getApplicationTypeId() != null ? arr.getApplicationTypeId() : -1)+","
							+(arr.getAssetTypeId()  != null ? arr.getAssetTypeId() : -1)+")";
					arrDueDeligenceString[i] = inputData;
					i++;
				}
				cs.setArray(5, connection.createArrayOf(  
					      "bmadmin.obj_import_template",arrDueDeligenceString));
			    cs.executeUpdate();
			    if(null!=cs.getObject(1)) {
			    	PGobject arr = (PGobject) cs.getObject(1);
			    	String resultString = arr.getValue().substring(3, arr.getValue().lastIndexOf(")"));
			    	if(null!=resultString && !StringUtils.isEmpty(resultString)) {
					    String[] data = resultString.split(",");
					    resp.setNumOfLoanSchemes(String.valueOf(cntLoanSchemes));
					    resp.setWorkSheetName(String.valueOf(data[0]));
					    resp.setNumOfDDaps(String.valueOf(data[1]));
					    resp.setSuccessCount(String.valueOf(data[2]));
					    String failureCount = String.valueOf(data[3]);
					    resp.setFailureCount(failureCount);
					    resp.setDdId(String.valueOf(data[4]));
					    resp.setImportedDate("");
					    if(null!=failureCount && Integer.parseInt(failureCount)>0)
					    	resp.setStatus("Failure");
					    else 
					    	resp.setStatus("Success");
					    uploadResponseList.add(resp);
			    	}
			    	cntLoanSchemes =  cntLoanSchemes+1;
			    }
			}
		} catch (Exception ex) {
			logger.error("Exception while import template:" + ex);
			throw new DataAccessException(APIConstant.MSG_IMPORT_TEMPLATE_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
			    logger.error("Unable to close connection",e);
			}
			
		}
		return uploadResponseList;
	}

	@Override
	public List<ClientDueDeligenceDownloadResponse> getImportSummary(String outputType,Integer ddId) throws DataAccessException {
		try {
			if(!StringUtils.isEmpty(outputType)) {
				if(APIConstant.IMPORT_SUCCESS.equalsIgnoreCase(outputType))
					return jdbcTemplate.query(APIConstant.QUERY_GET_DOWNLOAD_SUCCESS_RECORDS,new Object[]{ddId,ddId,ddId,ddId,ddId}, new DueDeligenceSuccessRowMapper());
				else 
					return jdbcTemplate.query(APIConstant.QUERY_GET_DOWNLOAD_FAILURE_RECORDS,new Object[]{ddId}, new DueDeligenceFailiureRowMapper());
			} else {
				throw new DataAccessException(APIConstant.MSG_EXPORT_TEMPLATE_FAILURE);
			}
		} catch (Exception ex) {
			logger.error("Unable to execute query for downloading the summary",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_DOWNLOAD_IMPORT_SUMMARY);
		}
	}

	@Override
	public List<TemplateUploadResponse> getListOfExistingTemplates(ImportTemplateRequest importTemplateRequest)
			throws DataAccessException {
		List<TemplateUploadResponse> existingImportedResults = null;
		try {
			existingImportedResults =  jdbcTemplate.query(APIConstant.QUERY_GET_EXISTING_SUMMARY_TEMPLATES,
					new Object[]{importTemplateRequest.getClientTypeId(),importTemplateRequest.getCreditScoreTypeId(),importTemplateRequest.getRiskTypeId()},new ImportedTemplateRowMapper());
		} catch (Exception ex) {
			logger.error("Unable to get existing imported summary ",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return existingImportedResults;
	}

}
