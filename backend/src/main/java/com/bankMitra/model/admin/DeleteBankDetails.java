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
public class DeleteBankDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7812936246338151043L;

	private String bankName;
	
	private Integer clientId;
	
	private List<BankDetails> bankDetails;
	
	/**
	 * @return the bankDetails
	 */
	public List<BankDetails> getBankDetails() {
		return bankDetails;
	}

	/**
	 * @param bankDetails the bankDetails to set
	 */
	public void setBankDetails(List<BankDetails> bankDetails) {
		this.bankDetails = bankDetails;
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
	 * @return the clientGroupId
	 */
	public Integer getClientGroupId() {
		return clientGroupId;
	}

	/**
	 * @param clientGroupId the clientGroupId to set
	 */
	public void setClientGroupId(Integer clientGroupId) {
		this.clientGroupId = clientGroupId;
	}

	private Integer clientGroupId;
	
}
