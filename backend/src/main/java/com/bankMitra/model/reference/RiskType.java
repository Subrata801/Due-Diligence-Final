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
//@Table(	name = "bmrisktype",schema="bmadmin")
public class RiskType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Risk Type Id")
	private Integer riskTypeId;
	
	@ApiModelProperty(notes = "Risk Type Name")
	private String riskTypeName;

	/**
	 * @return the riskTypeId
	 */
	public Integer getRiskTypeId() {
		return riskTypeId;
	}

	/**
	 * @param riskTypeId the riskTypeId to set
	 */
	public void setRiskTypeId(Integer riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	/**
	 * @return the riskTypeName
	 */
	public String getRiskTypeName() {
		return riskTypeName;
	}

	/**
	 * @param riskTypeName the riskTypeName to set
	 */
	public void setRiskTypeName(String riskTypeName) {
		this.riskTypeName = riskTypeName;
	}

}
