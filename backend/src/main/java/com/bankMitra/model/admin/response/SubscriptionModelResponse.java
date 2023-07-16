/**
 * 
 */
package com.bankMitra.model.admin.response;

/**
 * @author BankMitra
 *
 */
public class SubscriptionModelResponse {
	
	private Integer subscriptionModelId;
	
	private String subscriptionModeDesc;

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
