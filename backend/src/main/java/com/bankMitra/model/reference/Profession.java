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
//@Table(	name = "bmprofession",schema="bmadmin")
public class Profession implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Profession Id")
	private Integer professionId;
	
	@ApiModelProperty(notes = "Profession Name")
	private String professionName;

	/**
	 * @return the professionId
	 */
	public Integer getProfessionId() {
		return professionId;
	}

	/**
	 * @param professionId the professionId to set
	 */
	public void setProfessionId(Integer professionId) {
		this.professionId = professionId;
	}

	/**
	 * @return the professionName
	 */
	public String getProfessionName() {
		return professionName;
	}

	/**
	 * @param professionName the professionName to set
	 */
	public void setProfessionName(String professionName) {
		this.professionName = professionName;
	}

}
