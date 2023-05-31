package com.example.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.Model.TeacherDto;

@Repository
public class TeacherDao extends SqlSessionDaoSupport implements ITeacherDao {
	@Override
	@Autowired
	public void setSqlSessionFactory(@Qualifier("defaultDS") SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}	
	public List<TeacherDto> GetListTeacher() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("TeacherMapper.selectAll");
	}

	public int insert(TeacherDto obj) {
		// TODO Auto-generated method stub
		return getSqlSession().insert("TeacherMapper.insertTeacher", obj);
	}

	public TeacherDto findById(String ID) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("TeacherMapper.findById", ID);
	}

	public List<TeacherDto> findByName(String name) {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("findByName", name);
	}

	public void update(TeacherDto obj) {
		getSqlSession().update("updateTeacher", obj);

	}

	public void delete(String ID) {
		// TODO Auto-generated method stub
		getSqlSession().delete("TeacherMapper.deleteTeacher", ID);
	}

}
