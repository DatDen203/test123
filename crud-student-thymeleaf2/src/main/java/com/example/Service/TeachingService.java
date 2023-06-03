package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.TeachingDao;
import com.example.Model.ClassRoomDto;
@Service
public class TeachingService implements ITeachingService {
	@Autowired
	private TeachingDao dao;
	@Override
	public List<ClassRoomDto> getAllClass(String idTeacher) {
		// TODO Auto-generated method stub
		return dao.getAllClassRoom(idTeacher);
	}

}
