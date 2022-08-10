package com.varxyz.wgt.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.EmptyResultDataAccessException;
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
	
	@PostMapping("/login")
	public String login(User user, HttpSession session, HttpServletRequest request,
							Model model) {
		
		User dbUser = new User();
		
		try {
			dbUser = loginService.login(user.getUserId());
			
			session.setAttribute("userId", dbUser);
			
			if(user.getUserId().equals(dbUser.getUserId()) && user.getPasswd().equals(dbUser.getPasswd())) {
				session.setAttribute("userId", user.getUserId());
			return "map/map";
			}
			
		} catch (EmptyResultDataAccessException e) {
//			e.printStackTrace(); // 무슨 에러가 나는지 콘솔창에서 알려줌
			model.addAttribute("msg", "아이디를 다시 확인하세요!!");
			model.addAttribute("url", "login");
			
			return "error/error";
		}
		
		model.addAttribute("msg", "비밀번호를 다시 확인하세요!!");
		model.addAttribute("url", "login");
		
		return  "error/error";
	}

}
