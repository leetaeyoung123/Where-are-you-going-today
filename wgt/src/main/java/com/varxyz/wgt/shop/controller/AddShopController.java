package com.varxyz.wgt.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddShopController {
	
	@GetMapping("/add_shop")
	public String addShopGo() {
		return "shop/addShop";
	}
	
	@PostMapping("/add_shop2")
	public String addShop2Form() {
		return "shop/addShop2";
	}
	
	@PostMapping("/add_shop3")
	public String addShop3Form() {
		return "shop/addShop3";
	}
	
	@PostMapping("/add_shop4")
	public String addShop4Form() {
		return "shop/addShop4";
	}
}
