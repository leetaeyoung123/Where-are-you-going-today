package com.varxyz.wgt.shop.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.wgt.data.DataSourceConfig;
import com.varxyz.wgt.shop.dao.ShopDao;
import com.varxyz.wgt.shop.domain.Shop;

public interface ShopService {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	ShopDao dao = context.getBean("shopDao", ShopDao.class);
	
	// 매장명으로 매장 정보 가져오기
	public List<Shop> findAllByShopName(String shopName);
}
