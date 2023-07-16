/**
 * 
 */
package com.bankMitra.exception;

/**
 * @author BankMitra
 *
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	private Exception exception;
	private String errorCode = null;
	
	public ResourceNotFoundException(String errorMsg) {
		super(errorMsg);
	}
	
	public ResourceNotFoundException(String errorMsg,Exception exception) {
		super(errorMsg);
		this.exception = exception;
	}

	public ResourceNotFoundException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	/**
	 * @return the exception
	 */
	public Exception getException() {
		return exception;
	}

	/**
	 * @param exception the exception to set
	 */
	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	
}
