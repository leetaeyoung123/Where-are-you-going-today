package com.varxyz.wgt.shop.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
