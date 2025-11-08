package com.lucian.dgaspc.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.EvidentaCHMapper;
import com.lucian.dgaspc.model.CopilHandicap;

@Service
public class EvidentaCHService{
	
	@Autowired
	EvidentaCHMapper evidentaCHMapper;
	
	public List<CopilHandicap> getEvidentaCH(String filtruDataComisieStart, String filtruDataComisieEnd, String filtruVarstaStart, String filtruVarstaEnd) {
		List<CopilHandicap> listaCH = evidentaCHMapper.getEvidentaCH(filtruDataComisieStart, filtruDataComisieEnd, filtruVarstaStart, filtruVarstaEnd);
		for(int i = 0; i < listaCH.size(); i++) {
			CopilHandicap c = listaCH.get(i);
			var valabilInPrezent = "DA";
			if(Integer.valueOf(c.getVarsta()) >= 18) {
				valabilInPrezent = "NU";
			}
			
			if(c.getStatusTransfer().contentEquals("Transferat la")) {
				valabilInPrezent = "NU";
			}
			
			if(c.getValabilitateCertificat().contentEquals("0")) {
				valabilInPrezent = "NU";
			}
			
			Integer ziua = Integer.valueOf(c.getDataComisie().substring(0, 2));
			Integer luna = Integer.valueOf(c.getDataComisie().substring(3, 5));
			Integer anul = Integer.valueOf(c.getDataComisie().substring(6, 10));
			long monthsBetween = ChronoUnit.MONTHS.between(LocalDate.of(anul, luna, ziua), LocalDate.now());
			if(monthsBetween > Integer.valueOf(c.getValabilitateCertificat())) {
				valabilInPrezent = "NU";
			}
			
			//daca am acelasi cnp cu data comisie mai mare decat cel curent, trebuie invalidat
			for(int j = 0; j < i; j++) {
				CopilHandicap cFw = listaCH.get(j);
				if(c.getCnp().contentEquals(cFw.getCnp())) {
					valabilInPrezent = "NU";
					break;
				}
			}
			
			c.setValabilInPrezent(valabilInPrezent);
		}
		return listaCH;
	}
	
	public CopilHandicap getCopilHandicapById(String id) {
		return evidentaCHMapper.getCopilHandicapById(id);
	}
	
	public CopilHandicap getCopilByCNP(String cnp) {
		return evidentaCHMapper.getCopilByCNP(cnp);
	}
	
	public Integer postCopilHandicap(CopilHandicap copilHandicap) {
		return evidentaCHMapper.postCopilHandicap(copilHandicap);
	}
	
	public void stergeCopilHandicap(String id) {
		evidentaCHMapper.stergeCopilHandicap(id);
	}
	
	public void putCopilHandicap(CopilHandicap copilHandicap) {
		evidentaCHMapper.putCopilHandicap(copilHandicap);
	}
}
