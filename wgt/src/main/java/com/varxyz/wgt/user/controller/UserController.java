package com.varxyz.wgt.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.user.domain.User;
import com.varxyz.wgt.user.service.UserService;
import com.varxyz.wgt.user.serviceImpl.UserServiceImpl;

@Controller("controller.userController")
public class UserController {
	UserService userService = new UserServiceImpl();
	
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
	
}
