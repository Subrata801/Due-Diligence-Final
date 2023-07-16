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
public class ClientNewSubscriptionRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6213527812876258961L;

	private Integer clientId;
	
	private String clientName;
	
	private Integer clientTypeId;
	
	private Integer productTypeId;
	
	private Integer clientSubTypeId;
	
	private Integer subscriptionModelId;
	
	private Integer subscriptionId;
	
	private Integer subscriptionTypeId;
	
	private Integer subscriptionSubTypeId;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private Integer newSubscriptionIndicator;

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
