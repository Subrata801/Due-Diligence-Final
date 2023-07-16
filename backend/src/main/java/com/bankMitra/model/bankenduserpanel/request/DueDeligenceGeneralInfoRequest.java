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
public class DueDeligenceGeneralInfoRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String e2eNumber;
	private String cifNumberAvailability2;
	private String selectCifNumber2;
	private String applicantName2;
	private String selectCreditSector2;
	private String selectLoanScheme2;
	private String selectLoanVariant2;
	private String loanApplnNumber2;
	private Date acceptanceDate;
	private String sanctionedLoanAmount;
	private String sanctionedLoanAmountWords;
	private String loanTenure2;
	private String revisedLoanTenure2;
	private Date disbursementDate;
	private Date m4CurrentReviewSanctionDate;
	private String presentStatus;
	private String releaseOfSecurityOnAccountClosure;
	private Date dateOfClosureOfLoan;
	private String selectedAccountType;
	private String selectedBorrowerType;
	private String selectedBorrowerCategory;
	private List<LoanFacility> commercialCreditFacilityDetails;
	
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
	 * @return the cifNumberAvailability2
	 */
	public String getCifNumberAvailability2() {
		return cifNumberAvailability2;
	}
	/**
	 * @param cifNumberAvailability2 the cifNumberAvailability2 to set
	 */
	public void setCifNumberAvailability2(String cifNumberAvailability2) {
		this.cifNumberAvailability2 = cifNumberAvailability2;
	}
	/**
	 * @return the selectCifNumber2
	 */
	public String getSelectCifNumber2() {
		return selectCifNumber2;
	}
	/**
	 * @param selectCifNumber2 the selectCifNumber2 to set
	 */
	public void setSelectCifNumber2(String selectCifNumber2) {
		this.selectCifNumber2 = selectCifNumber2;
	}
	/**
	 * @return the applicantName2
	 */
	public String getApplicantName2() {
		return applicantName2;
	}
	/**
	 * @param applicantName2 the applicantName2 to set
	 */
	public void setApplicantName2(String applicantName2) {
		this.applicantName2 = applicantName2;
	}
	/**
	 * @return the selectCreditSector2
	 */
	public String getSelectCreditSector2() {
		return selectCreditSector2;
	}
	/**
	 * @param selectCreditSector2 the selectCreditSector2 to set
	 */
	public void setSelectCreditSector2(String selectCreditSector2) {
		this.selectCreditSector2 = selectCreditSector2;
	}
	/**
	 * @return the selectLoanScheme2
	 */
	public String getSelectLoanScheme2() {
		return selectLoanScheme2;
	}
	/**
	 * @param selectLoanScheme2 the selectLoanScheme2 to set
	 */
	public void setSelectLoanScheme2(String selectLoanScheme2) {
		this.selectLoanScheme2 = selectLoanScheme2;
	}
	/**
	 * @return the selectLoanVariant2
	 */
	public String getSelectLoanVariant2() {
		return selectLoanVariant2;
	}
	/**
	 * @param selectLoanVariant2 the selectLoanVariant2 to set
	 */
	public void setSelectLoanVariant2(String selectLoanVariant2) {
		this.selectLoanVariant2 = selectLoanVariant2;
	}
	/**
	 * @return the loanApplnNumber2
	 */
	public String getLoanApplnNumber2() {
		return loanApplnNumber2;
	}
	/**
	 * @param loanApplnNumber2 the loanApplnNumber2 to set
	 */
	public void setLoanApplnNumber2(String loanApplnNumber2) {
		this.loanApplnNumber2 = loanApplnNumber2;
	}

	/**
	 * @return the acceptanceDate
	 */
	public Date getAcceptanceDate() {
		return acceptanceDate;
	}
	/**
	 * @param acceptanceDate the acceptanceDate to set
	 */
	public void setAcceptanceDate(Date acceptanceDate) {
		this.acceptanceDate = acceptanceDate;
	}
	/**
	 * @return the sanctionedLoanAmount
	 */
	public String getSanctionedLoanAmount() {
		return sanctionedLoanAmount;
	}
	/**
	 * @param sanctionedLoanAmount the sanctionedLoanAmount to set
	 */
	public void setSanctionedLoanAmount(String sanctionedLoanAmount) {
		this.sanctionedLoanAmount = sanctionedLoanAmount;
	}
	/**
	 * @return the sanctionedLoanAmountWords
	 */
	public String getSanctionedLoanAmountWords() {
		return sanctionedLoanAmountWords;
	}
	/**
	 * @param sanctionedLoanAmountWords the sanctionedLoanAmountWords to set
	 */
	public void setSanctionedLoanAmountWords(String sanctionedLoanAmountWords) {
		this.sanctionedLoanAmountWords = sanctionedLoanAmountWords;
	}
	/**
	 * @return the loanTenure2
	 */
	public String getLoanTenure2() {
		return loanTenure2;
	}
	/**
	 * @param loanTenure2 the loanTenure2 to set
	 */
	public void setLoanTenure2(String loanTenure2) {
		this.loanTenure2 = loanTenure2;
	}
	/**
	 * @return the revisedLoanTenure2
	 */
	public String getRevisedLoanTenure2() {
		return revisedLoanTenure2;
	}
	/**
	 * @param revisedLoanTenure2 the revisedLoanTenure2 to set
	 */
	public void setRevisedLoanTenure2(String revisedLoanTenure2) {
		this.revisedLoanTenure2 = revisedLoanTenure2;
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
	 * @return the presentStatus
	 */
	public String getPresentStatus() {
		return presentStatus;
	}
	/**
	 * @param presentStatus the presentStatus to set
	 */
	public void setPresentStatus(String presentStatus) {
		this.presentStatus = presentStatus;
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
	 * @return the selectedAccountType
	 */
	public String getSelectedAccountType() {
		return selectedAccountType;
	}
	/**
	 * @param selectedAccountType the selectedAccountType to set
	 */
	public void setSelectedAccountType(String selectedAccountType) {
		this.selectedAccountType = selectedAccountType;
	}
	/**
	 * @return the selectedBorrowerType
	 */
	public String getSelectedBorrowerType() {
		return selectedBorrowerType;
	}
	/**
	 * @param selectedBorrowerType the selectedBorrowerType to set
	 */
	public void setSelectedBorrowerType(String selectedBorrowerType) {
		this.selectedBorrowerType = selectedBorrowerType;
	}
	/**
	 * @return the selectedBorrowerCategory
	 */
	public String getSelectedBorrowerCategory() {
		return selectedBorrowerCategory;
	}
	/**
	 * @param selectedBorrowerCategory the selectedBorrowerCategory to set
	 */
	public void setSelectedBorrowerCategory(String selectedBorrowerCategory) {
		this.selectedBorrowerCategory = selectedBorrowerCategory;
	}
	public List<LoanFacility> getCommercialCreditFacilityDetails() {
		return commercialCreditFacilityDetails;
	}
	public void setCommercialCreditFacilityDetails(List<LoanFacility> commercialCreditFacilityDetails) {
		this.commercialCreditFacilityDetails = commercialCreditFacilityDetails;
	}
	
	
}
