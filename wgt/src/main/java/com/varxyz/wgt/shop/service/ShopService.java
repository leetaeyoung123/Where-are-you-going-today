package com.varxyz.wgt.shop.service;

import com.varxyz.wgt.shop.domain.Menu;
import com.varxyz.wgt.shop.domain.Shop;

public interface ShopService {

	public boolean addShop(Shop shop);
	
	public boolean addMenu(Menu menu);
	
}
