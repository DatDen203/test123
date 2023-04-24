package com.example.Dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Model.TeacherDto;
import com.example.Util.MyBatisUtil;
@Repository
public class TeacherDao implements ITeacherDao {
	
	@Autowired
	@Override
	public List<TeacherDto> GetListTeacher() {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<TeacherDto> teacherList = session.selectList("getAllTeachers");
		session.commit();
		session.close();
		return teacherList;
	}

	@Override
	public void insert(TeacherDto obj) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("insertTeacher", obj);
		session.commit();
		session.close();
	}

	@Override
	public TeacherDto findById(int idTeacher) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		TeacherDto obj = (TeacherDto)session.selectOne("findById", idTeacher);
		session.commit();
		session.close();
		return obj;
	}

	@Override
	public List<TeacherDto> findByName(String name) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		List<TeacherDto> listTeacher = new ArrayList<TeacherDto>();
		listTeacher = session.selectList("findByName",name);
		session.commit();
		session.close();
		return listTeacher;
	}

	@Override
	public void update(TeacherDto obj) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.update("updateTeacher", obj);
		session.commit();
		session.close();
	}

	@Override
	public void delete(Integer idTeacher) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteTeacher", idTeacher);
		session.commit();
		session.close();
	}

}
