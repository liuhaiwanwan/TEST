package com.example2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example2.DemoApplication;
import com.example2.bean.User;
import com.example2.service.UserService;

@RestController //声明为一个Restful的Controller
@RequestMapping("/userUpdateController")
public class UserUpdateController {
  @Autowired //自动连接到UserService Bean
  private UserService userService;
  
  @ResponseBody
  @RequestMapping(value="/del")
  public Map<String,String> delUser(int id) {
	   String result = null;
	   userService.del(id);
	   result = "1";
	   Map<String,String> map = new HashMap<>();
	   map.put("success", result);
	   return map;
  }
  
  @ResponseBody
  @RequestMapping(value="/updateById")
  public Map<String,User>  updateById(int id){
	  User user = userService.showDao(id);
	  Map<String,User> map = new HashMap<>();
	  map.put("user", user);
	  return map;

  }
  
  public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

