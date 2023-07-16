/**
 * 
 */
package com.bankMitra.model.admin.response;

import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class ClientSubscriptionResponse {
	
	private Integer subscriptionId;
	
	private String subscriptionName;
	
	private Integer subscriptionPeriod;
	
	private Integer maxNumberOfBranches;
	
	private Integer maxLoanSchemeAllowed;
	
	private Integer renewalReminderActivation;
	
	private Integer dataValidityPeriod;
	
	private Integer pricePerMonth;
	
	private Integer pricePackage;
	
	private Integer gst;
	
	private Integer tax;
	
	private Integer totalAmount;
	
	private Date startDate;
	
	private Date endDate;
	
	private Date renewalReminderDate;
	
	private Integer clientId;
	
	private Integer clientTypeId;
	
	private String messageCode;
	
	private String messageDescription;

	private Integer productId;
	
	private String productName;
	
	private String subscriptionType;
	
	private Integer subscriptionSubTypeId;
	
	private String subscriptionSubTypeName;
	
	private Integer subscriptionTypeId;
	
	private String subscriptionStatus;
	
	
	/**
	 * @return the renewalReminderDate
	 */
	public Date getRenewalReminderDate() {
		return renewalReminderDate;
	}

	/**
	 * @param renewalReminderDate the renewalReminderDate to set
	 */
	public void setRenewalReminderDate(Date renewalReminderDate) {
		this.renewalReminderDate = renewalReminderDate;
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
	 * @return the subscriptionSubTypeId
	 */
	public Integer getSubscriptionSubTypeId() {
		return subscriptionSubTypeId;
	}

	/**
	 * @param subscriptionSubTypeId the subscriptionSubTypeId to set
	 */
	public void setSubscriptionSubTypeId(Integer subscriptionSubTypeId) {
		this.subscriptionSubTypeId = subscriptionSubTypeId;
	}

	/**
	 * @return the subscriptionType
	 */
	public String getSubscriptionType() {
		return subscriptionType;
	}

	/**
	 * @param subscriptionType the subscriptionType to set
	 */
	public void setSubscriptionType(String subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	/**
	 * @return the subscriptionSubTypeName
	 */
	public String getSubscriptionSubTypeName() {
		return subscriptionSubTypeName;
	}

	/**
	 * @param subscriptionSubTypeName the subscriptionSubTypeName to set
	 */
	public void setSubscriptionSubTypeName(String subscriptionSubTypeName) {
		this.subscriptionSubTypeName = subscriptionSubTypeName;
	}

	/**
	 * @return the subscriptionTypeId
	 */
	public Integer getSubscriptionTypeId() {
		return subscriptionTypeId;
	}

	/**
	 * @param subscriptionTypeId the subscriptionTypeId to set
	 */
	public void setSubscriptionTypeId(Integer subscriptionTypeId) {
		this.subscriptionTypeId = subscriptionTypeId;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the subscriptionPeriod
	 */
	public Integer getSubscriptionPeriod() {
		return subscriptionPeriod;
	}

	/**
	 * @param subscriptionPeriod the subscriptionPeriod to set
	 */
	public void setSubscriptionPeriod(Integer subscriptionPeriod) {
		this.subscriptionPeriod = subscriptionPeriod;
	}

	/**
	 * @return the maxNumberOfBranches
	 */
	public Integer getMaxNumberOfBranches() {
		return maxNumberOfBranches;
	}

	/**
	 * @param maxNumberOfBranches the maxNumberOfBranches to set
	 */
	public void setMaxNumberOfBranches(Integer maxNumberOfBranches) {
		this.maxNumberOfBranches = maxNumberOfBranches;
	}

	/**
	 * @return the maxLoanSchemeAllowed
	 */
	public Integer getMaxLoanSchemeAllowed() {
		return maxLoanSchemeAllowed;
	}

	/**
	 * @param maxLoanSchemeAllowed the maxLoanSchemeAllowed to set
	 */
	public void setMaxLoanSchemeAllowed(Integer maxLoanSchemeAllowed) {
		this.maxLoanSchemeAllowed = maxLoanSchemeAllowed;
	}

	/**
	 * @return the renewalReminderActivation
	 */
	public Integer getRenewalReminderActivation() {
		return renewalReminderActivation;
	}

	/**
	 * @param renewalReminderActivation the renewalReminderActivation to set
	 */
	public void setRenewalReminderActivation(Integer renewalReminderActivation) {
		this.renewalReminderActivation = renewalReminderActivation;
	}

	/**
	 * @return the dataValidityPeriod
	 */
	public Integer getDataValidityPeriod() {
		return dataValidityPeriod;
	}

	/**
	 * @param dataValidityPeriod the dataValidityPeriod to set
	 */
	public void setDataValidityPeriod(Integer dataValidityPeriod) {
		this.dataValidityPeriod = dataValidityPeriod;
	}

	/**
	 * @return the pricePerMonth
	 */
	public Integer getPricePerMonth() {
		return pricePerMonth;
	}

	/**
	 * @param pricePerMonth the pricePerMonth to set
	 */
	public void setPricePerMonth(Integer pricePerMonth) {
		this.pricePerMonth = pricePerMonth;
	}

	/**
	 * @return the pricePackage
	 */
	public Integer getPricePackage() {
		return pricePackage;
	}

	/**
	 * @param pricePackage the pricePackage to set
	 */
	public void setPricePackage(Integer pricePackage) {
		this.pricePackage = pricePackage;
	}

	/**
	 * @return the subscriptionName
	 */
	public String getSubscriptionName() {
		return subscriptionName;
	}

	/**
	 * @param subscriptionName the subscriptionName to set
	 */
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	/**
	 * @return the gst
	 */
	public Integer getGst() {
		return gst;
	}

	/**
	 * @param gst the gst to set
	 */
	public void setGst(Integer gst) {
		this.gst = gst;
	}

	/**
	 * @return the tax
	 */
	public Integer getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Integer tax) {
		this.tax = tax;
	}

	/**
	 * @return the totalAmount
	 */
	public Integer getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	
}
