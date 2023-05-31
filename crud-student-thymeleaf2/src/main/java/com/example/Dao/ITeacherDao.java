package com.example.Dao;

import java.util.List;
import com.example.Model.TeacherDto;

public interface ITeacherDao {
	public List<TeacherDto> GetListTeacher();

	public int insert(TeacherDto obj);
	
	public TeacherDto findById(String ID);
	
	public List<TeacherDto> findByName(String name);

	public void update(TeacherDto obj);
	
	public void delete(String ID);
}
