package com.serviceone.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.serviceone.entity.Person;

@Service
public class Concat {
	
	public ResponseEntity<String> greetName(String greet, Person person){
		try {
			String str = greet + " " + person.getName()+" "+ person.getSurname();
			return new ResponseEntity<>(str, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

}
