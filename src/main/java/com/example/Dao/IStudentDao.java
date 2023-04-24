package com.example.Dao;

import java.util.List;

import com.example.Model.StudentDto;

public interface IStudentDao {
	public List<StudentDto> GetListStudent();
	
	
	public void insert(StudentDto obj);
	
	public StudentDto findById(int idStudent);
	
	public List<StudentDto> findByName(String name);
	
	public List<StudentDto> findByClass(String classStudent);

	public void update(StudentDto obj);
	
	public void delete(Integer idStudent);

}
