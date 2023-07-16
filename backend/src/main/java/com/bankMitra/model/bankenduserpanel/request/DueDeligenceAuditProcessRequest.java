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
public class DueDeligenceAuditProcessRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String userName;
	private String selectModule;
	private String cncNumber;
	private Date cncDate;
	private String branchId;
	private String ifscCode;
	private String auditFirmChecker;
	private String auditFirmControlAuth;
	private String cifNumber;
	private String borrowerName;
	private Integer creditSectorId;
	private Integer loanSchemeId;
	private String typeOfLoanScheme;
	private Integer loanVariantId;
	private String loanAccountNum;
	private Date sanctionDate;
	private Integer sanctionAmount;
	private String sanctionAmountWords;
	
	private Integer loanTenor;
	private String accountStatus;
	private String releaseOfSecurity;
	private Date dateOfclosure;
	private String typeOfAuditAccount;
	private Integer typeOfBorrower;
	private Integer borrowerCategory;
	private List<ComercialCreditFacilityDetails> facilityDetails;
	private List<CoApplicantDetails> listOfCoApplicantDetails;
    private String nameOfCoApplicant1;
	private String designation1;
    private String nameOfCoApplicant2;
	private String designation2;
	private String nameOfCoApplicant3;
	private String designation3;
    private String nameOfCoApplicant4;
	private String designation4;
	private String nameOfCoApplicant5;
	private String designation5;
	private List<GuarantorDetails> listOfGuarantorDetails;
    private String guarantor;
	private String nameOfGuarantor1;
	private String nameOfGuarantor2;
	private String nameOfGuarantor3;
	private String nameOfGuarantor4;
	private String collateralSecurityTypeId;
	private String typeOfSecurity;
	private String comments;	
	private String movablePropTypeGoodsStock;
	private String movablePropTypebookDebts;
	private String movablePropTypeRecievables;
	private String movablePropTypePlantMachinery;
	private String movablePropTypeVechile;
	private String movablePropTypeBankDeposit;
	private String movablePropTypeNsc;
	private String movablePropTypeLic;
	private String movablePropTypegoldJwellery;
	private String movablePropTypeStores;
	private List<String> movablePropertyTypes;
	
	private String auditChecker;
	private String auditControlAuthority;
	private String accountStatusInAuditView;
	private Date dateOfClosure;
	
	private String createdBy;

	/**
	 * @return the movablePropertyTypes
	 */
	public List<String> getMovablePropertyTypes() {
		return movablePropertyTypes;
	}

	/**
	 * @param movablePropertyTypes the movablePropertyTypes to set
	 */
	public void setMovablePropertyTypes(List<String> movablePropertyTypes) {
		this.movablePropertyTypes = movablePropertyTypes;
	}

	/**
	 * @return the nameOfCoApplicant5
	 */
	public String getNameOfCoApplicant5() {
		return nameOfCoApplicant5;
	}

	/**
	 * @param nameOfCoApplicant5 the nameOfCoApplicant5 to set
	 */
	public void setNameOfCoApplicant5(String nameOfCoApplicant5) {
		this.nameOfCoApplicant5 = nameOfCoApplicant5;
	}

	/**
	 * @return the designation5
	 */
	public String getDesignation5() {
		return designation5;
	}

	/**
	 * @param designation5 the designation5 to set
	 */
	public void setDesignation5(String designation5) {
		this.designation5 = designation5;
	}

	/**
	 * @return the movablePropTypeStores
	 */
	public String getMovablePropTypeStores() {
		return movablePropTypeStores;
	}

	/**
	 * @param movablePropTypeStores the movablePropTypeStores to set
	 */
	public void setMovablePropTypeStores(String movablePropTypeStores) {
		this.movablePropTypeStores = movablePropTypeStores;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}



	/**
	 * @return the selectModule
	 */
	public String getSelectModule() {
		return selectModule;
	}

	/**
	 * @param selectModule the selectModule to set
	 */
	public void setSelectModule(String selectModule) {
		this.selectModule = selectModule;
	}



	/**
	 * @return the cncNumber
	 */
	public String getCncNumber() {
		return cncNumber;
	}

	/**
	 * @param cncNumber the cncNumber to set
	 */
	public void setCncNumber(String cncNumber) {
		this.cncNumber = cncNumber;
	}

	/**
	 * @return the cncDate
	 */
	public Date getCncDate() {
		return cncDate;
	}

	/**
	 * @param cncDate the cncDate to set
	 */
	public void setCncDate(Date cncDate) {
		this.cncDate = cncDate;
	}

	/**
	 * @return the branchId
	 */
	public String getBranchId() {
		return branchId;
	}

	/**
	 * @param branchId the branchId to set
	 */
	public void setBranchId(String branchId) {
		this.branchId = branchId;
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
	 * @return the auditFirmChecker
	 */
	public String getAuditFirmChecker() {
		return auditFirmChecker;
	}

	/**
	 * @param auditFirmChecker the auditFirmChecker to set
	 */
	public void setAuditFirmChecker(String auditFirmChecker) {
		this.auditFirmChecker = auditFirmChecker;
	}

	/**
	 * @return the auditFirmControlAuth
	 */
	public String getAuditFirmControlAuth() {
		return auditFirmControlAuth;
	}

	/**
	 * @param auditFirmControlAuth the auditFirmControlAuth to set
	 */
	public void setAuditFirmControlAuth(String auditFirmControlAuth) {
		this.auditFirmControlAuth = auditFirmControlAuth;
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
	 * @return the creditSectorId
	 */
	public Integer getCreditSectorId() {
		return creditSectorId;
	}

	/**
	 * @param creditSectorId the creditSectorId to set
	 */
	public void setCreditSectorId(Integer creditSectorId) {
		this.creditSectorId = creditSectorId;
	}

	/**
	 * @return the loanSchemeId
	 */
	public Integer getLoanSchemeId() {
		return loanSchemeId;
	}

	/**
	 * @param loanSchemeId the loanSchemeId to set
	 */
	public void setLoanSchemeId(Integer loanSchemeId) {
		this.loanSchemeId = loanSchemeId;
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
	 * @return the loanVariantId
	 */
	public Integer getLoanVariantId() {
		return loanVariantId;
	}

	/**
	 * @param loanVariantId the loanVariantId to set
	 */
	public void setLoanVariantId(Integer loanVariantId) {
		this.loanVariantId = loanVariantId;
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
	 * @return the sanctionDate
	 */
	public Date getSanctionDate() {
		return sanctionDate;
	}

	/**
	 * @param sanctionDate the sanctionDate to set
	 */
	public void setSanctionDate(Date sanctionDate) {
		this.sanctionDate = sanctionDate;
	}

	/**
	 * @return the sanctionAmount
	 */
	public Integer getSanctionAmount() {
		return sanctionAmount;
	}

	/**
	 * @param sanctionAmount the sanctionAmount to set
	 */
	public void setSanctionAmount(Integer sanctionAmount) {
		this.sanctionAmount = sanctionAmount;
	}

	/**
	 * @return the sanctionAmountWords
	 */
	public String getSanctionAmountWords() {
		return sanctionAmountWords;
	}

	/**
	 * @param sanctionAmountWords the sanctionAmountWords to set
	 */
	public void setSanctionAmountWords(String sanctionAmountWords) {
		this.sanctionAmountWords = sanctionAmountWords;
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
	 * @return the accountStatus
	 */
	public String getAccountStatus() {
		return accountStatus;
	}

	/**
	 * @param accountStatus the accountStatus to set
	 */
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	/**
	 * @return the releaseOfSecurity
	 */
	public String getReleaseOfSecurity() {
		return releaseOfSecurity;
	}

	/**
	 * @param releaseOfSecurity the releaseOfSecurity to set
	 */
	public void setReleaseOfSecurity(String releaseOfSecurity) {
		this.releaseOfSecurity = releaseOfSecurity;
	}

	/**
	 * @return the dateOfclosure
	 */
	public Date getDateOfclosure() {
		return dateOfclosure;
	}

	/**
	 * @param dateOfclosure the dateOfclosure to set
	 */
	public void setDateOfclosure(Date dateOfclosure) {
		this.dateOfclosure = dateOfclosure;
	}

	/**
	 * @return the typeOfAuditAccount
	 */
	public String getTypeOfAuditAccount() {
		return typeOfAuditAccount;
	}

	/**
	 * @param typeOfAuditAccount the typeOfAuditAccount to set
	 */
	public void setTypeOfAuditAccount(String typeOfAuditAccount) {
		this.typeOfAuditAccount = typeOfAuditAccount;
	}

	/**
	 * @return the typeOfBorrower
	 */
	public Integer getTypeOfBorrower() {
		return typeOfBorrower;
	}

	/**
	 * @param typeOfBorrower the typeOfBorrower to set
	 */
	public void setTypeOfBorrower(Integer typeOfBorrower) {
		this.typeOfBorrower = typeOfBorrower;
	}

	/**
	 * @return the borrowerCategory
	 */
	public Integer getBorrowerCategory() {
		return borrowerCategory;
	}

	/**
	 * @param borrowerCategory the borrowerCategory to set
	 */
	public void setBorrowerCategory(Integer borrowerCategory) {
		this.borrowerCategory = borrowerCategory;
	}

	/**
	 * @return the facilityDetails
	 */
	public List<ComercialCreditFacilityDetails> getFacilityDetails() {
		return facilityDetails;
	}

	/**
	 * @param facilityDetails the facilityDetails to set
	 */
	public void setFacilityDetails(List<ComercialCreditFacilityDetails> facilityDetails) {
		this.facilityDetails = facilityDetails;
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
	 * @return the nameOfCoApplicant1
	 */
	public String getNameOfCoApplicant1() {
		return nameOfCoApplicant1;
	}

	/**
	 * @param nameOfCoApplicant1 the nameOfCoApplicant1 to set
	 */
	public void setNameOfCoApplicant1(String nameOfCoApplicant1) {
		this.nameOfCoApplicant1 = nameOfCoApplicant1;
	}

	/**
	 * @return the designation1
	 */
	public String getDesignation1() {
		return designation1;
	}

	/**
	 * @param designation1 the designation1 to set
	 */
	public void setDesignation1(String designation1) {
		this.designation1 = designation1;
	}

	/**
	 * @return the nameOfCoApplicant2
	 */
	public String getNameOfCoApplicant2() {
		return nameOfCoApplicant2;
	}

	/**
	 * @param nameOfCoApplicant2 the nameOfCoApplicant2 to set
	 */
	public void setNameOfCoApplicant2(String nameOfCoApplicant2) {
		this.nameOfCoApplicant2 = nameOfCoApplicant2;
	}

	/**
	 * @return the designation2
	 */
	public String getDesignation2() {
		return designation2;
	}

	/**
	 * @param designation2 the designation2 to set
	 */
	public void setDesignation2(String designation2) {
		this.designation2 = designation2;
	}

	/**
	 * @return the nameOfCoApplicant3
	 */
	public String getNameOfCoApplicant3() {
		return nameOfCoApplicant3;
	}

	/**
	 * @param nameOfCoApplicant3 the nameOfCoApplicant3 to set
	 */
	public void setNameOfCoApplicant3(String nameOfCoApplicant3) {
		this.nameOfCoApplicant3 = nameOfCoApplicant3;
	}

	/**
	 * @return the designation3
	 */
	public String getDesignation3() {
		return designation3;
	}

	/**
	 * @param designation3 the designation3 to set
	 */
	public void setDesignation3(String designation3) {
		this.designation3 = designation3;
	}

	/**
	 * @return the nameOfCoApplicant4
	 */
	public String getNameOfCoApplicant4() {
		return nameOfCoApplicant4;
	}

	/**
	 * @param nameOfCoApplicant4 the nameOfCoApplicant4 to set
	 */
	public void setNameOfCoApplicant4(String nameOfCoApplicant4) {
		this.nameOfCoApplicant4 = nameOfCoApplicant4;
	}

	/**
	 * @return the designation4
	 */
	public String getDesignation4() {
		return designation4;
	}

	/**
	 * @param designation4 the designation4 to set
	 */
	public void setDesignation4(String designation4) {
		this.designation4 = designation4;
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
	 * @return the guarantor
	 */
	public String getGuarantor() {
		return guarantor;
	}

	/**
	 * @param guarantor the guarantor to set
	 */
	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}

	/**
	 * @return the nameOfGuarantor1
	 */
	public String getNameOfGuarantor1() {
		return nameOfGuarantor1;
	}

	/**
	 * @param nameOfGuarantor1 the nameOfGuarantor1 to set
	 */
	public void setNameOfGuarantor1(String nameOfGuarantor1) {
		this.nameOfGuarantor1 = nameOfGuarantor1;
	}

	/**
	 * @return the nameOfGuarantor2
	 */
	public String getNameOfGuarantor2() {
		return nameOfGuarantor2;
	}

	/**
	 * @param nameOfGuarantor2 the nameOfGuarantor2 to set
	 */
	public void setNameOfGuarantor2(String nameOfGuarantor2) {
		this.nameOfGuarantor2 = nameOfGuarantor2;
	}

	/**
	 * @return the nameOfGuarantor3
	 */
	public String getNameOfGuarantor3() {
		return nameOfGuarantor3;
	}

	/**
	 * @param nameOfGuarantor3 the nameOfGuarantor3 to set
	 */
	public void setNameOfGuarantor3(String nameOfGuarantor3) {
		this.nameOfGuarantor3 = nameOfGuarantor3;
	}

	/**
	 * @return the nameOfGuarantor4
	 */
	public String getNameOfGuarantor4() {
		return nameOfGuarantor4;
	}

	/**
	 * @param nameOfGuarantor4 the nameOfGuarantor4 to set
	 */
	public void setNameOfGuarantor4(String nameOfGuarantor4) {
		this.nameOfGuarantor4 = nameOfGuarantor4;
	}

	/**
	 * @return the collateralSecurityTypeId
	 */
	public String getCollateralSecurityTypeId() {
		return collateralSecurityTypeId;
	}

	/**
	 * @param collateralSecurityTypeId the collateralSecurityTypeId to set
	 */
	public void setCollateralSecurityTypeId(String collateralSecurityTypeId) {
		this.collateralSecurityTypeId = collateralSecurityTypeId;
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
	 * @return the auditChecker
	 */
	public String getAuditChecker() {
		return auditChecker;
	}

	/**
	 * @param auditChecker the auditChecker to set
	 */
	public void setAuditChecker(String auditChecker) {
		this.auditChecker = auditChecker;
	}

	/**
	 * @return the auditControlAuthority
	 */
	public String getAuditControlAuthority() {
		return auditControlAuthority;
	}

	/**
	 * @param auditControlAuthority the auditControlAuthority to set
	 */
	public void setAuditControlAuthority(String auditControlAuthority) {
		this.auditControlAuthority = auditControlAuthority;
	}

	/**
	 * @return the accountStatusInAuditView
	 */
	public String getAccountStatusInAuditView() {
		return accountStatusInAuditView;
	}

	/**
	 * @param accountStatusInAuditView the accountStatusInAuditView to set
	 */
	public void setAccountStatusInAuditView(String accountStatusInAuditView) {
		this.accountStatusInAuditView = accountStatusInAuditView;
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
