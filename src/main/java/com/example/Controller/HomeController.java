package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.StudentDto;
import com.example.Service.StudentServiceImpl;
import com.example.Service.TeacherServiceImpl;

@Controller
public class HomeController {
	@Autowired
	StudentServiceImpl StudentService;
	@Autowired
	TeacherServiceImpl TeacherService;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		return new ModelAndView("about");
	}
	
	@RequestMapping(value = "/list")
	public ModelAndView student() {
		ModelAndView mv = new ModelAndView("test_table");
		mv.addObject("listStudent", StudentService.GetListStudent());
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView AddStudentView(ModelAndView mv) {
		StudentDto obj = new StudentDto();
		mv.addObject("obj", obj);
		mv.addObject("title", "Add New Student");
		mv.setViewName("add");
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute StudentDto obj) {
		if (obj.getIdStudent() == null) {
			StudentService.insert(obj);
		} else {
			StudentService.update(obj);	
		}
		return new ModelAndView("redirect:/list");
	}

	@RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.GET)
	public ModelAndView updateStudent(@PathVariable("id") int id) {
		StudentDto obj = StudentService.findById(id);
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("obj", obj);
		mv.addObject("title", "Update Student");
		System.out.println(obj);
		return mv;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam("idStudent") int id) {
		StudentService.delete(id);
		return new ModelAndView("redirect:/list");
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchByName(@RequestParam("name") String name) {
		ModelAndView mav = new ModelAndView("test_table");
		mav.addObject("listStudent", StudentService.findByName(name));
		return mav;
	}
	
	@RequestMapping(value = "/searchClass", method = RequestMethod.GET)
	public ModelAndView searchByClass(@RequestParam("classStudent") String classStudent) {
		ModelAndView mav = new ModelAndView("test_table");
		mav.addObject("listStudent", StudentService.findByClass(classStudent));
		return mav;
	}
	@RequestMapping(value = "/test")
	public ModelAndView test_student() {
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("listStudent", StudentService.GetListStudent());
		return mv;
	}
	@RequestMapping(value = "/listTeacher")
	public ModelAndView teacher() {
		ModelAndView mv = new ModelAndView("test");
		mv.addObject("listTeacher", TeacherService.GetListTeacher());
		return mv;
	}
}
