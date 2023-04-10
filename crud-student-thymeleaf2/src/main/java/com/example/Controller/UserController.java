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
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public ModelAndView login(@ModelAttribute UserDto obj) {
		ModelAndView mav= new ModelAndView("login");
		mav.addObject("obj", obj);
		return mav;
	}
	
	@RequestMapping(value="/doLogin", method=RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("obj") UserLogin obj) {
		ModelAndView mav= new ModelAndView("login");
		UserDto user = userService.validateLogin(obj);
		if(user!=null) {
			mav = new ModelAndView("redirect:/list","user",user);
			System.out.println(user.toString());
		}else {
			mav = new ModelAndView("login");
			mav.addObject("msg","tai khoan hoac mat khau sai");
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
	public ModelAndView register(ModelAndView mav, @ModelAttribute UserDto obj, @RequestParam String username) {
		try {
			userService.register(obj);
			mav.addObject("msg", "Dang ky thanh cong");
			mav= new ModelAndView("login");
		} catch (Exception e) {
			return new ModelAndView("register");	
		}
		return mav;
	}
	
	
}
