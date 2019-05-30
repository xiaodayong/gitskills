package com.liu.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.liu.po.UserInfo;

/**
 * user/list.do
 * user/add.do
 * @author yingjie
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@RequestMapping(value="/add1.do")
	public String add(HttpServletRequest request){
	
		String userNumber = request.getParameter("userNumber");
		String passWord = request.getParameter("passWord");
		
		System.out.println("userNumber:"+userNumber+" passWord:"+passWord);
		
		return "user_add1";
	}
	
	@RequestMapping(value="/add2.do")
	public String add(@RequestParam(value="number")String userNumber,Integer passWord){

		System.out.println("userNumber:"+userNumber+" passWord:"+passWord);
		
		return "user_add2";
	}
	
	@RequestMapping(value="/add3.do")
	public String add3(UserInfo user){

		System.out.println(user);
		
		return "user_add3";
	}
	
	@RequestMapping(value="/add4.do")
	public String add4(Integer userId,Date userTime){

		System.out.println(userId);
		System.out.println(userTime);
		
		return "user_add4";
	}
	
	/**
	 * ʱ�����Ա༭��
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder bin){
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		CustomDateEditor cust = new CustomDateEditor(sdf, true);
		
		
		bin.registerCustomEditor(Date.class,cust);
	}

}
