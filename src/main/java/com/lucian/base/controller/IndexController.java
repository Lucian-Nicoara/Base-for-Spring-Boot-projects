package com.lucian.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {
	
	@GetMapping("/index.html")
	public String getIndex(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		System.out.println("debug: into getIndex");
		model.addAttribute("name", name);
		return "index2";
	}

}
