/**
 * 
 */
package com.bankMitra.model.reference;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
//@Entity
//@Table(	name = "bmclienttype",schema="bmadmin")
public class ClientType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Client Type Id")
	private Integer clientTypeId;
	
	@ApiModelProperty(notes = "Client Type Name")
	private String clientTypeName;

	/**
	 * @return the clientTypeId
	 */
	public Integer getClientTypeId() {
		return clientTypeId;
	}

	/**
	 * @param clientTypeId the clientTypeId to set
	 */
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	/**
	 * @return the clientTypeName
	 */
	public String getClientTypeName() {
		return clientTypeName;
	}

	/**
	 * @param clientTypeName the clientTypeName to set
	 */
	public void setClientTypeName(String clientTypeName) {
		this.clientTypeName = clientTypeName;
	}
	
	

}
