package com.varxyz.wgt.shop.service;

import java.util.List;

import com.varxyz.wgt.shop.domain.Menu;
import com.varxyz.wgt.shop.domain.Shop;

public interface ShopService {

	// 매장명으로 매장 정보 가져오기
	public List<Shop> findAllByShopName(String shopName);
	
	// 매장 추가
	public boolean addShop(Shop shop);
	
	// 매장 메뉴 추가
	public boolean addMenu(Menu menu);
}
