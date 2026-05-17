package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucian.dgaspc.mapper.PrimitoriDispozitieMapper;
import com.lucian.dgaspc.mapper.RegistrulDispozitiiMapper;
import com.lucian.dgaspc.model.Dispozitie;
import com.lucian.dgaspc.model.PrimitorDispozitie;

@Service
public class DispozitiiService{
	
	@Autowired
	RegistrulDispozitiiMapper registrulDispozitiiMapper;
	
	@Autowired
	PrimitoriDispozitieMapper primitoriDispozitieMapper;
	
	public List<Dispozitie> getDispozitii() {
		List<Dispozitie> listaDispozitii = registrulDispozitiiMapper.getDispozitii();
		if(listaDispozitii != null && !listaDispozitii.isEmpty()) {
			for(Dispozitie d : listaDispozitii) {
				d.setListaPrimitori(primitoriDispozitieMapper.getPrimitoriByIdDispozitie(Integer.valueOf(d.getId())));
			}
		}
		return listaDispozitii;
	}
	
	public Dispozitie getDispozitieById(String id) {
		Dispozitie hotarare = registrulDispozitiiMapper.getDispozitieById(id);
		hotarare.setListaPrimitori(primitoriDispozitieMapper.getPrimitoriByIdDispozitie(Integer.valueOf(id)));
		return hotarare;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Integer postDispozitie(Dispozitie dispozitie) {
		Integer idDispozitie = registrulDispozitiiMapper.postDispozitie(dispozitie);
		if(idDispozitie != null) {
			primitoriDispozitieMapper.deleteAllPrimitoriByIdDispozitie(Integer.valueOf(dispozitie.getId()));
			for(PrimitorDispozitie p : dispozitie.getListaPrimitori()) {
				p.setIdDispozitie(dispozitie.getId());
				primitoriDispozitieMapper.postPrimitorDispozitie(p);
			}
			return idDispozitie;
		}else {
			return null;
		}
	}
	
	public void stergeDispozitie(String id) {
		registrulDispozitiiMapper.stergeDispozitie(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void putDispozitie(Dispozitie dispozitie) {
		registrulDispozitiiMapper.putDispozitie(dispozitie);
		if(dispozitie.getId() != null) {
			primitoriDispozitieMapper.deleteAllPrimitoriByIdDispozitie(Integer.valueOf(dispozitie.getId()));
			for(PrimitorDispozitie p : dispozitie.getListaPrimitori()) {
				p.setIdDispozitie(dispozitie.getId());
				primitoriDispozitieMapper.postPrimitorDispozitie(p);
			}
		}
	}
	
	public void incarcaFisier(String idDispozitie, String numeFisier, byte[] continutFisier) {
		registrulDispozitiiMapper.incarcaFisier(idDispozitie, numeFisier, continutFisier);
	}
	
	public Dispozitie getDispozitieCuFisier(String idDispozitie) {
		return registrulDispozitiiMapper.getDispozitieCuFisier(idDispozitie);
	}
}
