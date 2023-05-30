package com.example.Model;

public class UserRoleDto {
	public String id;
	public String id_user;
	public int id_role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getId_user() {
		return id_user;
	}
	public void setId_user(String id_user) {
		this.id_user = id_user;
	}
	public int getId_role() {
		return id_role;
	}
	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	public UserRoleDto(String id, String id_user, int id_role) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.id_role = id_role;
	}
	public UserRoleDto() {
	}
	@Override
	public String toString() {
		return "UserRoleDto [id=" + id + ", id_user=" + id_user + ", id_role=" + id_role + "]";
	}
	
	
}
