/**
 * 
 */
package com.bankMitra.model.reference;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
//@Entity
//@Table(	name = "bmborrowertype",schema="bmadmin")
public class BorrowerType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Borrower Type Id")
	private Integer borrowerTypeId;
	
	@ApiModelProperty(notes = "Borrower Type Name")
	private String borrowerTypeName;

	/**
	 * @return the borrowerTypeId
	 */
	public Integer getBorrowerTypeId() {
		return borrowerTypeId;
	}

	/**
	 * @param borrowerTypeId the borrowerTypeId to set
	 */
	public void setBorrowerTypeId(Integer borrowerTypeId) {
		this.borrowerTypeId = borrowerTypeId;
	}

	/**
	 * @return the borrowerTypeName
	 */
	public String getBorrowerTypeName() {
		return borrowerTypeName;
	}

	/**
	 * @param borrowerTypeName the borrowerTypeName to set
	 */
	public void setBorrowerTypeName(String borrowerTypeName) {
		this.borrowerTypeName = borrowerTypeName;
	}

}
