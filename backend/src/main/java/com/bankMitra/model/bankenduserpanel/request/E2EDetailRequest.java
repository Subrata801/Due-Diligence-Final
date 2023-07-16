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
public class E2EDetailRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String e2eNum;
	private String reviewNumber;
	private String securityReleaseNumber;
	private String e2eDate;
	private String branchName;
	private String cifNumber;
	private String borrowerName;
	private String securityType;
	private String existingAccountNum;
	private String loanSchemeName;
	private String loanVariantName;
	private String e2eNumOfExistingAccount;
	private String accountNum;
	private Date dateOfTransaction;
	
	private Integer sanctionedAmount;
	private String sanctionedAmountInWords;
	private String loanTenor;
	private String revisedLoanTenor;
	private String loanAppNum;
	private Date loanAppDate;
	private Date moduleExpectedStartDate;
	private Date moduleExpectedCompletionDate;
	private Date dateOfAcceptance;
	private Date m4ReviewStartDate;
	private Date m4ReviewCompletionDate;
	private Date m4ReviewSanctionDate;
	private String typeOfAccount;
	private String typeOfBorrower;
	private String borrowerCategory;
	private List<CoApplicantDetails> listOfCoApplicantDetails;
	private List<GuarantorDetails> listOfGuarantorDetails;
	private List<ComercialCreditFacilityDetails> comercialCreditFacilities;
	private String security;
	private String typeOfSecurity;
	private String movablePropTypeGoodsStock;
	private String movablePropTypebookDebts;
	private String movablePropTypeRecievables;
	private String movablePropTypePlantMachinery;
	private String movablePropTypeVechile;
	private String movablePropTypeBankDeposit;
	private String movablePropTypeNsc;
	private String movablePropTypeLic;
	private String movablePropTypegoldJwellery;
	private String branchMaker;
	private String branchChecker;
	private String branchSanctionAuthority;
	private String loanSanctionAuthority;
	private String acctStatus;
	private Date dateOfClosure;
	
	private String isM1ProcessedPartly;
	private String reviewCycleOption;
	private String numOfPeriodicReviews;
	private String comments;
	
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
	 * @return the reviewNumber
	 */
	public String getReviewNumber() {
		return reviewNumber;
	}

	/**
	 * @param reviewNumber the reviewNumber to set
	 */
	public void setReviewNumber(String reviewNumber) {
		this.reviewNumber = reviewNumber;
	}

	/**
	 * @return the securityReleaseNumber
	 */
	public String getSecurityReleaseNumber() {
		return securityReleaseNumber;
	}

	/**
	 * @param securityReleaseNumber the securityReleaseNumber to set
	 */
	public void setSecurityReleaseNumber(String securityReleaseNumber) {
		this.securityReleaseNumber = securityReleaseNumber;
	}

	/**
	 * @return the e2eDate
	 */
	public String getE2eDate() {
		return e2eDate;
	}

	/**
	 * @param e2eDate the e2eDate to set
	 */
	public void setE2eDate(String e2eDate) {
		this.e2eDate = e2eDate;
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
	 * @return the loanVariantName
	 */
	public String getLoanVariantName() {
		return loanVariantName;
	}

	/**
	 * @param loanVariantName the loanVariantName to set
	 */
	public void setLoanVariantName(String loanVariantName) {
		this.loanVariantName = loanVariantName;
	}

	/**
	 * @return the e2eNumOfExistingAccount
	 */
	public String getE2eNumOfExistingAccount() {
		return e2eNumOfExistingAccount;
	}

	/**
	 * @param e2eNumOfExistingAccount the e2eNumOfExistingAccount to set
	 */
	public void setE2eNumOfExistingAccount(String e2eNumOfExistingAccount) {
		this.e2eNumOfExistingAccount = e2eNumOfExistingAccount;
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
	 * @return the dateOfTransaction
	 */
	public Date getDateOfTransaction() {
		return dateOfTransaction;
	}

	/**
	 * @param dateOfTransaction the dateOfTransaction to set
	 */
	public void setDateOfTransaction(Date dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	/**
	 * @return the sanctionedAmount
	 */
	public Integer getSanctionedAmount() {
		return sanctionedAmount;
	}

	/**
	 * @param sanctionedAmount the sanctionedAmount to set
	 */
	public void setSanctionedAmount(Integer sanctionedAmount) {
		this.sanctionedAmount = sanctionedAmount;
	}

	/**
	 * @return the sanctionedAmountInWords
	 */
	public String getSanctionedAmountInWords() {
		return sanctionedAmountInWords;
	}

	/**
	 * @param sanctionedAmountInWords the sanctionedAmountInWords to set
	 */
	public void setSanctionedAmountInWords(String sanctionedAmountInWords) {
		this.sanctionedAmountInWords = sanctionedAmountInWords;
	}

	/**
	 * @return the loanTenor
	 */
	public String getLoanTenor() {
		return loanTenor;
	}

	/**
	 * @param loanTenor the loanTenor to set
	 */
	public void setLoanTenor(String loanTenor) {
		this.loanTenor = loanTenor;
	}

	/**
	 * @return the revisedLoanTenor
	 */
	public String getRevisedLoanTenor() {
		return revisedLoanTenor;
	}

	/**
	 * @param revisedLoanTenor the revisedLoanTenor to set
	 */
	public void setRevisedLoanTenor(String revisedLoanTenor) {
		this.revisedLoanTenor = revisedLoanTenor;
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
	public Date getLoanAppDate() {
		return loanAppDate;
	}

	/**
	 * @param loanAppDate the loanAppDate to set
	 */
	public void setLoanAppDate(Date loanAppDate) {
		this.loanAppDate = loanAppDate;
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
	 * @return the m4ReviewStartDate
	 */
	public Date getM4ReviewStartDate() {
		return m4ReviewStartDate;
	}

	/**
	 * @param m4ReviewStartDate the m4ReviewStartDate to set
	 */
	public void setM4ReviewStartDate(Date m4ReviewStartDate) {
		this.m4ReviewStartDate = m4ReviewStartDate;
	}

	/**
	 * @return the m4ReviewCompletionDate
	 */
	public Date getM4ReviewCompletionDate() {
		return m4ReviewCompletionDate;
	}

	/**
	 * @param m4ReviewCompletionDate the m4ReviewCompletionDate to set
	 */
	public void setM4ReviewCompletionDate(Date m4ReviewCompletionDate) {
		this.m4ReviewCompletionDate = m4ReviewCompletionDate;
	}

	/**
	 * @return the m4ReviewSanctionDate
	 */
	public Date getM4ReviewSanctionDate() {
		return m4ReviewSanctionDate;
	}

	/**
	 * @param m4ReviewSanctionDate the m4ReviewSanctionDate to set
	 */
	public void setM4ReviewSanctionDate(Date m4ReviewSanctionDate) {
		this.m4ReviewSanctionDate = m4ReviewSanctionDate;
	}

	/**
	 * @return the typeOfAccount
	 */
	public String getTypeOfAccount() {
		return typeOfAccount;
	}

	/**
	 * @param typeOfAccount the typeOfAccount to set
	 */
	public void setTypeOfAccount(String typeOfAccount) {
		this.typeOfAccount = typeOfAccount;
	}

	/**
	 * @return the typeOfBorrower
	 */
	public String getTypeOfBorrower() {
		return typeOfBorrower;
	}

	/**
	 * @param typeOfBorrower the typeOfBorrower to set
	 */
	public void setTypeOfBorrower(String typeOfBorrower) {
		this.typeOfBorrower = typeOfBorrower;
	}

	/**
	 * @return the borrowerCategory
	 */
	public String getBorrowerCategory() {
		return borrowerCategory;
	}

	/**
	 * @param borrowerCategory the borrowerCategory to set
	 */
	public void setBorrowerCategory(String borrowerCategory) {
		this.borrowerCategory = borrowerCategory;
	}

	/**
	 * @return the listOfCoApplicantDetails
	 */
	public List<CoApplicantDetails> getListOfCoApplicantDetails() {
		return listOfCoApplicantDetails;
	}

	/**
	 * @param listOfCoApplicantDetails the listOfCoApplicantDetails to set
	 */
	public void setListOfCoApplicantDetails(List<CoApplicantDetails> listOfCoApplicantDetails) {
		this.listOfCoApplicantDetails = listOfCoApplicantDetails;
	}

	/**
	 * @return the listOfGuarantorDetails
	 */
	public List<GuarantorDetails> getListOfGuarantorDetails() {
		return listOfGuarantorDetails;
	}

	/**
	 * @param listOfGuarantorDetails the listOfGuarantorDetails to set
	 */
	public void setListOfGuarantorDetails(List<GuarantorDetails> listOfGuarantorDetails) {
		this.listOfGuarantorDetails = listOfGuarantorDetails;
	}

	/**
	 * @return the comercialCreditFacilities
	 */
	public List<ComercialCreditFacilityDetails> getComercialCreditFacilities() {
		return comercialCreditFacilities;
	}

	/**
	 * @param comercialCreditFacilities the comercialCreditFacilities to set
	 */
	public void setComercialCreditFacilities(List<ComercialCreditFacilityDetails> comercialCreditFacilities) {
		this.comercialCreditFacilities = comercialCreditFacilities;
	}

	/**
	 * @return the security
	 */
	public String getSecurity() {
		return security;
	}

	/**
	 * @param security the security to set
	 */
	public void setSecurity(String security) {
		this.security = security;
	}

	/**
	 * @return the typeOfSecurity
	 */
	public String getTypeOfSecurity() {
		return typeOfSecurity;
	}

	/**
	 * @param typeOfSecurity the typeOfSecurity to set
	 */
	public void setTypeOfSecurity(String typeOfSecurity) {
		this.typeOfSecurity = typeOfSecurity;
	}

	/**
	 * @return the movablePropTypeGoodsStock
	 */
	public String getMovablePropTypeGoodsStock() {
		return movablePropTypeGoodsStock;
	}

	/**
	 * @param movablePropTypeGoodsStock the movablePropTypeGoodsStock to set
	 */
	public void setMovablePropTypeGoodsStock(String movablePropTypeGoodsStock) {
		this.movablePropTypeGoodsStock = movablePropTypeGoodsStock;
	}

	/**
	 * @return the movablePropTypebookDebts
	 */
	public String getMovablePropTypebookDebts() {
		return movablePropTypebookDebts;
	}

	/**
	 * @param movablePropTypebookDebts the movablePropTypebookDebts to set
	 */
	public void setMovablePropTypebookDebts(String movablePropTypebookDebts) {
		this.movablePropTypebookDebts = movablePropTypebookDebts;
	}

	/**
	 * @return the movablePropTypeRecievables
	 */
	public String getMovablePropTypeRecievables() {
		return movablePropTypeRecievables;
	}

	/**
	 * @param movablePropTypeRecievables the movablePropTypeRecievables to set
	 */
	public void setMovablePropTypeRecievables(String movablePropTypeRecievables) {
		this.movablePropTypeRecievables = movablePropTypeRecievables;
	}

	/**
	 * @return the movablePropTypePlantMachinery
	 */
	public String getMovablePropTypePlantMachinery() {
		return movablePropTypePlantMachinery;
	}

	/**
	 * @param movablePropTypePlantMachinery the movablePropTypePlantMachinery to set
	 */
	public void setMovablePropTypePlantMachinery(String movablePropTypePlantMachinery) {
		this.movablePropTypePlantMachinery = movablePropTypePlantMachinery;
	}

	/**
	 * @return the movablePropTypeVechile
	 */
	public String getMovablePropTypeVechile() {
		return movablePropTypeVechile;
	}

	/**
	 * @param movablePropTypeVechile the movablePropTypeVechile to set
	 */
	public void setMovablePropTypeVechile(String movablePropTypeVechile) {
		this.movablePropTypeVechile = movablePropTypeVechile;
	}

	/**
	 * @return the movablePropTypeBankDeposit
	 */
	public String getMovablePropTypeBankDeposit() {
		return movablePropTypeBankDeposit;
	}

	/**
	 * @param movablePropTypeBankDeposit the movablePropTypeBankDeposit to set
	 */
	public void setMovablePropTypeBankDeposit(String movablePropTypeBankDeposit) {
		this.movablePropTypeBankDeposit = movablePropTypeBankDeposit;
	}

	/**
	 * @return the movablePropTypeNsc
	 */
	public String getMovablePropTypeNsc() {
		return movablePropTypeNsc;
	}

	/**
	 * @param movablePropTypeNsc the movablePropTypeNsc to set
	 */
	public void setMovablePropTypeNsc(String movablePropTypeNsc) {
		this.movablePropTypeNsc = movablePropTypeNsc;
	}

	/**
	 * @return the movablePropTypeLic
	 */
	public String getMovablePropTypeLic() {
		return movablePropTypeLic;
	}

	/**
	 * @param movablePropTypeLic the movablePropTypeLic to set
	 */
	public void setMovablePropTypeLic(String movablePropTypeLic) {
		this.movablePropTypeLic = movablePropTypeLic;
	}

	/**
	 * @return the movablePropTypegoldJwellery
	 */
	public String getMovablePropTypegoldJwellery() {
		return movablePropTypegoldJwellery;
	}

	/**
	 * @param movablePropTypegoldJwellery the movablePropTypegoldJwellery to set
	 */
	public void setMovablePropTypegoldJwellery(String movablePropTypegoldJwellery) {
		this.movablePropTypegoldJwellery = movablePropTypegoldJwellery;
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
	 * @return the branchChecker
	 */
	public String getBranchChecker() {
		return branchChecker;
	}

	/**
	 * @param branchChecker the branchChecker to set
	 */
	public void setBranchChecker(String branchChecker) {
		this.branchChecker = branchChecker;
	}

	/**
	 * @return the branchSanctionAuthority
	 */
	public String getBranchSanctionAuthority() {
		return branchSanctionAuthority;
	}

	/**
	 * @param branchSanctionAuthority the branchSanctionAuthority to set
	 */
	public void setBranchSanctionAuthority(String branchSanctionAuthority) {
		this.branchSanctionAuthority = branchSanctionAuthority;
	}

	/**
	 * @return the loanSanctionAuthority
	 */
	public String getLoanSanctionAuthority() {
		return loanSanctionAuthority;
	}

	/**
	 * @param loanSanctionAuthority the loanSanctionAuthority to set
	 */
	public void setLoanSanctionAuthority(String loanSanctionAuthority) {
		this.loanSanctionAuthority = loanSanctionAuthority;
	}

	/**
	 * @return the acctStatus
	 */
	public String getAcctStatus() {
		return acctStatus;
	}

	/**
	 * @param acctStatus the acctStatus to set
	 */
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}

	/**
	 * @return the dateOfClosure
	 */
	public Date getDateOfClosure() {
		return dateOfClosure;
	}

	/**
	 * @param dateOfClosure the dateOfClosure to set
	 */
	public void setDateOfClosure(Date dateOfClosure) {
		this.dateOfClosure = dateOfClosure;
	}

	/**
	 * @return the isM1ProcessedPartly
	 */
	public String getIsM1ProcessedPartly() {
		return isM1ProcessedPartly;
	}

	/**
	 * @param isM1ProcessedPartly the isM1ProcessedPartly to set
	 */
	public void setIsM1ProcessedPartly(String isM1ProcessedPartly) {
		this.isM1ProcessedPartly = isM1ProcessedPartly;
	}

	/**
	 * @return the reviewCycleOption
	 */
	public String getReviewCycleOption() {
		return reviewCycleOption;
	}

	/**
	 * @param reviewCycleOption the reviewCycleOption to set
	 */
	public void setReviewCycleOption(String reviewCycleOption) {
		this.reviewCycleOption = reviewCycleOption;
	}

	/**
	 * @return the numOfPeriodicReviews
	 */
	public String getNumOfPeriodicReviews() {
		return numOfPeriodicReviews;
	}

	/**
	 * @param numOfPeriodicReviews the numOfPeriodicReviews to set
	 */
	public void setNumOfPeriodicReviews(String numOfPeriodicReviews) {
		this.numOfPeriodicReviews = numOfPeriodicReviews;
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
