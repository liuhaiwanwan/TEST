package com.example2.action;

import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example2.DemoApplication;

@Controller
public class UserController {

	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	  public String index() {
	  
	  return "index";
	  
	  }
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
