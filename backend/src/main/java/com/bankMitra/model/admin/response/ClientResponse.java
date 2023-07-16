/**
 * 
 */
package com.bankMitra.model.admin.response;

import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class ClientResponse {
	
	private String clientId;
	
	private Integer clientGroupId;
	private String riskTypeId;
	
	private Integer clientGroupTypeId;
	
	private String clientType;
	
	private String clientName;
	
	private String createDate;
	
	private String clientPrefix;
	
	private String lastUpdatedDate;
	
	private String subscriptionStatus;
	
	private String address;
	
	private String city;
	
	private Integer pincode;
	
	private String state;
	
	private String gstNum;
	
	private String primaryPoc;
	
	private String primaryPocNum;
	
	private String primaryPocDesignation;
	
	private String primaryPocEmail;
	
	private String secondaryPoc;
	
	private String secondaryPocNum;
	
	private String secondaryPocDesignation;
	
	private String secondaryPocEmail;
	
	private String createdDate;
	
	private String createdBy;
	
	private Integer languageId;
	
	private String status;
	
	private String clientTemplateStatus;
	
	private String clientLoanSchemeName;
	
	private String updatedBy;
	
	private String clientLogo;
	
	private String messageCode;
	
	private String messageDescription;



	/**
	 * @return the clientLoanSchemeName
	 */
	public String getClientLoanSchemeName() {
		return clientLoanSchemeName;
	}

	/**
	 * @param clientLoanSchemeName the clientLoanSchemeName to set
	 */
	public void setClientLoanSchemeName(String clientLoanSchemeName) {
		this.clientLoanSchemeName = clientLoanSchemeName;
	}

	/**
	 * @return the clientTemplateStatus
	 */
	public String getClientTemplateStatus() {
		return clientTemplateStatus;
	}

	/**
	 * @param clientTemplateStatus the clientTemplateStatus to set
	 */
	public void setClientTemplateStatus(String clientTemplateStatus) {
		this.clientTemplateStatus = clientTemplateStatus;
	}

	/**
	 * @return the riskTypeId
	 */
	public String getRiskTypeId() {
		return riskTypeId;
	}

	/**
	 * @param riskTypeId the riskTypeId to set
	 */
	public void setRiskTypeId(String riskTypeId) {
		this.riskTypeId = riskTypeId;
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
	 * @return the clientGroupTypeId
	 */
	public Integer getClientGroupTypeId() {
		return clientGroupTypeId;
	}

	/**
	 * @param clientGroupTypeId the clientGroupTypeId to set
	 */
	public void setClientGroupTypeId(Integer clientGroupTypeId) {
		this.clientGroupTypeId = clientGroupTypeId;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the clientLogo
	 */
	public String getClientLogo() {
		return clientLogo;
	}

	/**
	 * @param clientLogo the clientLogo to set
	 */
	public void setClientLogo(String clientLogo) {
		this.clientLogo = clientLogo;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the pincode
	 */
	public Integer getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the gstNum
	 */
	public String getGstNum() {
		return gstNum;
	}

	/**
	 * @param gstNum the gstNum to set
	 */
	public void setGstNum(String gstNum) {
		this.gstNum = gstNum;
	}

	/**
	 * @return the primaryPoc
	 */
	public String getPrimaryPoc() {
		return primaryPoc;
	}

	/**
	 * @param primaryPoc the primaryPoc to set
	 */
	public void setPrimaryPoc(String primaryPoc) {
		this.primaryPoc = primaryPoc;
	}

	/**
	 * @return the primaryPocNum
	 */
	public String getPrimaryPocNum() {
		return primaryPocNum;
	}

	/**
	 * @param primaryPocNum the primaryPocNum to set
	 */
	public void setPrimaryPocNum(String primaryPocNum) {
		this.primaryPocNum = primaryPocNum;
	}

	/**
	 * @return the primaryPocDesignation
	 */
	public String getPrimaryPocDesignation() {
		return primaryPocDesignation;
	}

	/**
	 * @param primaryPocDesignation the primaryPocDesignation to set
	 */
	public void setPrimaryPocDesignation(String primaryPocDesignation) {
		this.primaryPocDesignation = primaryPocDesignation;
	}

	/**
	 * @return the primaryPocEmail
	 */
	public String getPrimaryPocEmail() {
		return primaryPocEmail;
	}

	/**
	 * @param primaryPocEmail the primaryPocEmail to set
	 */
	public void setPrimaryPocEmail(String primaryPocEmail) {
		this.primaryPocEmail = primaryPocEmail;
	}

	/**
	 * @return the secondaryPoc
	 */
	public String getSecondaryPoc() {
		return secondaryPoc;
	}

	/**
	 * @param secondaryPoc the secondaryPoc to set
	 */
	public void setSecondaryPoc(String secondaryPoc) {
		this.secondaryPoc = secondaryPoc;
	}

	/**
	 * @return the secondaryPocNum
	 */
	public String getSecondaryPocNum() {
		return secondaryPocNum;
	}

	/**
	 * @param secondaryPocNum the secondaryPocNum to set
	 */
	public void setSecondaryPocNum(String secondaryPocNum) {
		this.secondaryPocNum = secondaryPocNum;
	}

	/**
	 * @return the secondaryPocDesignation
	 */
	public String getSecondaryPocDesignation() {
		return secondaryPocDesignation;
	}

	/**
	 * @param secondaryPocDesignation the secondaryPocDesignation to set
	 */
	public void setSecondaryPocDesignation(String secondaryPocDesignation) {
		this.secondaryPocDesignation = secondaryPocDesignation;
	}

	/**
	 * @return the secondaryPocEmail
	 */
	public String getSecondaryPocEmail() {
		return secondaryPocEmail;
	}

	/**
	 * @param secondaryPocEmail the secondaryPocEmail to set
	 */
	public void setSecondaryPocEmail(String secondaryPocEmail) {
		this.secondaryPocEmail = secondaryPocEmail;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * @return the clientPrefix
	 */
	public String getClientPrefix() {
		return clientPrefix;
	}

	/**
	 * @param clientPrefix the clientPrefix to set
	 */
	public void setClientPrefix(String clientPrefix) {
		this.clientPrefix = clientPrefix;
	}

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
	 * @return the clientType
	 */
	public String getClientType() {
		return clientType;
	}

	/**
	 * @param clientType the clientType to set
	 */
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the lastUpdatedDate
	 */
	public String getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(String lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/**
	 * @return the subscriptionStatus
	 */
	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	/**
	 * @param subscriptionStatus the subscriptionStatus to set
	 */
	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}

}
