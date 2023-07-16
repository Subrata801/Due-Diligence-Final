/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.List;

/**
 * @author BankMitra
 *
 */
public class ClientAuditFirmBankRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7812936246338151043L;

	private String createdBy;
	
	private Integer clientId;
	
	private Integer clientTypeId;
	
	private List<BankDetails> bankInfo;

	/**
	 * @return the clientTypeId
	 */
	public Integer getClientTypeId() {
		return clientTypeId;
	}

	/**
	 * @param clientTypeId the clientTypeId to set
	 */
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the bankInfo
	 */
	public List<BankDetails> getBankInfo() {
		return bankInfo;
	}

	/**
	 * @param bankInfo the bankInfo to set
	 */
	public void setBankInfo(List<BankDetails> bankInfo) {
		this.bankInfo = bankInfo;
	}
	
}
