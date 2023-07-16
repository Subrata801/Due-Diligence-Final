/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class BranchCheckerResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5648766818894085133L;

	
	private String username;
	
	private String fullname;

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the fullname
	 */
	public String getFullname() {
		return fullname;
	}

	/**
	 * @param fullname the fullname to set
	 */
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	
}
