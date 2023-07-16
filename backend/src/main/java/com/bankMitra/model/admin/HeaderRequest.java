/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class HeaderRequest implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3204916206018778405L;

	private String headerKey;
	
	private String englishDescription;
	
	private String nonEnglishDescription;
	
	private String createdBy;
	
	private Date createdDate;
	
	private String updatedBy;
	
	private Date updatedDate;
	
	private String headerRequestType;
	
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

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the headerRequestType
	 */
	public String getHeaderRequestType() {
		return headerRequestType;
	}

	/**
	 * @param headerRequestType the headerRequestType to set
	 */
	public void setHeaderRequestType(String headerRequestType) {
		this.headerRequestType = headerRequestType;
	}

}
