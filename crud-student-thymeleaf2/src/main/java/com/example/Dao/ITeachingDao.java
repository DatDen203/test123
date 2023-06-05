package com.example.Dao;

import java.util.List;

import com.example.Model.ClassRoomDto;
import com.example.Model.TeachingDto;

public interface ITeachingDao {
	public List<ClassRoomDto> getAllClassRoom(String idTeacher);
	
	public List<ClassRoomDto> getClassDontTeaching(String idTeacher);
	
	public void addClassTeacher(TeachingDto obj);
}
