package com.example.Model;

public class StudentDto {
	public Integer idStudent;
	public String name;
	public String classStudent;
	public int age;
	
	public StudentDto(Integer idStudent, String name, String classStudent, int age) {
		this.idStudent = idStudent;
		this.name = name;
		this.classStudent = classStudent;
		this.age = age;
	}
	
	public StudentDto(String name, String classStudent, int age) {
		this.name = name;
		this.classStudent = classStudent;
		this.age = age;
	}

	public StudentDto() {
		super();
	}

	public Integer getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Integer idStudent) {
		this.idStudent = idStudent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassStudent() {
		return classStudent;
	}

	public void setClassStudent(String classStudent) {
		this.classStudent = classStudent;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "idStudent=" + idStudent + ", name=" + name + ", classStudent=" + classStudent + ", age="
				+ age + "\n";
	}
}
