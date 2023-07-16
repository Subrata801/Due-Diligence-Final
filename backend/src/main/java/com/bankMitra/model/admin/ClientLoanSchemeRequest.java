/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author BankMitra
 *
 */
public class ClientLoanSchemeRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 763732170027435939L;

	private Integer clientGroupId;
	
	private Integer clientTypeId;
	
	private Integer clientId;
	
	private Integer loanSchemeId;
	
	private String loanSchemeName;
	
	private String clientLoanSchemeName;
	
	private String loanSchemeNameKeyword;
	
	private String action;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private List<ClientLoanSchemeRequest> schemeRequestForValidation;
	
	private List<ClientLoanSchemeRequest> loanSchemeDetails;


	/**
	 * @return the clientLoanSchemeName
	 */
	public String getClientLoanSchemeName() {
		return clientLoanSchemeName;
	}

	/**
	 * @param clientLoanSchemeName the clientLoanSchemeName to set
	 */
	public void setClientLoanSchemeName(String clientLoanSchemeName) {
		this.clientLoanSchemeName = clientLoanSchemeName;
	}

	/**
	 * @return the clientTypeId
	 */
	public Integer getClientTypeId() {
		return clientTypeId;
	}

	/**
	 * @param clientTypeId the clientTypeId to set
	 */
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	/**
	 * @return the loanSchemeDetails
	 */
	public List<ClientLoanSchemeRequest> getLoanSchemeDetails() {
		return loanSchemeDetails;
	}

	/**
	 * @param loanSchemeDetails the loanSchemeDetails to set
	 */
	public void setLoanSchemeDetails(List<ClientLoanSchemeRequest> loanSchemeDetails) {
		this.loanSchemeDetails = loanSchemeDetails;
	}

	/**
	 * @return the loanSchemeNameKeyword
	 */
	public String getLoanSchemeNameKeyword() {
		return loanSchemeNameKeyword;
	}

	/**
	 * @param loanSchemeNameKeyword the loanSchemeNameKeyword to set
	 */
	public void setLoanSchemeNameKeyword(String loanSchemeNameKeyword) {
		this.loanSchemeNameKeyword = loanSchemeNameKeyword;
	}

	/**
	 * @return the schemeRequestForValidation
	 */
	public List<ClientLoanSchemeRequest> getSchemeRequestForValidation() {
		return schemeRequestForValidation;
	}

	/**
	 * @param schemeRequestForValidation the schemeRequestForValidation to set
	 */
	public void setSchemeRequestForValidation(List<ClientLoanSchemeRequest> schemeRequestForValidation) {
		this.schemeRequestForValidation = schemeRequestForValidation;
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
	 * @return the clientGroupId
	 */
	public Integer getClientGroupId() {
		return clientGroupId;
	}

	/**
	 * @param clientGroupId the clientGroupId to set
	 */
	public void setClientGroupId(Integer clientGroupId) {
		this.clientGroupId = clientGroupId;
	}

	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
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
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
