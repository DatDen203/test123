package com.example.Model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<UserDto> {

	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto obj= new UserDto();
		obj.setIdUser(rs.getInt("idUser"));
		obj.setName(rs.getString("name"));
		obj.setUsername(rs.getString("username"));
		obj.setEmail(rs.getString("email"));
		obj.setPass(rs.getString("pass"));
		return obj;
	}

}
