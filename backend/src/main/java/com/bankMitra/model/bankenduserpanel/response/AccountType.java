/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
public class AccountType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Account Type Id")
	private Integer accountTypeId;
	
	@ApiModelProperty(notes = "Account Type Name")
	private String accountTypeName;

	/**
	 * @return the accountTypeId
	 */
	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	/**
	 * @param accountTypeId the accountTypeId to set
	 */
	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	/**
	 * @return the accountTypeName
	 */
	public String getAccountTypeName() {
		return accountTypeName;
	}

	/**
	 * @param accountTypeName the accountTypeName to set
	 */
	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}



}
