package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Dao.TeacherDao;
import com.example.Model.TeacherDto;

public class TeacherServiceImpl implements ITeacherService {
	@Autowired
	private TeacherDao dao;
	@Override
	public List<TeacherDto> GetListTeacher() {
		return dao.GetListTeacher();
	}

	@Override
	public void insert(TeacherDto obj) {
		dao.insert(obj);
	}

	@Override
	public void update(TeacherDto obj) {
		dao.update(obj);

	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);

	}

	@Override
	public TeacherDto findById(int idStudent) {
		return dao.findById(idStudent);
	}

	@Override
	public List<TeacherDto> findByName(String name) {
		return dao.findByName(name);
	}

}
