package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.StudentDao;
import com.example.Model.StudentDto;

@Service
public class StudentServiceImpl implements IStudentService{
	@Autowired
	private StudentDao dao;
	
	public List<StudentDto> GetListStudent() {
		return dao.GetListStudent();
	}

	public int insert(StudentDto obj) {
		return dao.insert(obj);
	}

	public StudentDto findById(int idStudent) {
		return dao.findById(idStudent);
	}

	public int update(StudentDto obj) {
		return dao.update(obj);
	}

	public int delete(Integer id) {
		return dao.delete(id);
	}

	public List<StudentDto> findByName(String name) {
		return dao.findByName(name);
	}

}
