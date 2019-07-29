package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example.bean.User;

@Mapper
public interface UserDao {
	
	@Results({ //2
	      @Result(property = "id", column = "id"), //2
	      @Result(property = "username", column = "username"),
	      @Result(property = "birthday", column = "birthday"),
	      @Result(property = "sex", column = "sex"),
	      @Result(property = "address", column = "address"),
	  })
	
	  @Select("SELECT * FROM user") //3
	  List<User> getAllUser();
	
	  @Select("SELECT * FROM user WHERE id = #{id}") //3
	  User get(int id);
	  
	  @Select("SELECT * FROM user WHERE memPhone = #{memPhone}") //3
	  User getPhon(String memPhone);
	  
	  @Insert("INSERT INTO user(username, sex, address) VALUES (#{username}, #{sex}, #{address})") //3
	  void insert(User user);

	  @Select("DELETE FROM `user` WHERE id = #{id}") 
	  String del(int id);

	  @Select("UPDATE `user` SET username= #{username},sex=#{sex},address=#{address} WHERE id = #{id}") 
	  void update(User user);
	  
}
