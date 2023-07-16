/**
 * 
 */
package com.bankMitra.exception;

/**
 * @author BankMitra
 *
 */
public class DataAccessException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1169931870685122167L;

	private transient Object object;
	
	private Exception exception;
	
	private String errorCode = null;

	public DataAccessException(String errorCode,String message, Exception exp) {
		super(message);
		this.errorCode = errorCode;
		this.exception = exp;
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}
	
	public DataAccessException (String message,Object obj) {
		super(message);
		this.object = obj;
	}
	
	public DataAccessException(String errorCode, String message,Object obj) {
		super(message);
		this.errorCode = errorCode;
		this.object = obj;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
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

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
}
