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
//@Table(	name = "bmusertypes",schema="bmadmin")
public class HeaderKey implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Header key Id")
	private Integer headerKey;
	
	@ApiModelProperty(notes = "Header Key Name")
	private String headerKeyDescription;

	/**
	 * @return the headerKey
	 */
	public Integer getHeaderKey() {
		return headerKey;
	}

	/**
	 * @param headerKey the headerKey to set
	 */
	public void setHeaderKey(Integer headerKey) {
		this.headerKey = headerKey;
	}

	/**
	 * @return the headerKeyDescription
	 */
	public String getHeaderKeyDescription() {
		return headerKeyDescription;
	}

	/**
	 * @param headerKeyDescription the headerKeyDescription to set
	 */
	public void setHeaderKeyDescription(String headerKeyDescription) {
		this.headerKeyDescription = headerKeyDescription;
	}
	
}
