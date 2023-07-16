/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class CifRegistrationResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String cifNum;
	
	private String customerName;
	
	private String createdBy;
	
	private String messageCode;
	
	private String messageDescription;


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
	
}
