package com.example.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.Model.ClassRoomDto;
@Repository
public class TeachingDao extends SqlSessionDaoSupport implements ITeachingDao {

	@Override
	@Autowired
	public void setSqlSessionFactory(@Qualifier("defaultDS") SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}	
	public List<ClassRoomDto> getAllClassRoom(String idTeacher) {
		return getSqlSession().selectList("TeachingMapper.getAllClass", idTeacher);
	}

}
