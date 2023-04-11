package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.UserDto;
import com.example.Model.UserLogin;
import com.example.Service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	enum validateResult{
		FULLNAME_NOT_FOUND,
		USERNAME_NOT_FOUND,
		USERNAME_EXISTED,
		PASSWORD_NOT_FOUND,
		EMAIL_NOT_FOUND,
		EMAIL_EXISTED,
		EMAIL_INVALID,
		FAIL
	}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public ModelAndView login(@ModelAttribute UserDto obj) {
		ModelAndView mav= new ModelAndView("login");
		mav.addObject("obj", obj);
		return mav;
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("obj") UserLogin obj) {
		ModelAndView mav= new ModelAndView("login");
		
		String message = "";
		validateResult result = null;
		
		if(obj.getUsername().equals("")){ 
			result = validateResult.USERNAME_NOT_FOUND;
		    mav.addObject("msgUsername", message); 
		} 
		else if(obj.getPass().equals("")){
			result = validateResult.PASSWORD_NOT_FOUND;
		    mav.addObject("msgPassword", message); }
		else {
			UserDto user = userService.validateLogin(obj);
			if(user!=null) {
				mav = new ModelAndView("redirect:/list","user",user);
				return mav;
			}
			else{
				result = validateResult.FAIL;
			}
		}
//		System.out.println(loginResult);
		switch (result) {
		case USERNAME_NOT_FOUND:
			message = "Username is required";
			mav.addObject("msgUsername", message);
			break;
		case PASSWORD_NOT_FOUND:
			message = "Password is required"; 
			mav.addObject("msgPassword", message);
			break;
		case FAIL:
			message = "Incorrect login information!";
			mav.addObject("msg", message);
			break;
		}
		return mav;
	}
	
	@RequestMapping(value="/register" , method=RequestMethod.GET)
	public ModelAndView register(@ModelAttribute UserDto obj) {
		ModelAndView mav= new ModelAndView("register");
		mav.addObject("obj", obj);
		return mav;
	}
	
	@RequestMapping(value="/doRegister",method=RequestMethod.POST )
	public ModelAndView register(@ModelAttribute UserDto obj, @RequestParam String username) {

		ModelAndView mav = new ModelAndView("register");
		String message = "";
		validateResult result = null;
		
		if(obj.getName().equals("")){ 
			result = validateResult.FULLNAME_NOT_FOUND;
		}
		if(obj.getUsername().equals("")){ 
			result = validateResult.USERNAME_NOT_FOUND;
		} 
		if(obj.getPass().equals("")){
			result = validateResult.PASSWORD_NOT_FOUND; 
		}
		if(obj.getEmail().equals("")){
			result = validateResult.EMAIL_NOT_FOUND;
		}
		else if(!obj.getEmail().endsWith("@gmail.com")){
			result = validateResult.EMAIL_INVALID;
		}
		
		else {
			String check = userService.validateReigister(obj);
			if(check.equals("true")) {
				userService.register(obj);
			}
			else if(check.equals("Error username")){
				result = validateResult.USERNAME_EXISTED;
			}
			else if(check.equals("Error email")){
				result = validateResult.EMAIL_EXISTED;
			}
		}
		
		switch (result) {
		case EMAIL_NOT_FOUND:
			message = "Email is required"; 
			mav.addObject("msgEmail", message);
//			break;
		case FULLNAME_NOT_FOUND:
			message = "Fullname is required";
			mav.addObject("msgFullname", message);
//			break;
		case USERNAME_NOT_FOUND:
			message = "Username is required";
			mav.addObject("msgUsername", message);
//			break;
		case PASSWORD_NOT_FOUND:
			message = "Password is required"; 
			mav.addObject("msgPassword", message);
//			break;
		
		case USERNAME_EXISTED:
			message = "Username already exists"; 
			mav.addObject("msgUsername", message);
			break;
		case EMAIL_INVALID:
			message = "Invalid email"; 
			mav.addObject("msgEmail", message);
			break;
		case EMAIL_EXISTED:
			message = "Email already exists";
			mav.addObject("msgEmail", message);
			break;
		}
		return mav;
	}
	
	
}
