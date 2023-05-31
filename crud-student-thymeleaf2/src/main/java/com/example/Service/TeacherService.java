package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.TeacherDao;
import com.example.Model.TeacherDto;


@Service
public class TeacherService implements ITeacherService {
	@Autowired
	private TeacherDao dao;
	@Override
	public List<TeacherDto> GetListTeacher() {
		// TODO Auto-generated method stub
		return dao.GetListTeacher();
	}

	@Override
	public void insert(TeacherDto obj) {
		// TODO Auto-generated method stub
		dao.insert(obj);

	}

	@Override
	public void update(TeacherDto obj) {
		// TODO Auto-generated method stub
		dao.update(obj);

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		dao.delete(id);

	}

	@Override
	public TeacherDto findById(String id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public List<TeacherDto> findByName(String name) {
		// TODO Auto-generated method stub
		return dao.findByName(name);
	}

}
