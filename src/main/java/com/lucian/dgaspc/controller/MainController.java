package com.lucian.dgaspc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lucian.dgaspc.mapper.UserDataMapper;
import com.lucian.dgaspc.model.UserData;
import com.lucian.dgaspc.service.UserDataService;

/*
 * info:
	https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial
	
TODOS: remember me: 
	https://www.baeldung.com/spring-security-persistent-remember-me
	https://www.youtube.com/watch?v=YNsDrOCV0L0&t=430s
*/


@Controller
public class MainController {
	
	@Autowired
	UserDataService userDataService;
	
	@Autowired
	UserDataMapper userDataMapper;
	
	@GetMapping("/")
	public String getIndex(Model model) {
		UserData user = null;
		if(userDataService.getAuthUser() != null) {
			user = userDataService.getAuthUser();
			System.out.println("debug authUserName: " + user.getUsername());
			System.out.println("debug authUser: " + user.toString());
			model.addAttribute("name", user.getFirstName());
		}else {
			System.out.println("debug no authUser");
		}
		return "/pages/homepage";
	}
	
	@GetMapping("/signup")
	public String signup(Model model) {
		return "/pages/signup";
	}
		
	@GetMapping("/signin")
	public String signin(Model model) {
		return "/pages/signin";
	}
	
	@GetMapping("/registrul-hcjc")
	public String registrulHcjc(Model model) {
		return "/pages/registrul-hcjc";
	}
	
	@GetMapping("/consiliul-director")
	public String consiliulDirector(Model model) {
		return "/pages/consiliul-director";
	}
}
