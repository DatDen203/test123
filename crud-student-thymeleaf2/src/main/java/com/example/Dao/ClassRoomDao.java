package com.example.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.Model.ClassRoomDto;

@Repository
public class ClassRoomDao extends SqlSessionDaoSupport implements IClassRoomDao{
	@Override
	@Autowired
	public void setSqlSessionFactory(@Qualifier("defaultDS") SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}	

	public List<ClassRoomDto> GetListClass() {
		return getSqlSession().selectList("ClassRoomMapper.selectAll");
	}

	@Override
	public void delete(String id) {
		getSqlSession().delete("ClassRoomMapper.deleteClass", id);
		
	}
	
	public ClassRoomDto findById(String ID) {
		return getSqlSession().selectOne("ClassRoomMapper.findById", ID);
	}

	@Override
	public int insert(ClassRoomDto obj) {
		return getSqlSession().insert("ClassRoomMapper.insertClassRoom", obj);
	}

	@Override
	public void update(ClassRoomDto obj) {
		getSqlSession().insert("ClassRoomMapper.updateClassRoom", obj);
		
	}

}
