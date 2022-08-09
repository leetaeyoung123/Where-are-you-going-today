package com.varxyz.wgt.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.board.service.BoardService;
import com.varxyz.wgt.board.service.BoardServiceImpl;

@Controller
public class Writecontroller {
	BoardService service = new BoardServiceImpl();
	
	// 등록하기 화면
	@GetMapping("/board/write")
	public String postForm(Model model) {
		return "/board/write";
	}
	
	@PostMapping("/board/write")
	public String post(Board board, Model model) {
		model.addAttribute("Board", board);
		service.create(board);
		model.addAttribute("msg", "게시글 작성 완료하였습니다.");
		model.addAttribute("url","home"); //alert model.addAttribute 할땐 msg랑 url 둘 다
		return "alert/alert";
	}
	
	
	

}