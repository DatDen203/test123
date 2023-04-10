package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.UserDto;
import com.example.Model.UserLogin;

@Service
public interface IUserService {
	@Autowired
	public int register(UserDto obj);

	@Autowired
	public UserDto validateLogin(UserLogin obj);

	@Autowired
	public int update(UserDto obj);
	
	@Autowired
	public UserDto getUserByUsername(String username);
}
