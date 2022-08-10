package com.varxyz.wgt.user.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.user.domain.User;
import com.varxyz.wgt.user.service.UserService;
import com.varxyz.wgt.user.serviceImpl.UserServiceImpl;

@Controller("controller.userController")
public class UserController {
	// 유저 서비스 객체 생성
	UserService userService = new UserServiceImpl();
	
	// 유저 리스트 생성
	User user = new User();
	
	// 회원가입 
	@GetMapping("/addUser")
	public String addUserForm() {
		
		return "user/addUser";
	}

	@PostMapping("/addUser") 
	public String addUser(User user, Model model) {
		
		userService.addUser(user);
		UserService.context.close();
			
		return "login/login";
	}
	
//	// 회원정보 수정
	@GetMapping("/modifyUser")
	public String modifyUserForm(User user, HttpSession session, Model model) {
		
		
		model.addAttribute(user.getUserId());
		model.addAttribute(user.getPasswd());

		
		return "user/modifyUser";
	}
	
}
