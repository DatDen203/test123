package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Dao.UserRoleDao;
import com.example.Model.UserRoleDto;

@Service
public class UserRoleService implements IUserRoleService{
	@Autowired
	private UserRoleDao dao;
	
	public void insert(UserRoleDto obj) {
		dao.insert(obj);
	}

	public UserRoleDto findByIdUser(String id) {
		return dao.findByIdUser(id);
	}

	
	public void delete(String id) {
		dao.delete(id);
	}
}
