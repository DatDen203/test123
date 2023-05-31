package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TeacherController {

	@RequestMapping("/list_teacher")
	public ModelAndView listTeacher() {
		return new ModelAndView("teacher/listTeacher");
	}

	@RequestMapping("/admin/add_teacher")
	public ModelAndView addTeacher() {
		return new ModelAndView("teacher/addTeacher");
	}

	@RequestMapping("/admin/update_teacher")
	public ModelAndView updateTeacher() {
		return new ModelAndView("teacher/addTeacher");
	}

	@RequestMapping("/admin/class_teaching")
	public String classTeaching() {
		return "teacher/listClassTeaching";
	}

}