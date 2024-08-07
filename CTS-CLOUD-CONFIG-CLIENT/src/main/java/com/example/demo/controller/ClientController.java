package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Value("${company}")
	private String companyName;
	@Value("${name}")
	private String name;
	
	@Value("${location}")
	private String location;
	@GetMapping("/")
	public String getCompanyName() {
		return name+" -->"+companyName + "--> " + location;
	}
	

}
