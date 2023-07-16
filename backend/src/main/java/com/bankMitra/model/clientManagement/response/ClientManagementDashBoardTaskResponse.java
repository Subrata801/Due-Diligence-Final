/**
 * 
 */
package com.bankMitra.model.clientManagement.response;

import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class ClientManagementDashBoardTaskResponse {
	
	private String module;
	
	private String e2eApplicationNum;
	
	private String applicationName;
	
	private String loanAccountNum;
	
	private Date moduleExpectedStartDate;
	
	private Date moduleExpectedEndDate;
	
	private Date dateOfAcceptance;
	
	private Date dateOfDisbursement;
	
	private String loanAmount;
	
	private Integer loanTenure;
	
	private Integer remainingTenure;
	
	private String messageCode;
	
	private String messageDescription;

	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * @return the e2eApplicationNum
	 */
	public String getE2eApplicationNum() {
		return e2eApplicationNum;
	}

	/**
	 * @param e2eApplicationNum the e2eApplicationNum to set
	 */
	public void setE2eApplicationNum(String e2eApplicationNum) {
		this.e2eApplicationNum = e2eApplicationNum;
	}

	/**
	 * @return the applicationName
	 */
	public String getApplicationName() {
		return applicationName;
	}

	/**
	 * @param applicationName the applicationName to set
	 */
	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	/**
	 * @return the loanAccountNum
	 */
	public String getLoanAccountNum() {
		return loanAccountNum;
	}

	/**
	 * @param loanAccountNum the loanAccountNum to set
	 */
	public void setLoanAccountNum(String loanAccountNum) {
		this.loanAccountNum = loanAccountNum;
	}

	/**
	 * @return the moduleExpectedStartDate
	 */
	public Date getModuleExpectedStartDate() {
		return moduleExpectedStartDate;
	}

	/**
	 * @param moduleExpectedStartDate the moduleExpectedStartDate to set
	 */
	public void setModuleExpectedStartDate(Date moduleExpectedStartDate) {
		this.moduleExpectedStartDate = moduleExpectedStartDate;
	}

	/**
	 * @return the moduleExpectedEndDate
	 */
	public Date getModuleExpectedEndDate() {
		return moduleExpectedEndDate;
	}

	/**
	 * @param moduleExpectedEndDate the moduleExpectedEndDate to set
	 */
	public void setModuleExpectedEndDate(Date moduleExpectedEndDate) {
		this.moduleExpectedEndDate = moduleExpectedEndDate;
	}

	/**
	 * @return the dateOfAcceptance
	 */
	public Date getDateOfAcceptance() {
		return dateOfAcceptance;
	}

	/**
	 * @param dateOfAcceptance the dateOfAcceptance to set
	 */
	public void setDateOfAcceptance(Date dateOfAcceptance) {
		this.dateOfAcceptance = dateOfAcceptance;
	}

	/**
	 * @return the dateOfDisbursement
	 */
	public Date getDateOfDisbursement() {
		return dateOfDisbursement;
	}

	/**
	 * @param dateOfDisbursement the dateOfDisbursement to set
	 */
	public void setDateOfDisbursement(Date dateOfDisbursement) {
		this.dateOfDisbursement = dateOfDisbursement;
	}

	/**
	 * @return the loanAmount
	 */
	public String getLoanAmount() {
		return loanAmount;
	}

	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(String loanAmount) {
		this.loanAmount = loanAmount;
	}

	/**
	 * @return the loanTenure
	 */
	public Integer getLoanTenure() {
		return loanTenure;
	}

	/**
	 * @param loanTenure the loanTenure to set
	 */
	public void setLoanTenure(Integer loanTenure) {
		this.loanTenure = loanTenure;
	}

	/**
	 * @return the remainingTenure
	 */
	public Integer getRemainingTenure() {
		return remainingTenure;
	}

	/**
	 * @param remainingTenure the remainingTenure to set
	 */
	public void setRemainingTenure(Integer remainingTenure) {
		this.remainingTenure = remainingTenure;
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
	
}
