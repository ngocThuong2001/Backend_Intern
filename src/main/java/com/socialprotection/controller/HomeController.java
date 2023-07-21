package com.socialprotection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.socialprotection.entity.AddressType;
import com.socialprotection.entity.Role;
import com.socialprotection.entity.User;
import com.socialprotection.service.AddressTypeService;
import com.socialprotection.service.UserService;

@Controller
public class HomeController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homePage() {
		userService.saveRole(new Role("SUPER_ADMIN"));
		userService.saveRole(new Role("ADMIN"));

		userService.saveUser(new User("super admin", "123456789", new Role(1, "SUPER_ADMIN")));

		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
}
