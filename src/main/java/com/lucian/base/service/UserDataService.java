package com.lucian.base.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucian.base.mapper.UserDataMapper;
import com.lucian.base.model.UserData;

@Service
public class UserDataService implements UserDetailsService{
	
	@Autowired
	UserDataMapper userDataMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData user = userDataMapper.getByUsername(username);
		if (user != null) {
			return user;//new User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("CUSTOMER"))); 
		} else {
			throw new UsernameNotFoundException("username");
		}
	}
	
	public UserData getAuthUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			return (UserData) authentication.getPrincipal();
		}else {
			return null;
		}		
	}
}
