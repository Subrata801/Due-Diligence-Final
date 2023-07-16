/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class ComercialCreditFacilityDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String loanAppId;
	
	private Integer facility;
	
	private String accountNum;
	
	private Date dateOfSanction;
	
	private Integer sanctionedLimit;
	
	private String sanctionedLimitWords;
	
	private Integer loanTenor;

	
	/**
	 * @return the loanAppId
	 */
	public String getLoanAppId() {
		return loanAppId;
	}

	/**
	 * @param loanAppId the loanAppId to set
	 */
	public void setLoanAppId(String loanAppId) {
		this.loanAppId = loanAppId;
	}

	/**
	 * @return the facility
	 */
	public Integer getFacility() {
		return facility;
	}

	/**
	 * @param facility the facility to set
	 */
	public void setFacility(Integer facility) {
		this.facility = facility;
	}

	/**
	 * @return the accountNum
	 */
	public String getAccountNum() {
		return accountNum;
	}

	/**
	 * @param accountNum the accountNum to set
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	/**
	 * @return the dateOfSanction
	 */
	public Date getDateOfSanction() {
		return dateOfSanction;
	}

	/**
	 * @param dateOfSanction the dateOfSanction to set
	 */
	public void setDateOfSanction(Date dateOfSanction) {
		this.dateOfSanction = dateOfSanction;
	}

	/**
	 * @return the sanctionedLimit
	 */
	public Integer getSanctionedLimit() {
		return sanctionedLimit;
	}

	/**
	 * @param sanctionedLimit the sanctionedLimit to set
	 */
	public void setSanctionedLimit(Integer sanctionedLimit) {
		this.sanctionedLimit = sanctionedLimit;
	}

	/**
	 * @return the sanctionedLimitWords
	 */
	public String getSanctionedLimitWords() {
		return sanctionedLimitWords;
	}

	/**
	 * @param sanctionedLimitWords the sanctionedLimitWords to set
	 */
	public void setSanctionedLimitWords(String sanctionedLimitWords) {
		this.sanctionedLimitWords = sanctionedLimitWords;
	}

	/**
	 * @return the loanTenor
	 */
	public Integer getLoanTenor() {
		return loanTenor;
	}

	/**
	 * @param loanTenor the loanTenor to set
	 */
	public void setLoanTenor(Integer loanTenor) {
		this.loanTenor = loanTenor;
	}
	
}
