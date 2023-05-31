package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.ClassRoomDto;
import com.example.Model.StudentDto;
import com.example.Service.AuthenticationServiceImpl;
import com.example.Service.ClassRoomService;
import com.example.Service.StudentServiceImpl;
import com.example.Service.UserService;

@Controller
public class UserPageController {
	
	@Autowired
	AuthenticationServiceImpl authenticationService;
	@Autowired
	UserService userService;
	@Autowired
	StudentServiceImpl studentService;
	@Autowired
	ClassRoomService classRoomService;
	
	@RequestMapping("/userPage")
	public ModelAndView userPageLogin() {
		String id = authenticationService.authenticateAndGetUsername();
		ModelAndView mv = new ModelAndView("userPage");
		mv.addObject("id", id);
		/*
		 * UserDto obj = userService.findUserById(id); mv.addObject("obj", obj);
		 */
		String username = userService.findUserById(id).getId();
		mv.addObject("name", username);
		return mv;
	}
	
	@RequestMapping("/userPage/{id}")
	public ModelAndView userPage(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("userPage");
		mv.addObject("id", id);
		/*
		 * UserDto obj = userService.findUserById(id); mv.addObject("obj", obj);
		 */
		String username = userService.findUserById(id).getId();
		mv.addObject("name", username);
		return mv;
	}
	
	
	@RequestMapping(value = "/profileOfStudent/{id}", method = RequestMethod.GET)
	public ModelAndView userPageProfile(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("profileOfStudent");
		StudentDto obj = studentService.findByIdUser(id);
		mv.addObject("obj", obj);
		return mv;
	}
	
	
	@RequestMapping(value = "/classOfStudent/{id}", method = RequestMethod.GET)
	public ModelAndView userPageClassRoom(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("classOfStudent");
		List<ClassRoomDto> obj = classRoomService.findClassOfOneStudent(id);
		mv.addObject("listClass", obj);
		return mv;
	}
	
}
