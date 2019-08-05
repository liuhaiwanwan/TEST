package com.companyInfo.service;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.companyInfo.bean.Company;
import com.companyInfo.dao.CompanyDao;
 
@Service //声明成一个spring bean
public class CompanyService {
 
  @Autowired //连接到UserDao Bean
  private CompanyDao companyDao;
 
  public String show() {
    return "companyInfo";
  }
 
  public List<Company> showAllCompany() {
	  return companyDao.getAllCompany();
	  }

  public Company showDaoById(int id) {
  //  System.out.println("传递id值 = "+id);
    Company result = companyDao.getById(id);
   //   System.out.println("传递id值 = "+result.getCompanyAddress());
    return result;
  } 
  public String showCompanyName(int id) {
	    String result = companyDao.getCompanyName(id);
	    return result;
	  } 
  public String showLegalPerson(int id) {
	    String result = companyDao.getLegalPerson(id);
	    return result;
	  } 
  public String showLegalPersonPhone(int id) {
	    String result = companyDao.getLegalPersonPhone(id);
	    return result;
	  } 
  public String showCompanyAddress(int id) {
	    String result = companyDao.getCompanyAddress(id);
	    return result;
	  } 
public String showRemark(int id) {
	    String result = companyDao.getRemark(id);
	    return result;
	  } 
public String showMobilePhone(int id) {
	    String result = companyDao.getMobilePhone(id);
	    return result;
	  } 
public String showEmail(int id) {
    String result = companyDao.getEmail(id);
    return result;
  } 
public String showPassword(int id) {
    String result = companyDao.getPassword(id);
    return result;
  } 
public String showLanguage(int id) {
    String result = companyDao.getLanguage(id);
    return result;
  } 


  public String update(Company company) {
	  companyDao.update(company);
	   return "success";
 }
  
  
  public String  updateCompanyName(String company_name,int id){
   companyDao.updateCompanyName(company_name,id);
   return "company";
  }

	  public String  updateLegalPerson(String legal_person,int id){
	   companyDao.updateLegalPerson(legal_person,id);
	   return "company";
   }
	   
	public String  updateLegalPersonPhone(String legal_person_phone,int id){
	companyDao.updateLegalPersonPhone(legal_person_phone,id);
	return "company";
	}
	public String  updateCompanyAddress(String company_address,int id){
    companyDao.updateCompanyAddress(company_address, id);
    return "company";
	}	   
	public String  updateRemark(String remark,int id){
	companyDao.updateRemark(remark,id);
	return "company";
	}
			   
	public String updateMobilePhone(String mobile_phone,int id){
    companyDao.updateMobilePhone(mobile_phone,id);
    return "company";
	}
	public String  updateEmail(String email,int id){
	companyDao.updateEmail(email,id);
	return "company";
	}

	public String  updatePassword(String login_password,int id){
	companyDao.updatePassword(login_password,id);
	return "company";
	}
	
	public String  updateLanguage(String language,int id){
	companyDao.updateLanguage(language,id);
	return "company";
	} 
  
  
}