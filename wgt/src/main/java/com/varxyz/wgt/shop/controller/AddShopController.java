package com.varxyz.wgt.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AddShopController {
	
	@GetMapping("/add_shop")
	public String addShopGo() {
		return "shop/addShop";
	}
}
