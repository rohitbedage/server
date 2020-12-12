package com.app.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.pojos.Vendor;
import com.app.service.IVendorService;

@Controller // Mandatory
@RequestMapping("/user") // optional BUT recommended
public class UserController {
	// dependency : service layer
	@Autowired
	private IVendorService vendorService;

	public UserController() {
		System.out.println("in ctor of " + getClass().getName());

	}

	// add req handling method : get : to show login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("in show login form");
		return "/user/login";// actual view name : /WEB-INF/views/user/login.jsp
	}

	// add req handling method with method=post : to process the form
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email, @RequestParam String password,
			Model map,HttpSession session) {
		System.out.println("in process login form " + email + " " + password);
		// invoke service layer method for exec B.L
		try {
			Vendor validatedUser = vendorService.authenticateUser(email, password);
			//add validated user details under session scope
			session.setAttribute("user_details", validatedUser);
			return "redirect:/vendor/details";
		} catch (RuntimeException e) {
			System.out.println("err in process login form " + e);// NoResultExc
			//in case of failure : FORWARD client to login form : highlighted with error message
			map.addAttribute("message", "Invalid Login , Pls retry....");
			return "/user/login";//actual view name : /WEB-INF/views/user/login.jsp
			
		}
		
	}
}
