package com.varxyz.wgt.user.controller;

import javax.servlet.http.HttpServletRequest;
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

	// 회원정보 가져오기
	@GetMapping("/modifyUser")
	public String findAllUser(HttpServletRequest request, HttpSession session, Model model) {
		
		List<User> user = new ArrayList<User>();
		user = userService.findAllUser();

		model.addAttribute("user", user);

		return "user/modifyUser";
	}

}
