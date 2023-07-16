/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class SubscriptionModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7253986405494570837L;

	private Integer productTypeId;
	
	private Integer subscriptionTypeId;
	
	private Integer subscriptionSubTypeId;
	
	private Integer subscriptionModelId;
	
	private String subscriptionModeDesc;

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

	public Integer getSubscriptionTypeId() {
		return subscriptionTypeId;
	}

	public void setSubscriptionTypeId(Integer subscriptionTypeId) {
		this.subscriptionTypeId = subscriptionTypeId;
	}

	public Integer getSubscriptionSubTypeId() {
		return subscriptionSubTypeId;
	}

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
	 * @return the subscriptionModeDesc
	 */
	public String getSubscriptionModeDesc() {
		return subscriptionModeDesc;
	}

	/**
	 * @param subscriptionModeDesc the subscriptionModeDesc to set
	 */
	public void setSubscriptionModeDesc(String subscriptionModeDesc) {
		this.subscriptionModeDesc = subscriptionModeDesc;
	}

}
