package com.varxyz.wgt.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.login.service.LoginService;
import com.varxyz.wgt.login.serviceImpl.LoginServiceImpl;
import com.varxyz.wgt.user.domain.User;
import com.varxyz.wgt.user.service.UserService;
import com.varxyz.wgt.user.serviceImpl.UserServiceImpl;

@Controller
public class LoginController {
	LoginService loginService = new LoginServiceImpl();
	
	UserService userService = new UserServiceImpl();
	
	// 로그인 화면
	@GetMapping("/login")
	public String loginForm(HttpSession session) {
		session.invalidate();	// 세션 단절
		
		return "login/login";
	}
	
	@PostMapping("/login/login")
	public String login(User user, HttpSession session, HttpServletRequest request,
							Model model) {
		
		User dbUser = new User();
		dbUser = loginService.login(user.getUserId());
		
		session.setAttribute("userId", dbUser);
		
		return null;
	}
	
}
