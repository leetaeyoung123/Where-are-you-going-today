package com.varxyz.wgt.map.dao;

import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.varxyz.wgt.map.domain.Map;

public class MapDao {
	private JdbcTemplate jdbcTemplate;
	
	public MapDao(DataSource dataSourceConfig) {
		jdbcTemplate = new JdbcTemplate(dataSourceConfig);
	}
	
	public List<Map> findAll(String businessNumber){
		String sql = "SELECT * FROM map WHERE businessNumber = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Map>(Map.class), businessNumber);
	}
	
	public List<Map> search(String name){
		String sql = "SELECT * FROM map WHERE name like '%" + name +"%' ";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Map>(Map.class));
	}
}
