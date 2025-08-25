package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.NoteMapper;
import com.lucian.dgaspc.mapper.UserDataMapper;
import com.lucian.dgaspc.model.Nota;
import com.lucian.dgaspc.model.UserData;

@Service
public class NoteService {
	@Autowired
	private NoteMapper noteMapper;
	
	@Autowired
	private UserDataMapper userMapper;
	
	@Autowired
	UserDataService userDataService;
	
	public List<Nota> getNote(String id, String entitate){
		List<Nota> listaNote = noteMapper.getNote(id, entitate);
		for(Nota n : listaNote) {
			n.setPersoana(userMapper.getPersoanaById(n.getIdUser()));
		}
		return listaNote;
	}
	
	public String postNota(Nota nota) {
		if(nota.getIdEntitate() != null && !nota.getIdEntitate().isEmpty() && nota.getEntitate() != null && !nota.getEntitate().isEmpty() && nota.getText() != null && !nota.getText().isEmpty()) {
			UserData user = userDataService.getAuthUser();
			System.out.println(user.toString());
			if(user != null) {
				nota.setIdUser(String.valueOf(user.getId()));
				noteMapper.postNota(nota);
				return "ok";
			}else {
				return "fara-drepturi";
			}
			
		}else {
			return "eroare";
		}
		
	}
}
