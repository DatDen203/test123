package com.example.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.StudentDto;
import com.example.Model.UserDto;
import com.example.Model.UserRoleDto;
import com.example.Service.StudentServiceImpl;
import com.example.Service.UserRoleService;
import com.example.Service.UserService;
import com.example.Service.AuthenticationServiceImpl;

@Controller
public class HomeController {
	@Autowired
	StudentServiceImpl StudentService;
	@Autowired
	UserService UserService;
	@Autowired
	UserRoleService UserRoleService;
	@Autowired
	AuthenticationServiceImpl authenticationService;

	@RequestMapping("/")
	public ModelAndView home() {
		return new ModelAndView("redirect:/login");
	}

	@RequestMapping("/about")
	public ModelAndView about() {
		return new ModelAndView("about");
	}

	@RequestMapping(value ="/list", method=RequestMethod.GET)
	public ModelAndView getAllStudent() {
		ModelAndView mv = new ModelAndView("list");
		mv.addObject("listStudent", StudentService.GetListStudent());
		return mv;
	}
	
	@RequestMapping(value = "/home")
	public ModelAndView student(Authentication authentication) {
	        if (authentication != null) {
	        	Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
	            if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
	            	ModelAndView mv = new ModelAndView("list");
	        		mv.addObject("listStudent", StudentService.GetListStudent());
	        		return mv;
	            } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))) {
	            	String id = authenticationService.authenticateAndGetUsername();
	        		ModelAndView mv = new ModelAndView("userPage");
	        		mv.addObject("id", id);
	        		/*
	        		 * UserDto obj = userService.findUserById(id); mv.addObject("obj", obj);
	        		 */
	        		String username = UserService.findUserById(id).getId();
	        		mv.addObject("name", username);
	        		return mv;
	            }
	        }
	        return new ModelAndView("login");
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
	public ModelAndView insertStudent(@ModelAttribute StudentDto obj) throws ParseException {
		
		try {
			if (obj.getID() == null) {
				
				UserDto objUser = new UserDto();
				//username của user
				objUser.setId(obj.getID_USER());
				
				Date ngaySinh = obj.getBirthDay();
				SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
				String strNgaySinh = formatter.format(ngaySinh);
				strNgaySinh = strNgaySinh.replace("-", "");
				
				//password của user
				objUser.setPass(strNgaySinh);
				
				//đang fix, phải tự động tăng trong db
				obj.setID(obj.getID_USER());
				
				//uer_role
				UserRoleDto objUserRole = new UserRoleDto();
				//set id_role = user = 2, admin = 1
				objUserRole.setId_role(2);
				//set id_user là id của user
				objUserRole.setId_user(objUser.getId());
				
				UserService.register(objUser);
				UserRoleService.insert(objUserRole);
				StudentService.insert(obj);
			} else {
				StudentService.update(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/home");
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
		
		String idUser = StudentService.findById(id).getID_USER();
		String idUserRole = UserRoleService.findByIdUser(idUser).getId();
		UserRoleService.delete(idUserRole);
		StudentService.delete(id);
		UserService.delete(idUser);
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping(value = "/searchClassRoom", method = RequestMethod.GET)
	public ModelAndView searchByName(@RequestParam("fullname") String name) {
		ModelAndView mav = new ModelAndView("list");
		mav.addObject("listStudent", StudentService.findByName(name));
		return mav;
	}
}
