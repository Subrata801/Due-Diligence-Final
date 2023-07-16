/**
 * 
 */
package com.bankMitra.model.admin.response;

/**
 * @author BankMitra
 *
 */
public class ClientLoanSchemeResponse {
	
	private Integer clientId;
	
	private Integer clientGroupId;
	
	private String loanSchemeName;
	
	private Integer loanSchemeId;
	
	private String clientLoanSchemeName;
	
	private String loanSchemeNameKeyword;
	
	private String messageCode;
	
	private String messageDescription;


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
