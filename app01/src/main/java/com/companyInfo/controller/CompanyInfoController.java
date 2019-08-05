package com.companyInfo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.companyInfo.bean.Company;
import com.companyInfo.service.CompanyService;

	
@Controller //声明为一个Restful的Controller
@RequestMapping("/companyInfoController")
public class CompanyInfoController {
	@RequestMapping(value = "/companyInfo")
	  public String index() {
	  return "company"; 
	  }
  @Autowired //自动连接到UserService Bean
  private  CompanyService companyService;
  
  @ResponseBody
  @RequestMapping(value="/seekById")
  public Company seekCompanyById(int id) {
//	  System.out.println("传递id值 = "+id);
	  Company result = companyService.showDaoById(id);
//	  System.out.println("得到id值 = "+result.getCompanyAddress());
	   return result;
  }
  
  @ResponseBody
  @RequestMapping(value="/seek_company_name")
  public String seekCompanyName(int id) {
	 
	  String result = companyService.showCompanyName(id);
	 
	   return result;
  }
  @ResponseBody
  @RequestMapping(value="/seek_legal_person")
  public String seekLegalPerson(int id) {
	 
	  String result = companyService.showLegalPerson(id);
	  return result;
  }
  @ResponseBody
  @RequestMapping(value="/seek_legal_person_phone")
  public String seekLegalPersonPhone(int id) {
	 
	  String result = companyService.showLegalPersonPhone(id);
	  return result;
  }
  @ResponseBody
  @RequestMapping(value="/seek_company_address")
  public String seekCompanyAddress(int id) {
	  String result = companyService.showCompanyAddress(id);
	  System.out.println("传递T1值 = "+result);
	  return result;
  }
  @ResponseBody
  @RequestMapping(value="/seek_remark")
  public String seekRemark(int id) {
	 
	  String result = companyService.showRemark(id);
	  return result;
  }
  @ResponseBody
  @RequestMapping(value="/seek_mobile_phone")
  public String seekMobilePhone(int id) {
	 
	  String result = companyService.showMobilePhone(id);
	  return result;
  }
  @ResponseBody
  @RequestMapping(value="/seek_email")
  public String seekEmail(int id) {
	 
	  String result = companyService.showEmail(id);
	  return result;
  }
  @ResponseBody
  @RequestMapping(value="/seek_login_password")
  public String seekPassword(int id) {
	 
	  String result = companyService.showPassword(id);
	  return result;
  }
  @ResponseBody
  @RequestMapping(value="/seek_language")
  public String seekLanguage(int id) {
	 
	  String result = companyService.showLanguage(id);
	  return result;
  }
  

  @RequestMapping(value="/update")
  public String  update(Company company){
	  companyService.update(company);
	  return "company";
  }
	  
	  @RequestMapping(value="/update_company_name")
	  public String  updateCompanyName(String company_name,int id){
	   companyService.updateCompanyName(company_name, id);
	   return "company";
	  }
	
	   @RequestMapping(value="/update_legal_person")
		  public String  updateLegalPerson(String legal_person,int id){
		   companyService.updateLegalPerson(legal_person, id);
		   return "company";
	   }
		   
		@RequestMapping(value="/update_legal_person_phone")
		public String  updateLegalPersonPhone(String legal_person_phone,int id){
		companyService.updateLegalPersonPhone(legal_person_phone, id);
		return "company";
		}
			
		@RequestMapping(value="/update_company_address")
		public String  updateCompanyAddress(String company_address,int id){
	//		System.out.println("传递T1值 = "+company_address);
	//		System.out.println("传递T1值 = "+id);
		companyService.updateCompanyAddress(company_address, id);
	//	    System.out.println("传递T1值 = "+company_address);
		return "company";
		}
		@RequestMapping(value="/update_remark")
		public String  updateRemark(String remark,int id){
		companyService.updateRemark(remark, id);
		return "company";
		}
				   
		@RequestMapping(value="/update_mobile_phone")
		public String updateMobilePhone(String mobile_phone,int id){
	    companyService.updateMobilePhone(mobile_phone, id);
	    return "company";
		}
		@RequestMapping(value="/update_email")
		public String  updateEmail(String email,int id){
		companyService.updateEmail(email, id);
		return "company";
		}
		@RequestMapping(value="/update_password")
		public String  updatePassword(String login_password,int id){
		companyService.updatePassword(login_password, id);
		return "company";
		}
		@RequestMapping(value="/update_language")
		public String  updateLanguage(String language,int id){
		companyService.updateLanguage(language,id);
		return "company";
		} 
		  
}

