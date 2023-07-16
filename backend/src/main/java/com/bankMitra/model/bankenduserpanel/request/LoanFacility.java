/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bankMitra.model.bankenduserpanel.response.CoApplicantDetails;
import com.bankMitra.model.bankenduserpanel.response.ComercialCreditFacilityDetails;
import com.bankMitra.model.bankenduserpanel.response.GuarantorDetails;

/**
 * @author BankMitra
 *
 */
public class LoanFacility implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private Integer facility;
	private String accountNum;
	private Date dateOfSanction;
	private Integer sanctionedLimit;
	private String sanctionedLimitWords;
	private Integer loanTenor;
	
	
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
	
	public String getAccountNum() {
		return accountNum;
	}
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
