package com.example.Dao;

import java.util.List;

import com.example.Model.ClassRoomDto;

public interface IClassRoomDao {
	public List<ClassRoomDto> GetListClass();
	
	public void delete(String id);
	
	public ClassRoomDto findById(String id);
}
