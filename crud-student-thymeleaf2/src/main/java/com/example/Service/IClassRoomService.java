package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.ClassRoomDto;
import com.example.Model.StudentDto;

@Service
public interface IClassRoomService {
	@Autowired
	public List<ClassRoomDto> GetListClass();
	
	@Autowired
	public int insert(ClassRoomDto obj);
	
	@Autowired
	public void update(ClassRoomDto obj);
	
	@Autowired
	public void delete(String id);
	
	@Autowired
	public ClassRoomDto findById(String id);
	
	@Autowired
	public List<ClassRoomDto> findClassOfOneStudent(String id);
	
	@Autowired
	public List<StudentDto> gelAllStudentOneClass(String idClass);
	
	
}
