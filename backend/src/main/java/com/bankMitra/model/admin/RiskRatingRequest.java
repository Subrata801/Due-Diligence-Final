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
public class RiskRatingRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9137793716633362686L;

	private Integer clientId;
	
	private Integer firmId;
	
	private Integer clientTypeId;
	
	private Integer clientGroupId;
	
	private Integer riskTypeId;
	
	private Integer creditScoreTypeId;
	
	public List<RiskScore> riskScoreList;
	
	private String authorizedBy;
	
	private String designation;
	
	private String circularNum;
	
	private Date circularDate;
	
	private Date effectiveDate;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	

	/**
	 * @return the firmId
	 */
	public Integer getFirmId() {
		return firmId;
	}

	/**
	 * @param firmId the firmId to set
	 */
	public void setFirmId(Integer firmId) {
		this.firmId = firmId;
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
	 * @return the clientGroupId
	 */
	public Integer getClientGroupId() {
		return clientGroupId;
	}

	/**
	 * @param clientGroupId the clientGroupId to set
	 */
	public void setClientGroupId(Integer clientGroupId) {
		this.clientGroupId = clientGroupId;
	}

	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
	 * @return the riskScoreList
	 */
	public List<RiskScore> getRiskScoreList() {
		return riskScoreList;
	}

	/**
	 * @param riskScoreList the riskScoreList to set
	 */
	public void setRiskScoreList(List<RiskScore> riskScoreList) {
		this.riskScoreList = riskScoreList;
	}

	/**
	 * @return the authorizedBy
	 */
	public String getAuthorizedBy() {
		return authorizedBy;
	}

	/**
	 * @param authorizedBy the authorizedBy to set
	 */
	public void setAuthorizedBy(String authorizedBy) {
		this.authorizedBy = authorizedBy;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the circularNum
	 */
	public String getCircularNum() {
		return circularNum;
	}

	/**
	 * @param circularNum the circularNum to set
	 */
	public void setCircularNum(String circularNum) {
		this.circularNum = circularNum;
	}

	/**
	 * @return the circularDate
	 */
	public Date getCircularDate() {
		return circularDate;
	}

	/**
	 * @param circularDate the circularDate to set
	 */
	public void setCircularDate(Date circularDate) {
		this.circularDate = circularDate;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
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
