package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.RegistrulHcjcMapper;
import com.lucian.dgaspc.model.HotarareCJC;

@Service
public class HotarariCjcService{
	
	@Autowired
	RegistrulHcjcMapper registrulHcjcMapper;
	
	public List<HotarareCJC> getHotarariCJC() {
		return registrulHcjcMapper.getHotarariCJC();
	}
	
	public HotarareCJC getHotarareCJCById(String id) {
		return registrulHcjcMapper.getHotarareCJCById(id);
	}
	
	public Integer postHotarareCJC(HotarareCJC hotarareCJC) {
		return registrulHcjcMapper.postHotarareCJC(hotarareCJC);
	}
	
	public void putHotarareCJC(HotarareCJC hotarareCJC) {
		registrulHcjcMapper.putHotarareCJC(hotarareCJC);
	}
	
	public void incarcaFisier(String idHotarare, String numeFisier, byte[] continutFisier) {
		registrulHcjcMapper.incarcaFisier(idHotarare, numeFisier, continutFisier);
	}
	
	public HotarareCJC getHotarareCuFisier(String idHotarare) {
		return registrulHcjcMapper.getHotarareCuFisier(idHotarare);
	}
}
