package com.varxyz.wgt.user.serviceImpl;

import com.varxyz.wgt.login.dao.LoginDao;
import com.varxyz.wgt.user.domain.User;
import com.varxyz.wgt.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}



}
