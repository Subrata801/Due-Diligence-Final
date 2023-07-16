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
//@Table(	name = "bmsecurityquestions",schema="bmadmin")
public class SecurityQuestions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Security Question Id")
	private Integer securityQuestionId;
	
	@ApiModelProperty(notes = "Security Question Name")
	private String securityQuestionName;

	/**
	 * @return the securityQuestionId
	 */
	public Integer getSecurityQuestionId() {
		return securityQuestionId;
	}

	/**
	 * @param securityQuestionId the securityQuestionId to set
	 */
	public void setSecurityQuestionId(Integer securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	/**
	 * @return the securityQuestionName
	 */
	public String getSecurityQuestionName() {
		return securityQuestionName;
	}

	/**
	 * @param securityQuestionName the securityQuestionName to set
	 */
	public void setSecurityQuestionName(String securityQuestionName) {
		this.securityQuestionName = securityQuestionName;
	}
	
}
