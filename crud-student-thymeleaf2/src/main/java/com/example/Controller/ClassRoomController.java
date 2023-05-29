package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.Service.ClassRoomService;

@Controller
public class ClassRoomController {
    @Autowired
    ClassRoomService ClassRoomService;
    
	@RequestMapping(value = "/admin/allClass")
	public ModelAndView student() {
		ModelAndView mv = new ModelAndView("allClass");
		mv.addObject("listClass", ClassRoomService.GetListClass());
		return mv;
	}
}
