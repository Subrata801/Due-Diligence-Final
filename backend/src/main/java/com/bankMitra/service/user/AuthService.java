package com.bankMitra.service.user;


import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.admin.UserRequest;
import com.bankMitra.model.auth.LoginRequest;
import com.bankMitra.model.auth.ResetPasswordRequest;
import com.bankMitra.model.auth.SignupRequest;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.response.JwtResponse;
import com.bankMitra.model.user.User;
/**
 * @author BankMitra
 *
 */
public interface AuthService {

	MessageCode registerUser(SignupRequest signUpRequest) throws APIException;

	MessageCode resetPassword(@Valid ResetPasswordRequest resetPasswordRequest) throws APIException;

	JwtResponse authenticate(@Valid LoginRequest loginRequest) throws APIException;

	JwtResponse updatePassword(@Valid ResetPasswordRequest updatePassword) throws APIException;

	MessageCode updateUserDetails(@Valid User userDetailRequest) throws APIException;

	User getUserDetails(@Valid User userDetailRequest) throws APIException;

	List<User> getListOfUsers(@Valid UserRequest searchUserRequest) throws APIException;

}
