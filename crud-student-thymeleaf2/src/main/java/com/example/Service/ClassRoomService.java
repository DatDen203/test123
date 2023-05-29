package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.ClassRoomDao;
import com.example.Model.ClassRoomDto;

@Service
public class ClassRoomService implements IClassRoomService{
	@Autowired
	private ClassRoomDao dao;
	
	public List<ClassRoomDto> GetListClass(){
		return dao.GetListClass();
	}

	public void delete(String id) {
		dao.delete(id);
	}

	public ClassRoomDto findById(String id) {
		return dao.findById(id);
	}
}
