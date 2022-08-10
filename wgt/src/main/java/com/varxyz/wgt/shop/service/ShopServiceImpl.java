package com.varxyz.wgt.shop.service;

import java.util.List;

import com.varxyz.wgt.shop.domain.Shop;

public class ShopServiceImpl implements ShopService {

	@Override
	public List<Shop> findAllByShopName(String shopName) {
		return dao.findAllByShopName(shopName);
	}

}
