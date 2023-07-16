package com.bankMitra.repository.user;

import java.util.List;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.UserRequest;
import com.bankMitra.model.auth.ResetPasswordRequest;
import com.bankMitra.model.user.User;

/**
 * @author BankMitra
 *
 */
public interface UserRepository  {
	User authenticateUser(String username, String password) throws DataAccessException;

	public User getUserByUserName(String userName);
	
	boolean existsByEmail(String email);
	
	String registerUser(User user, String adminUser) throws DataAccessException;
	
	User checkSecurityQuestionDetails(Long userId,Integer securityQuestionId, String securityQuestionAnswer);
	
	String resetPassword(ResetPasswordRequest resetPasswordRequest) throws DataAccessException;
	
	String updatedPassword(ResetPasswordRequest updatePassword) throws DataAccessException;
	
	String updateUserDetails(User userDetailRequest) throws DataAccessException;

	List<User> getListOfUsers(UserRequest searchUserRequest) throws DataAccessException;

}
