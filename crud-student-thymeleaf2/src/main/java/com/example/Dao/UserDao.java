package com.example.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.example.Model.UserDto;
import com.example.Model.UserLogin;
import com.example.Model.UserMapper;

@Repository
public class UserDao implements IUserDao {
	@Autowired
	JdbcTemplate _jdbcTemplate;

	public int register(UserDto obj) {
		String sql = "INSERT INTO user (name, username, email,pass) VALUES (?,?,?,?)";
		return _jdbcTemplate.update(sql, obj.getName(), obj.getUsername(), obj.getEmail(), obj.getPass());
	}
	
	public UserDto validateLogin(UserLogin obj) {
		String sql = "select * from user where username='" + obj.getUsername() + "' and pass='" + obj.getPass() + "'";
		List<UserDto> count = _jdbcTemplate.query(sql, new UserMapper());
		return count.size() > 0 ? count.get(0) : null;
	}

	public int update(UserDto obj) {
		String sql = "update user set name=?,username=?,email=? where idUser = ?";
		return _jdbcTemplate.update(sql, obj.getName(), obj.getUsername(), obj.getEmail(), obj.getIdUser());
	}

	public String validateReigister(UserDto obj) {
		int count = _jdbcTemplate.queryForObject("select count(*) from user where username=?", Integer.class, obj.getUsername());
		if (count == 1) {
			return "Error username";
		}
		count = _jdbcTemplate.queryForObject("select count(*) from user where email=?", Integer.class, obj.getEmail());
		if (count == 1) {
			return "Error email";
		}
		return "true";
	}

	public int ChangePass(UserDto obj) {
		String sql = "update user set pass=? where email = ?";
		return _jdbcTemplate.update(sql, obj.getPass(), obj.getEmail());
	}

	public UserDto findUserByEmail(String email) {
		try {
			String sql = "select * from user where email = '"+email+"'";
			return _jdbcTemplate.queryForObject(sql, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
		
	}
}
