package com.varxyz.wgt.owner.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.wgt.owner.doamin.Owner;
import com.varxyz.wgt.owner.service.OwnerService;

@Repository("ownerDao")
public class OwnerDao {
	private JdbcTemplate jdbcTemplate;
	
	public OwnerDao(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// 점주가입
	public void addOwner(Owner owner) {
		String sql = "INSERT INTO Owner (ownerId, passwd, name, bnumber, phone, addr) "
				+ " VALUES (?, ?, ?, ?, ?, ?)";
		
		jdbcTemplate.update(sql, owner.getOwnerId(), owner.getPasswd(), owner.getName(), 
								owner.getBnumber(), owner.getPhone(), owner.getAddr());
	}

	// 점주 정보 가져오기
	public List<Owner> findAllOwner(String ownerId) {
		String sql = "SELECT * FROM Owner WHERE ownerId = ?";
		
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Owner>(Owner.class), ownerId);
	}

	// 점주정보 수정
	public void modifyOwner(Owner owner) {
		String sql = "UPDATE Owner SET passwd = ?, name = ?, phone = ?, addr = ? WHERE ownerId = ?";
		
		jdbcTemplate.update(sql, owner.getPasswd(), owner.getName(), owner.getPhone(), owner.getAddr(), owner.getOwnerId());
	}

	public void delete(String ownerId) {
		String sql = "DELETE FROM Owner WHERE ownerId = ?";
		
		jdbcTemplate.update(sql, ownerId);
	}

}
