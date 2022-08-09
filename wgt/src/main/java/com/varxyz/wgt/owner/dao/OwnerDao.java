package com.varxyz.wgt.owner.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.varxyz.wgt.owner.doamin.Owner;

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

}
