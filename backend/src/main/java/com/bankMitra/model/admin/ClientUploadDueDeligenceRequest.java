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
public class ClientUploadDueDeligenceRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 763732170027435939L;

	private Integer ddId;
	
	private Integer templateId;
	
	private String loanSchemeKeyword;
	
    private String status;
    
	private String actionPoint;
	
	private String action;
	
	private String userName;
    
	private List<ClientDueDeligenceArray> dueDelegencyList;


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

	/**
	 * @return the dueDelegencyList
	 */
	public List<ClientDueDeligenceArray> getDueDelegencyList() {
		return dueDelegencyList;
	}

	/**
	 * @param dueDelegencyList the dueDelegencyList to set
	 */
	public void setDueDelegencyList(List<ClientDueDeligenceArray> dueDelegencyList) {
		this.dueDelegencyList = dueDelegencyList;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
