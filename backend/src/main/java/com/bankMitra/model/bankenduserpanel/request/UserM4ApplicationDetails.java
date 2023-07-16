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
public class UserM4ApplicationDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private Date date;
	
	private String e2eNum;
	
	private String e2eM4ReviewNum;
	
	private String nameOfBorrower;
	
	private String appStatus;
	
	private String appFinalStatus;
	
	private String maker;
	
	private String checker;
	
	private String sanctioningAuthority;
	
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
	 * @return the e2eM4ReviewNum
	 */
	public String getE2eM4ReviewNum() {
		return e2eM4ReviewNum;
	}

	/**
	 * @param e2eM4ReviewNum the e2eM4ReviewNum to set
	 */
	public void setE2eM4ReviewNum(String e2eM4ReviewNum) {
		this.e2eM4ReviewNum = e2eM4ReviewNum;
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
	 * @return the sanctioningAuthority
	 */
	public String getSanctioningAuthority() {
		return sanctioningAuthority;
	}

	/**
	 * @param sanctioningAuthority the sanctioningAuthority to set
	 */
	public void setSanctioningAuthority(String sanctioningAuthority) {
		this.sanctioningAuthority = sanctioningAuthority;
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
