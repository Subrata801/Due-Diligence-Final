/**
 * 
 */
package com.bankMitra.model.admin.response;

/**
 * @author BankMitra
 *
 */
public class RiskRatingResponse {
	
	private String messageCode;
	
	private String messageDescription;

	private Integer responseId;
	
	private String responseKey;
	
	private String responseDesc;
	
	private Integer generalScore;
	
	private String colorCode;
	
	private String responseHexCode;

	private Integer applicantScore;
	
	private Integer coApplicantScore;
	
	private Integer guarantorScore;
	
	/**
	 * @return the responseKey
	 */
	public String getResponseKey() {
		return responseKey;
	}

	/**
	 * @param responseKey the responseKey to set
	 */
	public void setResponseKey(String responseKey) {
		this.responseKey = responseKey;
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
	
}
