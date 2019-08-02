package com.file.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.file.entity.ShareFile;

@Mapper
public interface ShareFileMapper {
	
	@Results({ //2
	      @Result(property = "id", column = "id"), //2
	      @Result(property = "fileName", column = "fileName"),
	      @Result(property = "fileContent", column = "fileContent"),
	      @Result(property = "remark", column = "remark"),
	  })
	
	  @Select("SELECT * FROM share_file") //3
	  List<ShareFile> getAllFile();
	
	  @Select("SELECT * FROM share_file WHERE id = #{id}") //3
	  ShareFile getFileInfo(int id);
	  
//	  @Select("SELECT * FROM user WHERE memPhone = #{memPhone}") //3
//	  ShareFile getPhon(String memPhone);
//	  
	  @Insert("INSERT INTO share_file(fileName, fileContent, remark) VALUES (#{fileName}, #{fileContent}, #{remark})") //3
	  void insert(ShareFile shareFile);

	  @Select("DELETE FROM `share_file` WHERE id = #{id}") 
	  String delFile(int id);

	  @Select("UPDATE `share_file` SET fileName= #{fileName},fileContent=#{fileContent},remark=#{remark} WHERE id = #{id}") 
	  void updateFile(ShareFile shareFile);
	  
}
