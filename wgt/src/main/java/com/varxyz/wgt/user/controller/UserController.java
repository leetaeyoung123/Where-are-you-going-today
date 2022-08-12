package com.varxyz.wgt.user.controller;

import java.util.ArrayList;
import java.util.List;

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
		
		List<User> userList = new ArrayList<User>();
		userList = userService.inquiryUser(user.getUserId());
		if(user.getUserId().equals(userList.get(0).getUserId())) {
			model.addAttribute("msg", "중복된 아이디 입니다!!");
			model.addAttribute("url", "addUser");
			
			return "error/error";
		} 
			// 생성되기 전에 위에서 중복검사를 하고 유저를 여기서 추가해야함
			userService.addUser(user);
			UserService.context.close();
			
			return "login/login";
}

	// 회원정보 가져오기
	@GetMapping("/modifyUser")
	public String findAllUserForm(HttpServletRequest request, HttpSession session, Model model) {
		
		List<User> userList = new ArrayList<User>();
		userList = userService.inquiryUser((String)session.getAttribute("userId"));	// 세션을 가져옴
		model.addAttribute("userList", userList);

		return "user/modifyUser";
	}
	
	// 회원정보 수정
	@PostMapping("/modifyUser")
	public String modifyUserForm(User user, HttpServletRequest request, HttpSession session, Model model) {
		
		userService.modifyUser(user);
		
		return "user/successModifyUser";
	}

//	 회원 탈퇴
	@GetMapping("/deleteUser")
	public String deleteUserForm(HttpServletRequest request, HttpSession session, Model model) {
		
		return "login/login";
	}
	
	@PostMapping("/deleteUser")
	public String delete(HttpServletRequest request, HttpSession session, Model model) {
		
		userService.delete((String)session.getAttribute("userId"));	// 세션 userId 가져와서 삭제
		
		return "user/deleteUser";
	}

}
