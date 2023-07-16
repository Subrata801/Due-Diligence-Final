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
public class MoveableProperty implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Moveable Property Id")
	private Integer movablePropertyId;

	/**
	 * @return the movablePropertyId
	 */
	public Integer getMovablePropertyId() {
		return movablePropertyId;
	}

	/**
	 * @param movablePropertyId the movablePropertyId to set
	 */
	public void setMovablePropertyId(Integer movablePropertyId) {
		this.movablePropertyId = movablePropertyId;
	}
	
	
}
