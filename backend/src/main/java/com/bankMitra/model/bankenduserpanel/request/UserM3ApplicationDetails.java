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
public class UserM3ApplicationDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private Date date;
	
	private String e2eNum;
	
	private String nameOfBorrower;
	
	private String accountNum;
	
	private Date expectedStartDate;
	
	private String appStatus;
	
	private String maker;
	
	private String checker;
	
	private String sanctionAuthority;
	
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
	 * @return the accountNum
	 */
	public String getAccountNum() {
		return accountNum;
	}

	/**
	 * @param accountNum the accountNum to set
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
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
	 * @return the sanctionAuthority
	 */
	public String getSanctionAuthority() {
		return sanctionAuthority;
	}

	/**
	 * @param sanctionAuthority the sanctionAuthority to set
	 */
	public void setSanctionAuthority(String sanctionAuthority) {
		this.sanctionAuthority = sanctionAuthority;
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
