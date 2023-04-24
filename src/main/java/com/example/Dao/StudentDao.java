package com.example.Dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Model.StudentDto;
import com.example.Util.MyBatisUtil;

@Repository
public class StudentDao implements IStudentDao {
	@Autowired

	public List<StudentDto> GetListStudent() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<StudentDto> studentList = session.selectList("getAllStudents");
		session.commit();
		session.close();
		return studentList;
	}

	public void insert(StudentDto obj) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertStudent", obj);
		session.commit();
		session.close();
		
	}

	public void delete(Integer idStudent) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteStudent", idStudent);
		session.commit();
		session.close();
	}
	public StudentDto findById(int idStudent) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		StudentDto obj = (StudentDto)session.selectOne("findById", idStudent);
		session.commit();
		session.close();
		return obj;
	}
	

	public void update(StudentDto obj) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("updateStu"
				+ "dent", obj);
		session.commit();
		session.close();
	}

	public List<StudentDto> findByName(String name) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<StudentDto> listStudent = new ArrayList<StudentDto>();
		listStudent = session.selectList("findByName",name);
		session.commit();
		session.close();
		return listStudent;
	}
	public List<StudentDto> findByClass(String classStudent) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<StudentDto> listStudent = new ArrayList<StudentDto>();
		listStudent = session.selectList("findByClass",classStudent);
		session.commit();
		session.close();
		return listStudent;
	}
}
