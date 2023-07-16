/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class CoApplicantDetails implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String nameOfCoApplicant;
	
	private String designation;
	private boolean selectedCoApplicant;
	private String profile;
	private String coapplicantName;
	private String coappDesignation;

	

	/**
	 * @return the selectedCoApplicant
	 */
	public boolean getSelectedCoApplicant() {
		return selectedCoApplicant;
	}

	/**
	 * @param selectedCoApplicant the selectedCoApplicant to set
	 */
	public void setSelectedCoApplicant(boolean selectedCoApplicant) {
		this.selectedCoApplicant = selectedCoApplicant;
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
	 * @return the coapplicantName
	 */
	public String getCoapplicantName() {
		return coapplicantName;
	}

	/**
	 * @param coapplicantName the coapplicantName to set
	 */
	public void setCoapplicantName(String coapplicantName) {
		this.coapplicantName = coapplicantName;
	}

	/**
	 * @return the coappDesignation
	 */
	public String getCoappDesignation() {
		return coappDesignation;
	}

	/**
	 * @param coappDesignation the coappDesignation to set
	 */
	public void setCoappDesignation(String coappDesignation) {
		this.coappDesignation = coappDesignation;
	}

	/**
	 * @return the nameOfCoApplicant
	 */
	public String getNameOfCoApplicant() {
		return nameOfCoApplicant;
	}

	/**
	 * @param nameOfCoApplicant the nameOfCoApplicant to set
	 */
	public void setNameOfCoApplicant(String nameOfCoApplicant) {
		this.nameOfCoApplicant = nameOfCoApplicant;
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

}
