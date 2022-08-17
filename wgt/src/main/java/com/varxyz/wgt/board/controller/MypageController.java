package com.varxyz.wgt.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.board.service.BoardService;
import com.varxyz.wgt.board.service.BoardServiceImpl;
import com.varxyz.wgt.user.domain.User;
import com.varxyz.wgt.user.service.UserService;
import com.varxyz.wgt.user.serviceImpl.UserServiceImpl;

@Controller
public class MypageController {
	BoardService service = new BoardServiceImpl();
	UserService userService = new UserServiceImpl();

	// 회원정보 가져오기
	@GetMapping("/board/mypage")
	public String postForm(HttpSession session, Model model, Board board) {
		List<User> userList = userService.inquiryUser((String) session.getAttribute("userId"));
//		System.out.println(session.getAttribute("userId"));
		model.addAttribute("userList", userList);
		model.addAttribute("board", service.read(board));
		session.setAttribute("number", board.getNumber());
		return "/board/mypage";
	}

	@PostMapping("/board/mypage")
	public String post(Board board, Model model) {
		model.addAttribute("Board", board);
		service.create(board, "imgname");
		model.addAttribute("msg", "게시글 수정을 완료하였습니다.");
		model.addAttribute("url", "home");
		return "alert/alert";
	}

	// 게시글 삭제
	@GetMapping("/board/delete")
	public String deleteGet(@RequestParam("bid") int bid, Model model, String imgname, HttpSession session) {
//		System.out.println(bid);
		String filePath = "C:\\\\NCS\\\\Where-are-you-going-today\\\\wgt\\\\src\\\\main\\\\webapp\\\\resources\\\\board\\\\img\\\\upload";
        
        File deleteFile = new File(filePath);
        // 파일이 존재하는지 체크 존재할경우 true, 존재하지않을경우 false
        if(deleteFile.exists()) {
            // 파일을 삭제합니다.
        	session.removeAttribute(imgname);
            deleteFile.delete(); 
            System.out.println("파일을 삭제하였습니다.");
        } else {
            System.out.println("파일이 존재하지 않습니다.");
        }
		service.delete(bid, imgname);
		return "redirect:/board/mypage";
	}

//	@PostMapping("/board/delete")
//	public String delete(Board board, Model model, HttpSession session) {
//		session.getAttribute("number");
//		System.out.println(board.getNumber());
//		service.delete(board.getNumber());
//		model.addAttribute("msg", "게시글이 삭제되었습니다.");
//		model.addAttribute("url","mypage");
//		return "alert/alert";
//	}

}