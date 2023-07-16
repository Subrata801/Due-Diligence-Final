/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
public class ClientSubscriptionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6213527812876258961L;

	private String typeofrequest;
	
	private Integer clientId;
	
	private Integer subscriptionId;
	
	private Integer subscriptionModelId;
	
	private Integer price;
	
	private Integer tax;
	
	private Integer gst;
	
	private Integer totalAmount;
	
	@ApiModelProperty(notes = "SubscriptionStartDate",required=true)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date subscriptionStartDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date subscriptionEndDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date renewalReminderDate;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private Integer newSubscriptionIndicator;

    private Integer productTypeId;
	
	private Integer clientSubTypeId;
	
	
	private Integer subscriptionTypeId;
	
	private Integer subscriptionSubTypeId;
	
	private String subscriptionName;
	
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
	 * @return the clientSubTypeId
	 */
	public Integer getClientSubTypeId() {
		return clientSubTypeId;
	}

	/**
	 * @param clientSubTypeId the clientSubTypeId to set
	 */
	public void setClientSubTypeId(Integer clientSubTypeId) {
		this.clientSubTypeId = clientSubTypeId;
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
	 * @return the subscriptionModelId
	 */
	public Integer getSubscriptionModelId() {
		return subscriptionModelId;
	}

	/**
	 * @param subscriptionModelId the subscriptionModelId to set
	 */
	public void setSubscriptionModelId(Integer subscriptionModelId) {
		this.subscriptionModelId = subscriptionModelId;
	}

	/**
	 * @return the typeofrequest
	 */
	public String getTypeofrequest() {
		return typeofrequest;
	}

	/**
	 * @param typeofrequest the typeofrequest to set
	 */
	public void setTypeofrequest(String typeofrequest) {
		this.typeofrequest = typeofrequest;
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
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
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
	 * @return the subscriptionStartDate
	 */
	public Date getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	/**
	 * @param subscriptionStartDate the subscriptionStartDate to set
	 */
	public void setSubscriptionStartDate(Date subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	/**
	 * @return the subscriptionEndDate
	 */
	public Date getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	/**
	 * @param subscriptionEndDate the subscriptionEndDate to set
	 */
	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}

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
	 * @return the newSubscriptionIndicator
	 */
	public Integer getNewSubscriptionIndicator() {
		return newSubscriptionIndicator;
	}

	/**
	 * @param newSubscriptionIndicator the newSubscriptionIndicator to set
	 */
	public void setNewSubscriptionIndicator(Integer newSubscriptionIndicator) {
		this.newSubscriptionIndicator = newSubscriptionIndicator;
	}

}
