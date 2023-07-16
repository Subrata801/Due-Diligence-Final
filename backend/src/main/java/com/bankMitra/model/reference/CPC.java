package com.bankMitra.model.reference;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bank Maitra
 *
 */

public class CPC implements Serializable{
	
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
	
	@ApiModelProperty(notes = "CPC Id")
	private Integer cpcId;

	@ApiModelProperty(notes = "CPC Name")
	private String cpcName;

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
	 * @return the cpcId
	 */
	public Integer getCpcId() {
		return cpcId;
	}

	/**
	 * @param cpcId the cpcId to set
	 */
	public void setCpcId(Integer cpcId) {
		this.cpcId = cpcId;
	}

	/**
	 * @return the cpcName
	 */
	public String getCpcName() {
		return cpcName;
	}

	/**
	 * @param cpcName the cpcName to set
	 */
	public void setCpcName(String cpcName) {
		this.cpcName = cpcName;
	}

}
