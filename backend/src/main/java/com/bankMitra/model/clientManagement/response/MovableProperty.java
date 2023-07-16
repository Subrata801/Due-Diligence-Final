/**
 * 
 */
package com.bankMitra.model.clientManagement.response;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
//@Entity
public class MovableProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Movable Property Id")
	private Integer propertyId;
	
	@ApiModelProperty(notes = "Movable Property Name")
	private String propertyName;
	
	private Boolean checked;

	/**
	 * @return the propertyId
	 */
	public Integer getPropertyId() {
		return propertyId;
	}

	/**
	 * @param propertyId the propertyId to set
	 */
	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}

	/**
	 * @return the propertyName
	 */
	public String getPropertyName() {
		return propertyName;
	}

	/**
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public Boolean getChecked() {
		return checked;
	}

	public void setChecked(Boolean checked) {
		this.checked = checked;
	}


}
