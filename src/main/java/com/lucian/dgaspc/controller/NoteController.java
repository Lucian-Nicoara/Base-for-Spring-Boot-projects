package com.lucian.dgaspc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.dgaspc.mapper.CompartimenteMapper;
import com.lucian.dgaspc.mapper.UserDataMapper;
import com.lucian.dgaspc.model.Compartiment;
import com.lucian.dgaspc.model.Nota;
import com.lucian.dgaspc.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	NoteService noteService;
	
	@Autowired
	CompartimenteMapper compartimenteMapper;
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	@GetMapping("/getNote")
	public List<Nota> getNote() {
		List<Nota> listaNote = noteService.getNote();
		return listaNote;
	}
	
	@GetMapping("/getCompartimente")
	public List<Compartiment> getCompartiment() {
		List<Compartiment> listaCompartimente = compartimenteMapper.getCompartimente();
		return listaCompartimente;
	}
	
	@GetMapping("/getLov")
	public Map<String, Object> getLov() {
		Map<String, Object> listeDeValori = new HashMap<String, Object>();
		listeDeValori.put("listaCompartimente", compartimenteMapper.getCompartimente());
		listeDeValori.put("listaPersoane", userDataMapper.getPersoane());
		return listeDeValori;
	}
	
}