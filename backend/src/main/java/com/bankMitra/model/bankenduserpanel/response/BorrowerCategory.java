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
public class BorrowerCategory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "BorrowerCategory Id")
	private Integer borrowerCategoryId;
	
	@ApiModelProperty(notes = "BorrowerCategory Name")
	private String borrowerCategoryName;

	/**
	 * @return the borrowerCategoryId
	 */
	public Integer getBorrowerCategoryId() {
		return borrowerCategoryId;
	}

	/**
	 * @param borrowerCategoryId the borrowerCategoryId to set
	 */
	public void setBorrowerCategoryId(Integer borrowerCategoryId) {
		this.borrowerCategoryId = borrowerCategoryId;
	}

	/**
	 * @return the borrowerCategoryName
	 */
	public String getBorrowerCategoryName() {
		return borrowerCategoryName;
	}

	/**
	 * @param borrowerCategoryName the borrowerCategoryName to set
	 */
	public void setBorrowerCategoryName(String borrowerCategoryName) {
		this.borrowerCategoryName = borrowerCategoryName;
	}

}
