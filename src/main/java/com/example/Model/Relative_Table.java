package com.example.Model;

public class Relative_Table {
	private int id, idStudent, idClassroom, idTeacher;

	public Relative_Table(int id, int idStudent, int idClassroom, int idTeacher) {
		this.id = id;
		this.idStudent = idStudent;
		this.idClassroom = idClassroom;
		this.idTeacher = idTeacher;
	}

	public Relative_Table() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public int getIdClassroom() {
		return idClassroom;
	}

	public void setIdClassroom(int idClassroom) {
		this.idClassroom = idClassroom;
	}

	public int getIdTeacher() {
		return idTeacher;
	}

	public void setIdTeacher(int idTeacher) {
		this.idTeacher = idTeacher;
	}
	
}
