package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.NoteMapper;
import com.lucian.dgaspc.mapper.UserDataMapper;
import com.lucian.dgaspc.model.Nota;

@Service
public class NoteService {
	@Autowired
	private NoteMapper noteMapper;
	
	@Autowired
	private UserDataMapper userMapper;
	
	public List<Nota> getNote(){
		List<Nota> listaNote = noteMapper.getNote("registrulHCJC");
		for(Nota n : listaNote) {
			n.setPersoana(userMapper.getPersoanaById(n.getIdUser()));
		}
		return listaNote;
	}
}
