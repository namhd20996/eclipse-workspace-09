package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.Order;
import com.example.model.Person;

@Controller
public class HelloWordController {

	@Autowired
	@Qualifier("person")
	private Person person;

	@Autowired
	private Order order;

	@GetMapping("/home-page")
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView("home");
		model.addObject("model", person);
		model.addObject("modelTwo", order);
		return model;
	}
}
