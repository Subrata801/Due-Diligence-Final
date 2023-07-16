package com.bankMitra.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.model.user.User;
import com.bankMitra.repository.user.UserRepository;

/**
 * @author BankMitra
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUserName(username);
		//User  user = new User();
		return UserDetailsImpl.build(user);
	}
	
	@Transactional
	public User getUserDetails(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUserName(username);
		return user;
	}

}
