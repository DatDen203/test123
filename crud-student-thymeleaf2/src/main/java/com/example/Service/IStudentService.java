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
	public void insert(StudentDto obj);

	@Autowired
	public void update(StudentDto obj);
	
	@Autowired
	public void delete(String id);
	
	@Autowired
	public StudentDto findById(String id);
	
	@Autowired
	public StudentDto findByIdUser(String id);
	
	@Autowired
	public List<StudentDto> findByName(String name);
}
