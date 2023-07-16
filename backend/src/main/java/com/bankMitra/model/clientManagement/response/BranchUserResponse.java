/**
 * 
 */
package com.bankMitra.model.clientManagement.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class BranchUserResponse implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8558651600485195374L;

	private String unitName;
	
	private Integer clientGroupId;
	
	private Integer userRoleId;
	
	private String userRoleName;
	
	private String employeeName;
	
	private String employeeMail;
	
	private String employeeId;
	
	private String userName;
	
	private Integer userId;
	
	private String password;
	
	private String e2eStatus;
	
	private String updatedDate;
	
    private Integer clientTypeId;
	
	private String clientName;
	
	private Integer clientId;
	
	private String messageCode;
	
	private String messageDescription;
	
	private String lastUpdatedBy;
	
	private String createdBy;
	
	/**
	 * @return the userRoleName
	 */
	public String getUserRoleName() {
		return userRoleName;
	}

	/**
	 * @param userRoleName the userRoleName to set
	 */
	public void setUserRoleName(String userRoleName) {
		this.userRoleName = userRoleName;
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
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	/**
	 * @return the employeeMail
	 */
	public String getEmployeeMail() {
		return employeeMail;
	}

	/**
	 * @param employeeMail the employeeMail to set
	 */
	public void setEmployeeMail(String employeeMail) {
		this.employeeMail = employeeMail;
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
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return the userRoleId
	 */
	public Integer getUserRoleId() {
		return userRoleId;
	}

	/**
	 * @param userRoleId the userRoleId to set
	 */
	public void setUserRoleId(Integer userRoleId) {
		this.userRoleId = userRoleId;
	}

	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeId
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
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
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the e2eStatus
	 */
	public String getE2eStatus() {
		return e2eStatus;
	}

	/**
	 * @param e2eStatus the e2eStatus to set
	 */
	public void setE2eStatus(String e2eStatus) {
		this.e2eStatus = e2eStatus;
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
