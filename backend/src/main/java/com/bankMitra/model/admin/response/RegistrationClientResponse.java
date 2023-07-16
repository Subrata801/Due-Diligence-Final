/**
 * 
 */
package com.bankMitra.model.admin.response;


/**
 * @author BankMitra
 *
 */
public class RegistrationClientResponse {
	
	private Integer clientId;
	
	private String clientName;

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
	
}
