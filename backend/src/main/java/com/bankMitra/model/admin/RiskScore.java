/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class RiskScore implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4804662104920188548L;

	private Integer responseId;
	
	private String responseDesc;
	
	private String colorCode;
	
	private String responseHexCode;

	private Integer generalScore;
	
	private Integer applicantScore;
	
	private Integer coApplicantScore;
	
	private Integer guarantorScore;

	/**
	 * @return the responseId
	 */
	public Integer getResponseId() {
		return responseId;
	}

	/**
	 * @param responseId the responseId to set
	 */
	public void setResponseId(Integer responseId) {
		this.responseId = responseId;
	}

	/**
	 * @return the generalScore
	 */
	public Integer getGeneralScore() {
		return generalScore;
	}

	/**
	 * @param generalScore the generalScore to set
	 */
	public void setGeneralScore(Integer generalScore) {
		this.generalScore = generalScore;
	}

	/**
	 * @return the applicantScore
	 */
	public Integer getApplicantScore() {
		return applicantScore;
	}

	/**
	 * @param applicantScore the applicantScore to set
	 */
	public void setApplicantScore(Integer applicantScore) {
		this.applicantScore = applicantScore;
	}

	/**
	 * @return the coApplicantScore
	 */
	public Integer getCoApplicantScore() {
		return coApplicantScore;
	}

	/**
	 * @param coApplicantScore the coApplicantScore to set
	 */
	public void setCoApplicantScore(Integer coApplicantScore) {
		this.coApplicantScore = coApplicantScore;
	}

	/**
	 * @return the guarantorScore
	 */
	public Integer getGuarantorScore() {
		return guarantorScore;
	}

	/**
	 * @param guarantorScore the guarantorScore to set
	 */
	public void setGuarantorScore(Integer guarantorScore) {
		this.guarantorScore = guarantorScore;
	}

	/**
	 * @return the responseDesc
	 */
	public String getResponseDesc() {
		return responseDesc;
	}

	/**
	 * @param responseDesc the responseDesc to set
	 */
	public void setResponseDesc(String responseDesc) {
		this.responseDesc = responseDesc;
	}

	/**
	 * @return the colorCode
	 */
	public String getColorCode() {
		return colorCode;
	}

	/**
	 * @param colorCode the colorCode to set
	 */
	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	/**
	 * @return the responseHexCode
	 */
	public String getResponseHexCode() {
		return responseHexCode;
	}

	/**
	 * @param responseHexCode the responseHexCode to set
	 */
	public void setResponseHexCode(String responseHexCode) {
		this.responseHexCode = responseHexCode;
	}
	
}
