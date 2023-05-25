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

@Controller
public class HomeController {
	@Autowired
	StudentServiceImpl StudentService;

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
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("listStudent", StudentService.GetListStudent());
		return mv;
	}

	@RequestMapping(value = "admin/add", method = RequestMethod.GET)
	public ModelAndView AddStudentView(ModelAndView mv) {
		StudentDto obj = new StudentDto();
		mv.addObject("obj", obj);
		mv.addObject("title", "Add New Student");
		mv.setViewName("add");
		return mv;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView insertStudent(@ModelAttribute StudentDto obj) {
		try {
			if (obj.getID().equals("")) {
				StudentService.insert(obj);
			} else {
				StudentService.update(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/list");
	}

	@RequestMapping(value = "admin/updateStudent/{id}", method = RequestMethod.GET)
	public ModelAndView updateStudent(@PathVariable("id") String id) {
		StudentDto obj = StudentService.findById(id);
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("obj", obj);
		mv.addObject("title", "Update Student");
		return mv;
	}

	@RequestMapping(value = "admin/delete", method = RequestMethod.GET)
	public ModelAndView deleteStudent(@RequestParam("idStudent") String id) {
		StudentService.delete(id);
		return new ModelAndView("redirect:/list");
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView searchByName(@RequestParam("fullname") String name) {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("listStudent", StudentService.findByName(name));
		return mav;
	}
}
