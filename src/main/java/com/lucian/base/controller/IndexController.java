package com.lucian.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lucian.base.model.UserData;
import com.lucian.base.service.UserDataService;

/*
 * info:
	https://www.codejava.net/frameworks/spring-boot/spring-boot-security-role-based-authorization-tutorial
	
TODOS: remember me: 
	https://www.baeldung.com/spring-security-persistent-remember-me
	https://www.youtube.com/watch?v=YNsDrOCV0L0&t=430s
*/


@Controller
public class IndexController {
	
	@Autowired
	UserDataService userDataService;
	
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
	
	@GetMapping("/album")
	public String album(Model model) {
		return "/pages/album";
	}
	
	@GetMapping("/pricing")
	public String pricing(Model model) {
		return "/pages/pricing";
	}
	
	@GetMapping("/super")
	public String superuser(Model model) {
		return "/pages/pricing";
	}
	
	@GetMapping("/admin")
	public String admin(Model model) {
		return "/pages/pricing";
	}

}
