/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.List;

import com.bankMitra.model.bankenduserpanel.request.AppScrutinityAutoGenerateRequest;

/**
 * @author BankMitra
 *
 */
public class NewDueDeligenceProcessResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String module1Name;
	private String module2Name;
	private String module3Name;
	private String module4Name;
	private String module5Name;
	private String dueDeligenceOfNewApp;
	private String dueDeligenceOfExistingAccount;
	private String loanAppNum;
	private String loanAppDate;
	private String availabilityOfCifNum;
	private String cifNum;
	private String boorrowerName;
	private String securityType;
	private String existingLoanAcctNum;
	private String loanSchemeName;
	private String loanVariant;
	private String e2eExistingLoanAcount;
	private String assignBranchMaker;
	private String comments;
	private List<AppScrutinityAutoGenerateRequest> autoGenerate;
	private String createdBy;
	
	private String messageCode;
	
	private String messageDescription;

	/**
	 * @return the module1Name
	 */
	public String getModule1Name() {
		return module1Name;
	}
	/**
	 * @param module1Name the module1Name to set
	 */
	public void setModule1Name(String module1Name) {
		this.module1Name = module1Name;
	}
	/**
	 * @return the module2Name
	 */
	public String getModule2Name() {
		return module2Name;
	}
	/**
	 * @param module2Name the module2Name to set
	 */
	public void setModule2Name(String module2Name) {
		this.module2Name = module2Name;
	}
	/**
	 * @return the module3Name
	 */
	public String getModule3Name() {
		return module3Name;
	}
	/**
	 * @param module3Name the module3Name to set
	 */
	public void setModule3Name(String module3Name) {
		this.module3Name = module3Name;
	}
	/**
	 * @return the module4Name
	 */
	public String getModule4Name() {
		return module4Name;
	}
	/**
	 * @param module4Name the module4Name to set
	 */
	public void setModule4Name(String module4Name) {
		this.module4Name = module4Name;
	}
	/**
	 * @return the module5Name
	 */
	public String getModule5Name() {
		return module5Name;
	}
	/**
	 * @param module5Name the module5Name to set
	 */
	public void setModule5Name(String module5Name) {
		this.module5Name = module5Name;
	}
	/**
	 * @return the dueDeligenceOfNewApp
	 */
	public String getDueDeligenceOfNewApp() {
		return dueDeligenceOfNewApp;
	}
	/**
	 * @param dueDeligenceOfNewApp the dueDeligenceOfNewApp to set
	 */
	public void setDueDeligenceOfNewApp(String dueDeligenceOfNewApp) {
		this.dueDeligenceOfNewApp = dueDeligenceOfNewApp;
	}
	/**
	 * @return the dueDeligenceOfExistingAccount
	 */
	public String getDueDeligenceOfExistingAccount() {
		return dueDeligenceOfExistingAccount;
	}
	/**
	 * @param dueDeligenceOfExistingAccount the dueDeligenceOfExistingAccount to set
	 */
	public void setDueDeligenceOfExistingAccount(String dueDeligenceOfExistingAccount) {
		this.dueDeligenceOfExistingAccount = dueDeligenceOfExistingAccount;
	}
	/**
	 * @return the loanAppNum
	 */
	public String getLoanAppNum() {
		return loanAppNum;
	}
	/**
	 * @param loanAppNum the loanAppNum to set
	 */
	public void setLoanAppNum(String loanAppNum) {
		this.loanAppNum = loanAppNum;
	}
	/**
	 * @return the loanAppDate
	 */
	public String getLoanAppDate() {
		return loanAppDate;
	}
	/**
	 * @param loanAppDate the loanAppDate to set
	 */
	public void setLoanAppDate(String loanAppDate) {
		this.loanAppDate = loanAppDate;
	}
	/**
	 * @return the availabilityOfCifNum
	 */
	public String getAvailabilityOfCifNum() {
		return availabilityOfCifNum;
	}
	/**
	 * @param availabilityOfCifNum the availabilityOfCifNum to set
	 */
	public void setAvailabilityOfCifNum(String availabilityOfCifNum) {
		this.availabilityOfCifNum = availabilityOfCifNum;
	}
	/**
	 * @return the cifNum
	 */
	public String getCifNum() {
		return cifNum;
	}
	/**
	 * @param cifNum the cifNum to set
	 */
	public void setCifNum(String cifNum) {
		this.cifNum = cifNum;
	}
	/**
	 * @return the boorrowerName
	 */
	public String getBoorrowerName() {
		return boorrowerName;
	}
	/**
	 * @param boorrowerName the boorrowerName to set
	 */
	public void setBoorrowerName(String boorrowerName) {
		this.boorrowerName = boorrowerName;
	}
	/**
	 * @return the securityType
	 */
	public String getSecurityType() {
		return securityType;
	}
	/**
	 * @param securityType the securityType to set
	 */
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	/**
	 * @return the existingLoanAcctNum
	 */
	public String getExistingLoanAcctNum() {
		return existingLoanAcctNum;
	}
	/**
	 * @param existingLoanAcctNum the existingLoanAcctNum to set
	 */
	public void setExistingLoanAcctNum(String existingLoanAcctNum) {
		this.existingLoanAcctNum = existingLoanAcctNum;
	}
	/**
	 * @return the loanSchemeName
	 */
	public String getLoanSchemeName() {
		return loanSchemeName;
	}
	/**
	 * @param loanSchemeName the loanSchemeName to set
	 */
	public void setLoanSchemeName(String loanSchemeName) {
		this.loanSchemeName = loanSchemeName;
	}
	/**
	 * @return the loanVariant
	 */
	public String getLoanVariant() {
		return loanVariant;
	}
	/**
	 * @param loanVariant the loanVariant to set
	 */
	public void setLoanVariant(String loanVariant) {
		this.loanVariant = loanVariant;
	}
	/**
	 * @return the e2eExistingLoanAcount
	 */
	public String getE2eExistingLoanAcount() {
		return e2eExistingLoanAcount;
	}
	/**
	 * @param e2eExistingLoanAcount the e2eExistingLoanAcount to set
	 */
	public void setE2eExistingLoanAcount(String e2eExistingLoanAcount) {
		this.e2eExistingLoanAcount = e2eExistingLoanAcount;
	}
	/**
	 * @return the assignBranchMaker
	 */
	public String getAssignBranchMaker() {
		return assignBranchMaker;
	}
	/**
	 * @param assignBranchMaker the assignBranchMaker to set
	 */
	public void setAssignBranchMaker(String assignBranchMaker) {
		this.assignBranchMaker = assignBranchMaker;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
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
	 * @return the autoGenerate
	 */
	public List<AppScrutinityAutoGenerateRequest> getAutoGenerate() {
		return autoGenerate;
	}
	/**
	 * @param autoGenerate the autoGenerate to set
	 */
	public void setAutoGenerate(List<AppScrutinityAutoGenerateRequest> autoGenerate) {
		this.autoGenerate = autoGenerate;
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
