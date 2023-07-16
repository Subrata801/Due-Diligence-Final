/**
 * 
 */
package com.bankMitra.model.clientManagement.response;

/**
 * @author BankMitra
 *
 */
public class EmployeeUploadResponse {

	private String successCount;
	
	private String success;
	
	private String failureCount;
	
	private String messageCode;
	
	private String messageDescription;

	/**
	 * @return the success
	 */
	public String getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(String success) {
		this.success = success;
	}

	/**
	 * @return the successCount
	 */
	public String getSuccessCount() {
		return successCount;
	}

	/**
	 * @param successCount the successCount to set
	 */
	public void setSuccessCount(String successCount) {
		this.successCount = successCount;
	}

	/**
	 * @return the failureCount
	 */
	public String getFailureCount() {
		return failureCount;
	}

	/**
	 * @param failureCount the failureCount to set
	 */
	public void setFailureCount(String failureCount) {
		this.failureCount = failureCount;
	}

	/**
	 * @return the messageCode
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param messageCode the messageCode to set
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @return the messageDescription
	 */
	public String getMessageDescription() {
		return messageDescription;
	}

	/**
	 * @param messageDescription the messageDescription to set
	 */
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

}
