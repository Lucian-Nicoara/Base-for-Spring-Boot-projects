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
	
	public Integer postSedintaCD(SedintaCD sedintaCD) {
		return sedinteCDMapper.postSedintaCD(sedintaCD);
	}
	
	public void stergeSedintaCD(String id) {
		sedinteCDMapper.stergeSedintaCD(id);
	}
	
	public void putSedintaCD(SedintaCD sedintaCD) {
		sedinteCDMapper.putSedintaCD(sedintaCD);
	}
	
	public void incarcaFisier(String idSedintaCD, String numeFisier, byte[] continutFisier) {
		sedinteCDMapper.incarcaFisier(idSedintaCD, numeFisier, continutFisier);
	}
	
	public SedintaCD getSedintaCDCuFisier(String idSedintaCD) {
		return sedinteCDMapper.getSedintaCDCuFisier(idSedintaCD);
	}
}
