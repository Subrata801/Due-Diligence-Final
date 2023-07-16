/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class GuarantorDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String profile;
	
	private String nameOfGuarantor;
	
	private boolean selectedGurantor;
	private String guarantorName;
	private String guarantorDesc;

	/**
	 * @return the selectedGurantor
	 */
	public boolean isSelectedGurantor() {
		return selectedGurantor;
	}

	/**
	 * @param selectedGurantor the selectedGurantor to set
	 */
	public void setSelectedGurantor(boolean selectedGurantor) {
		this.selectedGurantor = selectedGurantor;
	}

	/**
	 * @return the guarantorName
	 */
	public String getGuarantorName() {
		return guarantorName;
	}

	/**
	 * @param guarantorName the guarantorName to set
	 */
	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}

	/**
	 * @return the guarantorDesc
	 */
	public String getGuarantorDesc() {
		return guarantorDesc;
	}

	/**
	 * @param guarantorDesc the guarantorDesc to set
	 */
	public void setGuarantorDesc(String guarantorDesc) {
		this.guarantorDesc = guarantorDesc;
	}

	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * @return the nameOfGuarantor
	 */
	public String getNameOfGuarantor() {
		return nameOfGuarantor;
	}

	/**
	 * @param nameOfGuarantor the nameOfGuarantor to set
	 */
	public void setNameOfGuarantor(String nameOfGuarantor) {
		this.nameOfGuarantor = nameOfGuarantor;
	}

}
