/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.List;

/**
 * @author BankMitra
 *
 */
public class ClientDueDeligenceRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 763732170027435939L;

	private Integer ddId;
	
	private Integer ddSequence;
	
	private Integer ddParentSequence = 0;
	
	private Integer headerSequence;
	
	private String moduleName;
	
	private String headerType;
	
	private String header1;
	
    private String header2;
	
    private String header3;
	
    private String header4;
	
	private Integer templateId;
	
	private String loanSchemeKeyword;
	
    private String status;
    
	private String actionPoint;
	
	private String action;
	
	private String userName;
	
	private String headerKey;
	
    private String ddData;
	
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

	
	private List<ClientDueDeligenceArray> dueDeligenceDetails;


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
	 * @return the dueDeligenceDetails
	 */
	public List<ClientDueDeligenceArray> getDueDeligenceDetails() {
		return dueDeligenceDetails;
	}

	/**
	 * @param dueDeligenceDetails the dueDeligenceDetails to set
	 */
	public void setDueDeligenceDetails(List<ClientDueDeligenceArray> dueDeligenceDetails) {
		this.dueDeligenceDetails = dueDeligenceDetails;
	}

	/**
	 * @return the headerKey
	 */
	public String getHeaderKey() {
		return headerKey;
	}

	/**
	 * @param headerKey the headerKey to set
	 */
	public void setHeaderKey(String headerKey) {
		this.headerKey = headerKey;
	}

	/**
	 * @return the headerType
	 */
	public String getHeaderType() {
		return headerType;
	}

	/**
	 * @param headerType the headerType to set
	 */
	public void setHeaderType(String headerType) {
		this.headerType = headerType;
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
	 * @return the loanSchemeKeyword
	 */
	public String getLoanSchemeKeyword() {
		return loanSchemeKeyword;
	}

	/**
	 * @param loanSchemeKeyword the loanSchemeKeyword to set
	 */
	public void setLoanSchemeKeyword(String loanSchemeKeyword) {
		this.loanSchemeKeyword = loanSchemeKeyword;
	}

	/**
	 * @return the templateId
	 */
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the ddId
	 */
	public Integer getDdId() {
		return ddId;
	}

	/**
	 * @param ddId the ddId to set
	 */
	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the actionPoint
	 */
	public String getActionPoint() {
		return actionPoint;
	}

	/**
	 * @param actionPoint the actionPoint to set
	 */
	public void setActionPoint(String actionPoint) {
		this.actionPoint = actionPoint;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
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


}
