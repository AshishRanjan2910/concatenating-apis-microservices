package com.servicethree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicethree.entity.Person;
import com.servicethree.service.FetchName;

@RestController
@RequestMapping("/service3")
public class Service3Controller {
	
	@Autowired
	private FetchName fetchName;
	@PostMapping("/log")
	public ResponseEntity<String> postingName(@RequestBody Person person){
		return fetchName.printingName(person);
	}
}
