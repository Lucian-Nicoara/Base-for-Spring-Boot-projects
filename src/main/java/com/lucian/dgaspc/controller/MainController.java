package com.lucian.dgaspc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lucian.dgaspc.model.UserData;
import com.lucian.dgaspc.service.UserDataService;

@Controller
public class MainController {
	
	private UserData user;
	
	@Autowired
	private UserDataService userDataService;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		if(userDataService.getAuthUser() != null) {
			user = userDataService.getAuthUser();
			System.out.println("debug authUser: " + user.toString());
			return "pages/homepage";
		}else {
			System.out.println("debug no authUser");
			return "pages/signin";
		}
	}
	
	@GetMapping("/signin")
	public String signin(Model model) {
		return "pages/signin";
	}
	
	@PreAuthorize("hasAuthority('OpRegHCJC')")
	@GetMapping("/registrul-hcjc")
	public String registrulHcjc(Model model) {
		return "pages/registrul-hcjc";
	}
	
	@PreAuthorize("hasAuthority('OpRegConsDir')")
	@GetMapping("/consiliul-director")
	public String consiliulDirector(Model model) {
		return "pages/consiliul-director";
	}
}
