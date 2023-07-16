/**
 * 
 */
package com.bankMitra.model.admin.response;

/**
 * @author BankMitra
 *
 */
public class ClientLoanVariantResponse {
	
	private Integer loanSchemeId;
	
	private Integer clientGroupId;
	
	private String loanSchemeName;
	
	private String clientLoanSchemeName;
	
	private Integer loanVariantId;
	
	private String loanVariantName;
	
	private String preferredLoanVariantName;
	
	private String loanVariantKeyword;
	
	private String messageCode;
	
	private String messageDescription;

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
