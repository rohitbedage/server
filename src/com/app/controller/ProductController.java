package com.app.controller;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // mandatory
@RequestMapping("/product") // optional BUT recommended : for separation
public class ProductController {
	public ProductController() {
		System.out.println("in ctor of " + getClass().getName());
	}

	// add request handling method to get the product details
	@GetMapping("/add") // @GetMapping = @RequestMapping with method=get
	public String getProductDetails(@RequestParam String name, @RequestParam String category,
			@RequestParam double price, @RequestParam("qty") int quantity,
			@RequestParam("creation_date") Date creationDate,Model map) 
	//@RequestParam String name => request.getParameter("name")
	//@RequestParam("qty") int quantity => int quantity=Integer.parseInt(request.getParamter("qty"))
	//def date  format : mon/day/yr : SDF sdf=new SDF("MM/dd/yyyy");
	//Date creationDate=sdf.parse(request.getParamter("creation_date"));
	{
		System.out.println("in get product details "+name+" "+price+" created on "+creationDate);
		//add product details in model attribute n share it with view.
		map.addAttribute("product_details",name+":"+category+":"+price+" created on "+creationDate);
		return "/product/show";//actual view name reted by V.R : /WEB-INF/views/product/show.jsp
	}
	@GetMapping("/add2") // @GetMapping = @RequestMapping with method=get
	public String getProductDetails2(@RequestParam String name, @RequestParam String category,
			@RequestParam double price, @RequestParam("qty") int quantity,
			@RequestParam("creation_date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date creationDate,Model map) 
	//@RequestParam String name => request.getParameter("name")
	//@RequestParam("qty") int quantity => int quantity=Integer.parseInt(request.getParamter("qty"))
	//def date  format : mon/day/yr : SDF sdf=new SDF("yyyy-MM-dd");
	//Date creationDate=sdf.parse(request.getParamter("creation_date"));
	{
		System.out.println("in get product details 2"+name+" "+price+" created on "+creationDate);
		//add product details in model attribute n share it with view.
		map.addAttribute("product_details",name+":"+category+":"+price+" created on "+creationDate);
		return "/product/show";//actual view name reted by V.R : /WEB-INF/views/product/show.jsp
	}
}
