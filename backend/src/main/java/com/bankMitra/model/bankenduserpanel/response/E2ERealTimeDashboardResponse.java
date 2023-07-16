/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.Date;


/**
 * @author Bank Maitra
 *
 */
public class E2ERealTimeDashboardResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String moduleName;
	
	private String e2eNum;
	
	private String bankName;
	
	private String branchName;
	
	private String ifscCode;
	
	private String borrowerName;
	
	private Date dateField;
	
	private String cifNumber;
	
	private String loanApplicationNum;
	
	private String applicationStatus;
	
	private Date reviewScheduleDate;
	
	private String userName;
	
	private String applicationFinalStatus;
	
	private String createdBy;
	
	private String zoName;
	
	private String cpcName;
	
	private String messageCode;
	
	private String messageDescription;
	
	private Integer m4ReviewNo;
	
	private Integer m5SecurityReleaseNo;

	
	public Integer getM4ReviewNo() {
		return m4ReviewNo;
	}

	public void setM4ReviewNo(Integer m4ReviewNo) {
		this.m4ReviewNo = m4ReviewNo;
	}

	public Integer getM5SecurityReleaseNo() {
		return m5SecurityReleaseNo;
	}

	public void setM5SecurityReleaseNo(Integer m5SecurityReleaseNo) {
		this.m5SecurityReleaseNo = m5SecurityReleaseNo;
	}

	/**
	 * @return the zoName
	 */
	public String getZoName() {
		return zoName;
	}

	/**
	 * @param zoName the zoName to set
	 */
	public void setZoName(String zoName) {
		this.zoName = zoName;
	}

	/**
	 * @return the cpcName
	 */
	public String getCpcName() {
		return cpcName;
	}

	/**
	 * @param cpcName the cpcName to set
	 */
	public void setCpcName(String cpcName) {
		this.cpcName = cpcName;
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

	/**
	 * @return the messageCode
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param messageCode the messageCode to set
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @return the messageDescription
	 */
	public String getMessageDescription() {
		return messageDescription;
	}

	/**
	 * @param messageDescription the messageDescription to set
	 */
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

}
