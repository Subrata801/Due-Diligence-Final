/**
 * 
 */
package com.bankMitra.model.auth;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author BankMitra
 *
 */
public class ResetPasswordRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4635462119602487670L;

	private String username;
	
	private String securityQuestionId;
	
	private String securityQuestionAnswer;
	
	private String newPassword;
	
	private String confirmPassword;

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
	 * @return the securityQuestionId
	 */
	public String getSecurityQuestionId() {
		return securityQuestionId;
	}

	/**
	 * @param securityQuestionId the securityQuestionId to set
	 */
	public void setSecurityQuestionId(String securityQuestionId) {
		this.securityQuestionId = securityQuestionId;
	}

	/**
	 * @return the securityQuestionAnswer
	 */
	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	/**
	 * @param securityQuestionAnswer the securityQuestionAnswer to set
	 */
	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}

	/**
	 * @return the newPassword
	 */
	public String getNewPassword() {
		return newPassword;
	}

	/**
	 * @param newPassword the newPassword to set
	 */
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	/**
	 * @return the confirmPassword
	 */
	public String getConfirmPassword() {
		return confirmPassword;
	}

	/**
	 * @param confirmPassword the confirmPassword to set
	 */
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
}
