/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class DueDeligenceProcessResponse implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 615525540353871906L;
	
	private String loanApplicationId;
	private String clientId;
	private String clientGroupId;
	private String startModule;
	private String loanApplicationNo;
	private Date loanApplicationDate;
	private String cifFlag;
	private String cifNo;
	private String loanStatus;
	private String loanApplicantName;
	private String creditSectorTypeId;
	private Integer loanSchemeId;
	private Integer loanVariantId;
	private String unitMaker;
	private String initiateDdpComments;

	private String createdBy;
	
	private String messageCode;
	
	private String messageDescription;

	/**
	 * @return the loanApplicationId
	 */
	public String getLoanApplicationId() {
		return loanApplicationId;
	}

	/**
	 * @param loanApplicationId the loanApplicationId to set
	 */
	public void setLoanApplicationId(String loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}

	/**
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientGroupId
	 */
	public String getClientGroupId() {
		return clientGroupId;
	}

	/**
	 * @param clientGroupId the clientGroupId to set
	 */
	public void setClientGroupId(String clientGroupId) {
		this.clientGroupId = clientGroupId;
	}

	/**
	 * @return the startModule
	 */
	public String getStartModule() {
		return startModule;
	}

	/**
	 * @param startModule the startModule to set
	 */
	public void setStartModule(String startModule) {
		this.startModule = startModule;
	}

	/**
	 * @return the loanApplicationNo
	 */
	public String getLoanApplicationNo() {
		return loanApplicationNo;
	}

	/**
	 * @param loanApplicationNo the loanApplicationNo to set
	 */
	public void setLoanApplicationNo(String loanApplicationNo) {
		this.loanApplicationNo = loanApplicationNo;
	}

	/**
	 * @return the loanApplicationDate
	 */
	public Date getLoanApplicationDate() {
		return loanApplicationDate;
	}

	/**
	 * @param loanApplicationDate the loanApplicationDate to set
	 */
	public void setLoanApplicationDate(Date loanApplicationDate) {
		this.loanApplicationDate = loanApplicationDate;
	}

	/**
	 * @return the cifFlag
	 */
	public String getCifFlag() {
		return cifFlag;
	}

	/**
	 * @param cifFlag the cifFlag to set
	 */
	public void setCifFlag(String cifFlag) {
		this.cifFlag = cifFlag;
	}

	/**
	 * @return the cifNo
	 */
	public String getCifNo() {
		return cifNo;
	}

	/**
	 * @param cifNo the cifNo to set
	 */
	public void setCifNo(String cifNo) {
		this.cifNo = cifNo;
	}

	/**
	 * @return the loanStatus
	 */
	public String getLoanStatus() {
		return loanStatus;
	}

	/**
	 * @param loanStatus the loanStatus to set
	 */
	public void setLoanStatus(String loanStatus) {
		this.loanStatus = loanStatus;
	}

	/**
	 * @return the loanApplicantName
	 */
	public String getLoanApplicantName() {
		return loanApplicantName;
	}

	/**
	 * @param loanApplicantName the loanApplicantName to set
	 */
	public void setLoanApplicantName(String loanApplicantName) {
		this.loanApplicantName = loanApplicantName;
	}

	/**
	 * @return the creditSectorTypeId
	 */
	public String getCreditSectorTypeId() {
		return creditSectorTypeId;
	}

	/**
	 * @param creditSectorTypeId the creditSectorTypeId to set
	 */
	public void setCreditSectorTypeId(String creditSectorTypeId) {
		this.creditSectorTypeId = creditSectorTypeId;
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
	 * @return the unitMaker
	 */
	public String getUnitMaker() {
		return unitMaker;
	}

	/**
	 * @param unitMaker the unitMaker to set
	 */
	public void setUnitMaker(String unitMaker) {
		this.unitMaker = unitMaker;
	}

	/**
	 * @return the initiateDdpComments
	 */
	public String getInitiateDdpComments() {
		return initiateDdpComments;
	}

	/**
	 * @param initiateDdpComments the initiateDdpComments to set
	 */
	public void setInitiateDdpComments(String initiateDdpComments) {
		this.initiateDdpComments = initiateDdpComments;
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
