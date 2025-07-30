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
	
	public HotarareCJC getHotarareCjcById(String id) {
		return registrulHcjcMapper.getById(id);
	}
	
}
