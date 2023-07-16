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
public class LoanSchemes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Loan Scheme Id")
	private Integer loanSchemeId;
	
	@ApiModelProperty(notes = "Loan Scheme Name")
	private String loanSchemeName;

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
	 * @return the loanSchemeName
	 */
	public String getLoanSchemeName() {
		return loanSchemeName;
	}

	/**
	 * @param loanSchemeName the loanSchemeName to set
	 */
	public void setLoanSchemeName(String loanSchemeName) {
		this.loanSchemeName = loanSchemeName;
	}

}
