/**
 * 
 */
package com.bankMitra.model.reference;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
public class Banks implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6670073113867191677L;

	@ApiModelProperty(notes = "Bank Id")
	private Integer bankId;
	
	@ApiModelProperty(notes = "Bank Description")
	private String bankDesc;

	/**
	 * @return the bankId
	 */
	public Integer getBankId() {
		return bankId;
	}

	/**
	 * @param bankId the bankId to set
	 */
	public void setBankId(Integer bankId) {
		this.bankId = bankId;
	}

	/**
	 * @return the bankDesc
	 */
	public String getBankDesc() {
		return bankDesc;
	}

	/**
	 * @param bankDesc the bankDesc to set
	 */
	public void setBankDesc(String bankDesc) {
		this.bankDesc = bankDesc;
	}

}
