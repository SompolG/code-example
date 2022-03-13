package com.demo.firstProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class FirstProjectController {
	@GetMapping("/hello/{name}")	
	private String hello(@PathVariable String name) {
		return "Hello " + name;
	}
	
	@GetMapping("/hi/{name}")	
	private String hi(@PathVariable String name) {
		return "hi " + name;
	}
}
