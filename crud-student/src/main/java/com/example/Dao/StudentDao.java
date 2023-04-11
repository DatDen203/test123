package com.example.Dao;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Model.StudentDto;
import com.example.Model.StudentMapper;

@Repository
public class StudentDao implements IStudentDao {
	@Autowired
	JdbcTemplate _jdbcTemplate;

	public List<StudentDto> GetListStudent() {
		List<StudentDto> listStudent = new ArrayList<StudentDto>();
		String sql = "select * from student";
		listStudent = _jdbcTemplate.query(sql, new StudentMapper());
		return listStudent;
	}

	public int insert(StudentDto obj) {
		String sql = "INSERT INTO student (name, age, class) VALUES (?,?,?)";
		return _jdbcTemplate.update(sql, obj.getName(), obj.getAge(), obj.getClassStudent());
	}

	public int delete(Integer idStudent) {
		String sql="delete from student where idStudent="+idStudent;
		return _jdbcTemplate.update(sql);
	}

	public StudentDto findById(int idStudent) {
		String sql = "select * from student where idStudent=" + idStudent;
		return _jdbcTemplate.queryForObject(sql, new StudentMapper());
	}

	public int update(StudentDto obj) {
		String sql = "update student set name=?,age=?,class=? where idStudent = ?";
		return _jdbcTemplate.update(sql, obj.getName(), obj.getAge(), obj.getClassStudent(), obj.getIdStudent());
	}

	public List<StudentDto> findByName(String name) {
		List<StudentDto> listStudent = new ArrayList<StudentDto>();
		String sql = "select * from student where name like" + "'%"+name+"%'";
		listStudent = _jdbcTemplate.query(sql, new StudentMapper());
		return listStudent;
	}

}
