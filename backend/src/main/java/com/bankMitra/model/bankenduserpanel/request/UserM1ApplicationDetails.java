/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class UserM1ApplicationDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

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

}
