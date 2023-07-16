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
@ApiModel(value="ResponseWithPagination")
public class ResponseWithPagination<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3658140445428804596L;
	
	@ApiModelProperty(value="Api MetaData" , required=true)
	MetaData metaData;
	
	@ApiModelProperty(value="Response Data" , required=true)
	private T data;
	
	@ApiModelProperty(value="Pagination" , required=true)
	private Pagination pagination;
	
	public ResponseWithPagination(){}
	
	public ResponseWithPagination(MetaData metaData,T Data,Pagination pagination){
		this.metaData = metaData;
		this.data = data;
		this.pagination = pagination;
	}
	
	public ResponseWithPagination(MetaData metaData,T data){
		this.metaData = metaData;
		this.data = data;
	}
	
	public ResponseWithPagination(T data){
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
