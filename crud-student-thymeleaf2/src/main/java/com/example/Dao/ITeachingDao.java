package com.example.Dao;

import java.util.List;

import com.example.Model.ClassRoomDto;

public interface ITeachingDao {
	public List<ClassRoomDto> getAllClassRoom(String idTeacher);
}
