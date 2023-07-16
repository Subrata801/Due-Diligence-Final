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
public class LoanVariant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Loan Scheme Id")
	private Integer loanSchemeId;
	
	@ApiModelProperty(notes = "Loan Variant Id")
	private Integer loanVariantId;
	
	@ApiModelProperty(notes = "Loan Variant Name")
	private String loanVariantName;
	
	private String typeOfDueDeligence;
	
	private Integer clientId;
	
	
	
	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the typeOfDueDeligence
	 */
	public String getTypeOfDueDeligence() {
		return typeOfDueDeligence;
	}

	/**
	 * @param typeOfDueDeligence the typeOfDueDeligence to set
	 */
	public void setTypeOfDueDeligence(String typeOfDueDeligence) {
		this.typeOfDueDeligence = typeOfDueDeligence;
	}

	/**
	 * @return the loanSchemeId
	 */
	public Integer getLoanSchemeId() {
		return loanSchemeId;
	}

	/**
	 * @param loanSchemeId the loanSchemeId to set
	 */
	public void setLoanSchemeId(Integer loanSchemeId) {
		this.loanSchemeId = loanSchemeId;
	}

	/**
	 * @return the loanVariantId
	 */
	public Integer getLoanVariantId() {
		return loanVariantId;
	}

	/**
	 * @param loanVariantId the loanVariantId to set
	 */
	public void setLoanVariantId(Integer loanVariantId) {
		this.loanVariantId = loanVariantId;
	}

	/**
	 * @return the loanVariantName
	 */
	public String getLoanVariantName() {
		return loanVariantName;
	}

	/**
	 * @param loanVariantName the loanVariantName to set
	 */
	public void setLoanVariantName(String loanVariantName) {
		this.loanVariantName = loanVariantName;
	}

}
