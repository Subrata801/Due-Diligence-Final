package com.bankMitra.model.reference;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bank Maitra
 *
 */

public class ZO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Client Group Id")
	private Integer clienGroupId;
	
	@ApiModelProperty(notes = "Parent Client Group Id")
	private Integer parentClienGroupId;
	
	@ApiModelProperty(notes = "Client Id")
	private Integer clientId;
	
	@ApiModelProperty(notes = "ZO Id")
	private Integer zoId;

	@ApiModelProperty(notes = "ZO Name")
	private String zoName;

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
	 * @return the parentClienGroupId
	 */
	public Integer getParentClienGroupId() {
		return parentClienGroupId;
	}

	/**
	 * @param parentClienGroupId the parentClienGroupId to set
	 */
	public void setParentClienGroupId(Integer parentClienGroupId) {
		this.parentClienGroupId = parentClienGroupId;
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
	 * @return the zoId
	 */
	public Integer getZoId() {
		return zoId;
	}

	/**
	 * @param zoId the zoId to set
	 */
	public void setZoId(Integer zoId) {
		this.zoId = zoId;
	}

	/**
	 * @return the zoName
	 */
	public String getZoName() {
		return zoName;
	}

	/**
	 * @param zoName the zoName to set
	 */
	public void setZoName(String zoName) {
		this.zoName = zoName;
	}

}
