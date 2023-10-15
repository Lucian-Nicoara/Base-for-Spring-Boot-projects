package com.lucian.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucian.base.service.UserDataService;

@Controller
public class IndexController {
	
	@Autowired
	UserDataService userDataService;
	
	@GetMapping("/")
	public String getIndex(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		if(userDataService.getAuthUser() != null) {
			System.out.println("debug authUserName: " + userDataService.getAuthUser().getUsername());
			System.out.println("debug authUser: " + userDataService.getAuthUser().toString());
			model.addAttribute("name", userDataService.getAuthUser().getFirstName());
		}else {
			System.out.println("debug no authUser");
		}
		return "/pages/homepage";
	}
	
	@GetMapping("/signup")
	public String signup(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", name);
		return "/pages/signup";
	}
	
	@GetMapping("/signin")
	public String signin(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", "Lucian");
		return "/pages/signin";
	}
	
	@GetMapping("/album")
	public String album(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", "Lucian");
		return "/pages/album";
	}
	
	@GetMapping("/pricing")
	public String pricing(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", "Lucian");
		return "/pages/pricing";
	}
}
