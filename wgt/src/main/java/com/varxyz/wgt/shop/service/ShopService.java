package com.varxyz.wgt.shop.service;

import java.util.List;

import com.varxyz.wgt.shop.domain.Shop;

public interface ShopService {

	// 매장명으로 매장 정보 가져오기
	public List<Shop> findAllByShopName(String shopName);
}
