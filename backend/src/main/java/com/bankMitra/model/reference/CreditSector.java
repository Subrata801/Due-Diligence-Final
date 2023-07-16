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
//@Table(	name = "bmcreditscoretype",schema="bmadmin")
public class CreditSector implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "CreditScore Id")
	private Integer creditSectorId;
	
	@ApiModelProperty(notes = "CreditScore Name")
	private String creditSectorName;

	/**
	 * @return the creditSectorId
	 */
	public Integer getCreditSectorId() {
		return creditSectorId;
	}

	/**
	 * @param creditSectorId the creditSectorId to set
	 */
	public void setCreditSectorId(Integer creditSectorId) {
		this.creditSectorId = creditSectorId;
	}

	/**
	 * @return the creditSectorName
	 */
	public String getCreditSectorName() {
		return creditSectorName;
	}

	/**
	 * @param creditSectorName the creditSectorName to set
	 */
	public void setCreditSectorName(String creditSectorName) {
		this.creditSectorName = creditSectorName;
	}
	
	
}
