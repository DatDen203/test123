package com.example.Model;

public class ClassroomDto {
	private int idClassroom;
	private String name;
	private int quantity;
	
	public ClassroomDto(int idClassroom, String name, int quantity) {
		this.idClassroom = idClassroom;
		this.name = name;
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public ClassroomDto() {
	}
	public int getIdClassroom() {
		return idClassroom;
	}
	public void setIdClassroom(int idClassroom) {
		this.idClassroom = idClassroom;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
