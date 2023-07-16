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
public class SanctionAuthority implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Sanction Authority Id")
	private Integer saId;
	
	@ApiModelProperty(notes = "Sanction Authority Name")
	private String saName;

	/**
	 * @return the saId
	 */
	public Integer getSaId() {
		return saId;
	}

	/**
	 * @param saId the saId to set
	 */
	public void setSaId(Integer saId) {
		this.saId = saId;
	}

	/**
	 * @return the saName
	 */
	public String getSaName() {
		return saName;
	}

	/**
	 * @param saName the saName to set
	 */
	public void setSaName(String saName) {
		this.saName = saName;
	}

}
