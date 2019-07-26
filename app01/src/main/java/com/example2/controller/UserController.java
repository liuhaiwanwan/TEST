package com.example2.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example2.DemoApplication;
import com.example2.bean.User;
import com.example2.service.UserService;

@Controller //声明为一个Restful的Controller
@RequestMapping("/userController")
public class UserController {
  @Autowired //自动连接到UserService Bean
  private UserService userService;
 
  @RequestMapping(value = "/show")
  public String show() {
    return userService.show();
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
  public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

