package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.TeacherDto;
import com.example.Service.TeacherService;
import com.example.Service.TeacherService;

@Controller
public class TeacherController {
	 @Autowired
	    TeacherService TeacherService;
	    
		@RequestMapping(value = "/allTeacher")
		public ModelAndView student() {
			ModelAndView mv = new ModelAndView("allClass");
			mv.addObject("listClass", TeacherService.GetListTeacher());
			return mv;
		}
		
		@RequestMapping(value = "admin/updateTeacher/{id}", method = RequestMethod.GET)
		public ModelAndView updateTeacher(@PathVariable("id") String id) {
			TeacherDto obj = TeacherService.findById(id);
			ModelAndView mv = new ModelAndView("addClass");
			mv.addObject("obj", obj);
			mv.addObject("title", "Update Teacher");
			return mv;
		}
		
		@RequestMapping(value = "admin/addTeacher", method = RequestMethod.GET)
		public ModelAndView AddTeacherView(ModelAndView mv) {
			TeacherDto obj = new TeacherDto();
			mv.addObject("obj", obj);
			mv.addObject("title", "Add New Teacher");
			mv.setViewName("addClass");
			return mv;
		}
		
		/*
		 * @RequestMapping(value = "admin/detailClass/{id}", method = RequestMethod.GET)
		 * public ModelAndView detailClassView(@PathVariable("id") String id) {
		 * TeacherDto obj = TeacherService.findById(id); ModelAndView mv = new
		 * ModelAndView("addClass"); int totalStudent =
		 * TeacherService.totalStudentById(id); mv.addObject("obj", obj);
		 * mv.addObject("totalStudent", totalStudent); mv.addObject("title",
		 * "Detail Teacher"); return mv; }
		 */
		
		@RequestMapping(value = "admin/detailTeacher/{id}", method = RequestMethod.GET)
		public ModelAndView detailClassView(@PathVariable("id") String id) {
			TeacherDto obj = TeacherService.findById(id);
			ModelAndView mv = new ModelAndView("DetailClass");
			mv.addObject("obj", obj);
			mv.addObject("totalStudent", 10);
			mv.addObject("title", "Detail Teacher");
			return mv;
		}
		
		@RequestMapping(value = "/admin/deleteTeacher", method = RequestMethod.GET)
		public ModelAndView deleteClass(@RequestParam("idClass") String id) {
			TeacherService.delete(id);
			return new ModelAndView("redirect:/allClass");
		}

}
