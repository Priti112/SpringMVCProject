package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
	
	@RequestMapping("/prodname")
	public String show() {
		return "prodname";
		
	}
	
	@RequestMapping("/proddetail")
	public String display() {
		return "proddetail";
		
	}
	
	
	@RequestMapping("/prodprice")
	public String show2() {
		return "prodprice";
		
	}

}
