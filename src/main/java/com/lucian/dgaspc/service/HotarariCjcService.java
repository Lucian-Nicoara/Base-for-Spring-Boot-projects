package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucian.dgaspc.mapper.PrimitoriHCJCMapper;
import com.lucian.dgaspc.mapper.RegistrulHcjcMapper;
import com.lucian.dgaspc.model.HotarareCJC;
import com.lucian.dgaspc.model.PrimitorHCJC;

@Service
public class HotarariCjcService{
	
	@Autowired
	RegistrulHcjcMapper registrulHcjcMapper;
	
	@Autowired
	PrimitoriHCJCMapper primitoriHCJCMapper;
	
	public List<HotarareCJC> getHotarariCJC() {
		List<HotarareCJC> listaHotarari = registrulHcjcMapper.getHotarariCJC();
		if(listaHotarari != null && !listaHotarari.isEmpty()) {
			for(HotarareCJC h : listaHotarari) {
				h.setListaPrimitori(primitoriHCJCMapper.getPrimitoriByIdHCJC(Integer.valueOf(h.getId())));
			}
		}
		return listaHotarari;
	}
	
	public HotarareCJC getHotarareCJCById(String id) {
		HotarareCJC hotarare = registrulHcjcMapper.getHotarareCJCById(id);
		hotarare.setListaPrimitori(primitoriHCJCMapper.getPrimitoriByIdHCJC(Integer.valueOf(id)));
		return hotarare;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Integer postHotarareCJC(HotarareCJC hotarareCJC) {
		Integer idHotarareHCJC = registrulHcjcMapper.postHotarareCJC(hotarareCJC);
		if(idHotarareHCJC != null) {
			primitoriHCJCMapper.deleteAllPrimitoriByIdHCJC(Integer.valueOf(hotarareCJC.getId()));
			for(PrimitorHCJC p : hotarareCJC.getListaPrimitori()) {
				p.setIdHotarareHCJC(hotarareCJC.getId());
				primitoriHCJCMapper.postPrimitorHCJC(p);
			}
			return idHotarareHCJC;
		}else {
			return null;
		}
	}
	
	public void stergeHotarareCJC(String id) {
		registrulHcjcMapper.stergeHotarareCJC(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void putHotarareCJC(HotarareCJC hotarareCJC) {
		registrulHcjcMapper.putHotarareCJC(hotarareCJC);
		if(hotarareCJC.getId() != null) {
			primitoriHCJCMapper.deleteAllPrimitoriByIdHCJC(Integer.valueOf(hotarareCJC.getId()));
			for(PrimitorHCJC p : hotarareCJC.getListaPrimitori()) {
				p.setIdHotarareHCJC(hotarareCJC.getId());
				primitoriHCJCMapper.postPrimitorHCJC(p);
			}
		}
	}
	
	public void incarcaFisier(String idHotarare, String numeFisier, byte[] continutFisier) {
		registrulHcjcMapper.incarcaFisier(idHotarare, numeFisier, continutFisier);
	}
	
	public HotarareCJC getHotarareCuFisier(String idHotarare) {
		return registrulHcjcMapper.getHotarareCuFisier(idHotarare);
	}
}
