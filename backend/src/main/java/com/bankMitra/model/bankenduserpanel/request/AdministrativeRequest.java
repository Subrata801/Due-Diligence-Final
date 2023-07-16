/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class AdministrativeRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String e2eNumber;
	private String assignUnitMaker;
	private String unitChecker;
	private String unitSanctionAuthority;
	private String loanSanctionAuthority;
	private String numReviewsCompleted;	
	private String createdBy;
	
	
	/**
	 * @return the unitSanctionAuthority
	 */
	public String getUnitSanctionAuthority() {
		return unitSanctionAuthority;
	}
	/**
	 * @param unitSanctionAuthority the unitSanctionAuthority to set
	 */
	public void setUnitSanctionAuthority(String unitSanctionAuthority) {
		this.unitSanctionAuthority = unitSanctionAuthority;
	}
	/**
	 * @return the assignUnitMaker
	 */
	public String getAssignUnitMaker() {
		return assignUnitMaker;
	}
	/**
	 * @param assignUnitMaker the assignUnitMaker to set
	 */
	public void setAssignUnitMaker(String assignUnitMaker) {
		this.assignUnitMaker = assignUnitMaker;
	}
	/**
	 * @return the e2eNumber
	 */
	public String getE2eNumber() {
		return e2eNumber;
	}
	/**
	 * @param e2eNumber the e2eNumber to set
	 */
	public void setE2eNumber(String e2eNumber) {
		this.e2eNumber = e2eNumber;
	}
	/**
	 * @return the unitChecker
	 */
	public String getUnitChecker() {
		return unitChecker;
	}
	/**
	 * @param unitChecker the unitChecker to set
	 */
	public void setUnitChecker(String unitChecker) {
		this.unitChecker = unitChecker;
	}
	/**
	 * @return the loanSanctionAuthority
	 */
	public String getLoanSanctionAuthority() {
		return loanSanctionAuthority;
	}
	/**
	 * @param loanSanctionAuthority the loanSanctionAuthority to set
	 */
	public void setLoanSanctionAuthority(String loanSanctionAuthority) {
		this.loanSanctionAuthority = loanSanctionAuthority;
	}
	/**
	 * @return the numReviewsCompleted
	 */
	public String getNumReviewsCompleted() {
		return numReviewsCompleted;
	}
	/**
	 * @param numReviewsCompleted the numReviewsCompleted to set
	 */
	public void setNumReviewsCompleted(String numReviewsCompleted) {
		this.numReviewsCompleted = numReviewsCompleted;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	
}
