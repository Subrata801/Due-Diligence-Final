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
public class AuditFirm implements Serializable {


	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3175534593209267952L;

	@ApiModelProperty(notes = "Audit Firm Id")
	private Integer auditFirmId;
	
	@ApiModelProperty(notes = "Audit Firm Description")
	private String auditFirmName;

	/**
	 * @return the auditFirmId
	 */
	public Integer getAuditFirmId() {
		return auditFirmId;
	}

	/**
	 * @param auditFirmId the auditFirmId to set
	 */
	public void setAuditFirmId(Integer auditFirmId) {
		this.auditFirmId = auditFirmId;
	}

	/**
	 * @return the auditFirmName
	 */
	public String getAuditFirmName() {
		return auditFirmName;
	}

	/**
	 * @param auditFirmName the auditFirmName to set
	 */
	public void setAuditFirmName(String auditFirmName) {
		this.auditFirmName = auditFirmName;
	}

}
