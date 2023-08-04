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
		System.out.println("debug: into getIndex");
		
		List<UserData> users = userDataProcess.getUserData();
		model.addAttribute("name", users.get(0).getName());
		
		return "index.html";
	}

	@GetMapping("/template.html")
	public String getTemplate(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		System.out.println("debug: into getTemplate");

		List<UserData> users = userDataProcess.getUserData();
		model.addAttribute("name", users.get(0).getName());

		return "template.html";
	}
	
	@GetMapping("/content1.html")
	public String getContent1(@RequestParam(name = "name", required = false, defaultValue = "World") String name, Model model) {
		System.out.println("debug: into getContent1");

		List<UserData> users = userDataProcess.getUserData();
		model.addAttribute("name", users.get(0).getName());

		return "content1.html";
	}
}
