/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.Map;

/**
 * @author BankMitra
 *
 */
public class ViewDueDeligenceResponse implements Serializable {
	
	private static final long serialVersionUID = 7457751716767909084L;
	private String loanApplicationId;
	private String header1;
	private String header1desc;
	private String header2;
	private String header2desc;
	private String header3;
	private String header3desc;
	private String header4;
	private String header4desc;
	private String ddSequence;
	private String totalResponseExpected;
	private String totalResponseFilled;
	
	private String ddParentSequence;
	private String ddData;
	private String schmemaNormPlaceHolderValues;
	private String schmemaNormUiValidValue;
	private String schmemaNormColor;
	private String applicantPlaceHolderValues;
	private String applicantUiValidValue;
	private String applicantColor;
	private String coapplicantplaceholdervalues;
	private String coapplicantuivalidvalue;
	private String coapplicantcolor;
	private String coapplicant1placeholdervalues;
	private String coapplicant1uivalidvalue;
	private String coapplicant1color;
	private String coapplicant2placeholdervalues;
	private String coapplicant2uivalidvalue;
	private String coapplicant2color;
	private String coapplicant3placeholdervalues;
	private String coapplicant3uivalidvalue;
	private String coapplicant3color;
	private String coapplicant4placeholdervalues;
	private String coapplicant4uivalidvalue;
	private String coapplicant4color;
	private String guarantorplaceholdervalues;
	private String guarantoruivalidvalue;
	private String guarantorcolor;
	private String guarantor1placeholdervalues;
	private String guarantor1uivalidvalue;
	private String guarantor1color;
	private String guarantor2placeholdervalues;
	private String guarantor2uivalidvalue;
	private String guarantor2color;
	private String guarantor3placeholdervalues;
	private String guarantor3uivalidvalue;
	private String guarantor3color;
	private String guarantor4placeholdervalues;
	private String guarantor4uivalidvalue;
	private String guarantor4color;
	
	private String compliancePlaceholdervalues;
	private String complianceUivalidvalue;
	private String complianceColor;
	
	private String auditorComment;
	private String comment;
	
	private Map<String,String> headerMap;
	
	/**
	 * @return the headerMap
	 */
	public Map<String, String> getHeaderMap() {
		return headerMap;
	}
	/**
	 * @param headerMap the headerMap to set
	 */
	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
	}
	/**
	 * @return the compliancePlaceholdervalues
	 */
	public String getCompliancePlaceholdervalues() {
		return compliancePlaceholdervalues;
	}
	/**
	 * @param compliancePlaceholdervalues the compliancePlaceholdervalues to set
	 */
	public void setCompliancePlaceholdervalues(String compliancePlaceholdervalues) {
		this.compliancePlaceholdervalues = compliancePlaceholdervalues;
	}
	/**
	 * @return the complianceUivalidvalue
	 */
	public String getComplianceUivalidvalue() {
		return complianceUivalidvalue;
	}
	/**
	 * @param complianceUivalidvalue the complianceUivalidvalue to set
	 */
	public void setComplianceUivalidvalue(String complianceUivalidvalue) {
		this.complianceUivalidvalue = complianceUivalidvalue;
	}
	/**
	 * @return the complianceColor
	 */
	public String getComplianceColor() {
		return complianceColor;
	}
	/**
	 * @param complianceColor the complianceColor to set
	 */
	public void setComplianceColor(String complianceColor) {
		this.complianceColor = complianceColor;
	}
	/**
	 * @return the ddParentSequence
	 */
	public String getDdParentSequence() {
		return ddParentSequence;
	}
	/**
	 * @param ddParentSequence the ddParentSequence to set
	 */
	public void setDdParentSequence(String ddParentSequence) {
		this.ddParentSequence = ddParentSequence;
	}
	/**
	 * @return the ddData
	 */
	public String getDdData() {
		return ddData;
	}
	/**
	 * @param ddData the ddData to set
	 */
	public void setDdData(String ddData) {
		this.ddData = ddData;
	}
	/**
	 * @return the schmemaNormPlaceHolderValues
	 */
	public String getSchmemaNormPlaceHolderValues() {
		return schmemaNormPlaceHolderValues;
	}
	/**
	 * @param schmemaNormPlaceHolderValues the schmemaNormPlaceHolderValues to set
	 */
	public void setSchmemaNormPlaceHolderValues(String schmemaNormPlaceHolderValues) {
		this.schmemaNormPlaceHolderValues = schmemaNormPlaceHolderValues;
	}
	/**
	 * @return the schmemaNormUiValidValue
	 */
	public String getSchmemaNormUiValidValue() {
		return schmemaNormUiValidValue;
	}
	/**
	 * @param schmemaNormUiValidValue the schmemaNormUiValidValue to set
	 */
	public void setSchmemaNormUiValidValue(String schmemaNormUiValidValue) {
		this.schmemaNormUiValidValue = schmemaNormUiValidValue;
	}
	/**
	 * @return the schmemaNormColor
	 */
	public String getSchmemaNormColor() {
		return schmemaNormColor;
	}
	/**
	 * @param schmemaNormColor the schmemaNormColor to set
	 */
	public void setSchmemaNormColor(String schmemaNormColor) {
		this.schmemaNormColor = schmemaNormColor;
	}
	/**
	 * @return the applicantPlaceHolderValues
	 */
	public String getApplicantPlaceHolderValues() {
		return applicantPlaceHolderValues;
	}
	/**
	 * @param applicantPlaceHolderValues the applicantPlaceHolderValues to set
	 */
	public void setApplicantPlaceHolderValues(String applicantPlaceHolderValues) {
		this.applicantPlaceHolderValues = applicantPlaceHolderValues;
	}
	/**
	 * @return the applicantUiValidValue
	 */
	public String getApplicantUiValidValue() {
		return applicantUiValidValue;
	}
	/**
	 * @param applicantUiValidValue the applicantUiValidValue to set
	 */
	public void setApplicantUiValidValue(String applicantUiValidValue) {
		this.applicantUiValidValue = applicantUiValidValue;
	}
	/**
	 * @return the applicantColor
	 */
	public String getApplicantColor() {
		return applicantColor;
	}
	/**
	 * @param applicantColor the applicantColor to set
	 */
	public void setApplicantColor(String applicantColor) {
		this.applicantColor = applicantColor;
	}
	/**
	 * @return the coapplicantplaceholdervalues
	 */
	public String getCoapplicantplaceholdervalues() {
		return coapplicantplaceholdervalues;
	}
	/**
	 * @param coapplicantplaceholdervalues the coapplicantplaceholdervalues to set
	 */
	public void setCoapplicantplaceholdervalues(String coapplicantplaceholdervalues) {
		this.coapplicantplaceholdervalues = coapplicantplaceholdervalues;
	}
	/**
	 * @return the coapplicantuivalidvalue
	 */
	public String getCoapplicantuivalidvalue() {
		return coapplicantuivalidvalue;
	}
	/**
	 * @param coapplicantuivalidvalue the coapplicantuivalidvalue to set
	 */
	public void setCoapplicantuivalidvalue(String coapplicantuivalidvalue) {
		this.coapplicantuivalidvalue = coapplicantuivalidvalue;
	}
	/**
	 * @return the coapplicantcolor
	 */
	public String getCoapplicantcolor() {
		return coapplicantcolor;
	}
	/**
	 * @param coapplicantcolor the coapplicantcolor to set
	 */
	public void setCoapplicantcolor(String coapplicantcolor) {
		this.coapplicantcolor = coapplicantcolor;
	}
	/**
	 * @return the coapplicant1placeholdervalues
	 */
	public String getCoapplicant1placeholdervalues() {
		return coapplicant1placeholdervalues;
	}
	/**
	 * @param coapplicant1placeholdervalues the coapplicant1placeholdervalues to set
	 */
	public void setCoapplicant1placeholdervalues(String coapplicant1placeholdervalues) {
		this.coapplicant1placeholdervalues = coapplicant1placeholdervalues;
	}
	/**
	 * @return the coapplicant1uivalidvalue
	 */
	public String getCoapplicant1uivalidvalue() {
		return coapplicant1uivalidvalue;
	}
	/**
	 * @param coapplicant1uivalidvalue the coapplicant1uivalidvalue to set
	 */
	public void setCoapplicant1uivalidvalue(String coapplicant1uivalidvalue) {
		this.coapplicant1uivalidvalue = coapplicant1uivalidvalue;
	}
	/**
	 * @return the coapplicant1color
	 */
	public String getCoapplicant1color() {
		return coapplicant1color;
	}
	/**
	 * @param coapplicant1color the coapplicant1color to set
	 */
	public void setCoapplicant1color(String coapplicant1color) {
		this.coapplicant1color = coapplicant1color;
	}
	/**
	 * @return the coapplicant2placeholdervalues
	 */
	public String getCoapplicant2placeholdervalues() {
		return coapplicant2placeholdervalues;
	}
	/**
	 * @param coapplicant2placeholdervalues the coapplicant2placeholdervalues to set
	 */
	public void setCoapplicant2placeholdervalues(String coapplicant2placeholdervalues) {
		this.coapplicant2placeholdervalues = coapplicant2placeholdervalues;
	}
	/**
	 * @return the coapplicant2uivalidvalue
	 */
	public String getCoapplicant2uivalidvalue() {
		return coapplicant2uivalidvalue;
	}
	/**
	 * @param coapplicant2uivalidvalue the coapplicant2uivalidvalue to set
	 */
	public void setCoapplicant2uivalidvalue(String coapplicant2uivalidvalue) {
		this.coapplicant2uivalidvalue = coapplicant2uivalidvalue;
	}
	/**
	 * @return the coapplicant2color
	 */
	public String getCoapplicant2color() {
		return coapplicant2color;
	}
	/**
	 * @param coapplicant2color the coapplicant2color to set
	 */
	public void setCoapplicant2color(String coapplicant2color) {
		this.coapplicant2color = coapplicant2color;
	}
	/**
	 * @return the coapplicant3placeholdervalues
	 */
	public String getCoapplicant3placeholdervalues() {
		return coapplicant3placeholdervalues;
	}
	/**
	 * @param coapplicant3placeholdervalues the coapplicant3placeholdervalues to set
	 */
	public void setCoapplicant3placeholdervalues(String coapplicant3placeholdervalues) {
		this.coapplicant3placeholdervalues = coapplicant3placeholdervalues;
	}
	/**
	 * @return the coapplicant3uivalidvalue
	 */
	public String getCoapplicant3uivalidvalue() {
		return coapplicant3uivalidvalue;
	}
	/**
	 * @param coapplicant3uivalidvalue the coapplicant3uivalidvalue to set
	 */
	public void setCoapplicant3uivalidvalue(String coapplicant3uivalidvalue) {
		this.coapplicant3uivalidvalue = coapplicant3uivalidvalue;
	}
	/**
	 * @return the coapplicant3color
	 */
	public String getCoapplicant3color() {
		return coapplicant3color;
	}
	/**
	 * @param coapplicant3color the coapplicant3color to set
	 */
	public void setCoapplicant3color(String coapplicant3color) {
		this.coapplicant3color = coapplicant3color;
	}
	/**
	 * @return the coapplicant4placeholdervalues
	 */
	public String getCoapplicant4placeholdervalues() {
		return coapplicant4placeholdervalues;
	}
	/**
	 * @param coapplicant4placeholdervalues the coapplicant4placeholdervalues to set
	 */
	public void setCoapplicant4placeholdervalues(String coapplicant4placeholdervalues) {
		this.coapplicant4placeholdervalues = coapplicant4placeholdervalues;
	}
	/**
	 * @return the coapplicant4uivalidvalue
	 */
	public String getCoapplicant4uivalidvalue() {
		return coapplicant4uivalidvalue;
	}
	/**
	 * @param coapplicant4uivalidvalue the coapplicant4uivalidvalue to set
	 */
	public void setCoapplicant4uivalidvalue(String coapplicant4uivalidvalue) {
		this.coapplicant4uivalidvalue = coapplicant4uivalidvalue;
	}
	/**
	 * @return the coapplicant4color
	 */
	public String getCoapplicant4color() {
		return coapplicant4color;
	}
	/**
	 * @param coapplicant4color the coapplicant4color to set
	 */
	public void setCoapplicant4color(String coapplicant4color) {
		this.coapplicant4color = coapplicant4color;
	}
	/**
	 * @return the guarantorplaceholdervalues
	 */
	public String getGuarantorplaceholdervalues() {
		return guarantorplaceholdervalues;
	}
	/**
	 * @param guarantorplaceholdervalues the guarantorplaceholdervalues to set
	 */
	public void setGuarantorplaceholdervalues(String guarantorplaceholdervalues) {
		this.guarantorplaceholdervalues = guarantorplaceholdervalues;
	}
	/**
	 * @return the guarantoruivalidvalue
	 */
	public String getGuarantoruivalidvalue() {
		return guarantoruivalidvalue;
	}
	/**
	 * @param guarantoruivalidvalue the guarantoruivalidvalue to set
	 */
	public void setGuarantoruivalidvalue(String guarantoruivalidvalue) {
		this.guarantoruivalidvalue = guarantoruivalidvalue;
	}
	/**
	 * @return the guarantorcolor
	 */
	public String getGuarantorcolor() {
		return guarantorcolor;
	}
	/**
	 * @param guarantorcolor the guarantorcolor to set
	 */
	public void setGuarantorcolor(String guarantorcolor) {
		this.guarantorcolor = guarantorcolor;
	}
	/**
	 * @return the guarantor1placeholdervalues
	 */
	public String getGuarantor1placeholdervalues() {
		return guarantor1placeholdervalues;
	}
	/**
	 * @param guarantor1placeholdervalues the guarantor1placeholdervalues to set
	 */
	public void setGuarantor1placeholdervalues(String guarantor1placeholdervalues) {
		this.guarantor1placeholdervalues = guarantor1placeholdervalues;
	}
	/**
	 * @return the guarantor1uivalidvalue
	 */
	public String getGuarantor1uivalidvalue() {
		return guarantor1uivalidvalue;
	}
	/**
	 * @param guarantor1uivalidvalue the guarantor1uivalidvalue to set
	 */
	public void setGuarantor1uivalidvalue(String guarantor1uivalidvalue) {
		this.guarantor1uivalidvalue = guarantor1uivalidvalue;
	}
	/**
	 * @return the guarantor1color
	 */
	public String getGuarantor1color() {
		return guarantor1color;
	}
	/**
	 * @param guarantor1color the guarantor1color to set
	 */
	public void setGuarantor1color(String guarantor1color) {
		this.guarantor1color = guarantor1color;
	}
	/**
	 * @return the guarantor2placeholdervalues
	 */
	public String getGuarantor2placeholdervalues() {
		return guarantor2placeholdervalues;
	}
	/**
	 * @param guarantor2placeholdervalues the guarantor2placeholdervalues to set
	 */
	public void setGuarantor2placeholdervalues(String guarantor2placeholdervalues) {
		this.guarantor2placeholdervalues = guarantor2placeholdervalues;
	}
	/**
	 * @return the guarantor2uivalidvalue
	 */
	public String getGuarantor2uivalidvalue() {
		return guarantor2uivalidvalue;
	}
	/**
	 * @param guarantor2uivalidvalue the guarantor2uivalidvalue to set
	 */
	public void setGuarantor2uivalidvalue(String guarantor2uivalidvalue) {
		this.guarantor2uivalidvalue = guarantor2uivalidvalue;
	}
	/**
	 * @return the guarantor2color
	 */
	public String getGuarantor2color() {
		return guarantor2color;
	}
	/**
	 * @param guarantor2color the guarantor2color to set
	 */
	public void setGuarantor2color(String guarantor2color) {
		this.guarantor2color = guarantor2color;
	}
	/**
	 * @return the guarantor3placeholdervalues
	 */
	public String getGuarantor3placeholdervalues() {
		return guarantor3placeholdervalues;
	}
	/**
	 * @param guarantor3placeholdervalues the guarantor3placeholdervalues to set
	 */
	public void setGuarantor3placeholdervalues(String guarantor3placeholdervalues) {
		this.guarantor3placeholdervalues = guarantor3placeholdervalues;
	}
	/**
	 * @return the guarantor3uivalidvalue
	 */
	public String getGuarantor3uivalidvalue() {
		return guarantor3uivalidvalue;
	}
	/**
	 * @param guarantor3uivalidvalue the guarantor3uivalidvalue to set
	 */
	public void setGuarantor3uivalidvalue(String guarantor3uivalidvalue) {
		this.guarantor3uivalidvalue = guarantor3uivalidvalue;
	}
	/**
	 * @return the guarantor3color
	 */
	public String getGuarantor3color() {
		return guarantor3color;
	}
	/**
	 * @param guarantor3color the guarantor3color to set
	 */
	public void setGuarantor3color(String guarantor3color) {
		this.guarantor3color = guarantor3color;
	}
	/**
	 * @return the guarantor4placeholdervalues
	 */
	public String getGuarantor4placeholdervalues() {
		return guarantor4placeholdervalues;
	}
	/**
	 * @param guarantor4placeholdervalues the guarantor4placeholdervalues to set
	 */
	public void setGuarantor4placeholdervalues(String guarantor4placeholdervalues) {
		this.guarantor4placeholdervalues = guarantor4placeholdervalues;
	}
	/**
	 * @return the guarantor4uivalidvalue
	 */
	public String getGuarantor4uivalidvalue() {
		return guarantor4uivalidvalue;
	}
	/**
	 * @param guarantor4uivalidvalue the guarantor4uivalidvalue to set
	 */
	public void setGuarantor4uivalidvalue(String guarantor4uivalidvalue) {
		this.guarantor4uivalidvalue = guarantor4uivalidvalue;
	}
	/**
	 * @return the guarantor4color
	 */
	public String getGuarantor4color() {
		return guarantor4color;
	}
	/**
	 * @param guarantor4color the guarantor4color to set
	 */
	public void setGuarantor4color(String guarantor4color) {
		this.guarantor4color = guarantor4color;
	}
	/**
	 * @return the loanApplicationId
	 */
	public String getLoanApplicationId() {
		return loanApplicationId;
	}
	/**
	 * @param loanApplicationId the loanApplicationId to set
	 */
	public void setLoanApplicationId(String loanApplicationId) {
		this.loanApplicationId = loanApplicationId;
	}
	/**
	 * @return the header1
	 */
	public String getHeader1() {
		return header1;
	}
	/**
	 * @param header1 the header1 to set
	 */
	public void setHeader1(String header1) {
		this.header1 = header1;
	}
	/**
	 * @return the header1desc
	 */
	public String getHeader1desc() {
		return header1desc;
	}
	/**
	 * @param header1desc the header1desc to set
	 */
	public void setHeader1desc(String header1desc) {
		this.header1desc = header1desc;
	}
	/**
	 * @return the header2
	 */
	public String getHeader2() {
		return header2;
	}
	/**
	 * @param header2 the header2 to set
	 */
	public void setHeader2(String header2) {
		this.header2 = header2;
	}
	/**
	 * @return the header2desc
	 */
	public String getHeader2desc() {
		return header2desc;
	}
	/**
	 * @param header2desc the header2desc to set
	 */
	public void setHeader2desc(String header2desc) {
		this.header2desc = header2desc;
	}
	/**
	 * @return the header3
	 */
	public String getHeader3() {
		return header3;
	}
	/**
	 * @param header3 the header3 to set
	 */
	public void setHeader3(String header3) {
		this.header3 = header3;
	}
	/**
	 * @return the header3desc
	 */
	public String getHeader3desc() {
		return header3desc;
	}
	/**
	 * @param header3desc the header3desc to set
	 */
	public void setHeader3desc(String header3desc) {
		this.header3desc = header3desc;
	}
	/**
	 * @return the header4
	 */
	public String getHeader4() {
		return header4;
	}
	/**
	 * @param header4 the header4 to set
	 */
	public void setHeader4(String header4) {
		this.header4 = header4;
	}
	/**
	 * @return the header4desc
	 */
	public String getHeader4desc() {
		return header4desc;
	}
	/**
	 * @param header4desc the header4desc to set
	 */
	public void setHeader4desc(String header4desc) {
		this.header4desc = header4desc;
	}
	/**
	 * @return the totalResponseExpected
	 */
	public String getTotalResponseExpected() {
		return totalResponseExpected;
	}
	/**
	 * @param totalResponseExpected the totalResponseExpected to set
	 */
	public void setTotalResponseExpected(String totalResponseExpected) {
		this.totalResponseExpected = totalResponseExpected;
	}
	/**
	 * @return the totalResponseFilled
	 */
	public String getTotalResponseFilled() {
		return totalResponseFilled;
	}
	/**
	 * @param totalResponseFilled the totalResponseFilled to set
	 */
	public void setTotalResponseFilled(String totalResponseFilled) {
		this.totalResponseFilled = totalResponseFilled;
	}
	/**
	 * @return the ddSequence
	 */
	public String getDdSequence() {
		return ddSequence;
	}
	/**
	 * @param ddSequence the ddSequence to set
	 */
	public void setDdSequence(String ddSequence) {
		this.ddSequence = ddSequence;
	}
	/**
	 * @return the auditorComment
	 */
	public String getAuditorComment() {
		return auditorComment;
	}
	/**
	 * @param auditorComment the auditorComment to set
	 */
	public void setAuditorComment(String auditorComment) {
		this.auditorComment = auditorComment;
	}
	/**
	 * @return the comment
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
