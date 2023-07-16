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
public class CoApplicant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Coapplicant Id")
	private Integer coapplicantId;
	
	@ApiModelProperty(notes = "Coapplicant Name")
	private String coapplicantName;
	
	@ApiModelProperty(notes = "Profession Id")
	private Integer professionId;
	
	@ApiModelProperty(notes = "Profession Name")
	private String professionName;

	/**
	 * @return the coapplicantId
	 */
	public Integer getCoapplicantId() {
		return coapplicantId;
	}

	/**
	 * @param coapplicantId the coapplicantId to set
	 */
	public void setCoapplicantId(Integer coapplicantId) {
		this.coapplicantId = coapplicantId;
	}

	/**
	 * @return the coapplicantName
	 */
	public String getCoapplicantName() {
		return coapplicantName;
	}

	/**
	 * @param coapplicantName the coapplicantName to set
	 */
	public void setCoapplicantName(String coapplicantName) {
		this.coapplicantName = coapplicantName;
	}

	public Integer getProfessionId() {
		return professionId;
	}

	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	public String getProfessionName() {
		return professionName;
	}

	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}


}
