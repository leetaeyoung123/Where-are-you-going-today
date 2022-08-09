package com.varxyz.wgt.user.serviceImpl;

import java.util.List;

import com.varxyz.wgt.user.domain.User;
import com.varxyz.wgt.user.service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> findAllUser(String userId) {
		return userDao.findUserId(userId);
	}


}
