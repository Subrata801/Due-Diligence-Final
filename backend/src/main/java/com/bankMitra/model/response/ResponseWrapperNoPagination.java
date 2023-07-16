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
@ApiModel(value="ResponseWrapperNoPagination")
public class ResponseWrapperNoPagination<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3658140445428804596L;
	
	@ApiModelProperty(value="Api MetaData" , required=true)
	MetaData metaData;
	
	@ApiModelProperty(value="Response Data" , required=true)
	private T data;
	
	public ResponseWrapperNoPagination(){}
	
	public ResponseWrapperNoPagination(MetaData metaData,T data){
		this.metaData = metaData;
		this.data = data;
	}
	
	public ResponseWrapperNoPagination(T data){
		this.data = data;
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

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(T data) {
		this.data = data;
	}

}
