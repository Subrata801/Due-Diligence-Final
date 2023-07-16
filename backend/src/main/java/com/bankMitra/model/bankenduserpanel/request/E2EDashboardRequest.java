/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class E2EDashboardRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String moduleName;
	
	private String bankName;
	
	private String clientId;
	
	private String clientGroupId;
	
	private String userName;
	
	private String branchName;
	
	private String e2eNum;
	
	private String createdBy;

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
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
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
	 * @return the e2eNum
	 */
	public String getE2eNum() {
		return e2eNum;
	}

	/**
	 * @param e2eNum the e2eNum to set
	 */
	public void setE2eNum(String e2eNum) {
		this.e2eNum = e2eNum;
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

}
