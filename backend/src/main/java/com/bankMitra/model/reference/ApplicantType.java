/**
 * 
 */
package com.bankMitra.model.reference;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */
public class ApplicantType implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(notes = "Applicant Type Id")
	private Integer applicantTypeId;
	
	@ApiModelProperty(notes = "Applicant Type Name")
	private String applicantTypeName;

	/**
	 * @return the applicantTypeId
	 */
	public Integer getApplicantTypeId() {
		return applicantTypeId;
	}

	/**
	 * @param applicantTypeId the applicantTypeId to set
	 */
	public void setApplicantTypeId(Integer applicantTypeId) {
		this.applicantTypeId = applicantTypeId;
	}

	/**
	 * @return the applicantTypeName
	 */
	public String getApplicantTypeName() {
		return applicantTypeName;
	}

	/**
	 * @param applicantTypeName the applicantTypeName to set
	 */
	public void setApplicantTypeName(String applicantTypeName) {
		this.applicantTypeName = applicantTypeName;
	}

}
