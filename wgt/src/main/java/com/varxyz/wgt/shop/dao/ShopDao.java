package com.varxyz.wgt.shop.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.wgt.shop.domain.Menu;
import com.varxyz.wgt.shop.domain.Shop;
import com.varxyz.wgt.waiting.domain.Waiting;

public class ShopDao {
private JdbcTemplate jdbcTemplate;
	
	public ShopDao(DataSource dataSourceConfig) {
		jdbcTemplate = new JdbcTemplate(dataSourceConfig);
	}
	
	// 매장명으로 매장 정보 가져오기
	public List<Shop> findAllByShopName(String shopName){
		String sql = "SELECT * FROM shop WHERE SHOP_NAME = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Shop>(Shop.class), shopName);
	}

	public boolean addShop(Shop shop) {
		String sql = "INSERT INTO SHOP (BUSINESS_NUMBER, SHOP_NAME, SHOP_TEL, SHOP_ADDRESS, SHOP_HOURS, SHOP_IMG) "
				+ " VALUES(?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, shop.getShopBusinessNum(), shop.getShopName(), shop.getShopTel(), 
								shop.getShopAddress(), shop.getShopHours(), shop.getShopImg());
		return true;
	}

	public boolean addMenu(Menu menu) {
		String sql = "INSERT INTO MENU (BUSINESS_NUMBER, SHOP_MENU_NAME, SHOP_MENU_INTRO, SHOP_MENU_PRICE, SHOP_MENU_IMG) "
				+ " VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, menu.getBusinessNumber(), menu.getMenuName(), menu.getMenuIntro(), 
								menu.getMenuPrice(), menu.getMenuImg());
		return true;
	}
}
