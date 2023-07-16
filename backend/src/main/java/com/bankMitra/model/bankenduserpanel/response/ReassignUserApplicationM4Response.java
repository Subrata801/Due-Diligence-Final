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
public class ReassignUserApplicationM4Response extends ReassignUserApplicationResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	
    private Date date;
	
	private String e2eNum;
	
	private String nameOfApplicant;
	
	private String appStatus;
	
	private String appFinalStatus;
	
	private String maker;
	
	private String checker;
	
    private String sanctioningAuth;
	
	private String cancelApplication;
	
	private String reasonOfCancellation;

	
    private String createdBy;
	
	private String messageCode;
	
	private String messageDescription;

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
