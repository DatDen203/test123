package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.UserRoleDto;

@Service
public interface IUserRoleService {
	
	@Autowired
	public void insert(UserRoleDto obj);
	
	@Autowired
	public UserRoleDto findByIdUser(String id);
	
	@Autowired
	public void delete(String id);
}
