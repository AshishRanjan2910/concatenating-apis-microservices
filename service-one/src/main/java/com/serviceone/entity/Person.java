package com.serviceone.entity;

public class Person {
	private String Name;
	private String Surname;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public Person(String name, String surname) {
		super();
		Name = name;
		Surname = surname;
	}
	
}
