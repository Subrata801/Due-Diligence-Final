/**
 * 
 */
package com.bankMitra.model.admin.response;

/**
 * @author BankMitra
 *
 */
public class TemplateUploadResponse {

	private String ddId;
	
	private String workSheetName;
	
	private String numOfLoanSchemes;
	
	private String numOfDDaps;
	
	private String status;
	
	private String importedDate;
	
	private String successCount;
	
	private String failureCount;
	
	private String messageCode;
	
	private String messageDescription;



	/**
	 * @return the importedDate
	 */
	public String getImportedDate() {
		return importedDate;
	}

	/**
	 * @param importedDate the importedDate to set
	 */
	public void setImportedDate(String importedDate) {
		this.importedDate = importedDate;
	}

	/**
	 * @return the ddId
	 */
	public String getDdId() {
		return ddId;
	}

	/**
	 * @param ddId the ddId to set
	 */
	public void setDdId(String ddId) {
		this.ddId = ddId;
	}

	/**
	 * @return the workSheetName
	 */
	public String getWorkSheetName() {
		return workSheetName;
	}

	/**
	 * @param workSheetName the workSheetName to set
	 */
	public void setWorkSheetName(String workSheetName) {
		this.workSheetName = workSheetName;
	}

	/**
	 * @return the numOfLoanSchemes
	 */
	public String getNumOfLoanSchemes() {
		return numOfLoanSchemes;
	}

	/**
	 * @param numOfLoanSchemes the numOfLoanSchemes to set
	 */
	public void setNumOfLoanSchemes(String numOfLoanSchemes) {
		this.numOfLoanSchemes = numOfLoanSchemes;
	}

	/**
	 * @return the numOfDDaps
	 */
	public String getNumOfDDaps() {
		return numOfDDaps;
	}

	/**
	 * @param numOfDDaps the numOfDDaps to set
	 */
	public void setNumOfDDaps(String numOfDDaps) {
		this.numOfDDaps = numOfDDaps;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
