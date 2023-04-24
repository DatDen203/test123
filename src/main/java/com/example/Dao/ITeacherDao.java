package com.example.Dao;

import java.util.List;

import com.example.Model.StudentDto;
import com.example.Model.TeacherDto;

public interface ITeacherDao {
	public List<TeacherDto> GetListTeacher();
	
	public void insert(TeacherDto obj);
	
	public TeacherDto findById(int idTeacher);
	
	public List<TeacherDto> findByName(String name);

	public void update(TeacherDto obj);
	
	public void delete(Integer idTeacher);
}
