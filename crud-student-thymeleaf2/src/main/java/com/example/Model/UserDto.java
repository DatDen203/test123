package com.example.Model;

public class UserDto {
	public String id, pass;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public UserDto() {
		super();
	}

	public UserDto(String id, String pass) {
		this.id = id;
		this.pass = pass;
	}
	
	
}
	
