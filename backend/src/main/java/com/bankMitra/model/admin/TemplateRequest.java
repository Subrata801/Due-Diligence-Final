/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class TemplateRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8144099032924521353L;

	private String importTemplateName;
	
	private String incrementImportTemplateName;
	
	private Integer languageId;
	
	private Integer clientTypeId;
	
	private Integer riskTypeId;
	
	private Integer creditScoreId;
	
	private Integer creditSectorId;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;

	/**
	 * @return the importTemplateName
	 */
	public String getImportTemplateName() {
		return importTemplateName;
	}

	/**
	 * @param importTemplateName the importTemplateName to set
	 */
	public void setImportTemplateName(String importTemplateName) {
		this.importTemplateName = importTemplateName;
	}

	/**
	 * @return the incrementImportTemplateName
	 */
	public String getIncrementImportTemplateName() {
		return incrementImportTemplateName;
	}

	/**
	 * @param incrementImportTemplateName the incrementImportTemplateName to set
	 */
	public void setIncrementImportTemplateName(String incrementImportTemplateName) {
		this.incrementImportTemplateName = incrementImportTemplateName;
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
	 * @return the creditScoreId
	 */
	public Integer getCreditScoreId() {
		return creditScoreId;
	}

	/**
	 * @param creditScoreId the creditScoreId to set
	 */
	public void setCreditScoreId(Integer creditScoreId) {
		this.creditScoreId = creditScoreId;
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

	/**
	 * @return the creditSectorId
	 */
	public Integer getCreditSectorId() {
		return creditSectorId;
	}

	/**
	 * @param creditSectorId the creditSectorId to set
	 */
	public void setCreditSectorId(Integer creditSectorId) {
		this.creditSectorId = creditSectorId;
	}

}
