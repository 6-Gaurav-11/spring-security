package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class SecurityController {

	@GetMapping("/welcome")
	public String home() {
		return ("<h2>Welcome All</h2>");
	}
	
	@GetMapping("/user")
	public String homeUser() {
		return ("<h2>Welcome USER<h2>");
	}
	
	@GetMapping("/admin")
	public String homeAdmin() {
		return ("<h2>Welcome ADMIN<h2>");
	}
}
