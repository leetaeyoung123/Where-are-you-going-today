package com.varxyz.wgt.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.board.service.BoardService;
import com.varxyz.wgt.board.service.BoardServiceImpl;
import com.varxyz.wgt.user.service.UserService;
import com.varxyz.wgt.user.serviceImpl.UserServiceImpl;

@Controller
public class TestController {
	BoardService service = new BoardServiceImpl();
	UserService us = new UserServiceImpl();
	
	// 게시판 화면
	@GetMapping("/board/test")
	public String list(Model model, Board board) {
		model.addAttribute("board", service.read(board));
		return "board/test";
	}

	@PostMapping("/board/test")
	public String post(Board board, Model model) {
		
		return "redirect:/board/write";
	}

}