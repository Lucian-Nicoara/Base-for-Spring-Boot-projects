package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.AdminUtilizatoriMapper;
import com.lucian.dgaspc.model.UserData;

@Service
public class AdminUtilizatoriService{
	
	@Autowired
	AdminUtilizatoriMapper adminUtilizatoriMapper;
	
	public List<UserData> getUtilizatori() {
		return adminUtilizatoriMapper.getUtilizatori();
	}
	
	public UserData getUtilizatorByUsername(String username) {
		return adminUtilizatoriMapper.getUtilizatorByUsername(username);
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
}
