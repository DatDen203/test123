package com.example.Dao;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface ILearnDao {
	
	public List<String> getIdClassOfOneStudent(String id);
}
