package com.lucian.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucian.base.mapper.RegistrulHcjcMapper;
import com.lucian.base.model.HotarareCJC;

@Service
public class HotarariCjcService{
	
	@Autowired
	RegistrulHcjcMapper registrulHcjcMapper;
	
	public List<HotarareCJC> getHotarariCJC() {
		return registrulHcjcMapper.getHotarariCJC();
	}
	
	public HotarareCJC getHotarareCJCById(String id) {
		return registrulHcjcMapper.getById(id);
	}
	
	public Integer postHotarareCJC(HotarareCJC hotarareCJC) {
		return registrulHcjcMapper.postHotarareCJC(hotarareCJC);
	}
	
	public void putHotarareCJC(HotarareCJC hotarareCJC) {
		registrulHcjcMapper.putHotarareCJC(hotarareCJC);
	}
	
}
