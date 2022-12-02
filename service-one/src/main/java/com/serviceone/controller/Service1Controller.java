package com.serviceone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.serviceone.entity.Person;


@RestController
@RequestMapping("/service1")
public class Service1Controller {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String status() {
		return "Up";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/greetname")
	public ResponseEntity<String> greetName(@RequestBody Person person) {
		try {
			System.out.println("Inside greetname");
			String greet = this.restTemplate.getForObject("http://greet-service/service2/greet", String.class);
			System.out.println("Inside greet");
			String res = this.restTemplate.postForObject("http://log-service/service3/log",
					person, String.class);
			System.out.println("Inside log");
			return new ResponseEntity<String>(greet + " " + res, HttpStatus.CREATED);
		} catch (Exception exc) {
			System.out.println("Error log" + exc);
			return new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
	}
}

//Error while extracting response for type [class org.springframework.http.ResponseEntity] and content type [application/json]; nested exception is org.springframework.http.converter.HttpMessageNotReadableException: JSON parse error: Unrecognized token 'string': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false'); nested exception is com.fasterxml.jackson.core.JsonParseException: Unrecognized token 'string': was expecting (JSON String, Number, Array, Object or token 'null', 'true' or 'false')
//at [Source: (org.springframework.util.StreamUtils$NonClosingInputStream); line: 1, column: 8]
