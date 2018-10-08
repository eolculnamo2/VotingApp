package com.votingapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "index";
	}
	
	//temporary route to get front end started
	@GetMapping("/webapp/login")
	public String loginPage2() {
		return "index";
	}
}
