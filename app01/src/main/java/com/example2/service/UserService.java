package com.example2.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example2.bean.User;
import com.example2.dao.UserDao;
 
@Service //声明成一个spring bean
public class UserService {
 
  @Autowired //连接到UserDao Bean
  private UserDao userDao;
 
  public String show() {
    return "Hello World!";
  }
 
  public List<User> showDao(int id) {
    return userDao.get(id);
  }
 
  public String insert(int id, String username, String sex) { //插入一条记录
    User user = new User();
    user.setId(id);
    user.setUsername(username);
    user.setSex(sex);
    userDao.insert(user);
    return "Insert ( \""+username+"\", sex"+sex+") OK!";
  }
}