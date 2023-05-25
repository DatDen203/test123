package com.example.Model;

import java.sql.Date;

public class StudentDto {
	public String ID;
	public String ID_USER;
	public String email;
	public String phone;
	public String fullname;
	public String address;
	public String major;
	public String sex;
	public Date birthDay;
	public StudentDto(String iD, String iD_USER, String email, String phone, String fullname, String address,
			String major, String sex, Date birthDay) {
		super();
		ID = iD;
		ID_USER = iD_USER;
		this.email = email;
		this.phone = phone;
		this.fullname = fullname;
		this.address = address;
		this.major = major;
		this.sex = sex;
		this.birthDay = birthDay;
	}
	public StudentDto() {
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getID_USER() {
		return ID_USER;
	}
	public void setID_USER(String iD_USER) {
		ID_USER = iD_USER;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthDay() {
		return birthDay;
	}
	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
	
}
