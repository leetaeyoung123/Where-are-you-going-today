package com.varxyz.wgt.user.service;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.wgt.data.DataSourceConfig;
import com.varxyz.wgt.user.dao.UserDao;
import com.varxyz.wgt.user.domain.User;

public interface UserService {
	AnnotationConfigApplicationContext context = 
			new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	UserDao userDao = context.getBean("userDao", UserDao.class);
	
	// 회원 추가
	public void addUser(User user);
	
	// 회원 조회
	public List<User> findAllUser(String userId);
	
	// 회원 수정
	public void modifyUser(User user);

}
