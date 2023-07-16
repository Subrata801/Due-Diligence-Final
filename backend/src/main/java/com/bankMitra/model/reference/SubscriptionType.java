/**
 * 
 */
package com.bankMitra.model.reference;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
//@Entity
//@Table(	name = "bmsubscriptiontype",schema="bmadmin")
public class SubscriptionType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Subscription Type Id")
	private Integer subscriptionTypeId;
	
	@ApiModelProperty(notes = "Subscription Type Name")
	private String subscriptionTypeName;

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
	 * @return the subscriptionTypeName
	 */
	public String getSubscriptionTypeName() {
		return subscriptionTypeName;
	}

	/**
	 * @param subscriptionTypeName the subscriptionTypeName to set
	 */
	public void setSubscriptionTypeName(String subscriptionTypeName) {
		this.subscriptionTypeName = subscriptionTypeName;
	}

}
