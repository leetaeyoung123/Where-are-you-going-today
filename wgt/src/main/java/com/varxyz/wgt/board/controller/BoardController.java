package com.varxyz.wgt.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
		String userId = (String) session.getAttribute("userId");
		if (session.getAttribute("userId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "../login");
			return "alert/alert";
		}
		
		for (int i = 0; i < service.read(board).size(); i++) {
			long boardNum = service.read(board).get(i).getNumber();
			if( !service.findLikes(userId, boardNum).get(0).getUserId().equals("없음")) {
				if ( service.findLikes(userId, boardNum).get(0).getLikeCheck().equals("false") ) {
					service.updateLikeImg(boardNum, "dislikeheart");
				}else {
					service.updateLikeImg(boardNum, "likeheart");
				}
			}else {
				service.updateLikeImg(boardNum,"dislikeheart");
			}
		}
		
		model.addAttribute("board", service.read(board));
		
		return "board/home";
	}
	
	@GetMapping("/board/likes")
	public String getLikes(HttpSession session, Model model, Board board, HttpServletRequest request) {
		String userId = (String) session.getAttribute("userId");
		
		if (session.getAttribute("userId") == null) {
			model.addAttribute("msg", "로그인이 필요한 서비스 입니다.");
			model.addAttribute("url", "../login");
			return "alert/alert";
		}
		
		
		// 만약 Likes 테이블에 id, number가 동일한 정보가 없으면 만들어주기 아니면 밑에꺼 실행 
		if ( service.findLikes(userId, board.getNumber()).get(0).getUserId().equals("없음")
				&& service.findLikes(userId, board.getNumber()).get(0).getNumber() == -1 ) {
			Likes likes = new Likes();
			String result = "false";
			likes.setUserId(userId);
			likes.setLikeCheck(result);
			likes.setNumber(board.getNumber());
			service.likeuser(likes);
			service.checkUpdate(userId, board.getNumber(), "true");
			service.likecountPlus(board.getLikecount(), board.getNumber());
			service.updateLikeImg(board.getNumber(), "likeheart");
		}else { // DB에 아이디랑 게시글번호가 동일한 정보가 있다면 true, false를 비교한다
			if(service.findLikes(userId, board.getNumber()).get(0).getLikeCheck().equals("false")) { // 좋아요를 누르지 않은 상태태
				service.checkUpdate(userId, board.getNumber(), "true");
				service.likecountPlus(board.getLikecount(), board.getNumber());
				service.updateLikeImg(board.getNumber(), "likeheart");
			}else {
				service.checkUpdate(userId, board.getNumber(), "false");
				service.likecountDown(board.getLikecount(), board.getNumber());
				service.updateLikeImg(board.getNumber(), "dislikeheart");
			}
		}
		
		return "redirect:/board/home";
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