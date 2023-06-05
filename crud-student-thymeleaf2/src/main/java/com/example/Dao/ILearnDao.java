package com.example.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Model.LearnDto;

@Repository
public interface ILearnDao {
	
	public List<LearnDto> getClassOfOneStudent(String id);
	
	public List<LearnDto> gelAllStudentOneClass(String id);
}
