/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.List;

/**
 * @author BankMitra
 *
 */
public class ClientConfigRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2895381904547893782L;

	private Integer clientTypeId;
	
	private Integer clientGroupId;
	
	private Integer clientId;
	
	private Integer languageId;
	
	private Integer subscriptionId;
	
	private String riskTypeId;
	
	private String clientName;
	
	private String clientPrefix;
	
	private String gstNum;
	
	private String city;
	
	private String state;
	
	private List<Address> addressInfo;
	
	private List<Contact> primaryContactInfo;
	
	private List<Contact> secondaryContactInfo;
	
	private List<ClientLoanVariantRequest> loanSchemeVariantDetails;
	
	private String createdBy;
	
	private String clientLogoPath;
	
	private String v1TemplateStatus;



	/**
	 * @return the v1TemplateStatus
	 */
	public String getV1TemplateStatus() {
		return v1TemplateStatus;
	}

	/**
	 * @param v1TemplateStatus the v1TemplateStatus to set
	 */
	public void setV1TemplateStatus(String v1TemplateStatus) {
		this.v1TemplateStatus = v1TemplateStatus;
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
	 * @return the subscriptionId
	 */
	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * @param subscriptionId the subscriptionId to set
	 */
	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
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
	 * @return the addressInfo
	 */
	public List<Address> getAddressInfo() {
		return addressInfo;
	}

	/**
	 * @param addressInfo the addressInfo to set
	 */
	public void setAddressInfo(List<Address> addressInfo) {
		this.addressInfo = addressInfo;
	}

	/**
	 * @return the primaryContactInfo
	 */
	public List<Contact> getPrimaryContactInfo() {
		return primaryContactInfo;
	}

	/**
	 * @param primaryContactInfo the primaryContactInfo to set
	 */
	public void setPrimaryContactInfo(List<Contact> primaryContactInfo) {
		this.primaryContactInfo = primaryContactInfo;
	}

	/**
	 * @return the secondaryContactInfo
	 */
	public List<Contact> getSecondaryContactInfo() {
		return secondaryContactInfo;
	}

	/**
	 * @param secondaryContactInfo the secondaryContactInfo to set
	 */
	public void setSecondaryContactInfo(List<Contact> secondaryContactInfo) {
		this.secondaryContactInfo = secondaryContactInfo;
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
	 * @return the clientLogoPath
	 */
	public String getClientLogoPath() {
		return clientLogoPath;
	}

	/**
	 * @param clientLogoPath the clientLogoPath to set
	 */
	public void setClientLogoPath(String clientLogoPath) {
		this.clientLogoPath = clientLogoPath;
	}

	/**
	 * @return the loanSchemeVariantDetails
	 */
	public List<ClientLoanVariantRequest> getLoanSchemeVariantDetails() {
		return loanSchemeVariantDetails;
	}

	/**
	 * @param loanSchemeVariantDetails the loanSchemeVariantDetails to set
	 */
	public void setLoanSchemeVariantDetails(List<ClientLoanVariantRequest> loanSchemeVariantDetails) {
		this.loanSchemeVariantDetails = loanSchemeVariantDetails;
	}
	
}
