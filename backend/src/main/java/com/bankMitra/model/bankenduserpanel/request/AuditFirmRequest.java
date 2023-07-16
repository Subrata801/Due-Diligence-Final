/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
public class AuditFirmRequest implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3175534593209267952L;

	@ApiModelProperty(notes = "Client Id")
	private Integer clientId;
	
	@ApiModelProperty(notes = "User Role Id")
	private String userRoleId;

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
	 * @return the userRoleId
	 */
	public String getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}


}
