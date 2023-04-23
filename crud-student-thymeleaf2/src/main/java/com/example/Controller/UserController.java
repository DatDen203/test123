package com.example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.Model.UserDto;
import com.example.Model.UserLogin;
import com.example.Service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;

	enum validateResult {
		FULLNAME_NOT_FOUND("Fullname is required"), 
		USERNAME_NOT_FOUND("Username is required"),
		USERNAME_EXISTED("Username already exists"), 
		PASSWORD_NOT_FOUND("Password is required"),
		EMAIL_NOT_FOUND("Email is required"), 
		EMAIL_EXISTED("Email already exists"), 
		EMAIL_INVALID("Invalid email"),
		FAIL("Incorrect login information!");

		String message;

		private validateResult(String message) {
			this.message = message;
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@ModelAttribute UserDto obj) {
		ModelAndView mav = new ModelAndView("login");
		mav.addObject("obj", obj);
		return mav;
	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public ModelAndView doLogin(@ModelAttribute("obj") UserLogin obj) {
		ModelAndView mav = new ModelAndView("login");
		validateResult result = null;

		if (obj.getUsername().equals("")) {
			result = validateResult.USERNAME_NOT_FOUND;
			mav.addObject("msgUsername", result.message);
		}
		if (obj.getPass().equals("")) {
			result = validateResult.PASSWORD_NOT_FOUND;
			mav.addObject("msgPassword", result.message);
		}
		if (result == null) {
			UserDto user = userService.validateLogin(obj);
			if (user != null) {
				mav = new ModelAndView("redirect:/list", "user", user);
				return mav;
			} else {
				result = validateResult.FAIL;
				mav.addObject("msg", result.message);
			}
		}
		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(@ModelAttribute UserDto obj) {
		ModelAndView mav = new ModelAndView("register");
		mav.addObject("obj", obj);
		return mav;
	}

	@RequestMapping(value = "/doRegister", method = RequestMethod.POST)
	public ModelAndView doregister(@ModelAttribute("obj") UserDto obj) {

		ModelAndView mav = new ModelAndView("register");
		String message = "";
		validateResult result = null;

		if (obj.getName().equals("")) {
			result = validateResult.FULLNAME_NOT_FOUND;
			mav.addObject("msgFullname", result.message);
		}
		if (obj.getUsername().equals("")) {
			result = validateResult.USERNAME_NOT_FOUND;
			mav.addObject("msgUsername", result.message);
		}
		if (obj.getPass().equals("")) {
			result = validateResult.PASSWORD_NOT_FOUND;
			mav.addObject("msgPassword", result.message);
		}
		if (obj.getEmail().equals("")) {
			result = validateResult.EMAIL_NOT_FOUND;
			mav.addObject("msgEmail", result.message);
		} 
		else if (!obj.getEmail().endsWith("@gmail.com")) {
			result = validateResult.EMAIL_INVALID;
			mav.addObject("msgEmail", result.message);
		}

		if(result == null) {
			String check = userService.validateReigister(obj);
			if (check.equals("true")) {
				userService.register(obj);
			} else if (check.equals("Error username")) {
				result = validateResult.USERNAME_EXISTED;
				mav.addObject("msgEmail", result.message);
			} else if (check.equals("Error email")) {
				result = validateResult.EMAIL_EXISTED;
				mav.addObject("msgEmail", result.message);
			}
		}
		return mav;
	}

}
