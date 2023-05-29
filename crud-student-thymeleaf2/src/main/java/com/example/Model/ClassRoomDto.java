package com.example.Model;

public class ClassRoomDto {
	public String id;
	public String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

//	public ClassRoom(String id, String name, String totalStudent, String teacher) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.totalStudent = totalStudent;
//		this.teacher = teacher;
//	}
	
	public ClassRoomDto(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public ClassRoomDto() {
		// TODO Auto-generated constructor stub
	}
}
