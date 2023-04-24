package com.example.Model;

public class TeacherDto {
	private int idTeacher;
	private String name;
	private String classes;
	private int age;
	private String major;
	public TeacherDto(int idTeacher, String name, String classes, int age, String major) {
		super();
		this.idTeacher = idTeacher;
		this.name = name;
		this.classes = classes;
		this.age = age;
		this.major = major;
	}
	public TeacherDto() {
		super();
	}
	public int getIdTeacher() {
		return idTeacher;
	}
	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	
}
