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
//@Table(	name = "bmsecuritytype",schema="bmadmin")
public class SecurityType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Security Type Id")
	private Integer securityTypeId;
	
	@ApiModelProperty(notes = "Security Type Name")
	private String securityTypeName;

	/**
	 * @return the securityTypeId
	 */
	public Integer getSecurityTypeId() {
		return securityTypeId;
	}

	/**
	 * @param securityTypeId the securityTypeId to set
	 */
	public void setSecurityTypeId(Integer securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	/**
	 * @return the securityTypeName
	 */
	public String getSecurityTypeName() {
		return securityTypeName;
	}

	/**
	 * @param securityTypeName the securityTypeName to set
	 */
	public void setSecurityTypeName(String securityTypeName) {
		this.securityTypeName = securityTypeName;
	}

}
