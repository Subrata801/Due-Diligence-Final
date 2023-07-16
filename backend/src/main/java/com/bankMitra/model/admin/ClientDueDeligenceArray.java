/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class ClientDueDeligenceArray implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 763732170027435939L;

	private String moduleName;
	
	private String header1;
	
    private String header2;
	
    private String header3;
	
    private String header4;
    
	private Integer  ddSequence;
	
	private Integer  ddParentSequence;
	
	private Integer  headerSequence;
	
	private String dd_data;
	
	private String generalOption;
	
	private String applicantOption;
	
	private String coApplicantOption;
	
	private String guarantorOption;
	
	private String complianceOption;
	
	private String remarks;
	
	private String conditions;
	
	private Integer creditSectorId;
	
	private Integer loanSchemeId;
	
	private String loanVariant_keyword;
	
	private Integer borrowerTypeId;
	
	private String criticaltyFactor;
	
	private Integer professionId;
	
	private Integer loanApplicationTypeId;
	
	private Integer securityId;
	
	private Integer securityTypeId;

	private Integer security_subtype_id;
	
	private Integer applicationTypeId;
	
	private Integer assetTypeId;

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
	 * @return the dd_data
	 */
	public String getDd_data() {
		return dd_data;
	}

	/**
	 * @param dd_data the dd_data to set
	 */
	public void setDd_data(String dd_data) {
		this.dd_data = dd_data;
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
	 * @return the security_subtype_id
	 */
	public Integer getSecurity_subtype_id() {
		return security_subtype_id;
	}

	/**
	 * @param security_subtype_id the security_subtype_id to set
	 */
	public void setSecurity_subtype_id(Integer security_subtype_id) {
		this.security_subtype_id = security_subtype_id;
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

}
