package com.varxyz.wgt.login.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.login.service.OwnerLoginService;
import com.varxyz.wgt.login.serviceImpl.OwnerLoginServiceImpl;
import com.varxyz.wgt.owner.doamin.Owner;
import com.varxyz.wgt.owner.service.OwnerService;
import com.varxyz.wgt.owner.serviceImpl.OwnerServiceImpl;

@Controller
public class OwnerLoginController {
	OwnerLoginService ownerLoginService = new OwnerLoginServiceImpl();
	
	OwnerService ownerService = new OwnerServiceImpl();
	
	// 점주 로그인
	@GetMapping("/ownerLogin")
	public String ownerForm(HttpSession session) {
		session.invalidate();	// 세션 단절
		
		return "login/ownerLogin";
	}
	
	@PostMapping("/ownerLogin")
	public String ownerLogin(Owner owner, HttpSession session, HttpServletRequest request,
							Model model) {
		
		List<Owner> ownerList = new ArrayList<Owner>();
		ownerList = ownerService.findAllOwner(owner.getOwnerId());
		
		session.setAttribute("ownerList", ownerList);
		
		if(owner.getOwnerId().equals(ownerList.get(0).getOwnerId())) {
			if(owner.getPasswd().equals(ownerList.get(1).getPasswd())) {
				if(owner.getBnumber().equals(ownerList.get(2).getBnumber())) {
					return "login/successOwnerLogin";
				}
			}
		}
		return null;
			
		
		
//		try {
//			Owner ownerList = new Owner();
//			ownerList = ownerLoginService.ownerLogin(owner.getOwnerId());
//			
//			session.setAttribute("ownerList", ownerList);
//			
//			if(owner.getOwnerId().equals(ownerList.getOwnerId()) && owner.getPasswd().equals(ownerList.getPasswd())) {
////				System.out.println(owner.getOwnerId());
////				System.out.println(ownerList.getOwnerId());
//				session.setAttribute("ownerId", owner.getOwnerId());
//				
//			return "login/successOwnerLogin";
//			}
//			
//		} catch (EmptyResultDataAccessException e) {
////			e.printStackTrace(); // 무슨 에러가 나는지 콘솔창에서 알려줌
//			System.out.println(owner.getOwnerId());
////			System.out.println(ownerList.getOwnerId());
//			model.addAttribute("msg", "아이디를 다시 확인하세요!!");
//			model.addAttribute("url", "ownerLogin");
//			
//			return "error/error";
//		}
//		
//		model.addAttribute("msg", "비밀번호를 다시 확인하세요!!");
//		model.addAttribute("url", "ownerLogin");
//		
//		return  "error/error";
	}

}
