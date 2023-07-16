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
public class M1MonitoringDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private Date date;
	
	private String e2eNum;
	
	private String nameOfApplicant;
	
	private String cifNumber;
	
	private String loanApplicationNum;
	
	private Date expectedStartDate;
	
	private String appStatus;
	
	private String appFinalStatus;
	
	private String userName;
	
	private String createdBy;

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
