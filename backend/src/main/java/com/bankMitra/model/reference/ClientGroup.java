package com.bankMitra.model.reference;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */

public class ClientGroup implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Client Group Id")
	private Integer clienGroupId;
	
	@ApiModelProperty(notes = "Client Id")
	private Integer clientId;
	
	@ApiModelProperty(notes = "Client Group Type Id")
	private Integer clienGroupTypeId;

	@ApiModelProperty(notes = "Client Group Name")
	private String clienGroupName;

	/**
	 * @return the clienGroupId
	 */
	public Integer getClienGroupId() {
		return clienGroupId;
	}

	/**
	 * @param clienGroupId the clienGroupId to set
	 */
	public void setClienGroupId(Integer clienGroupId) {
		this.clienGroupId = clienGroupId;
	}

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
	 * @return the clienGroupTypeId
	 */
	public Integer getClienGroupTypeId() {
		return clienGroupTypeId;
	}

	/**
	 * @param clienGroupTypeId the clienGroupTypeId to set
	 */
	public void setClienGroupTypeId(Integer clienGroupTypeId) {
		this.clienGroupTypeId = clienGroupTypeId;
	}

	/**
	 * @return the clienGroupName
	 */
	public String getClienGroupName() {
		return clienGroupName;
	}

	/**
	 * @param clienGroupName the clienGroupName to set
	 */
	public void setClienGroupName(String clienGroupName) {
		this.clienGroupName = clienGroupName;
	}
	
	
}
