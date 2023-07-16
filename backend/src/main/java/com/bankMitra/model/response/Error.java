/**
 * 
 */
package com.bankMitra.model.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author BankMitra
 *
 */
@JsonInclude(Include.NON_NULL)
public class Error implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6620991175203264787L;

	private String code;
	
	private String message;
	
	private List<FieldErrors> fieldErrors;
	
	private Object data;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the fieldErrors
	 */
	public List<FieldErrors> getFieldErrors() {
		return fieldErrors;
	}

	/**
	 * @param fieldErrors the fieldErrors to set
	 */
	public void setFieldErrors(List<FieldErrors> fieldErrors) {
		this.fieldErrors = fieldErrors;
	}

	/**
	 * @return the data
	 */
	public Object getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 */
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
