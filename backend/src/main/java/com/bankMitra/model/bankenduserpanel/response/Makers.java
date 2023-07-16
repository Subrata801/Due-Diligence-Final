/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
public class Makers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Maker Id")
	private Integer makerid;
	
	@ApiModelProperty(notes = "Maker Name")
	private String makerName;

	/**
	 * @return the makerid
	 */
	public Integer getMakerid() {
		return makerid;
	}

	/**
	 * @param makerid the makerid to set
	 */
	public void setMakerid(Integer makerid) {
		this.makerid = makerid;
	}

	/**
	 * @return the makerName
	 */
	public String getMakerName() {
		return makerName;
	}

	/**
	 * @param makerName the makerName to set
	 */
	public void setMakerName(String makerName) {
		this.makerName = makerName;
	}

}
