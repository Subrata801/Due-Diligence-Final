package com.bankMitra.model.response;
 
import java.util.Date;
import java.util.List;
/**
 * @author BankMitra
 *
 */
public class JwtResponse {
	private String jwt;
	private Long id;
	private String username;
	private String email;
	private Date lastlogin;
	private List<String> roles;
	private String messageDescription;
	
	public JwtResponse (String jwt,Long id,String username,String email,List<String> roles,Date lastlogin) {
		this.jwt = jwt;
		this.id = id;
		this.username = username;
		this.email = email;
		this.roles = roles;
		this.lastlogin = lastlogin;
		
	}
	
	public JwtResponse(){}

	/**
	 * @return the lastlogin
	 */
	public Date getLastlogin() {
		return lastlogin;
	}

	/**
	 * @param lastlogin the lastlogin to set
	 */
	public void setLastlogin(Date lastlogin) {
		this.lastlogin = lastlogin;
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

	/**
	 * @return the jwt
	 */
	public String getJwt() {
		return jwt;
	}

	/**
	 * @param jwt the jwt to set
	 */
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
}
