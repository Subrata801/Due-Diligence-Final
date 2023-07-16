/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bankMitra.model.bankenduserpanel.response.CoApplicantDetails;
import com.bankMitra.model.bankenduserpanel.response.ComercialCreditFacilityDetails;
import com.bankMitra.model.bankenduserpanel.response.GuarantorDetails;

/**
 * @author BankMitra
 *
 */
public class NewDueDeligenceProcessRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String module1Name;
	private String module2Name;
	private String module3Name;
	private String module4Name;
	private String module5Name;
	private String moduleName;
	private String dueDeligenceOfNewApp;
	private String dueDeligenceOfExistingAccount;
	private String loanAppNum;
	private String loanAppDate;
	private String availabilityOfCifNum;
	private String cifNum;
	private String boorrowerName;
	private String selectCreditSector;
	private String existingLoanAcctNum;
	private String selectLoanScheme;
	private String selectLoanVariant;
	private String e2eExistingLoanAcount;
	private Date startDate;
	private Date endDate;
	private String assignBranchMaker;
	private String assignBranchChecker;
	private String cpcChecker;
	private String cpcSA;
	private String zoChecker;
	private String zoSA;
	private String hoChecker;
	private String hoSA;
	private String comments;
	private List<AppScrutinityAutoGenerateRequest> autoGenerate;
	private String createdBy;
	
	
	/**
	 * @return the assignBranchChecker
	 */
	public String getAssignBranchChecker() {
		return assignBranchChecker;
	}
	/**
	 * @param assignBranchChecker the assignBranchChecker to set
	 */
	public void setAssignBranchChecker(String assignBranchChecker) {
		this.assignBranchChecker = assignBranchChecker;
	}
	/**
	 * @return the cpcChecker
	 */
	public String getCpcChecker() {
		return cpcChecker;
	}
	/**
	 * @param cpcChecker the cpcChecker to set
	 */
	public void setCpcChecker(String cpcChecker) {
		this.cpcChecker = cpcChecker;
	}
	/**
	 * @return the cpcSA
	 */
	public String getCpcSA() {
		return cpcSA;
	}
	/**
	 * @param cpcSA the cpcSA to set
	 */
	public void setCpcSA(String cpcSA) {
		this.cpcSA = cpcSA;
	}
	/**
	 * @return the zoChecker
	 */
	public String getZoChecker() {
		return zoChecker;
	}
	/**
	 * @param zoChecker the zoChecker to set
	 */
	public void setZoChecker(String zoChecker) {
		this.zoChecker = zoChecker;
	}
	/**
	 * @return the zoSA
	 */
	public String getZoSA() {
		return zoSA;
	}
	/**
	 * @param zoSA the zoSA to set
	 */
	public void setZoSA(String zoSA) {
		this.zoSA = zoSA;
	}
	/**
	 * @return the hoChecker
	 */
	public String getHoChecker() {
		return hoChecker;
	}
	/**
	 * @param hoChecker the hoChecker to set
	 */
	public void setHoChecker(String hoChecker) {
		this.hoChecker = hoChecker;
	}
	/**
	 * @return the hoSA
	 */
	public String getHoSA() {
		return hoSA;
	}
	/**
	 * @param hoSA the hoSA to set
	 */
	public void setHoSA(String hoSA) {
		this.hoSA = hoSA;
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
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
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
	 * @return the selectCreditSector
	 */
	public String getSelectCreditSector() {
		return selectCreditSector;
	}
	/**
	 * @param selectCreditSector the selectCreditSector to set
	 */
	public void setSelectCreditSector(String selectCreditSector) {
		this.selectCreditSector = selectCreditSector;
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
	 * @return the selectLoanScheme
	 */
	public String getSelectLoanScheme() {
		return selectLoanScheme;
	}
	/**
	 * @param selectLoanScheme the selectLoanScheme to set
	 */
	public void setSelectLoanScheme(String selectLoanScheme) {
		this.selectLoanScheme = selectLoanScheme;
	}
	/**
	 * @return the selectLoanVariant
	 */
	public String getSelectLoanVariant() {
		return selectLoanVariant;
	}
	/**
	 * @param selectLoanVariant the selectLoanVariant to set
	 */
	public void setSelectLoanVariant(String selectLoanVariant) {
		this.selectLoanVariant = selectLoanVariant;
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
