package com.companyInfo.bean;

	public class Company {
		
	 private int id;                      // 企业id号
	 private String company_name;         // 公司名称
	 private String legal_person;         // 法人
	 private String legal_person_phone;   // 法人手机号
	 private String company_address;      // 公司地址
	 private String remark;               // 备注
	 
	 private String user_name;            // 企业账号名
	 private String mobile_phone;         // 手机号
	 private String email;                // 邮箱
	 private String login_password;       // 登录密码
	 private String confirm_password;     // 确认密码
	 private String language;             // 语言
	 
	 
	public int getId() {
	  return id;
	 }
	public void setId(int id) {
	  this.id = id;
	 }
	public String getCompanyName() {
	  return company_name;
	 }
	public void setCompanyName(String company_name) {
	  this.company_name = company_name;
	 }
	public String getLegalPerson() {
	  return legal_person;
	 }
	public void setLegalPerson(String legal_person) {
	  this.legal_person = legal_person;
	 }
	public String getLegalPersonPhone() {
	  return legal_person_phone;
	 }
	public void setLegalPersonPhone(String legal_person_phone) {
	  this.legal_person_phone = legal_person_phone;
	 }
	public String getCompanyAddress() {
	  return company_address;
	 }
	public void setCompanyAddress(String company_address) {
	  this.company_address = company_address;
	 }
	public String getRemark() {
		  return remark;
		 }
    public void setRemark(String remark) {
		  this.remark = remark;
		 }
	public String getUser_name() {
		  return user_name;
		 }
    public void setUser_name(String user_name) {
		  this.user_name = user_name;
		 }
	public String getLoginPassword() {
		  return login_password;
		 }
    public void setLoginPassword(String login_password) {
		  this.login_password = login_password;
		 }
	public String getConfirmPassword() {
		  return confirm_password;
		 }
    public void setConfirmPassword(String confirm_password) {
		  this.confirm_password = confirm_password;
		 } 
	public String getMobile_phone() {
		  return mobile_phone;
		 }
    public void setMobile_phone(String mobile_phone) {
		  this.mobile_phone = mobile_phone;
		 } 
	public String getEmail() {
		  return email;
		 }
    public void setEmail(String email) {
		  this.email = email;
		 }
	public String getLanguage() {
		  return language;
		 }
    public void setLanguage(String language) {
		  this.language = language;
		 }
	 }
