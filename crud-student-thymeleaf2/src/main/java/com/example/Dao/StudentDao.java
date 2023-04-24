package com.example.Dao;

import java.util.*;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Model.StudentDto;
import com.example.util.MyBatisUtil;

@Repository
public class StudentDao implements IStudentDao {
	@Autowired
	JdbcTemplate _jdbcTemplate;

	public List<StudentDto> GetListStudent() {
		List<StudentDto> listStudent = new ArrayList<StudentDto>();
//		String sql = "select * from student";
//		listStudent = _jdbcTemplate.query(sql, new StudentMapper());
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		listStudent = session.selectList("StudentDao.selectAll");;
		session.commit();
		session.close();
		return listStudent;
	}

	public void insert(StudentDto obj) {
//		String sql = "INSERT INTO student (name, age, class) VALUES (?,?,?)";
//		return _jdbcTemplate.update(sql, obj.getName(), obj.getAge(), obj.getClassStudent());
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("StudentDao.insertStudent", obj);
		session.commit();
		session.close();
	}

	public void delete(Integer idStudent) {
//		String sql="delete from student where idStudent="+idStudent;
//		return _jdbcTemplate.update(sql);
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("StudentDao.deleteStudentById", idStudent);;
		session.commit();
		session.close();
	}

	public StudentDto findById(int id) {
//		String sql = "select * from student where idStudent=" + id;
//		return _jdbcTemplate.queryForObject(sql, new StudentMapper());
//		
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		StudentDto Student = session.selectOne("StudentDao.selectById", id);;
		session.commit();
		session.close();
		return Student;
	}

	public void update(StudentDto obj) {
//		String sql = "update student set name=?,age=?,class=? where idStudent = ?";
//		return _jdbcTemplate.update(sql, obj.getName(), obj.getAge(), obj.getClassStudent(), obj.getIdStudent());
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("StudentDao.update", obj);
		session.commit();
		session.close();
	}

	public List<StudentDto> findByName(String name) {
//		List<StudentDto> listStudent = new ArrayList<StudentDto>();
//		String sql = "select * from student where name like" + "'%"+name+"%'";
//		listStudent = _jdbcTemplate.query(sql, new StudentMapper());
//		return listStudent;

		List<StudentDto> listStudent = new ArrayList<StudentDto>();
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		listStudent = session.selectList("StudentDao.selectByName", name);;
		session.commit();
		session.close();
		return listStudent;
	}

}
