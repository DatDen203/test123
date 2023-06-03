//package com.example.Controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.example.Service.TeachingService;
//
//@Controller
//public class TeachingController {
//	@Autowired
//	TeachingService teachingService;
//	
//	@RequestMapping(value = "/listClassOfTeacher")
//	public ModelAndView student(@PathVariable("id") String id) {
//		ModelAndView mv = new ModelAndView("teacher/listClassTeaching");
//		mv.addObject("listClass",teachingService.getAllClass(id));
//		return mv;
//	}
//}
