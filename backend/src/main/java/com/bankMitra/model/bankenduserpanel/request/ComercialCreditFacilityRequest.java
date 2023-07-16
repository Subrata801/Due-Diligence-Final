/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class ComercialCreditFacilityRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	private Integer loanApplicationNum;
	private String e2eNumber;

	/**
	 * @return the loanApplicationNum
	 */
	public Integer getLoanApplicationNum() {
		return loanApplicationNum;
	}

	/**
	 * @param loanApplicationNum the loanApplicationNum to set
	 */
	public void setLoanApplicationNum(Integer loanApplicationNum) {
		this.loanApplicationNum = loanApplicationNum;
	}

	/**
	 * @return the e2eNumber
	 */
	public String getE2eNumber() {
		return e2eNumber;
	}

	/**
	 * @param e2eNumber the e2eNumber to set
	 */
	public void setE2eNumber(String e2eNumber) {
		this.e2eNumber = e2eNumber;
	}
		
}
