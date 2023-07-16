/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class ClientLoanVariantRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 758276040107684218L;

	private Integer loanSchemeId;
	
	private Integer clientGroupId;
	
	private Integer loanVariantId;
	
	private String loanVariantKeyword;
	
	private String loanVariantName;
	
	private String preferredLoanVariantName;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private String action;



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
	 * @return the preferredLoanVariantName
	 */
	public String getPreferredLoanVariantName() {
		return preferredLoanVariantName;
	}

	/**
	 * @param preferredLoanVariantName the preferredLoanVariantName to set
	 */
	public void setPreferredLoanVariantName(String preferredLoanVariantName) {
		this.preferredLoanVariantName = preferredLoanVariantName;
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
	 * @return the loanVariantKeyword
	 */
	public String getLoanVariantKeyword() {
		return loanVariantKeyword;
	}

	/**
	 * @param loanVariantKeyword the loanVariantKeyword to set
	 */
	public void setLoanVariantKeyword(String loanVariantKeyword) {
		this.loanVariantKeyword = loanVariantKeyword;
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

}
