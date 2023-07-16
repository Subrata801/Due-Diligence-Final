/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bankMitra.model.bankenduserpanel.response.CoApplicantDetails;
import com.bankMitra.model.bankenduserpanel.response.ComercialCreditFacilityDetails;
import com.bankMitra.model.bankenduserpanel.response.GuarantorDetails;
import com.bankMitra.model.bankenduserpanel.response.MoveableProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author BankMitra
 *
 */

public class DueDeligenceCoApplicantRequest implements Serializable{
	
	private static final long serialVersionUID = -4997751067406952731L;

	private String e2eNumber;
	private String facility;
	private String accountNum;
	private String dateOfSanction;
	private String sanctionedLimit;
	private String sanctionedLimitWords;
	private String loanTenor;
	private String coapplicantName;
	private Integer coappDesignation;
	private String coapplicantName1;
	private Integer coappDesignation1;
	private String coapplicantName2;
	private Integer coappDesignation2;
	private String coapplicantName3;
	private Integer coappDesignation3;
	private String coapplicantName4;
	private Integer coappDesignation4;
	private String guarantorName;
	private String guarantorName1;
	private String guarantorName2;
	private String guarantorName3;
	private String guarantorName4;
	private String loanSecurity;
	private String securityType;
	private String comments2;
	private List<String> moveAbleProperties;
	
	
	public String getE2eNumber() {
		return e2eNumber;
	}
	public void setE2eNumber(String e2eNumber) {
		this.e2eNumber = e2eNumber;
	}
	public String getFacility() {
		return facility;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getDateOfSanction() {
		return dateOfSanction;
	}
	public void setDateOfSanction(String dateOfSanction) {
		this.dateOfSanction = dateOfSanction;
	}
	public String getSanctionedLimit() {
		return sanctionedLimit;
	}
	public void setSanctionedLimit(String sanctionedLimit) {
		this.sanctionedLimit = sanctionedLimit;
	}
	public String getSanctionedLimitWords() {
		return sanctionedLimitWords;
	}
	public void setSanctionedLimitWords(String sanctionedLimitWords) {
		this.sanctionedLimitWords = sanctionedLimitWords;
	}
	public String getLoanTenor() {
		return loanTenor;
	}
	public void setLoanTenor(String loanTenor) {
		this.loanTenor = loanTenor;
	}
	public String getCoapplicantName() {
		return coapplicantName;
	}
	public void setCoapplicantName(String coapplicantName) {
		this.coapplicantName = coapplicantName;
	}
	public Integer getCoappDesignation() {
		return coappDesignation;
	}
	public void setCoappDesignation(Integer coappDesignation) {
		this.coappDesignation = coappDesignation;
	}
	public String getCoapplicantName1() {
		return coapplicantName1;
	}
	public void setCoapplicantName1(String coapplicantName1) {
		this.coapplicantName1 = coapplicantName1;
	}
	public Integer getCoappDesignation1() {
		return coappDesignation1;
	}
	public void setCoappDesignation1(Integer coappDesignation1) {
		this.coappDesignation1 = coappDesignation1;
	}
	public String getCoapplicantName2() {
		return coapplicantName2;
	}
	public void setCoapplicantName2(String coapplicantName2) {
		this.coapplicantName2 = coapplicantName2;
	}
	public Integer getCoappDesignation2() {
		return coappDesignation2;
	}
	public void setCoappDesignation2(Integer coappDesignation2) {
		this.coappDesignation2 = coappDesignation2;
	}
	public String getCoapplicantName3() {
		return coapplicantName3;
	}
	public void setCoapplicantName3(String coapplicantName3) {
		this.coapplicantName3 = coapplicantName3;
	}
	public Integer getCoappDesignation3() {
		return coappDesignation3;
	}
	public void setCoappDesignation3(Integer coappDesignation3) {
		this.coappDesignation3 = coappDesignation3;
	}
	public String getCoapplicantName4() {
		return coapplicantName4;
	}
	public void setCoapplicantName4(String coapplicantName4) {
		this.coapplicantName4 = coapplicantName4;
	}
	public Integer getCoappDesignation4() {
		return coappDesignation4;
	}
	public void setCoappDesignation4(Integer coappDesignation4) {
		this.coappDesignation4 = coappDesignation4;
	}
	public String getGuarantorName() {
		return guarantorName;
	}
	public void setGuarantorName(String guarantorName) {
		this.guarantorName = guarantorName;
	}
	public String getGuarantorName1() {
		return guarantorName1;
	}
	public void setGuarantorName1(String guarantorName1) {
		this.guarantorName1 = guarantorName1;
	}
	public String getGuarantorName2() {
		return guarantorName2;
	}
	public void setGuarantorName2(String guarantorName2) {
		this.guarantorName2 = guarantorName2;
	}
	public String getGuarantorName3() {
		return guarantorName3;
	}
	public void setGuarantorName3(String guarantorName3) {
		this.guarantorName3 = guarantorName3;
	}
	public String getGuarantorName4() {
		return guarantorName4;
	}
	public void setGuarantorName4(String guarantorName4) {
		this.guarantorName4 = guarantorName4;
	}
	public String getLoanSecurity() {
		return loanSecurity;
	}
	public void setLoanSecurity(String loanSecurity) {
		this.loanSecurity = loanSecurity;
	}
	public String getSecurityType() {
		return securityType;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	public String getComments2() {
		return comments2;
	}
	public void setComments2(String comments2) {
		this.comments2 = comments2;
	}
	public List<String> getMoveAbleProperties() {
		return moveAbleProperties;
	}
	public void setMoveAbleProperties(List<String> moveAbleProperties) {
		this.moveAbleProperties = moveAbleProperties;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
		 
}
