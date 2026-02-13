package com.basic.Java_Beans;

public class User {
	private String firstName;
	private String lastName;
	public User() {
		firstName = "Kshitij";
		lastName = "Antre";
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
