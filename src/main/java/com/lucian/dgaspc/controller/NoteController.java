package com.lucian.dgaspc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.dgaspc.model.Nota;
import com.lucian.dgaspc.service.NoteService;

@RestController
@RequestMapping("/note")
public class NoteController {
	
	@Autowired
	NoteService noteService;
	
	@GetMapping("/getNote")
	public List<Nota> getNote() {
		List<Nota> listaNote = noteService.getNote();
		System.out.println(listaNote.toString());
		return listaNote;
	}
	
}