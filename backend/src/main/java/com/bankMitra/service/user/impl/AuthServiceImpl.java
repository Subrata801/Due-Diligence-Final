/**
 * 
 */
package com.bankMitra.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.admin.UserRequest;
import com.bankMitra.model.admin.response.ClientResponse;
import com.bankMitra.model.auth.LoginRequest;
import com.bankMitra.model.auth.ResetPasswordRequest;
import com.bankMitra.model.auth.SignupRequest;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.reference.UserRoles;
import com.bankMitra.model.response.JwtResponse;
import com.bankMitra.model.user.User;
import com.bankMitra.repository.user.UserRepository;
import com.bankMitra.security.jwt.JwtUtils;
import com.bankMitra.security.services.UserDetailsServiceImpl;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.service.user.AuthService;
import com.bankMitra.util.APIConstant;

/**
 * @author BankMitra
 *
 */
@Service
public class AuthServiceImpl implements AuthService {
	
	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Autowired
	ReferenceService refService;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.user.AuthService#registerUser(com.bankMitra.model.auth.SignupRequest)
	 */
	@Override
	@Transactional
	public MessageCode registerUser(SignupRequest signUpRequest) throws APIException {
		MessageCode msgOutput = null;
		try {
			User user = new User();
			user.setUserRoleId(signUpRequest.getUserRoleId());
			user.setClientId(signUpRequest.getClientId());
			user.setClientName(signUpRequest.getClientName());
			user.setClientGroupId(1);
			if(!StringUtils.isEmpty(signUpRequest.getEmployeeId()))
				user.setEmployeeId(signUpRequest.getEmployeeId());
			else 
				user.setEmployeeId(signUpRequest.getUserName());
			user.setFullName(signUpRequest.getFullName());
			user.setEmail(signUpRequest.getEmail());
			user.setMobileNumber(Long.parseLong(signUpRequest.getMobileNum()));
			user.setUserName(signUpRequest.getUserName());
			user.setPassword(encoder.encode(signUpRequest.getPassword()));
			//user.setPassword(signUpRequest.getPassword());
			user.setUserStatus(signUpRequest.getUserStatus());
			user.setCreatedBy(signUpRequest.getCreatedBy());
			if(null!=signUpRequest.getUserId() && signUpRequest.getUserId()>0)
				user.setUserId(Long.parseLong(String.valueOf(signUpRequest.getUserId())));
			else 
				user.setUserId(-1L);
			final String resultCode =  userRepository.registerUser(user,APIConstant.USER_BANK_MITRA);
			List<MessageCode> msgCodes = refService.getListOfMessageCode();
			for(MessageCode msg : msgCodes) {
				if(msg.getMessageCode().equalsIgnoreCase(resultCode)) {
					msgOutput =  msg;
					break;
				}
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_REGISTER_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_REGISTER_FAILURE);
		}
		
		return msgOutput;
	}

	@Override
	@Transactional
	public MessageCode resetPassword(ResetPasswordRequest resetPasswordRequest) throws APIException {
		MessageCode msgOutput = null;
		try {
			final String resultCode =  userRepository.resetPassword(resetPasswordRequest);
			List<MessageCode> msgCodes = refService.getListOfMessageCode();
			for(MessageCode msg : msgCodes) {
				if(msg.getMessageCode().equalsIgnoreCase(resultCode)) {
					msgOutput =  msg;
					break;
				}
			}
			if(null!=msgOutput && !msgOutput.getMessageCode().equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
				throw new APIException(msgOutput.getMessageDescription());
			} 
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_RESET_PASSWORD_FAILURE);
		}
		return msgOutput;
	}

	@Override
	@Transactional
	public JwtResponse authenticate(LoginRequest loginRequest) throws APIException {
		JwtResponse jwtResponse = null;
		String jwt;
		
		try {
			Authentication authentication = authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getUserPassword()));
	
			SecurityContextHolder.getContext().setAuthentication(authentication);
		
			jwt = jwtUtils.generateJwtToken(authentication);
			User userDetails = userDetailsService.getUserDetails(String.valueOf(authentication.getPrincipal()));
			List<UserRoles> roles = userDetails.getRoles();
			List<String> userRoleList = new ArrayList<String>();
			for(UserRoles uRoles :roles) {
				userRoleList.add(uRoles.getRoleName());
			}
			jwtResponse = new JwtResponse(jwt, 
					 userDetails.getUserId(), 
					 userDetails.getUserName(), 
					 userDetails.getEmail(), 
					 userRoleList,
					 userDetails.getLastLogin());
		} catch (Exception e) {
			throw new APIException(e.getMessage());
		}
		return jwtResponse;
	}

	@Override
	@Transactional
	public JwtResponse updatePassword(ResetPasswordRequest updatePassword) throws APIException {
		MessageCode msgOutput = null;
		JwtResponse userDetails = null;
		try {
			final String resultCode =  userRepository.updatedPassword(updatePassword);
			List<MessageCode> msgCodes = refService.getListOfMessageCode();
			for(MessageCode msg : msgCodes) {
				if(msg.getMessageCode().equalsIgnoreCase(resultCode)) {
					msgOutput =  msg;
					break;
				}
			}
			if(null!=msgOutput){
				if(msgOutput.getMessageCode().equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
					LoginRequest loginRequest = new LoginRequest();
					loginRequest.setUsername(updatePassword.getUsername());
					loginRequest.setUserPassword(updatePassword.getNewPassword());
					userDetails = authenticate(loginRequest);
				} else {
					logger.error("Failed to update password for first time login with error description :"+msgOutput.getMessageDescription());
					throw new APIException(msgOutput.getMessageDescription());
				}
			} else {
				throw new APIException(APIConstant.MSG_UPDATE_PASSWORD_FAILURE);
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_UPDATE_PASSWORD_FAILURE);
		} catch (Exception ex) {
			throw new APIException(APIConstant.MSG_UPDATE_PASSWORD_FAILURE);
		}
		return userDetails;
	}

	@Override
	public MessageCode updateUserDetails(User userDetailRequest) throws APIException {
		MessageCode msgOutput = null;
		try {
			final String resultCode =  userRepository.updateUserDetails(userDetailRequest);
			List<MessageCode> msgCodes = refService.getListOfMessageCode();
			for(MessageCode msg : msgCodes) {
				if(msg.getMessageCode().equalsIgnoreCase(resultCode)) {
					msgOutput =  msg;
					break;
				}
			}
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_UPDATE_USER_FAILURE,e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_UPDATE_USER_FAILURE,e.getMessage());
		}
		return msgOutput;
	}
	private String hashPassword(String plainTextPassword){
		return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
	}

	@Override
	@Transactional(readOnly=true)
	public User getUserDetails(User userDetailRequest) throws APIException {
		User userDetails = null;
		try {
			userDetails = userDetailsService.getUserDetails(userDetailRequest.getUserName());
		}  catch (Exception e) {
			logger.error("Unable to retrive user :",e);
			throw new APIException(APIConstant.MSG_GET_USER_FAILURE);
		} 
		return userDetails;
	}

	@Override
	@Transactional(readOnly=true)
	public List<User> getListOfUsers(UserRequest searchUserRequest) throws APIException {
		List<User> listOfUsers = null;
		try {
			listOfUsers = userRepository.getListOfUsers(searchUserRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_USER_SEARCH_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_USER_SEARCH_FAILURE,e.getMessage());
		}
		return listOfUsers;
	}
}
