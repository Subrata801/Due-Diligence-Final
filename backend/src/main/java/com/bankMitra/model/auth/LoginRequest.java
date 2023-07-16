package com.bankMitra.model.auth;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class LoginRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3307958273136844046L;
	private String username;
	private String userPassword;
	
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
	 * @return the userPassword
	 */
	public String getUserPassword() {
		return userPassword;
	}


	/**
	 * @param userPassword the userPassword to set
	 */
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
