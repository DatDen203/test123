package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Model.TeacherDto;

public interface ITeacherService {
	@Autowired
	public List<TeacherDto> GetListTeacher();

	@Autowired
	public void insert(TeacherDto obj);

	@Autowired
	public void update(TeacherDto obj);
	
	@Autowired
	public void delete(Integer id);
	
	@Autowired
	public TeacherDto findById(int idStudent);
	
	@Autowired
	public List<TeacherDto> findByName(String name);
}
