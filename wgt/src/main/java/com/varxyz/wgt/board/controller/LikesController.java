//package com.varxyz.wgt.board.controller;
//
//import java.util.List;
//
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import com.varxyz.wgt.board.domain.Board;
//import com.varxyz.wgt.board.domain.Likes;
//import com.varxyz.wgt.board.service.BoardService;
//import com.varxyz.wgt.board.service.BoardServiceImpl;
//
//@Controller
//public class LikesController {
//	BoardService service = new BoardServiceImpl();
//	
//	@GetMapping("/board/likes")
//	public String list(Model model, Board board) {
//		model.addAttribute("board", service.read(board));
//		return "board/home";
//	}
//
//	@PostMapping("/board/likes")
//	public String search(Board board, Model model) {
//		List<Board> list = service.search(board.getTitle());
//		model.addAttribute("list", list);
//		return "board/search";
//	}
//	
//	// 검색 화면
//	@GetMapping("/board/search")
//	public String searchlist(Model model) {
//		return "board/search";
//	}
//
//	@PostMapping("/board/search")
//	public String getsearchlist(Board board, Model model, HttpSession session) {
//		List<Board> list = service.search(board.getTitle());
//		model.addAttribute("list", list);
//		session.invalidate();
//		return "board/search";
//	}
//}