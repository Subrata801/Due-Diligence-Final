/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class CifRegistrationRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String cifNum;
	
	private String customerName;
	
	private String createdBy;

	/**
	 * @return the cifNum
	 */
	public String getCifNum() {
		return cifNum;
	}

	/**
	 * @param cifNum the cifNum to set
	 */
	public void setCifNum(String cifNum) {
		this.cifNum = cifNum;
	}

	/**
	 * @return the customerName
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * @param customerName the customerName to set
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
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
	
}
