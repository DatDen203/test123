package com.example.Model;

import java.sql.Date;

public class TeachingDto {
	private int ID;
	private String ID_Teacher;
	private String ID_Classroom;
//	private String teachingTime;
//	private Date teachingDate;
	public TeachingDto(int iD, String iD_Teacher, String iD_Classroom) {
		super();
		ID = iD;
		ID_Teacher = iD_Teacher;
		ID_Classroom = iD_Classroom;
//		this.teachingTime = teachingTime;
//		this.teachingDate = teachingDate;
	}
	
	public TeachingDto(String iD_Teacher, String iD_Classroom) {
		ID_Teacher = iD_Teacher;
		ID_Classroom = iD_Classroom;
//		this.teachingTime = teachingTime;
//		this.teachingDate = teachingDate;
	}
	
	public TeachingDto() {
		super();
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getID_Teacher() {
		return ID_Teacher;
	}
	public void setID_Teacher(String iD_Teacher) {
		ID_Teacher = iD_Teacher;
	}
	public String getID_Classroom() {
		return ID_Classroom;
	}
	public void setID_Classroom(String iD_Classroom) {
		ID_Classroom = iD_Classroom;
	}
	/*
	 * public String getTeachingTime() { return teachingTime; } public void
	 * setTeachingTime(String teachingTime) { this.teachingTime = teachingTime; }
	 * public Date getTeachingDate() { return teachingDate; } public void
	 * setTeachingDate(Date teachingDate) { this.teachingDate = teachingDate; }
	 */
}
