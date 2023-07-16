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
public class LoanVariantRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3274722312991971617L;

	private Integer clientTypeId;
	
	private Integer riskTypeId;
	
	private Integer creditScoreTypeId;
	
	private Integer templateId;
	
	private Integer loanSchemeId;
	
	private Integer loanVariantId;
	
	private String loanVariantKeyword;
	
	private List<LoanVariantDetails> loanVariantDetails;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;

	
	/**
	 * @return the loanVariantDetails
	 */
	public List<LoanVariantDetails> getLoanVariantDetails() {
		return loanVariantDetails;
	}

	/**
	 * @param loanVariantDetails the loanVariantDetails to set
	 */
	public void setLoanVariantDetails(List<LoanVariantDetails> loanVariantDetails) {
		this.loanVariantDetails = loanVariantDetails;
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

	/**
	 * @return the loanVariantId
	 */
	public Integer getLoanVariantId() {
		return loanVariantId;
	}

	/**
	 * @param loanVariantId the loanVariantId to set
	 */
	public void setLoanVariantId(Integer loanVariantId) {
		this.loanVariantId = loanVariantId;
	}

	/**
	 * @return the loanVariantKeyword
	 */
	public String getLoanVariantKeyword() {
		return loanVariantKeyword;
	}

	/**
	 * @param loanVariantKeyword the loanVariantKeyword to set
	 */
	public void setLoanVariantKeyword(String loanVariantKeyword) {
		this.loanVariantKeyword = loanVariantKeyword;
	}

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

}
