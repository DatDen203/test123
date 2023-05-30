package com.example.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    public String authenticateAndGetUsername() {
        // Xác thực người dùng
		/*
		 * Authentication authentication = authenticationManager.authenticate( new
		 * UsernamePasswordAuthenticationToken(username, password));
		 * 
		 * // Lấy thông tin của người dùng UserDetails userDetails = (UserDetails)
		 * authentication.getPrincipal(); String userID = userDetails.getUsername();
		 * 
		 * return userID;
		 */
    	
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    	String username = authentication.getName();
    	return username;
    }
}

