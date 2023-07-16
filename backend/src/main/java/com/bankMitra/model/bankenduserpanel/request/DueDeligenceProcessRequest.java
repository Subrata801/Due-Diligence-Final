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
public class DueDeligenceProcessRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String newLoanApplication;
	private String existingAccount;
	private String cifNumberAvailable;
	private String cifNumber;
	private String borrowerName;
	private String creditSector;
	private String existingAccountNum;
	private String typeOfLoanScheme;
	private String e2eNumber;
	private Date moduleExpectedStartDate;
	private Date moduleExpectedCompletionDate;
	private String branchMaker;
	
	private String comments;	
	private String createdBy;
	
	private String loanAccountNo;
	private Date loanSanctionedDate;
	private Integer loanAmount;
	private String loanAmountInWords;
	private Integer loanTenor;
	private Integer revisedLoanTenor;
	private Date disbursementDate;
	private Date m4CurrentReviewSanctionDate;
	private Integer assetTypeId;
	private String releaseOfSecurityOnAccountClosure;
	private Date dateOfClosureOfLoan;
	private Integer accountTypeId;
	private Integer borrowerTypeId;
	private Integer professionId;
	private List<LoanFacility> loanFacilities;
	 
	/**
	 * @return the loanFacilities
	 */
	public List<LoanFacility> getLoanFacilities() {
		return loanFacilities;
	}
	/**
	 * @param loanFacilities the loanFacilities to set
	 */
	public void setLoanFacilities(List<LoanFacility> loanFacilities) {
		this.loanFacilities = loanFacilities;
	}
	/**
	 * @return the loanAccountNo
	 */
	public String getLoanAccountNo() {
		return loanAccountNo;
	}
	/**
	 * @param loanAccountNo the loanAccountNo to set
	 */
	public void setLoanAccountNo(String loanAccountNo) {
		this.loanAccountNo = loanAccountNo;
	}

	/**
	 * @return the loanSanctionedDate
	 */
	public Date getLoanSanctionedDate() {
		return loanSanctionedDate;
	}
	/**
	 * @param loanSanctionedDate the loanSanctionedDate to set
	 */
	public void setLoanSanctionedDate(Date loanSanctionedDate) {
		this.loanSanctionedDate = loanSanctionedDate;
	}
	/**
	 * @return the loanAmount
	 */
	public Integer getLoanAmount() {
		return loanAmount;
	}
	/**
	 * @param loanAmount the loanAmount to set
	 */
	public void setLoanAmount(Integer loanAmount) {
		this.loanAmount = loanAmount;
	}
	/**
	 * @return the loanAmountInWords
	 */
	public String getLoanAmountInWords() {
		return loanAmountInWords;
	}
	/**
	 * @param loanAmountInWords the loanAmountInWords to set
	 */
	public void setLoanAmountInWords(String loanAmountInWords) {
		this.loanAmountInWords = loanAmountInWords;
	}
	/**
	 * @return the loanTenor
	 */
	public Integer getLoanTenor() {
		return loanTenor;
	}
	/**
	 * @param loanTenor the loanTenor to set
	 */
	public void setLoanTenor(Integer loanTenor) {
		this.loanTenor = loanTenor;
	}
	/**
	 * @return the revisedLoanTenor
	 */
	public Integer getRevisedLoanTenor() {
		return revisedLoanTenor;
	}
	/**
	 * @param revisedLoanTenor the revisedLoanTenor to set
	 */
	public void setRevisedLoanTenor(Integer revisedLoanTenor) {
		this.revisedLoanTenor = revisedLoanTenor;
	}
	/**
	 * @return the disbursementDate
	 */
	public Date getDisbursementDate() {
		return disbursementDate;
	}
	/**
	 * @param disbursementDate the disbursementDate to set
	 */
	public void setDisbursementDate(Date disbursementDate) {
		this.disbursementDate = disbursementDate;
	}
	/**
	 * @return the m4CurrentReviewSanctionDate
	 */
	public Date getM4CurrentReviewSanctionDate() {
		return m4CurrentReviewSanctionDate;
	}
	/**
	 * @param m4CurrentReviewSanctionDate the m4CurrentReviewSanctionDate to set
	 */
	public void setM4CurrentReviewSanctionDate(Date m4CurrentReviewSanctionDate) {
		this.m4CurrentReviewSanctionDate = m4CurrentReviewSanctionDate;
	}
	/**
	 * @return the assetTypeId
	 */
	public Integer getAssetTypeId() {
		return assetTypeId;
	}
	/**
	 * @param assetTypeId the assetTypeId to set
	 */
	public void setAssetTypeId(Integer assetTypeId) {
		this.assetTypeId = assetTypeId;
	}
	/**
	 * @return the releaseOfSecurityOnAccountClosure
	 */
	public String getReleaseOfSecurityOnAccountClosure() {
		return releaseOfSecurityOnAccountClosure;
	}
	/**
	 * @param releaseOfSecurityOnAccountClosure the releaseOfSecurityOnAccountClosure to set
	 */
	public void setReleaseOfSecurityOnAccountClosure(String releaseOfSecurityOnAccountClosure) {
		this.releaseOfSecurityOnAccountClosure = releaseOfSecurityOnAccountClosure;
	}
	/**
	 * @return the dateOfClosureOfLoan
	 */
	public Date getDateOfClosureOfLoan() {
		return dateOfClosureOfLoan;
	}
	/**
	 * @param dateOfClosureOfLoan the dateOfClosureOfLoan to set
	 */
	public void setDateOfClosureOfLoan(Date dateOfClosureOfLoan) {
		this.dateOfClosureOfLoan = dateOfClosureOfLoan;
	}
	/**
	 * @return the accountTypeId
	 */
	public Integer getAccountTypeId() {
		return accountTypeId;
	}
	/**
	 * @param accountTypeId the accountTypeId to set
	 */
	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}
	/**
	 * @return the borrowerTypeId
	 */
	public Integer getBorrowerTypeId() {
		return borrowerTypeId;
	}
	/**
	 * @param borrowerTypeId the borrowerTypeId to set
	 */
	public void setBorrowerTypeId(Integer borrowerTypeId) {
		this.borrowerTypeId = borrowerTypeId;
	}
	/**
	 * @return the professionId
	 */
	public Integer getProfessionId() {
		return professionId;
	}
	/**
	 * @param professionId the professionId to set
	 */
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}
	/**
	 * @return the newLoanApplication
	 */
	public String getNewLoanApplication() {
		return newLoanApplication;
	}
	/**
	 * @param newLoanApplication the newLoanApplication to set
	 */
	public void setNewLoanApplication(String newLoanApplication) {
		this.newLoanApplication = newLoanApplication;
	}
	/**
	 * @return the existingAccount
	 */
	public String getExistingAccount() {
		return existingAccount;
	}
	/**
	 * @param existingAccount the existingAccount to set
	 */
	public void setExistingAccount(String existingAccount) {
		this.existingAccount = existingAccount;
	}
	/**
	 * @return the cifNumberAvailable
	 */
	public String getCifNumberAvailable() {
		return cifNumberAvailable;
	}
	/**
	 * @param cifNumberAvailable the cifNumberAvailable to set
	 */
	public void setCifNumberAvailable(String cifNumberAvailable) {
		this.cifNumberAvailable = cifNumberAvailable;
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
	 * @return the borrowerName
	 */
	public String getBorrowerName() {
		return borrowerName;
	}
	/**
	 * @param borrowerName the borrowerName to set
	 */
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	/**
	 * @return the creditSector
	 */
	public String getCreditSector() {
		return creditSector;
	}
	/**
	 * @param creditSector the creditSector to set
	 */
	public void setCreditSector(String creditSector) {
		this.creditSector = creditSector;
	}
	/**
	 * @return the existingAccountNum
	 */
	public String getExistingAccountNum() {
		return existingAccountNum;
	}
	/**
	 * @param existingAccountNum the existingAccountNum to set
	 */
	public void setExistingAccountNum(String existingAccountNum) {
		this.existingAccountNum = existingAccountNum;
	}
	/**
	 * @return the typeOfLoanScheme
	 */
	public String getTypeOfLoanScheme() {
		return typeOfLoanScheme;
	}
	/**
	 * @param typeOfLoanScheme the typeOfLoanScheme to set
	 */
	public void setTypeOfLoanScheme(String typeOfLoanScheme) {
		this.typeOfLoanScheme = typeOfLoanScheme;
	}
	/**
	 * @return the e2eNumber
	 */
	public String getE2eNumber() {
		return e2eNumber;
	}
	/**
	 * @param e2eNumber the e2eNumber to set
	 */
	public void setE2eNumber(String e2eNumber) {
		this.e2eNumber = e2eNumber;
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
	 * @return the moduleExpectedCompletionDate
	 */
	public Date getModuleExpectedCompletionDate() {
		return moduleExpectedCompletionDate;
	}
	/**
	 * @param moduleExpectedCompletionDate the moduleExpectedCompletionDate to set
	 */
	public void setModuleExpectedCompletionDate(Date moduleExpectedCompletionDate) {
		this.moduleExpectedCompletionDate = moduleExpectedCompletionDate;
	}
	/**
	 * @return the branchMaker
	 */
	public String getBranchMaker() {
		return branchMaker;
	}
	/**
	 * @param branchMaker the branchMaker to set
	 */
	public void setBranchMaker(String branchMaker) {
		this.branchMaker = branchMaker;
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

}
