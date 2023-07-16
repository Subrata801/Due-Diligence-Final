/**
 * 
 */
package com.bankMitra.model.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
@JsonInclude(Include.NON_NULL)
@ApiModel(value="ResponseWrapperWithError")
public class ResponseWrapperWithError<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5271080038975669830L;
	
	@ApiModelProperty(value="Api MetaData" , required=true)
	MetaData metaData;
	
	public ResponseWrapperWithError(){}
	
	public ResponseWrapperWithError(MetaData metaData) {
		this.metaData = metaData;
	}

	/**
	 * @return the metaData
	 */
	public MetaData getMetaData() {
		return metaData;
	}

	/**
	 * @param metaData the metaData to set
	 */
	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}
	
	
	
}
