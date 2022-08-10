package com.varxyz.wgt.user.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.wgt.user.domain.User;

@Repository("userDao")
public class UserDao {
	private JdbcTemplate jdbcTemplate;
	
	public UserDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// 회원가입
	public void addUser(User user) {
		String sql = "INSERT INTO User (userId, passwd, name, ssn, phone, addr) "
				+ " VALUES (?, ?, ?, ?, ?, ?) ";
		
		jdbcTemplate.update(sql, user.getUserId(), user.getPasswd(), user.getName(), 
								user.getSsn(), user.getPhone(), user.getAddr());
	}
	
	// 회원 조회
	public List<User> findUser(String userId) {
		String sql = "SELECT * FROM User WHERE userId = ?";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class), userId);
	}
	
	// 회원정보 수정
	public void modifyUser(User user) {
		String sql = "UPDATE User SET passwd = ?, name = ?, phone = ?, addr = ? WHERE userId = ?";
		
		jdbcTemplate.update(sql, new BeanPropertyRowMapper<User>(User.class), user.getPasswd(), user.getName(), user.getPhone(), user.getAddr());
		
	}
	
	// 회원탈퇴
	public void delete(User user) {
		String sql = "DELETE FROM User WHERE userId = ?";
		
		jdbcTemplate.update(sql, user.getUserId(), user.getPasswd(), user.getName(), user.getSsn(), user.getPhone(), user.getAddr());
	}
	
}
