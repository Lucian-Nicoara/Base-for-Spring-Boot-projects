package com.lucian.dgaspc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.UserDataMapper;
import com.lucian.dgaspc.model.UserData;

@Service
public class UserDataService implements UserDetailsService{
	
	@Autowired
	UserDataMapper userDataMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserData user = userDataMapper.getByUsername(username);
		if (user != null) {
			user.setAuthorities(userDataMapper.getAuthoritiesByUserId(user.getId()));
			return user; 
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
