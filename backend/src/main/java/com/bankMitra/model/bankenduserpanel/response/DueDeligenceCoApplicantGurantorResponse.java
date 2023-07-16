/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class DueDeligenceCoApplicantGurantorResponse implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 615525540353871906L;
	
	private boolean selectedGurantor;
	private String guarantorName;
	private String guarantorDesc;
	
	private String guarantor;
	private String guarantor1;
	private String guarantor2;
	private String guarantor3;
	private String guarantor4;

	private String messageCode;
	
	private String messageDescription;

	/**
	 * @return the selectedGurantor
	 */
	public boolean getSelectedGurantor() {
		return selectedGurantor;
	}

	/**
	 * @param selectedGurantor the selectedGurantor to set
	 */
	public void setSelectedGurantor(boolean selectedGurantor) {
		this.selectedGurantor = selectedGurantor;
	}

	/**
	 * @return the guarantor
	 */
	public String getGuarantor() {
		return guarantor;
	}

	/**
	 * @param guarantor the guarantor to set
	 */
	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}

	/**
	 * @return the guarantor1
	 */
	public String getGuarantor1() {
		return guarantor1;
	}

	/**
	 * @param guarantor1 the guarantor1 to set
	 */
	public void setGuarantor1(String guarantor1) {
		this.guarantor1 = guarantor1;
	}

	/**
	 * @return the guarantor2
	 */
	public String getGuarantor2() {
		return guarantor2;
	}

	/**
	 * @param guarantor2 the guarantor2 to set
	 */
	public void setGuarantor2(String guarantor2) {
		this.guarantor2 = guarantor2;
	}

	/**
	 * @return the guarantor3
	 */
	public String getGuarantor3() {
		return guarantor3;
	}

	/**
	 * @param guarantor3 the guarantor3 to set
	 */
	public void setGuarantor3(String guarantor3) {
		this.guarantor3 = guarantor3;
	}

	/**
	 * @return the guarantor4
	 */
	public String getGuarantor4() {
		return guarantor4;
	}

	/**
	 * @param guarantor4 the guarantor4 to set
	 */
	public void setGuarantor4(String guarantor4) {
		this.guarantor4 = guarantor4;
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

}
