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
public class UnitType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Unit Type Id")
	private Integer unitTypeId;
	
	@ApiModelProperty(notes = "Unit Type Name")
	private String unitTypeName;

	/**
	 * @return the unitTypeId
	 */
	public Integer getUnitTypeId() {
		return unitTypeId;
	}

	/**
	 * @param unitTypeId the unitTypeId to set
	 */
	public void setUnitTypeId(Integer unitTypeId) {
		this.unitTypeId = unitTypeId;
	}

	/**
	 * @return the unitTypeName
	 */
	public String getUnitTypeName() {
		return unitTypeName;
	}

	/**
	 * @param unitTypeName the unitTypeName to set
	 */
	public void setUnitTypeName(String unitTypeName) {
		this.unitTypeName = unitTypeName;
	}

}
