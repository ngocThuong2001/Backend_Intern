package com.socialprotection.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.socialprotection.entity.AddressType;
import com.socialprotection.service.AddressTypeService;

@Controller
public class HomeController {
//	@Autowired
//	private AddressTypeService addressTypeService;
//	
//	@RequestMapping(value = "/home", method = RequestMethod.GET)
//	public ModelAndView homePage() {
//		addressTypeService.save(new AddressType(1, "address 1"));
//		ModelAndView modelAndView = new ModelAndView("home");
//		return modelAndView;
//	}
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}
	
}
