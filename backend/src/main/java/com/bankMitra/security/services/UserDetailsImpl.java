package com.bankMitra.security.services;


import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.bankMitra.model.user.User;

/**
 * @author BankMitra
 *
 */
public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;

	private Long userId;

	private String userName;

	private String fullName;
	
	private String email;
	
	private Long mobileNumber;
	
	private String userStatus;

	private Integer clientId;
	
	private String clientName;
	
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImpl(Long userId, String username, String fullName,
			String userStatus,Integer clientId,String clientName,
			String email,Long mobileNum,String password,
			Collection<? extends GrantedAuthority> authorities) {
		this.userId = userId;
		this.userName = username;
		this.fullName = fullName;
		this.userStatus = userStatus;
		this.clientId = clientId;
		this.clientName= clientName;
		this.email = email;
		this.mobileNumber = mobileNum;
		this.authorities = authorities;
		this.password = password;
	}

	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getRoleName()))
				.collect(Collectors.toList());

		return new UserDetailsImpl(
				user.getUserId(), 
				user.getUserName(), 
				user.getFullName(),
				user.getUserStatus(),
				user.getClientId(),
				user.getClientName(),
				user.getEmail(),
				user.getMobileNumber(),
				user.getPassword(),
				authorities);
		/*return new UserDetailsImpl(
				1L, 
				"sanket", 
				"sanket_roy@yahoo.com",
				"test", 
				null);*/
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(userId, user.userId);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	 * @return the mobileNumber
	 */
	public Long getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}

	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
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
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
