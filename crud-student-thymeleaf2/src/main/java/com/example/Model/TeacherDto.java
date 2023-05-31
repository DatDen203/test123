package com.example.Model;

public class TeacherDto {
	private String ID_Teacher;
	private String name;
	private String major;
	public TeacherDto(String iD_Teacher, String name, String major) {
		super();
		ID_Teacher = iD_Teacher;
		this.name = name;
		this.major = major;
	}
	public TeacherDto() {
		super();
	}
	public String getID_Teacher() {
		return ID_Teacher;
	}
	public void setID_Teacher(String iD_Teacher) {
		ID_Teacher = iD_Teacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
