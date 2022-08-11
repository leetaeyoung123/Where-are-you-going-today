package com.varxyz.wgt.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.varxyz.wgt.shop.service.ShopService;
import com.varxyz.wgt.shop.service.ShopServiceImpl;

@Controller
public class SelectShopController {
	
	@GetMapping("shop/viewMyShop")
	public String viewMyShop(Model model) {
		ShopService service = new ShopServiceImpl();
		model.addAttribute("shop", service.findShopByBnsNum("123-4568-7891"));
		
		model.addAttribute("menus", service.findShopMenuByBnsNum("123-4568-7891"));
		return "shop/view/viewMyShop";
	}
}
