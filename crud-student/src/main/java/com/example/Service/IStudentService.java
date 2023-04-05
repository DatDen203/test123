package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Model.StudentDto;

@Service
public interface IStudentService {
	@Autowired
	public List<StudentDto> GetListStudent();

	@Autowired
	public int insert(StudentDto obj);

	@Autowired
	public int update(StudentDto obj);
	
	@Autowired
	public int delete(Integer id);
	
	@Autowired
	public StudentDto findById(int idStudent);
}
