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
public class ClientDeleteDueDeligenceRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 763732170027435939L;

	private Integer ddId;
	
	private Integer ddSequence;
	
	private Integer ddParentSequence;
	
	private String moduleName;
	
	private String headerKey;
	
    	
	private String userName;


	/**
	 * @return the ddId
	 */
	public Integer getDdId() {
		return ddId;
	}


	/**
	 * @param ddId the ddId to set
	 */
	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}


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
	 * @return the ddParentSequence
	 */
	public Integer getDdParentSequence() {
		return ddParentSequence;
	}


	/**
	 * @param ddParentSequence the ddParentSequence to set
	 */
	public void setDdParentSequence(Integer ddParentSequence) {
		this.ddParentSequence = ddParentSequence;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}


	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
