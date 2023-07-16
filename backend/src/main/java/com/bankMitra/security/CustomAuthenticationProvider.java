/**
 * 
 */
package com.bankMitra.security;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.user.User;
import com.bankMitra.repository.user.UserRepository;
import com.bankMitra.repository.user.impl.UserRepositoryImpl;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;


/**
 * @author BankMitra
 *
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReferenceService refService;
	
	@Autowired
	PasswordEncoder encoder;
	
    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {
      String username = auth.getName();
      String password = auth.getCredentials().toString();
      try {
		User userDetails = userRepository.authenticateUser(username,password);
		if(APIConstant.SUCCESS_CODE.equalsIgnoreCase(userDetails.getOutputCode()))
			return new UsernamePasswordAuthenticationToken(username, password, Collections.emptyList());
		else {
			List<MessageCode> msgCodes = refService.getListOfMessageCode();
			String msgDesc = null;
			for(MessageCode msg : msgCodes) {
				if(msg.getMessageCode().equalsIgnoreCase(userDetails.getOutputCode())) {
					msgDesc = msg.getMessageDescription();
					break;
				}
			}
            throw new BadCredentialsException(msgDesc);
		}
       
	  } catch (DataAccessException e) {
		  logger.error("User authentication failed due to data access exception !!!!",e);
		  throw new BadCredentialsException(e.getMessage());
	  } catch (ResourceNotFoundException e) {
		  logger.error("User authentication failed due to resource found exception !!!!",e);
		  throw new BadCredentialsException(e.getMessage());
	  } catch (Exception e) {
		  logger.error("User authentication failed due to exception !!!!",e);
		  throw new BadCredentialsException(e.getMessage());
	  }
      
    }
    @Override
    public boolean supports(Class<?>auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
