package com.example.Dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.example.Model.UserRoleDto;

@Repository
public class UserRoleDao extends SqlSessionDaoSupport implements IUserRoleDao {

	@Override
	@Autowired
	public void setSqlSessionFactory(@Qualifier("defaultDS") SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	public void insert(UserRoleDto obj) {
		 getSqlSession().insert("UserRoleMapper.insert", obj);
	}
	
	public UserRoleDto findByIdUser(String id) {
		return getSqlSession().selectOne("UserRoleMapper.findByIdUser", id);
	}

	public void delete(String id) {
		getSqlSession().delete("UserRoleMapper.delete", id);
	}

}
