package com.example.Dao;

import java.util.List;

import com.example.Model.StudentDto;

public interface IStudentDao {
	public List<StudentDto> GetListStudent();

	public int insert(StudentDto obj);
	
	public StudentDto findById(String ID);
	
	public List<StudentDto> findByName(String name);

	public void update(StudentDto obj);
	
	public void delete(String ID);

}
