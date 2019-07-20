package com.example2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example2.DemoApplication;
import com.example2.service.UserService;

@RestController //声明为一个Restful的Controller
@RequestMapping("/user")
public class UserController {
  @Autowired //自动连接到UserService Bean
  private UserService userService;
 
  @RequestMapping(value = "/show")
  public String show() {
    return userService.show();
  }
 
  @RequestMapping(value = "/showDao")
  public Object showDao(int id) {
    return userService.showDao(id);
  }
 
  @RequestMapping(value="/insert")
  public String insert(int id ,String name, String sex) {
    return userService.insert(id,name, sex);
  }
  
  public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

