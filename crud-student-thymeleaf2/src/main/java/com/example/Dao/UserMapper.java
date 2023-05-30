package com.example.Dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.Model.UserDto;

public class UserMapper implements RowMapper<UserDto> {

	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto obj= new UserDto();
		obj.setId(rs.getString("id"));
		obj.setPass(rs.getString("pass"));
		return obj;
	}
//{	
//	public List<UserDto> selectAll(){
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
////		@SuppressWarnings("unchecked")
//		List<UserDto> userDtoList = session.selectList("selectAll");
//		session.commit();
//		session.close();
//		return userDtoList;
//	}

}
