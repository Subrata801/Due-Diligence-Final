/**
 * 
 */
package com.bankMitra.model.subscription;

import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author BankMitra
 *
 */
public class SubscriptionRequest {
	
	private Integer productTypeId;
	
	private Integer subscriptionId;
	
	private Integer subscriptionReqType;
	
	private Integer subscriptionTypeId;
	
	private Integer subscriptionSubTypeId;
	
	private String subscriptionName;
	
	private Integer subscriptionPeriod;
	
	private Integer dbAction;
	
	private Integer maxBranches;
	
	private Integer maxNumOfLoanSchemes;
	
	private Integer maxBanks;
	
	private Integer renewalReminderDate;
	
	private Integer dataValidityPeriod;
	
	private Integer pricePerMonth;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;

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
	 * @return the productTypeId
	 */
	public Integer getProductTypeId() {
		return productTypeId;
	}

	/**
	 * @param productTypeId the productTypeId to set
	 */
	public void setProductTypeId(Integer productTypeId) {
		this.productTypeId = productTypeId;
	}

	/**
	 * @return the subscriptionReqType
	 */
	public Integer getSubscriptionReqType() {
		return subscriptionReqType;
	}

	/**
	 * @param subscriptionReqType the subscriptionReqType to set
	 */
	public void setSubscriptionReqType(Integer subscriptionReqType) {
		this.subscriptionReqType = subscriptionReqType;
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
	 * @return the dbAction
	 */
	public Integer getDbAction() {
		return dbAction;
	}

	/**
	 * @param dbAction the dbAction to set
	 */
	public void setDbAction(Integer dbAction) {
		this.dbAction = dbAction;
	}

	/**
	 * @return the maxBranches
	 */
	public Integer getMaxBranches() {
		return maxBranches;
	}

	/**
	 * @param maxBranches the maxBranches to set
	 */
	public void setMaxBranches(Integer maxBranches) {
		this.maxBranches = maxBranches;
	}

	/**
	 * @return the maxNumOfLoanSchemes
	 */
	public Integer getMaxNumOfLoanSchemes() {
		return maxNumOfLoanSchemes;
	}

	/**
	 * @param maxNumOfLoanSchemes the maxNumOfLoanSchemes to set
	 */
	public void setMaxNumOfLoanSchemes(Integer maxNumOfLoanSchemes) {
		this.maxNumOfLoanSchemes = maxNumOfLoanSchemes;
	}

	/**
	 * @return the maxBanks
	 */
	public Integer getMaxBanks() {
		return maxBanks;
	}

	/**
	 * @param maxBanks the maxBanks to set
	 */
	public void setMaxBanks(Integer maxBanks) {
		this.maxBanks = maxBanks;
	}

	/**
	 * @return the renewalReminderDate
	 */
	public Integer getRenewalReminderDate() {
		return renewalReminderDate;
	}

	/**
	 * @param renewalReminderDate the renewalReminderDate to set
	 */
	public void setRenewalReminderDate(Integer renewalReminderDate) {
		this.renewalReminderDate = renewalReminderDate;
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
