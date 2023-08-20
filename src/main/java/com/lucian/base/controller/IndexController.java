package com.lucian.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lucian.base.model.UserData;
import com.lucian.base.process.UserDataProcess;

@Controller
public class IndexController {
	
	@Autowired
	UserDataProcess userDataProcess;
	
	
	@GetMapping("/")
	public String getIndex(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		List<UserData> users = userDataProcess.getUserData();
		model.addAttribute("name", users.get(0).getName());
		return "pages/homepage.html";
	}
	
	@GetMapping("/signup.html")
	public String signup(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", "Lucian");
		return "pages/signup.html";
	}
	
	@GetMapping("/signin.html")
	public String signin(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		model.addAttribute("name", "Lucian");
		return "pages/signin.html";
	}
}
