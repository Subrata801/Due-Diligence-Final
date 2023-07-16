/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class ViewDueDeligenceRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String moduleName;
	
	private String loanAppId;
	
	private String header1;
	
	private String header2;
	
	private String header3;
	
	private String header4;

	private String headerKey;
	
	private Integer ddSequence;
	
	
	/**
	 * @return the ddSequence
	 */
	public Integer getDdSequence() {
		return ddSequence;
	}

	/**
	 * @param ddSequence the ddSequence to set
	 */
	public void setDdSequence(Integer ddSequence) {
		this.ddSequence = ddSequence;
	}

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
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}

	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * @return the loanAppId
	 */
	public String getLoanAppId() {
		return loanAppId;
	}

	/**
	 * @param loanAppId the loanAppId to set
	 */
	public void setLoanAppId(String loanAppId) {
		this.loanAppId = loanAppId;
	}
	
}
