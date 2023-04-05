package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.StudentDto;
import com.example.Service.StudentServiceImpl;

@Controller
public class homeController {
	@Autowired
	StudentServiceImpl StudentService;

	@RequestMapping(value = "/home-page")
	public String wellcome() {
		return "home-page";
	}

	@RequestMapping(value = "/list")
	public ModelAndView student() {
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("listStudent", StudentService.GetListStudent());
		return mv;
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView AddStudentView(ModelAndView mv) {
		StudentDto obj = new StudentDto();
		mv.addObject("obj", obj);
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

	@RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
	public ModelAndView updateStudent(@RequestParam("idStudent") int id) {
		StudentDto obj = StudentService.findById(id);
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("obj", obj);
		System.out.println(obj);
		return mv;
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam("idStudent") int id) {
		StudentService.delete(id);
		return new ModelAndView("redirect:/list");
	}
}
