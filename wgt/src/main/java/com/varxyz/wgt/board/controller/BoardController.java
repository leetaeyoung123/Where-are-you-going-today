package com.varxyz.wgt.board.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.board.service.BoardService;
import com.varxyz.wgt.board.service.BoardServiceImpl;

@Controller
public class BoardController {
	BoardService service = new BoardServiceImpl();
	
	// 게시판 화면
	@GetMapping("/board/home")
	public String list(Model model, Board board) {
		service.read(board);
		model.addAttribute("board", service.read(board));
//		System.out.println(board);
		return "board/home";
	}

	@PostMapping("/board/home")
	public String post(Board board, Model model) {

		return "redirect:/board/write";
	}
	
	
	

}