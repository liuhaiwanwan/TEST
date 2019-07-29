package com.example.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.User;
import com.example.dao.UserDao;
 
@Service //声明成一个spring bean
public class UserService {
 
  @Autowired //连接到UserDao Bean
  private UserDao userDao;
 
  public String show() {
    return "Hello World!";
  }
 
  public List<User> showAllUser() {
	    return userDao.getAllUser();
	  }
  
  public User showDao(int id) {
    return userDao.get(id);
  }
 
  public String insert(String username, String sex, String address) { //插入一条记录
    User user = new User();
    user.setUsername(username);
    user.setSex(sex);
    user.setAddress(address);
    userDao.insert(user);
    return "Insert ( \""+username+"\", sex"+sex+") OK!";
  }
  
  public String del(int id) {
	  return userDao.del(id);
  }
  
  public String update(User user) {
	   userDao.update(user);
	   return "success";
  }
  
  public User selectByPhone(String memPhone) {
	    return userDao.getPhon(memPhone);
	  }
  
}