package com.example.Model;

public class LearnDto {
	
	public Integer  id;
	public String id_student;
	public String id_classroom;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_student() {
		return id_student;
	}
	public void setId_student(String id_student) {
		this.id_student = id_student;
	}
	public String getId_classroom() {
		return id_classroom;
	}
	public void setId_classroom(String id_classroom) {
		this.id_classroom = id_classroom;
	}
	public LearnDto(Integer  id, String id_student, String id_classroom) {
		this.id = id;
		this.id_student = id_student;
		this.id_classroom = id_classroom;
	}
	@Override
	public String toString() {
		return "LearnDto [id=" + id + ", id_student=" + id_student + ", id_classroom=" + id_classroom + "]";
	}
	
	
}
