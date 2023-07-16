/**
 * 
 */
package com.bankMitra.model.reference;

import java.io.Serializable;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
//@Entity
//@Table(	name = "bmsecuritytype",schema="bmadmin")
public class MessageCode implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Message Code")
	private String messageCode;
	
	@ApiModelProperty(notes = "Message Description")
	private String messageDescription;



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

}
