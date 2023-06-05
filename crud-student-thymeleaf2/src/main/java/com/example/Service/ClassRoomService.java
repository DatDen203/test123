package com.example.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.ClassRoomDao;
import com.example.Dao.LearnDao;
import com.example.Dao.StudentDao;
import com.example.Model.ClassRoomDto;
import com.example.Model.LearnDto;
import com.example.Model.StudentDto;

@Service
public class ClassRoomService implements IClassRoomService{
	@Autowired
	private ClassRoomDao dao;
	@Autowired 
	private LearnDao daoLearn;
	@Autowired 
	private StudentDao daoStudent;
	
	public List<ClassRoomDto> GetListClass(){
		return dao.GetListClass();
	}

	public void delete(String id) {
		dao.delete(id);
	}

	public ClassRoomDto findById(String id) {
		return dao.findById(id);
	}

	@Override
	public List<ClassRoomDto> findClassOfOneStudent(String id) {
		String idStudent = daoStudent.findByIdUser(id).getID();
		List<String> idClassOfStudent = new ArrayList<>();
		List<LearnDto> listClass = daoLearn.getClassOfOneStudent(idStudent);
		for(LearnDto x : listClass) {
			idClassOfStudent.add(x.getId_classroom());
		}
				
		List<ClassRoomDto> classOfStudent = new ArrayList<>();
		for(String x : idClassOfStudent) {
			classOfStudent.add(dao.findById(x));
		}
		return classOfStudent;
	}

	@Override
	public int insert(ClassRoomDto obj) {
		// TODO Auto-generated method stub
		return dao.insert(obj);
	}

	@Override
	public void update(ClassRoomDto obj) {
		// TODO Auto-generated method stub
		dao.update(obj);
	}

	@Override
	public List<StudentDto> gelAllStudentOneClass(String idClass) {
		List<String> idStudentOfClass = new ArrayList<>();
		List<LearnDto> listLearn = daoLearn.gelAllStudentOneClass(idClass);
		for(LearnDto x : listLearn) {
			idStudentOfClass.add(x.getId_student());
		}
		
		List<StudentDto> studentOfClass = new ArrayList<>();
		for(String x : idStudentOfClass) {
			studentOfClass.add(daoStudent.findById(x));
		}
		return studentOfClass;
	}
}
