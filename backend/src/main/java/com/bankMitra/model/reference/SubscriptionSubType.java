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
//@Table(	name = "bmsubscriptionsubtype",schema="bmadmin")
public class SubscriptionSubType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Subscription Type Id")
	private Integer subscriptionTypeId;
	
	@ApiModelProperty(notes = "Subscription Sub Type Id")
	private Integer subscriptionSubTypeId;
	
	@ApiModelProperty(notes = "Subscription Sub Type Name")
	private String subscriptionSubTypeName;

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

}
