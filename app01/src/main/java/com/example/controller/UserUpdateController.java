package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bean.User;
import com.example.service.UserService;

@Controller//声明为一个Restful的Controller
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
  
}

