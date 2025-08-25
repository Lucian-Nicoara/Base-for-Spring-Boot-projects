package com.lucian.dgaspc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.dgaspc.mapper.CompartimenteMapper;
import com.lucian.dgaspc.mapper.UserDataMapper;
import com.lucian.dgaspc.model.Compartiment;
import com.lucian.dgaspc.model.HotarareCJC;
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
	public List<Nota> getNote(@RequestParam String id, @RequestParam String entitate) {
		System.out.println("debug + id=" + id);
		if(id != null && !id.isEmpty() && entitate != null && !entitate.isEmpty()) {
			List<Nota> listaNote = noteService.getNote(id, entitate);
			return listaNote;
		}else {
			return null;
		}
	}
	
	@PostMapping("/postNota")
	public String postNota(@RequestBody Nota nota) {
		System.out.println("debug /postNota");
		System.out.println(nota.toString());
		noteService.postNota(nota);
		
		return "ok";
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