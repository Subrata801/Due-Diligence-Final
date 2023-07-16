/**
 * 
 */
package com.bankMitra.model.admin.response;

/**
 * @author BankMitra
 *
 */
public class HeaderResponse {
	
	private String headerKey;
	
	private String englishDescription;
	
	private String nonEnglishDescription;
	
	private String messageCode;
	
	private String messageDescription;

	/**
	 * @return the headerKey
	 */
	public String getHeaderKey() {
		return headerKey;
	}

	/**
	 * @param headerKey the headerKey to set
	 */
	public void setHeaderKey(String headerKey) {
		this.headerKey = headerKey;
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

	/**
	 * @return the englishDescription
	 */
	public String getEnglishDescription() {
		return englishDescription;
	}

	/**
	 * @param englishDescription the englishDescription to set
	 */
	public void setEnglishDescription(String englishDescription) {
		this.englishDescription = englishDescription;
	}

	/**
	 * @return the nonEnglishDescription
	 */
	public String getNonEnglishDescription() {
		return nonEnglishDescription;
	}

	/**
	 * @param nonEnglishDescription the nonEnglishDescription to set
	 */
	public void setNonEnglishDescription(String nonEnglishDescription) {
		this.nonEnglishDescription = nonEnglishDescription;
	}

}
