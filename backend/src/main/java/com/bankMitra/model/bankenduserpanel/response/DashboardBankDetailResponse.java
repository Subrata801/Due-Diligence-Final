/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;

/**
 * @author Bank Maitra
 *
 */
public class DashboardBankDetailResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private String bankName;
	
	private String zoName;
	
	private String cpcName;
	
	private String branchName;
	
	private String ifscCode;
	
	private String clientGroupId;

	/**
	 * @return the zoName
	 */
	public String getZoName() {
		return zoName;
	}

	/**
	 * @param zoName the zoName to set
	 */
	public void setZoName(String zoName) {
		this.zoName = zoName;
	}

	/**
	 * @return the cpcName
	 */
	public String getCpcName() {
		return cpcName;
	}

	/**
	 * @param cpcName the cpcName to set
	 */
	public void setCpcName(String cpcName) {
		this.cpcName = cpcName;
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the clientGroupId
	 */
	public String getClientGroupId() {
		return clientGroupId;
	}

	/**
	 * @param clientGroupId the clientGroupId to set
	 */
	public void setClientGroupId(String clientGroupId) {
		this.clientGroupId = clientGroupId;
	}

}
