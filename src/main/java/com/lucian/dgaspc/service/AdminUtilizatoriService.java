package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
