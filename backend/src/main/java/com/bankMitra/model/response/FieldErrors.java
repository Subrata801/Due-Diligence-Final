/**
 * 
 */
package com.bankMitra.model.response;

/**
 * @author BankMitra
 *
 */
public class FieldErrors {

	private String code;
	
	private String fieldName;
	
	private String message;
	
	public FieldErrors(String code, String fieldName,String message) {
		this.code = code;
		this.fieldName = fieldName;
		this.message = message;
	}
	
	public FieldErrors(String fieldName,String message) {
		this.fieldName = fieldName;
		this.message = message;
	}

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
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}

	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
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
	
}
