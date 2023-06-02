package com.example.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.ClassRoomDao;
import com.example.Dao.LearnDao;
import com.example.Model.ClassRoomDto;

@Service
public class ClassRoomService implements IClassRoomService{
	@Autowired
	private ClassRoomDao dao;
	@Autowired 
	private LearnDao daoLearn;
	
	
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
		List<String> idClassOfStudent = daoLearn.getIdClassOfOneStudent(id);
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
}
