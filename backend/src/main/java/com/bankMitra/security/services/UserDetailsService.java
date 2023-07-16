package com.bankMitra.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
/**
 * @author BankMitra
 *
 */
public interface UserDetailsService {
	
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
    
}
