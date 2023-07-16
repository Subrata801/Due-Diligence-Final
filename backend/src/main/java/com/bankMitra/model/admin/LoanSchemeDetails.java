/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class LoanSchemeDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6275659296458835173L;

	private Integer loanSchemeId;
	
	private String loanSchemeName;
	
	private String keyword;
	
	private String worksheetName;

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

	/**
	 * @return the worksheetName
	 */
	public String getWorksheetName() {
		return worksheetName;
	}

	/**
	 * @param worksheetName the worksheetName to set
	 */
	public void setWorksheetName(String worksheetName) {
		this.worksheetName = worksheetName;
	}
	
	
}
