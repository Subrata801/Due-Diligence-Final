/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author BankMitra
 *
 */
public class LoanSchemeRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3137730583579628088L;

	private Integer clientTypeId;
	
	private Integer riskTypeId;
	
	private Integer creditScoreTypeId;
	
	private Integer languageId;
	
	private Integer templateId;
	
	private Integer loanSchemeId;
	
	private Integer branchId;
	
	private String clientId;
	
	private List<LoanSchemeDetails> loanSchemeDetails;
	
	/*private String loanSchemeName;
	
	private String keyword;
	
	private String worksheetName;*/
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private String typeOfDueDeligence;
	
	private Date updatedDate;


/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

/**
	 * @return the typeOfDueDeligence
	 */
	public String getTypeOfDueDeligence() {
		return typeOfDueDeligence;
	}

	/**
	 * @param typeOfDueDeligence the typeOfDueDeligence to set
	 */
	public void setTypeOfDueDeligence(String typeOfDueDeligence) {
		this.typeOfDueDeligence = typeOfDueDeligence;
	}

/**
	 * @return the branchId
	 */
	public Integer getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	/*	*//**
	 * @return the loanSchemeName
	 *//*
	public String getLoanSchemeName() {
		return loanSchemeName;
	}

	*//**
	 * @param loanSchemeName the loanSchemeName to set
	 *//*
	public void setLoanSchemeName(String loanSchemeName) {
		this.loanSchemeName = loanSchemeName;
	}

	*//**
	 * @return the keyword
	 *//*
	public String getKeyword() {
		return keyword;
	}

	*//**
	 * @param keyword the keyword to set
	 *//*
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
*/
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

/*	*//**
	 * @return the worksheetName
	 *//*
	public String getWorksheetName() {
		return worksheetName;
	}

	*//**
	 * @param worksheetName the worksheetName to set
	 *//*
	public void setWorksheetName(String worksheetName) {
		this.worksheetName = worksheetName;
	}
*/
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
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

	/**
	 * @return the loanSchemeDetails
	 */
	public List<LoanSchemeDetails> getLoanSchemeDetails() {
		return loanSchemeDetails;
	}

	/**
	 * @param loanSchemeDetails the loanSchemeDetails to set
	 */
	public void setLoanSchemeDetails(List<LoanSchemeDetails> loanSchemeDetails) {
		this.loanSchemeDetails = loanSchemeDetails;
	}
	
}
