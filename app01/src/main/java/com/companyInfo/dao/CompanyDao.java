package com.companyInfo.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.companyInfo.bean.Company;

@Mapper
public interface CompanyDao {
	
	@Results({ //2
	      @Result(property = " id", column = "id"), //2
	      @Result(property = "company_name", column = "company_name"),
	      @Result(property = "legal_person", column = "legal_person"),
	      @Result(property = "legal_person_phone", column = "legal_person_phone"),
	      @Result(property = "company_address", column = "company_address"),
	      @Result(property = "remark", column = "remark"), 
	      @Result(property = "user_name", column = "user_name"),
	      @Result(property = "mobile_phone", column = "mobile_phone"),
	      @Result(property = "email", column = "email"),
	      @Result(property = "login_password", column = "login_password"),
	      @Result(property = "language", column = "language"),
	  })
	
	  @Select("SELECT * FROM company") //3
	  List<Company>  getAllCompany();
	
	
	  @Select("SELECT * FROM company WHERE id = #{id}")
	  Company getById(int id);
	  
	  @Select("UPDATE `company` SET company_name= #{company_name},login_password=#{login_password},"
		  		+ "legal_person=#{legal_person},legal_person_phone=#{legal_person_phone},company_address=#{company_address} WHERE id = #{id}") 
		  void update(Company company);
		  
		  @Select("UPDATE `company` SET company_name= #{company_name} WHERE id = #{id}") 
		  void updateCompanyName(String company_name,int id);
		  
		  @Select("UPDATE `company` SET legal_person= #{legal_person} WHERE id = #{id}") 
		  void updateLegalPerson(String legal_person,int id);
		  
		  @Select("UPDATE `company` SET legal_person_phone= #{legal_person_phone} WHERE id = #{id}") 
		  void updateLegalPersonPhone(String legal_person_phone,int id);
		  
		  @Select("UPDATE `company` SET company_address= #{company_address} WHERE id = #{id}") 
		  void updateCompanyAddress(String company_address,int id);
		  
		  @Select("UPDATE `company` SET remark= #{remark} WHERE id = #{id}") 
		  void updateRemark(String remark,int id);
		  
		  @Select("UPDATE `company` SET mobile_phone= #{mobile_phone} WHERE id = #{id}") 
		  void updateMobilePhone(String mobile_phone,int id);
		  
		  @Select("UPDATE `company` SET email= #{email} WHERE id = #{id}") 
		  void updateEmail(String email,int id);
		  
		  @Select("UPDATE `company` SET login_password= #{login_password} WHERE id = #{id}") 
		  void updatePassword(String login_password,int id);
		  
		  @Select("UPDATE `company` SET language= #{language} WHERE id = #{id}") 
		  void updateLanguage(String language,int id);
	  
	  
	  @Select("SELECT company_name FROM company WHERE id = #{id}") 
	  String getCompanyName(int id);
	  
	  @Select("SELECT legal_person FROM company  WHERE id = #{id}") 
	  String getLegalPerson(int id);
	  
	  @Select("SELECT legal_person_phone FROM company  WHERE id = #{id}") 
	  String getLegalPersonPhone(int id);
	  
	  @Select("SELECT company_address FROM company  WHERE id = #{id}") 
	  String getCompanyAddress(int id);
	  
	  @Select("SELECT remark FROM company  WHERE id = #{id}") 
	  String getRemark(int id);
	  
	  @Select("SELECT  mobile_phone FROM company  WHERE id = #{id}") 
	  String getMobilePhone(int id);
	  
	  @Select("SELECT email FROM company WHERE id = #{id}") 
	  String getEmail(int id);
	  
	  @Select("SELECT login_password FROM company login_password WHERE id = #{id}") 
	  String getPassword(int id);
	  
	  @Select("SELECT language FROM company  WHERE id = #{id}") 
	  String getLanguage(int id);

	  
}
