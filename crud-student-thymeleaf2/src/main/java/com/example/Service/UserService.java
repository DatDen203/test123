package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.UserDao;
import com.example.Model.UserDto;
import com.example.Model.UserLogin;

@Service
public class UserService implements IUserService{
	@Autowired 
	private UserDao dao;

	public int register(UserDto obj) {
		return dao.register(obj);
	}

	public UserDto validateLogin(UserLogin obj) {
		return dao.validateLogin(obj);
	}

	public int update(UserDto obj) {
		return dao.update(obj);
	}

	public String validateReigister(UserDto obj) {
		return dao.validateReigister(obj);
	}

	public UserDto findUserByEmail(String email) {
		return dao.findUserByEmail(email);
	}

}
