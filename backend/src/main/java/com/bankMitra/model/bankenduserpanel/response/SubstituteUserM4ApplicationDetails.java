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
public class SubstituteUserM4ApplicationDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private Date date;
	
	private String e2eNum;
	
	private String e2eReviewNum;
	
	private String nameOfBorrower;
	
	private String nameOfApplicant;
	
	private String cifNum;
	
	private String loanAppNum;
	
	private Date expectedStartDate;
	
	private String appStatus;
	
	private String appFinalStatus;
	
	private String maker;
	
	private String checker;
	
	private String sanctioningAuth;
	
	private String cancelApplication;
	
	private String reasonOfCancellation;
	
	private String createdBy;

	/**
	 * @return the nameOfBorrower
	 */
	public String getNameOfBorrower() {
		return nameOfBorrower;
	}

	/**
	 * @param nameOfBorrower the nameOfBorrower to set
	 */
	public void setNameOfBorrower(String nameOfBorrower) {
		this.nameOfBorrower = nameOfBorrower;
	}

	/**
	 * @return the e2eReviewNum
	 */
	public String getE2eReviewNum() {
		return e2eReviewNum;
	}

	/**
	 * @param e2eReviewNum the e2eReviewNum to set
	 */
	public void setE2eReviewNum(String e2eReviewNum) {
		this.e2eReviewNum = e2eReviewNum;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the e2eNum
	 */
	public String getE2eNum() {
		return e2eNum;
	}

	/**
	 * @param e2eNum the e2eNum to set
	 */
	public void setE2eNum(String e2eNum) {
		this.e2eNum = e2eNum;
	}

	/**
	 * @return the nameOfApplicant
	 */
	public String getNameOfApplicant() {
		return nameOfApplicant;
	}

	/**
	 * @param nameOfApplicant the nameOfApplicant to set
	 */
	public void setNameOfApplicant(String nameOfApplicant) {
		this.nameOfApplicant = nameOfApplicant;
	}

	/**
	 * @return the cifNum
	 */
	public String getCifNum() {
		return cifNum;
	}

	/**
	 * @param cifNum the cifNum to set
	 */
	public void setCifNum(String cifNum) {
		this.cifNum = cifNum;
	}

	/**
	 * @return the loanAppNum
	 */
	public String getLoanAppNum() {
		return loanAppNum;
	}

	/**
	 * @param loanAppNum the loanAppNum to set
	 */
	public void setLoanAppNum(String loanAppNum) {
		this.loanAppNum = loanAppNum;
	}

	/**
	 * @return the expectedStartDate
	 */
	public Date getExpectedStartDate() {
		return expectedStartDate;
	}

	/**
	 * @param expectedStartDate the expectedStartDate to set
	 */
	public void setExpectedStartDate(Date expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	/**
	 * @return the appStatus
	 */
	public String getAppStatus() {
		return appStatus;
	}

	/**
	 * @param appStatus the appStatus to set
	 */
	public void setAppStatus(String appStatus) {
		this.appStatus = appStatus;
	}

	/**
	 * @return the appFinalStatus
	 */
	public String getAppFinalStatus() {
		return appFinalStatus;
	}

	/**
	 * @param appFinalStatus the appFinalStatus to set
	 */
	public void setAppFinalStatus(String appFinalStatus) {
		this.appFinalStatus = appFinalStatus;
	}

	/**
	 * @return the maker
	 */
	public String getMaker() {
		return maker;
	}

	/**
	 * @param maker the maker to set
	 */
	public void setMaker(String maker) {
		this.maker = maker;
	}

	/**
	 * @return the checker
	 */
	public String getChecker() {
		return checker;
	}

	/**
	 * @param checker the checker to set
	 */
	public void setChecker(String checker) {
		this.checker = checker;
	}

	/**
	 * @return the sanctioningAuth
	 */
	public String getSanctioningAuth() {
		return sanctioningAuth;
	}

	/**
	 * @param sanctioningAuth the sanctioningAuth to set
	 */
	public void setSanctioningAuth(String sanctioningAuth) {
		this.sanctioningAuth = sanctioningAuth;
	}

	/**
	 * @return the cancelApplication
	 */
	public String getCancelApplication() {
		return cancelApplication;
	}

	/**
	 * @param cancelApplication the cancelApplication to set
	 */
	public void setCancelApplication(String cancelApplication) {
		this.cancelApplication = cancelApplication;
	}

	/**
	 * @return the reasonOfCancellation
	 */
	public String getReasonOfCancellation() {
		return reasonOfCancellation;
	}

	/**
	 * @param reasonOfCancellation the reasonOfCancellation to set
	 */
	public void setReasonOfCancellation(String reasonOfCancellation) {
		this.reasonOfCancellation = reasonOfCancellation;
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
