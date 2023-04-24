package com.example.Model;

public class UserDto {
	public String name, username, email, pass;
	public int idUser;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public UserDto(String name, String username, String email, String pass, int idUser) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.idUser = idUser;
	}
	
	public UserDto() {
		super();
	}
	@Override
	public String toString() {
		return "UserDto [name=" + name + ", username=" + username + ", email=" + email + ", pass=" + pass + ", idUser="
				+ idUser + "]";
	}
	
	
	
	

}
