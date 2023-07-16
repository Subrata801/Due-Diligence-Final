/**
 * 
 */
package com.bankMitra.model.admin.response;


/**
 * @author BankMitra
 *
 */
public class ClientDueDeligenceResponse {
	
	private Integer  ddSequence;
	
	private Integer headerSequence;
	
	private Integer  ddParentSequence;
	
	private String ddData;
	
	private String generalOption;
	
	private String[] generalOptionArr;
	
	private String applicantOption;
	
	private String[] applicantOptionArr;
	
	private String coApplicantOption;
	
	private String[] coApplicantOptionArr;
	
	private String guarantorOption;
	
	private String[] guarantorOptionArr;
	
	private String complianceOption;
	
	private String[] complianceOptionArr;
	
	private String conditions;
	
	private String creditSectorId;
	
	private Integer loanSchemeId;
	
    private String loanVariant_keyword;
	
    private Integer borrowerTypeId;
	
	private String criticaltyFactor;
	
	private Integer professionId;
	
	private Integer loanApplicationTypeId;
	
	private Integer securityId;
	
	private Integer securityTypeId;
	
	private Integer applicationTypeId;
	
	private Integer assetTypeId;
	
	private String header1;
	
    private String header2;
	
    private String header3;
	
    private String header4;
	
	private String messageCode;
	
	private String messageDescription;
	
	private String remarks;


	/**
	 * @return the headerSequence
	 */
	public Integer getHeaderSequence() {
		return headerSequence;
	}

	/**
	 * @param headerSequence the headerSequence to set
	 */
	public void setHeaderSequence(Integer headerSequence) {
		this.headerSequence = headerSequence;
	}

	/**
	 * @return the conditions
	 */
	public String getConditions() {
		return conditions;
	}

	/**
	 * @param conditions the conditions to set
	 */
	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	/**
	 * @return the creditSectorId
	 */
	public String getCreditSectorId() {
		return creditSectorId;
	}

	/**
	 * @param creditSectorId the creditSectorId to set
	 */
	public void setCreditSectorId(String creditSectorId) {
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
	 * @return the loanVariant_keyword
	 */
	public String getLoanVariant_keyword() {
		return loanVariant_keyword;
	}

	/**
	 * @param loanVariant_keyword the loanVariant_keyword to set
	 */
	public void setLoanVariant_keyword(String loanVariant_keyword) {
		this.loanVariant_keyword = loanVariant_keyword;
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
	 * @return the criticaltyFactor
	 */
	public String getCriticaltyFactor() {
		return criticaltyFactor;
	}

	/**
	 * @param criticaltyFactor the criticaltyFactor to set
	 */
	public void setCriticaltyFactor(String criticaltyFactor) {
		this.criticaltyFactor = criticaltyFactor;
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
	 * @return the loanApplicationTypeId
	 */
	public Integer getLoanApplicationTypeId() {
		return loanApplicationTypeId;
	}

	/**
	 * @param loanApplicationTypeId the loanApplicationTypeId to set
	 */
	public void setLoanApplicationTypeId(Integer loanApplicationTypeId) {
		this.loanApplicationTypeId = loanApplicationTypeId;
	}

	/**
	 * @return the securityId
	 */
	public Integer getSecurityId() {
		return securityId;
	}

	/**
	 * @param securityId the securityId to set
	 */
	public void setSecurityId(Integer securityId) {
		this.securityId = securityId;
	}

	/**
	 * @return the securityTypeId
	 */
	public Integer getSecurityTypeId() {
		return securityTypeId;
	}

	/**
	 * @param securityTypeId the securityTypeId to set
	 */
	public void setSecurityTypeId(Integer securityTypeId) {
		this.securityTypeId = securityTypeId;
	}

	/**
	 * @return the applicationTypeId
	 */
	public Integer getApplicationTypeId() {
		return applicationTypeId;
	}

	/**
	 * @param applicationTypeId the applicationTypeId to set
	 */
	public void setApplicationTypeId(Integer applicationTypeId) {
		this.applicationTypeId = applicationTypeId;
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
	 * @return the applicantOptionArr
	 */
	public String[] getApplicantOptionArr() {
		return applicantOptionArr;
	}

	/**
	 * @param applicantOptionArr the applicantOptionArr to set
	 */
	public void setApplicantOptionArr(String[] applicantOptionArr) {
		this.applicantOptionArr = applicantOptionArr;
	}

	/**
	 * @return the generalOptionArr
	 */
	public String[] getGeneralOptionArr() {
		return generalOptionArr;
	}

	/**
	 * @param generalOptionArr the generalOptionArr to set
	 */
	public void setGeneralOptionArr(String[] generalOptionArr) {
		this.generalOptionArr = generalOptionArr;
	}

	/**
	 * @return the coApplicantOptionArr
	 */
	public String[] getCoApplicantOptionArr() {
		return coApplicantOptionArr;
	}

	/**
	 * @param coApplicantOptionArr the coApplicantOptionArr to set
	 */
	public void setCoApplicantOptionArr(String[] coApplicantOptionArr) {
		this.coApplicantOptionArr = coApplicantOptionArr;
	}

	/**
	 * @return the guarantorOptionArr
	 */
	public String[] getGuarantorOptionArr() {
		return guarantorOptionArr;
	}

	/**
	 * @param guarantorOptionArr the guarantorOptionArr to set
	 */
	public void setGuarantorOptionArr(String[] guarantorOptionArr) {
		this.guarantorOptionArr = guarantorOptionArr;
	}

	/**
	 * @return the complianceOptionArr
	 */
	public String[] getComplianceOptionArr() {
		return complianceOptionArr;
	}

	/**
	 * @param complianceOptionArr the complianceOptionArr to set
	 */
	public void setComplianceOptionArr(String[] complianceOptionArr) {
		this.complianceOptionArr = complianceOptionArr;
	}

	/**
	 * @return the complianceOption
	 */
	public String getComplianceOption() {
		return complianceOption;
	}

	/**
	 * @param complianceOption the complianceOption to set
	 */
	public void setComplianceOption(String complianceOption) {
		this.complianceOption = complianceOption;
	}

	/**
	 * @return the ddSequence
	 */
	public Integer getDdSequence() {
		return ddSequence;
	}

	/**
	 * @param ddSequence the ddSequence to set
	 */
	public void setDdSequence(Integer ddSequence) {
		this.ddSequence = ddSequence;
	}

	/**
	 * @return the ddParentSequence
	 */
	public Integer getDdParentSequence() {
		return ddParentSequence;
	}

	/**
	 * @param ddParentSequence the ddParentSequence to set
	 */
	public void setDdParentSequence(Integer ddParentSequence) {
		this.ddParentSequence = ddParentSequence;
	}

	/**
	 * @return the ddData
	 */
	public String getDdData() {
		return ddData;
	}

	/**
	 * @param ddData the ddData to set
	 */
	public void setDdData(String ddData) {
		this.ddData = ddData;
	}

	/**
	 * @return the generalOption
	 */
	public String getGeneralOption() {
		return generalOption;
	}

	/**
	 * @param generalOption the generalOption to set
	 */
	public void setGeneralOption(String generalOption) {
		this.generalOption = generalOption;
	}

	/**
	 * @return the applicantOption
	 */
	public String getApplicantOption() {
		return applicantOption;
	}

	/**
	 * @param applicantOption the applicantOption to set
	 */
	public void setApplicantOption(String applicantOption) {
		this.applicantOption = applicantOption;
	}

	/**
	 * @return the coApplicantOption
	 */
	public String getCoApplicantOption() {
		return coApplicantOption;
	}

	/**
	 * @param coApplicantOption the coApplicantOption to set
	 */
	public void setCoApplicantOption(String coApplicantOption) {
		this.coApplicantOption = coApplicantOption;
	}

	/**
	 * @return the guarantorOption
	 */
	public String getGuarantorOption() {
		return guarantorOption;
	}

	/**
	 * @param guarantorOption the guarantorOption to set
	 */
	public void setGuarantorOption(String guarantorOption) {
		this.guarantorOption = guarantorOption;
	}

	/**
	 * @return the header1
	 */
	public String getHeader1() {
		return header1;
	}

	/**
	 * @param header1 the header1 to set
	 */
	public void setHeader1(String header1) {
		this.header1 = header1;
	}

	/**
	 * @return the header2
	 */
	public String getHeader2() {
		return header2;
	}

	/**
	 * @param header2 the header2 to set
	 */
	public void setHeader2(String header2) {
		this.header2 = header2;
	}

	/**
	 * @return the header3
	 */
	public String getHeader3() {
		return header3;
	}

	/**
	 * @param header3 the header3 to set
	 */
	public void setHeader3(String header3) {
		this.header3 = header3;
	}

	/**
	 * @return the header4
	 */
	public String getHeader4() {
		return header4;
	}

	/**
	 * @param header4 the header4 to set
	 */
	public void setHeader4(String header4) {
		this.header4 = header4;
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

	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
