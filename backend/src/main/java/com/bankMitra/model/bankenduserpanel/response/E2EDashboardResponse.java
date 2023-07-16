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
public class E2EDashboardResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String moduleName;
	
	private String e2eNum;
	
	private String bankName;
	
	private String branchName;
	
	private String ifscCode;
	
	private String borrowerName;
	
	private Date dateField;
	
	private String cifNumber;
	
	private String reviewNum;
	
	private String loanApplicationNum;
	
	private String applicationStatus;
	
	private Date reviewScheduleDate;
	
	private String userName;
	
	private String applicationFinalStatus;
	
	private String createdBy;

	/**
	 * @return the reviewNum
	 */
	public String getReviewNum() {
		return reviewNum;
	}

	/**
	 * @param reviewNum the reviewNum to set
	 */
	public void setReviewNum(String reviewNum) {
		this.reviewNum = reviewNum;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the borrowerName
	 */
	public String getBorrowerName() {
		return borrowerName;
	}

	/**
	 * @param borrowerName the borrowerName to set
	 */
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}

	/**
	 * @return the dateField
	 */
	public Date getDateField() {
		return dateField;
	}

	/**
	 * @param dateField the dateField to set
	 */
	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}

	/**
	 * @return the cifNumber
	 */
	public String getCifNumber() {
		return cifNumber;
	}

	/**
	 * @param cifNumber the cifNumber to set
	 */
	public void setCifNumber(String cifNumber) {
		this.cifNumber = cifNumber;
	}

	/**
	 * @return the loanApplicationNum
	 */
	public String getLoanApplicationNum() {
		return loanApplicationNum;
	}

	/**
	 * @param loanApplicationNum the loanApplicationNum to set
	 */
	public void setLoanApplicationNum(String loanApplicationNum) {
		this.loanApplicationNum = loanApplicationNum;
	}

	/**
	 * @return the applicationStatus
	 */
	public String getApplicationStatus() {
		return applicationStatus;
	}

	/**
	 * @param applicationStatus the applicationStatus to set
	 */
	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	/**
	 * @return the reviewScheduleDate
	 */
	public Date getReviewScheduleDate() {
		return reviewScheduleDate;
	}

	/**
	 * @param reviewScheduleDate the reviewScheduleDate to set
	 */
	public void setReviewScheduleDate(Date reviewScheduleDate) {
		this.reviewScheduleDate = reviewScheduleDate;
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
	 * @return the applicationFinalStatus
	 */
	public String getApplicationFinalStatus() {
		return applicationFinalStatus;
	}

	/**
	 * @param applicationFinalStatus the applicationFinalStatus to set
	 */
	public void setApplicationFinalStatus(String applicationFinalStatus) {
		this.applicationFinalStatus = applicationFinalStatus;
	}

	/**
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
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
