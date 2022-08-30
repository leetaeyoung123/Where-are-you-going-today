package com.varxyz.wgt.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.login.service.OwnerLoginService;
import com.varxyz.wgt.login.serviceImpl.OwnerLoginServiceImpl;
import com.varxyz.wgt.owner.doamin.Owner;
import com.varxyz.wgt.owner.service.OwnerService;
import com.varxyz.wgt.owner.serviceImpl.OwnerServiceImpl;
import com.varxyz.wgt.shop.service.ShopService;
import com.varxyz.wgt.shop.service.ShopServiceImpl;

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

		Owner dbOwner = new Owner();
		dbOwner = ownerService.findAllOwner(owner.getOwnerId());
		session.setAttribute("dbOwner", dbOwner);
		
		if(owner.getOwnerId().equals(dbOwner.getOwnerId()) &&
		   owner.getPasswd().equals(dbOwner.getPasswd())) {

			ShopService shopService = new ShopServiceImpl();

			session.setAttribute("bnsNum", shopService.findShopByOwnerId(owner.getOwnerId()).getBusinessNumber());
			session.setAttribute("ownerId", request.getParameter("ownerId"));
			return "redirect:/add_shop";
		}

		System.out.println("로그인 실패");

		model.addAttribute("msg", "회원정보가 틀렸습니다");
		model.addAttribute("url", "ownerLogin");

		return "error/error";
	}
	// 로그아웃
	@GetMapping("/ownerLogOut")
	public String ownerLogOutForm() {

		return "logOut/ownerLogOut";
	}

	@PostMapping("ownerLogOut")
	public String ownerLogOut(HttpSession session) {
		session.invalidate(); // 세션단절

		return "login/ownerLogin";
	}


}
