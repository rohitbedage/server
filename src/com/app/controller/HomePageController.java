package com.app.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory
public class HomePageController {
	public HomePageController() {
		System.out.println("in ctor of "+getClass().getName());
	}
	//add a req handling method to return home page (index page)
	@RequestMapping("/")
	public String showHomePage(Model modelAttrMap)
	{
		System.out.println("in show home page "+modelAttrMap);
		modelAttrMap.addAttribute("server_time", new Date());
		return "/index";
	}

}
