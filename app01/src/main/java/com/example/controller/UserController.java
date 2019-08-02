package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.User;
import com.example.service.UserService;

@Controller //声明为一个Restful的Controller
@RequestMapping("/userController")
public class UserController {
  @Autowired //自动连接到UserService Bean
  private UserService userService;

  @RequestMapping(value = "/show")
  public String show() {
    return "management";
  }
  @ResponseBody
  @RequestMapping(value = "/user")
  public Object showDao() {
	  List<User> userList = userService.showAllUser();
	  Map<String,Object> map = new HashMap<>();
	  map.put("total", "10");
	  map.put("rows", userList);
	  return map;
//    return "management";
  }
 /**
  * 插入一条用户信息
  * @author liuhaiwan
  * @return
  */
  @RequestMapping(value="/insert")
  public String insert(String username, String sex, String address, Model model) {
     userService.insert(username, sex, address);
     List<User> userList = userService.showAllUser();
	 model.addAttribute("users", userList);
     return "user";
  }
  
  @RequestMapping(value="/update")
  public String  update(User user,Model model){
	  userService.update(user);
	  List<User> userList = userService.showAllUser();
	  model.addAttribute("users", userList);
	  return "user";

  }
}

