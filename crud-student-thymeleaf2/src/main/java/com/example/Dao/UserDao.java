package com.example.Dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.Model.UserDto;
import com.example.Model.UserLogin;
import com.example.util.MyBatisUtil;

@Repository
public class UserDao implements IUserDao {
	@Autowired
	JdbcTemplate _jdbcTemplate;
	
	public UserDao() {
		super();
	}
    
	
//	Reader reader = Resources.getResourceAsReader("SqlMapConfig.xml");
	public int register(UserDto obj) {
		String sql = "INSERT INTO user (name, username, email,pass) VALUES (?,?,?,?)";
		return _jdbcTemplate.update(sql, obj.getName(), obj.getUsername(), obj.getEmail(), obj.getPass());
	}
	
	public UserDto validateLogin(UserLogin obj) {
//		String sql = "select * from user where username='" + obj.getUsername() + "' and pass='" + obj.getPass() + "'";
//		List<UserDto> count = _jdbcTemplate.query(sql, new UserMapper());
//		return count.size() > 0 ? count.get(0) : null;
		
		UserDto userDto = null;
		
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("username", obj.getUsername());
		paramMap.put("pass", obj.getPass());
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		userDto = session.selectOne("selectUsernameAndPass", paramMap);
		session.commit();
		session.close();
		return userDto;
	}

	public int update(UserDto obj) {
		String sql = "update user set name=?,username=?,email=? where idUser = ?";
		return _jdbcTemplate.update(sql, obj.getName(), obj.getUsername(), obj.getEmail(), obj.getIdUser());
	}

	public UserDto getUserByUsername(String username) {
		String sql = "select * from user where username=?";
		return _jdbcTemplate.queryForObject(sql, new UserMapper(), new Object[] { username });
	}

	public String validateReigister(UserDto obj) {
		int count = _jdbcTemplate.queryForObject("select count(*) from user where username=?", Integer.class,
				obj.getUsername());
		if (count == 1) {
			return "Error username";
		}
		count = _jdbcTemplate.queryForObject("select count(*) from user where email=?", Integer.class, obj.getEmail());
		if (count == 1) {
			return "Error email";
		}
		return "true";
	}
	public static void main(String[] args) throws IOException {
//		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
//		//@SuppressWarnings("unchecked")
//		List<UserDto> userDtoList = session.selectList("selectAll");
//		session.commit();
//		session.close();
////		return userDtoList;
//		System.out.println(userDtoList);
		
        UserDto userDto = null;
		
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("username", "ngale");
		paramMap.put("pass", "123");
		
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		userDto = session.selectOne("selectUsernameAndPass", paramMap);
		session.commit();
		session.close();
		System.out.println(userDto);
    }


	@Override
	public UserDto findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}


	
}
