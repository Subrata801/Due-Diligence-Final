/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class AdministrativeResponse implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8558651600485195374L;

	private String messageCode;
	
	private String messageDescription;
	
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
