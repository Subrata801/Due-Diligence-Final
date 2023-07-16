/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class LoanVariantDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -111056915949624318L;

	private String loanVariantId;
	
	private String loanVariantName;
	
	private String keyword;

	/**
	 * @return the loanVariantId
	 */
	public String getLoanVariantId() {
		return loanVariantId;
	}

	/**
	 * @param loanVariantId the loanVariantId to set
	 */
	public void setLoanVariantId(String loanVariantId) {
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

	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
}
