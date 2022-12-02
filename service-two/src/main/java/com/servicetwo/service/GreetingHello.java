package com.servicetwo.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GreetingHello {
	public ResponseEntity<String> greeting(){
		return new ResponseEntity<>("Hello",HttpStatus.OK);
	}
}
