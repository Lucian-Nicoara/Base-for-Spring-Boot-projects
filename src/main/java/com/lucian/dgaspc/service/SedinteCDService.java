package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.SedinteCDMapper;
import com.lucian.dgaspc.model.SedintaCD;

@Service
public class SedinteCDService{
	
	@Autowired
	SedinteCDMapper sedinteCDMapper;
	
	public List<SedintaCD> getSedinteCD() {
		return sedinteCDMapper.getSedinteCD();
	}
	
	public SedintaCD getSedintaCDById(String id) {
		return sedinteCDMapper.getSedintaCDById(id);
	}
	
	public Integer postSedintaCD(SedintaCD hotarareCJC) {
		return sedinteCDMapper.postSedintaCD(hotarareCJC);
	}
	
	public void stergeSedintaCD(String id) {
		sedinteCDMapper.stergeSedintaCD(id);
	}
	
	public void putSedintaCD(SedintaCD hotarareCJC) {
		sedinteCDMapper.putSedintaCD(hotarareCJC);
	}
	
	public void incarcaFisier(String idHotarare, String numeFisier, byte[] continutFisier) {
		sedinteCDMapper.incarcaFisier(idHotarare, numeFisier, continutFisier);
	}
	
	public SedintaCD getHotarareCuFisier(String idHotarare) {
		return sedinteCDMapper.getSedintaCDCuFisier(idHotarare);
	}
}
