package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.ClassRoomDto;
import com.example.Model.StudentDto;
import com.example.Service.ClassRoomService;
import com.example.Service.StudentServiceImpl;

@Controller
public class ClassRoomController {
	@Autowired
	ClassRoomService ClassRoomService;

	@Autowired
	StudentServiceImpl studentService;
	
	@Autowired
	LearnService learnService;

	
	@RequestMapping(value = "/allClass")
	public ModelAndView student() {
		ModelAndView mv = new ModelAndView("classroom/allClass");
		mv.addObject("listClass", ClassRoomService.GetListClass());
		return mv;
	}

	@RequestMapping(value = "admin/updateClass/{id}", method = RequestMethod.GET)
	public ModelAndView updateClass(@PathVariable("id") String id) {
		ClassRoomDto obj = ClassRoomService.findById(id);
		ModelAndView mv = new ModelAndView("classroom/addClass");
		mv.addObject("obj", obj);
		mv.addObject("title", "Update ClassRoom");
		return mv;
	}

	@RequestMapping(value = "admin/addClass", method = RequestMethod.GET)
	public ModelAndView AddClassView(ModelAndView mv) {
		ClassRoomDto obj = new ClassRoomDto();
		mv.addObject("obj", obj);
		mv.addObject("title", "Add New Classroom");
		mv.setViewName("classroom/addClass");
		return mv;
	}

	@RequestMapping(value = "admin/saveClassRoom", method = RequestMethod.POST)
	public ModelAndView addClass(@ModelAttribute ClassRoomDto obj) {
		ClassRoomDto objCheck = ClassRoomService.findById(obj.getId());
		try {
			
			if (objCheck == null) {
				ClassRoomService.insert(obj);
			} else {
				ClassRoomService.update(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/allClass");
	}

	@RequestMapping(value = "admin/detailClass/{id}", method = RequestMethod.GET)
	public ModelAndView detailClassView(@PathVariable("id") String id) {
		ClassRoomDto obj = ClassRoomService.findById(id);
		ModelAndView mv = new ModelAndView("classroom/DetailClass");
		mv.addObject("obj", obj);
		mv.addObject("totalStudent", 10);
		mv.addObject("title", "Detail ClassRoom");
		return mv;
	}
	
	@RequestMapping(value = "admin/list-student-of-class/{id}", method = RequestMethod.GET)
	public ModelAndView listStudentOfClass(@PathVariable("id") String id) {
		
		List<StudentDto> listStudent = ClassRoomService.gelAllStudentOneClass(id);
		ModelAndView mv = new ModelAndView("classroom/listStudentOfClass");
		mv.addObject("listStudent", listStudent);
		mv.addObject("idClass", id);
		mv.addObject("title", "list Student Of Class");
		return mv;
	}
	
	

	@RequestMapping(value = "/admin/deleteClass", method = RequestMethod.GET)
	public ModelAndView deleteClass(@RequestParam("idClass") String id) {
		ClassRoomService.delete(id);
		return new ModelAndView("redirect:/allClass");
	}
	
	@RequestMapping(value = "/admin/add-student-of-class/{id}", method= RequestMethod.GET)
	public String addStudentOfClass(@PathVariable("id") String id) {
		ModelAndView mv = new ModelAndView("classroom/addStudent");
//		mv.addObject("listStudent", learnService.getStudentDontClass(id));
//		mv.addObject("idClass", id);
	}
	
	@RequestMapping(value = "admin/addStudentClass/{id}", method = RequestMethod.POST)
	public ModelAndView addClassTeacher(@RequestParam("selectedStudent") String[] selectedStudent, @PathVariable("id") String idClass) {
		ModelAndView mv = new ModelAndView();
//		mv.addObject("idClass", idClass);
//		mv.setViewName("redirect:/admin/list-teaching/" + idClass);
//		List<String> addClasses = Arrays.asList(selectedStudent);
//		for(String nameClass : addClasses) {
//			teachingService.addClassTeacher(nameClass, idTeacher);
//		}
		return mv;
	}
	
	

}
