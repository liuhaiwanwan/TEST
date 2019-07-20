package com.example2.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example2.bean.User;

@Controller
@RequestMapping("/jdbc")
public class JdbcController {

	
	@RequestMapping(value = "/index",method = RequestMethod.GET)
	  public String index() {
	  
	  return "index";
	  
	  }
	
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	@RequestMapping(value ="/userlist",method = RequestMethod.GET)
	public String getUserList(Model model) {
		String sql = "SELECT * FROM user";
		 List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>()  {
			User user = null;
			 @Override

	            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
	                user = new User();
	                user.setId(rs.getInt("id"));
	                user.setUsername(rs.getString("username"));
	                user.setSex(rs.getString("sex"));
	                user.setAddress(rs.getString("address"));
	                return user;
	            }});
	        for(User user:userList){
	            System.out.println(user.getId());
	            System.out.println(user.getUsername());
	            System.out.println(user.getSex());
	            System.out.println(user.getAddress());

	        }

	        model.addAttribute("userList", userList);

	        return "hello";
		};
		
	}
	
