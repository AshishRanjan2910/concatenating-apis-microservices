package com.servicethree.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.servicethree.entity.Person;

@Service
public class FetchName {
	public ResponseEntity<String> printingName(Person person){
		try {
			String str = person.getName()+" "+ person.getSurname();
			return new ResponseEntity<>(str, HttpStatus.CREATED);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
