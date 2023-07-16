/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class Contact implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5047545497303795178L;

	private String pointOfContact;
	
	private String designation;

	private String mobileNum;
	
	private String officialEmailId;
	
	private String contactStatus;

	/**
	 * @return the pointOfContact
	 */
	public String getPointOfContact() {
		return pointOfContact;
	}

	/**
	 * @param pointOfContact the pointOfContact to set
	 */
	public void setPointOfContact(String pointOfContact) {
		this.pointOfContact = pointOfContact;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the mobileNum
	 */
	public String getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	/**
	 * @return the officialEmailId
	 */
	public String getOfficialEmailId() {
		return officialEmailId;
	}

	/**
	 * @param officialEmailId the officialEmailId to set
	 */
	public void setOfficialEmailId(String officialEmailId) {
		this.officialEmailId = officialEmailId;
	}

	/**
	 * @return the contactStatus
	 */
	public String getContactStatus() {
		return contactStatus;
	}

	/**
	 * @param contactStatus the contactStatus to set
	 */
	public void setContactStatus(String contactStatus) {
		this.contactStatus = contactStatus;
	}
	
}
