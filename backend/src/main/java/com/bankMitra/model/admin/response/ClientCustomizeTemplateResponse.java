/**
 * 
 */
package com.bankMitra.model.admin.response;


/**
 * @author BankMitra
 *
 */
public class ClientCustomizeTemplateResponse {
	
	private Integer clientId;
	
	private Integer  ddId;
	
	private Integer  loanSchemeId;
	
	private Integer  clientGroupId;
	
	private String clientLoanSchemeName;
	
	private String templateStatus;
	
	private String startDate;
	
	private String endDate;
	
	private String messageCode;
	
	private String messageDescription;

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
	 * @return the templateStatus
	 */
	public String getTemplateStatus() {
		return templateStatus;
	}

	/**
	 * @param templateStatus the templateStatus to set
	 */
	public void setTemplateStatus(String templateStatus) {
		this.templateStatus = templateStatus;
	}


	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
