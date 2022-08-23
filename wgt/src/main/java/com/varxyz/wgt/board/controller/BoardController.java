package com.varxyz.wgt.board.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mysql.cj.Session;
import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.board.domain.Likes;
import com.varxyz.wgt.board.service.BoardService;
import com.varxyz.wgt.board.service.BoardServiceImpl;

@Controller
public class BoardController {
	BoardService service = new BoardServiceImpl();
	
	// 게시판 화면
	@GetMapping("/board/home")
	public String list(HttpSession session, Model model, Board board) {
		if (session.getAttribute("userId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "../login");
			return "alert/alert";
		}
		model.addAttribute("board", service.read(board));
		
		return "board/home";
	}
	
	@GetMapping("/board/likes")
	public String getLikes(HttpSession session, Model model, Board board) {
		Likes likes = new Likes();
		String result = "false";
		String userId = (String) session.getAttribute("userId");
		if (session.getAttribute("userId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "../login");
			return "alert/alert";
		}
		likes.setUserId(userId);
		likes.setLikeCheck(result);
		likes.setNumber(board.getNumber());
		System.out.println(board.getNumber());
		service.likeuser(likes);
		
		if(likes.getLikeCheck() == "false") {
			result = "true";
			service.likecountUpdate(board.getLikecount(), board.getNumber());
		}
		return "board/home";
	}

	@PostMapping("/board/home")
	public String search(Board board, Model model) {
		List<Board> list = service.search(board.getTitle());
		model.addAttribute("list", list);
		return "board/search";
	}
	
	// 검색 화면
	@GetMapping("/board/search")
	public String searchlist(Model model) {
		return "board/search";
	}

	@PostMapping("/board/search")
	public String getsearchlist(Board board, Model model, HttpSession session) {
		List<Board> list = service.search(board.getTitle());
		model.addAttribute("list", list);
		session.invalidate();
		return "board/search";
	}

}