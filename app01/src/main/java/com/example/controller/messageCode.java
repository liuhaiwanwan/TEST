package com.example.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.User;
import com.example.service.UserService;

@Controller
public class messageCode {
	@Autowired //自动连接到UserService Bean
	private UserService userService;
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	//短信平台相关参数
	//这个不用改
//	private String apiUrl = "https://sms_developer.zhenzikj.com";
	//榛子云系统上获取
//	private String appId = "100862";
//	private String appSecret = "62358d10-bc0e-4152-a52c-578a8debc9b9";

	@ResponseBody
	@RequestMapping(value = "/code")
	public boolean getCode(@RequestParam("memPhone") String memPhone, HttpSession httpSession){
	    User user = userService.selectByPhone(memPhone);
	    if (user!=null){
	        try {
//	        JSONObject json = null;
	        //随机生成验证码
	        String code = String.valueOf(new Random().nextInt(999999));
	        //将验证码通过榛子云接口发送至手机
//	        ZhenziSmsClient client = new ZhenziSmsClient(apiUrl, appId, appSecret);
//	        String result = client.send(memPhone, "您的验证码为:" + code + "，该码有效期为5分钟，该码只能使用一次!");
	        Map codeNo = new HashMap();
//	        json = JSONObject.parseObject(result);
//	        if (json.getIntValue("code")!=0){//发送短信失败
//	            return  false;
//	        }
	        //将验证码存到session中,同时存入创建时间
	        //以json存放，这里使用的是阿里的fastjson
//	        json = new JSONObject();
	        codeNo.put("memPhone","18909832595");
	        codeNo.put("code",code);
	        codeNo.put("createTime",System.currentTimeMillis());
	        // 将认证码存入SESSION
	        httpSession.setAttribute("code",codeNo);
	        return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	        return false;
	}
	
}
