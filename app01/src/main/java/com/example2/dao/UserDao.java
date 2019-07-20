package com.example2.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.example2.bean.User;

@Mapper
public interface UserDao {
	
	@Results({ //2
	      @Result(property = "id", column = "id"), //2
	      @Result(property = "username", column = "username"),
	      @Result(property = "birthday", column = "birthday"),
	      @Result(property = "sex", column = "sex"),
	      @Result(property = "address", column = "address"),
	  })
	  @Select("SELECT * FROM user WHERE id = #{id}") //3
	  List<User> get(int id);
	 
	  @Insert("INSERT INTO user(id,username, sex) VALUES (#{id},#{username}, #{sex})") //3
	  void insert(User user);

}
