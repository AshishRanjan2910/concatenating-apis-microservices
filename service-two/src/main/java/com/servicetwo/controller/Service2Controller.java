package com.servicetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicetwo.service.GreetingHello;


@RestController
@RequestMapping("/service2")
public class Service2Controller {
	
	@Autowired
	private GreetingHello greetingHello;
	@GetMapping("/greet")
	public ResponseEntity<String> gettingString() {
		return greetingHello.greeting();
	}
}
