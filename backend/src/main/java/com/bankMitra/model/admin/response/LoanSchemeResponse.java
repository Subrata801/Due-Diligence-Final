/**
 * 
 */
package com.bankMitra.model.admin.response;

import java.util.Map;

/**
 * @author BankMitra
 *
 */
public class LoanSchemeResponse {
	
	private Integer templateId;
	
	private Integer clientTypeId;
	
	private Integer riskTypeId;
	
	private Integer creditScoreTypeId;
	
	private Integer languageId;
	
	private Integer loanSchemeId;
	
	private String loanSchemeName;
	
	private String keyword;
	
	private String worksheetName;
	
	private String messageCode;
	
	private String messageDescription;
	
	private Map<String,String> loanSchemeGenerationResponse;


	/**
	 * @return the templateId
	 */
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the loanSchemeGenerationResponse
	 */
	public Map<String, String> getLoanSchemeGenerationResponse() {
		return loanSchemeGenerationResponse;
	}

	/**
	 * @param loanSchemeGenerationResponse the loanSchemeGenerationResponse to set
	 */
	public void setLoanSchemeGenerationResponse(Map<String, String> loanSchemeGenerationResponse) {
		this.loanSchemeGenerationResponse = loanSchemeGenerationResponse;
	}

	/**
	 * @return the loanSchemeId
	 */
	public Integer getLoanSchemeId() {
		return loanSchemeId;
	}

	/**
	 * @param loanSchemeId the loanSchemeId to set
	 */
	public void setLoanSchemeId(Integer loanSchemeId) {
		this.loanSchemeId = loanSchemeId;
	}

	/**
	 * @return the loanSchemeName
	 */
	public String getLoanSchemeName() {
		return loanSchemeName;
	}

	/**
	 * @param loanSchemeName the loanSchemeName to set
	 */
	public void setLoanSchemeName(String loanSchemeName) {
		this.loanSchemeName = loanSchemeName;
	}

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 * @return the worksheetName
	 */
	public String getWorksheetName() {
		return worksheetName;
	}

	/**
	 * @param worksheetName the worksheetName to set
	 */
	public void setWorksheetName(String worksheetName) {
		this.worksheetName = worksheetName;
	}

	/**
	 * @return the messageCode
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param messageCode the messageCode to set
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @return the messageDescription
	 */
	public String getMessageDescription() {
		return messageDescription;
	}

	/**
	 * @param messageDescription the messageDescription to set
	 */
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	/**
	 * @return the clientTypeId
	 */
	public Integer getClientTypeId() {
		return clientTypeId;
	}

	/**
	 * @param clientTypeId the clientTypeId to set
	 */
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	/**
	 * @return the riskTypeId
	 */
	public Integer getRiskTypeId() {
		return riskTypeId;
	}

	/**
	 * @param riskTypeId the riskTypeId to set
	 */
	public void setRiskTypeId(Integer riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	/**
	 * @return the creditScoreTypeId
	 */
	public Integer getCreditScoreTypeId() {
		return creditScoreTypeId;
	}

	/**
	 * @param creditScoreTypeId the creditScoreTypeId to set
	 */
	public void setCreditScoreTypeId(Integer creditScoreTypeId) {
		this.creditScoreTypeId = creditScoreTypeId;
	}

	/**
	 * @return the languageId
	 */
	public Integer getLanguageId() {
		return languageId;
	}

	/**
	 * @param languageId the languageId to set
	 */
	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}
	
}
