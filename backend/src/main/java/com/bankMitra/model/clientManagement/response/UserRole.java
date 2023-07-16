/**
 * 
 */
package com.bankMitra.model.clientManagement.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
public class UserRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "UserRole Id")
	private Integer userRoleId;
	
	@ApiModelProperty(notes = "UserRole Name")
	private String userRoleName;

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


}
