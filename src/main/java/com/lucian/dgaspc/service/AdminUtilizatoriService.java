package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.AdminUtilizatoriMapper;
import com.lucian.dgaspc.mapper.UserDataMapper;
import com.lucian.dgaspc.model.UserData;

@Service
public class AdminUtilizatoriService{
	
	@Autowired
	AdminUtilizatoriMapper adminUtilizatoriMapper;
	
	@Autowired
	UserDataMapper userDataMapper;
	
	public List<UserData> getUtilizatori() {
		List<UserData> utilizatori = adminUtilizatoriMapper.getUtilizatori();
		for(UserData u : utilizatori) {
			u.setAuthorities(userDataMapper.getAuthoritiesByUserId(u.getId()));
		}
		return utilizatori;
	}
	
	public UserData getUtilizatorByUsername(String username) {
		UserData utilizator = adminUtilizatoriMapper.getUtilizatorByUsername(username);
		utilizator.setAuthorities(userDataMapper.getAuthoritiesByUserId(utilizator.getId()));
		return utilizator;
	}
	
	public void postUtilizator(UserData utilizator) {
		if(utilizator.getPassword() != null && !utilizator.getPassword().isEmpty()) {
			utilizator.setPassword(new BCryptPasswordEncoder().encode(utilizator.getPassword()));
			utilizator.setStadiu("ACTIV");
		}else {
			utilizator.setStadiu("INACTIV");
		}
		adminUtilizatoriMapper.postUtilizator(utilizator);
	}
	public void putUtilizator(UserData utilizator) {
		if(utilizator.getPassword() != null && !utilizator.getPassword().isEmpty()) {
			utilizator.setPassword(new BCryptPasswordEncoder().encode(utilizator.getPassword()));
		}
		adminUtilizatoriMapper.putUtilizator(utilizator);
	}
}
