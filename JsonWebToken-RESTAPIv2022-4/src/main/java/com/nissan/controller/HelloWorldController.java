package com.nissan.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping({"/api"})
public class HelloWorldController {
	
	@RequestMapping({"/hello"})
	public String firstPage() {
		System.out.println("Success to Hello");
		return "Hello world";
	}

}
