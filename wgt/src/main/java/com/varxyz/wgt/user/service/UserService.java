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
	
	public void addUser(User user);
	
	List<User> findAllUser(String userId);
}
