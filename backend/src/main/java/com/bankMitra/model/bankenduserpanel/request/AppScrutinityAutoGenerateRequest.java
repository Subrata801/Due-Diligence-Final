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
public class AppScrutinityAutoGenerateRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String e2eNum;
	
	private Date e2eDate;
	
	private Date e2eM3ExpectedStartDate;
	
	private Date e2eM4ExpectedStartDate;
	
	private String e2eM4ReviewNum;
	
	private Date e2eM4ReviewDate;
	
	private String e2eM5SecurityReleaseNum;
	
	private Date e2eM5Date;
	
	private String branchName;
	
	private String ifscCode;
	
	private String createdBy;

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
	 * @return the e2eDate
	 */
	public Date getE2eDate() {
		return e2eDate;
	}

	/**
	 * @param e2eDate the e2eDate to set
	 */
	public void setE2eDate(Date e2eDate) {
		this.e2eDate = e2eDate;
	}

	/**
	 * @return the e2eM3ExpectedStartDate
	 */
	public Date getE2eM3ExpectedStartDate() {
		return e2eM3ExpectedStartDate;
	}

	/**
	 * @param e2eM3ExpectedStartDate the e2eM3ExpectedStartDate to set
	 */
	public void setE2eM3ExpectedStartDate(Date e2eM3ExpectedStartDate) {
		this.e2eM3ExpectedStartDate = e2eM3ExpectedStartDate;
	}

	/**
	 * @return the e2eM4ExpectedStartDate
	 */
	public Date getE2eM4ExpectedStartDate() {
		return e2eM4ExpectedStartDate;
	}

	/**
	 * @param e2eM4ExpectedStartDate the e2eM4ExpectedStartDate to set
	 */
	public void setE2eM4ExpectedStartDate(Date e2eM4ExpectedStartDate) {
		this.e2eM4ExpectedStartDate = e2eM4ExpectedStartDate;
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
	 * @return the e2eM4ReviewDate
	 */
	public Date getE2eM4ReviewDate() {
		return e2eM4ReviewDate;
	}

	/**
	 * @param e2eM4ReviewDate the e2eM4ReviewDate to set
	 */
	public void setE2eM4ReviewDate(Date e2eM4ReviewDate) {
		this.e2eM4ReviewDate = e2eM4ReviewDate;
	}

	/**
	 * @return the e2eM5SecurityReleaseNum
	 */
	public String getE2eM5SecurityReleaseNum() {
		return e2eM5SecurityReleaseNum;
	}

	/**
	 * @param e2eM5SecurityReleaseNum the e2eM5SecurityReleaseNum to set
	 */
	public void setE2eM5SecurityReleaseNum(String e2eM5SecurityReleaseNum) {
		this.e2eM5SecurityReleaseNum = e2eM5SecurityReleaseNum;
	}

	/**
	 * @return the e2eM5Date
	 */
	public Date getE2eM5Date() {
		return e2eM5Date;
	}

	/**
	 * @param e2eM5Date the e2eM5Date to set
	 */
	public void setE2eM5Date(Date e2eM5Date) {
		this.e2eM5Date = e2eM5Date;
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
