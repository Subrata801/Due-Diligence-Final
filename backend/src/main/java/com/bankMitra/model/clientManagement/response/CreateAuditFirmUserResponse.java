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
public class CreateAuditFirmUserResponse implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8558651600485195374L;

	private Long userId;
	
	private Integer userRoleId;
	
	private String employeeId;
	
	private String employeeName;
	
	private String employeeMail;
	
	private Long mobileNum;
	
	private String userName;
	
	private String password;
	
	private String cncStatus;
	
	private Integer clientTypeId;
	
	private String clientName;
	
	private Integer clientId;
	
	private String messageCode;
	
	private String messageDescription;
	
	private String createdBy;
	
	private String lastUpdatedBy;
	
	private Date updatedDate;

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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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
	 * @return the mobileNum
	 */
	public Long getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
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
	 * @return the cncStatus
	 */
	public String getCncStatus() {
		return cncStatus;
	}

	/**
	 * @param cncStatus the cncStatus to set
	 */
	public void setCncStatus(String cncStatus) {
		this.cncStatus = cncStatus;
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
	
}
