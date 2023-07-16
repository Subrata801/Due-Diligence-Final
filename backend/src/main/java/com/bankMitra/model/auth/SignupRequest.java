package com.bankMitra.model.auth;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author BankMitra
 *
 */
public class SignupRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3928250616578401145L;
	
	private Integer userId;
	
	private Integer userTypeId;
	
	private Integer clientTypeId;
	
	private Integer clientId;
	
	private Integer clientGroupId;
	
	private String clientName;
	//@NotNull(message = "Full Name should not be null")
	//@NotEmpty(message = "Full Name should not be empty")
	private String fullName;
	
	//@NotNull(message = "Email Id should not be null")
	//@NotEmpty(message = "Email Id should not be empty")
	//@Pattern(regexp=".+@.+\\.[a-z]+")
	private String email;
	
	//@Size(min = 10,max = 10)
	//@Min(10)
	//@Max(10)
	//@Pattern(regexp="([0-9|a-z|A-Z|_|$|.])*",message="value can contain only digits,alphabets or _ or . or $")
	private String mobileNum;

	//@NotNull(message = "Use Name should not be null")
	//@NotEmpty(message = "Use Name should not be empty")
	private String userName;
	
	//@NotNull(message = "Passowrd should not be null")
	//@NotEmpty(message = "Passowrd should not be empty")
	private String password;
	
	//@NotNull(message = "Please select a status")
	//@NotEmpty(message = "Please select a status")
	private String userStatus;
	
	private Integer userRoleId;
	private String employeeId;
	private String createdBy;
	
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
	 * @return the userTypeId
	 */
	public Integer getUserTypeId() {
		return userTypeId;
	}
	/**
	 * @param userTypeId the userTypeId to set
	 */
	public void setUserTypeId(Integer userTypeId) {
		this.userTypeId = userTypeId;
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
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}
	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobileNum
	 */
	public String getMobileNum() {
		return mobileNum;
	}
	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(String mobileNum) {
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
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}
	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
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
}
