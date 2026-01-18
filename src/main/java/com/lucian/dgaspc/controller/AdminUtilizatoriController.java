package com.lucian.dgaspc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.dgaspc.model.TableData;
import com.lucian.dgaspc.model.UserData;
import com.lucian.dgaspc.service.AdminUtilizatoriService;

@RestController
@PreAuthorize("hasAuthority('Administrator')")
@RequestMapping("/adminUtilizatori")
public class AdminUtilizatoriController {
	
	@Autowired
	private AdminUtilizatoriService adminUtilizatoriService;
	
	@GetMapping("/getUtilizatori")
	public TableData<UserData> getEvidentaCH() {
		List<UserData> listaUtilizatori = adminUtilizatoriService.getUtilizatori();
		TableData<UserData> tableData = new TableData<UserData>(listaUtilizatori.size(), listaUtilizatori.size(), listaUtilizatori);
		return tableData;
	}
	
	@PostMapping("/postUtilizator")
	public String postUtilizator(@RequestBody UserData utilizator) {
		if(utilizator.getUsername() != null && !utilizator.getUsername().isEmpty()) {
			//System.out.println(utilizator.toString());
			adminUtilizatoriService.postUtilizator(utilizator);
		}
		return "ok";
	}
	
	@PostMapping("/putUtilizator")
	public String putUtilizator(@RequestBody UserData utilizator) {
		if(utilizator.getId() != 0 && utilizator.getUsername() != null && !utilizator.getUsername().isEmpty()) {
			//System.out.println(utilizator.toString());
			adminUtilizatoriService.putUtilizator(utilizator);
		}
		return "ok";
	}
	
	@GetMapping("/getUtilizatorByUsername")
	public UserData getUtilizatorByUsername(@RequestParam String username) {
		UserData utilizator = adminUtilizatoriService.getUtilizatorByUsername(username);
		return utilizator;
	}
}