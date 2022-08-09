package com.varxyz.wgt.owner.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.owner.doamin.Owner;
import com.varxyz.wgt.owner.service.OwnerService;
import com.varxyz.wgt.owner.serviceImpl.OwnerServiceImpl;

@Controller
public class OwnerController {
	OwnerService ownerService = new OwnerServiceImpl();
	
	// 점주 로그인
	@GetMapping("/ownerLogin")
	public String ownerForm(HttpSession session) {
		session.invalidate();	// 세션 단절
		
		return "login/ownerLogin";
	}
	
	// 점주가입
	@GetMapping("/addOwner")
	public String addOwnerForm() {
		
		return "owner/addOwner";
	}
	
	@PostMapping("/addOwner")
	public String addOwner(Owner owner, Model model) {
		
		ownerService.addOwner(owner);
		OwnerService.context.close();
		
		return "login/login";
	}
}
