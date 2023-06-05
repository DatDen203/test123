package com.example.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Model.UserDto;

@Service
public class UserDetailService extends SqlSessionDaoSupport implements UserDetailsService{
	@Override
	@Autowired
	public void setSqlSessionFactory(@Qualifier("defaultDS") SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserDto user= getSqlSession().selectOne("UserMapper.findUserById", username);
		if(user == null) {
			throw new UsernameNotFoundException("User Not Found!");
		}
		return new UserPrincipal(user);
	}

}
