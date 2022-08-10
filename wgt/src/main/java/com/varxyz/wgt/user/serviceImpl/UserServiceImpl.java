package com.varxyz.wgt.user.serviceImpl;

import java.util.List;

import com.varxyz.wgt.user.domain.User;
import com.varxyz.wgt.user.service.UserService;

public class UserServiceImpl implements UserService {

	// 회원생성
	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	// 회원조회
	@Override
	public List<User> findAllUser(String userId) {
		return userDao.findUser(userId);
	}
	
	// 회원수정
	public void modifyUser(User user) {
		 userDao.modifyUser(user);
	}
	
}
