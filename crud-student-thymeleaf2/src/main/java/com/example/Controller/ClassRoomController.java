package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.ClassRoomDto;
import com.example.Service.ClassRoomService;

@Controller
public class ClassRoomController {
    @Autowired
    ClassRoomService ClassRoomService;
    
	@RequestMapping(value = "/allClass")
	public ModelAndView student() {
		ModelAndView mv = new ModelAndView("allClass");
		mv.addObject("listClass", ClassRoomService.GetListClass());
		return mv;
	}
	
	@RequestMapping(value = "admin/updateClass/{id}", method = RequestMethod.GET)
	public ModelAndView updateClass(@PathVariable("id") String id) {
		ClassRoomDto obj = ClassRoomService.findById(id);
		ModelAndView mv = new ModelAndView("addClass");
		mv.addObject("obj", obj);
		mv.addObject("title", "Update ClassRoom");
		return mv;
	}
	
	@RequestMapping(value = "admin/addClass", method = RequestMethod.GET)
	public ModelAndView AddClassView(ModelAndView mv) {
		ClassRoomDto obj = new ClassRoomDto();
		mv.addObject("obj", obj);
		mv.addObject("title", "Add New Classroom");
		mv.setViewName("addClass");
		return mv;
	}
	
	/*
	 * @RequestMapping(value = "admin/detailClass/{id}", method = RequestMethod.GET)
	 * public ModelAndView detailClassView(@PathVariable("id") String id) {
	 * ClassRoomDto obj = ClassRoomService.findById(id); ModelAndView mv = new
	 * ModelAndView("addClass"); int totalStudent =
	 * ClassRoomService.totalStudentById(id); mv.addObject("obj", obj);
	 * mv.addObject("totalStudent", totalStudent); mv.addObject("title",
	 * "Detail ClassRoom"); return mv; }
	 */
	
	@RequestMapping(value = "admin/detailClass/{id}", method = RequestMethod.GET)
	public ModelAndView detailClassView(@PathVariable("id") String id) {
		ClassRoomDto obj = ClassRoomService.findById(id);
		ModelAndView mv = new ModelAndView("DetailClass");
		mv.addObject("obj", obj);
		mv.addObject("totalStudent", 10);
		mv.addObject("title", "Detail ClassRoom");
		return mv;
	}
	
	@RequestMapping(value = "/admin/deleteClass", method = RequestMethod.GET)
	public ModelAndView deleteClass(@RequestParam("idClass") String id) {
		ClassRoomService.delete(id);
		return new ModelAndView("redirect:/allClass");
	}

	
}
