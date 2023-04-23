package com.example.Dao;

import com.example.Model.UserDto;
import com.example.Model.UserLogin;

public interface IUserDao {
	public int register(UserDto obj);
	public UserDto validateLogin(UserLogin obj);	
	public int update(UserDto obj);
	public String validateReigister(UserDto obj);
	public UserDto findUserByEmail(String email);
}
