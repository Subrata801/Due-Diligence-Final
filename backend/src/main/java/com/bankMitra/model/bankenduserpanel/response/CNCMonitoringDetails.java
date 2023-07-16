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
public class CNCMonitoringDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private Date date;
	
	private String cncNum;
	
	private String nameOfBorrower;
	
	private String cifNumber;
	
	private String auditStatus;
	
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
	 * @return the cncNum
	 */
	public String getCncNum() {
		return cncNum;
	}

	/**
	 * @param cncNum the cncNum to set
	 */
	public void setCncNum(String cncNum) {
		this.cncNum = cncNum;
	}

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
	 * @return the auditStatus
	 */
	public String getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @param auditStatus the auditStatus to set
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
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
