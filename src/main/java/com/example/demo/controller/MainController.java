package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/complete")
	public String complete(Model model) {
	return "complete";
	}
	
	@GetMapping("/")
	public String top(Model model) {
		System.out.println("main");
		return "top";
	}
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("moji", "login画面です");
		return "admin/login";
	}
	
	@GetMapping("/reserve_list")
	public String reserveList(Model model) {
		model.addAttribute("moji", "reserveList画面です");
		return "admin/reserve_list";
	}
	
	@GetMapping("/setting")
	public String setting(Model model) {
		model.addAttribute("moji", "setting画面です");
		return "admin/setting";
	}


}
