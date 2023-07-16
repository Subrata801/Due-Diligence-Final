/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class SubscriptionSearchRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7006029460655851908L;

	private Integer searchText;
	
	private String searchCriteria;
	
	private Integer productTypeId;
	
	private Integer subscriptionTypeId;
	
	private Integer subscriptionSubTypeId;
	
	private Integer subscriptionId;

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
	 * @return the searchText
	 */
	public Integer getSearchText() {
		return searchText;
	}

	/**
	 * @param searchText the searchText to set
	 */
	public void setSearchText(Integer searchText) {
		this.searchText = searchText;
	}

	/**
	 * @return the searchCriteria
	 */
	public String getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(String searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

}
