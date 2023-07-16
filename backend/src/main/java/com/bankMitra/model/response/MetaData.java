/**
 * 
 */
package com.bankMitra.model.response;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
@ApiModel(description="API MetaData")
public class MetaData {

	@ApiModelProperty(value="Success/Failure" , required=true)
	boolean success;
	
	@ApiModelProperty(value="Unique ResponseId" , required=true)
	String responseId;
	
	@ApiModelProperty(value="Api Description" , required=true)
	String description;
	
	@ApiModelProperty(value="Error" , required=false)
	@JsonInclude(JsonInclude.Include.NON_DEFAULT)
	private Error error;
	
	public MetaData () {}
	
	public MetaData(boolean success,String description,Error error){
		this.success = success;
		this.responseId = UUID.randomUUID().toString();
		this.description = description;
		this.error = error;
	}
	
	public MetaData(boolean success,String description){
		this.success = success;
		this.description = description;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the responseId
	 */
	public String getResponseId() {
		return responseId;
	}

	/**
	 * @param responseId the responseId to set
	 */
	public void setResponseId(String responseId) {
		this.responseId = responseId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the error
	 */
	public Error getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(Error error) {
		this.error = error;
	}
	
	
}
