package com.bankMitra.model.reference;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bank Maitra
 *
 */

public class HO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Client Group Id")
	private Integer clienGroupId;
	
	@ApiModelProperty(notes = "Client Id")
	private Integer clientId;
	
	@ApiModelProperty(notes = "HO Id")
	private Integer hoId;

	@ApiModelProperty(notes = "HO Name")
	private String hoName;

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
	 * @return the hoId
	 */
	public Integer getHoId() {
		return hoId;
	}

	/**
	 * @param hoId the hoId to set
	 */
	public void setHoId(Integer hoId) {
		this.hoId = hoId;
	}

	/**
	 * @return the hoName
	 */
	public String getHoName() {
		return hoName;
	}

	/**
	 * @param hoName the hoName to set
	 */
	public void setHoName(String hoName) {
		this.hoName = hoName;
	}

}
