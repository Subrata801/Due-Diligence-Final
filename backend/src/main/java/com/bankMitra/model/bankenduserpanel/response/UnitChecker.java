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
public class UnitChecker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "User Name")
	private String userName;
	
	@ApiModelProperty(notes = "Full Name")
	private String fullName;

	private String unitMaker;
	
	private String unitChecker;
	
	private String unitSanctionAuthority;
	
	private String loanSanctionAuthority;
	
	private String numberOfReviewsCompleted;
	
	
	/**
	 * @return the unitMaker
	 */
	public String getUnitMaker() {
		return unitMaker;
	}

	/**
	 * @param unitMaker the unitMaker to set
	 */
	public void setUnitMaker(String unitMaker) {
		this.unitMaker = unitMaker;
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
	 * @return the numberOfReviewsCompleted
	 */
	public String getNumberOfReviewsCompleted() {
		return numberOfReviewsCompleted;
	}

	/**
	 * @param numberOfReviewsCompleted the numberOfReviewsCompleted to set
	 */
	public void setNumberOfReviewsCompleted(String numberOfReviewsCompleted) {
		this.numberOfReviewsCompleted = numberOfReviewsCompleted;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
