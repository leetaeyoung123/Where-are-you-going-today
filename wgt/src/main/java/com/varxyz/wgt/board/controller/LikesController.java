package com.varxyz.wgt.board.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.varxyz.wgt.user.service.UserService;

public class LikesController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	LikesService likesService;
	
}
