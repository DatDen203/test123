package com.example.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.Model.StudentDto;

public class StudentMapper implements RowMapper<StudentDto> {

	public StudentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		StudentDto obj= new StudentDto();
		obj.setIdStudent(rs.getInt("idStudent"));
		obj.setName(rs.getString("name"));
		obj.setAge(rs.getInt("age"));
		obj.setClassStudent(rs.getString("class"));
		return obj;
	}
	
}
