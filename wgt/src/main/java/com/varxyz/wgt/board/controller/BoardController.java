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

	@GetMapping("/board/home")
	public String list() {
		return "/board/home";
	}
	
	@PostMapping("/board/home")
	public String post(Board board, Model model) {
		model.addAttribute("Board", board);
		service.create(board);
		model.addAttribute("msg", "게시글 작성 완료");
		BoardService.context.close();
		return "board/home";
	}
	
	
	

}