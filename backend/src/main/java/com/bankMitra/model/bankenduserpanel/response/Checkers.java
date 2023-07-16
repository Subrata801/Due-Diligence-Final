/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;


import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
public class Checkers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Checker Id")
	private Integer checkerId;
	
	@ApiModelProperty(notes = "Checker Name")
	private String checkerName;

	/**
	 * @return the checkerId
	 */
	public Integer getCheckerId() {
		return checkerId;
	}

	/**
	 * @param checkerId the checkerId to set
	 */
	public void setCheckerId(Integer checkerId) {
		this.checkerId = checkerId;
	}

	/**
	 * @return the checkerName
	 */
	public String getCheckerName() {
		return checkerName;
	}

	/**
	 * @param checkerName the checkerName to set
	 */
	public void setCheckerName(String checkerName) {
		this.checkerName = checkerName;
	}

}
