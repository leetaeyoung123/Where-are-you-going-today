package com.varxyz.wgt.board.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.board.domain.Page;
import com.varxyz.wgt.board.service.BoardService;

@Controller
public class BoardController {

	@GetMapping("/board/home")
	public String list() {
		return "/board/home";
	}
	
	@GetMapping("/board/board")
	public String wirte() {
		return "/board/board";
	}
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/")
	public String list(Model model) {
		
	}
	
	// 게시글 목록 화면
		@RequestMapping(value = "/board/home", method = RequestMethod.GET)
		public void list(Model model, Page page) throws Exception {
			Integer totalCount = null;
			Integer rowsPerPage = null;
			Integer pageCount = null;
			Integer pageNum = page.getPageNum();
			String keyword = page.getKeyword();
		
			// 조회된 전체 게시글 수
			if( page.getTotalCount() == 0 )
				totalCount = service.totalCount();
			else
				totalCount = page.getTotalCount();
			
			// 페이지 당 노출 게시글 수
			if( page.getRowsPerPage() == 0 ) 
				rowsPerPage = 10;
			else
				rowsPerPage = page.getRowsPerPage();
			
			// 노출 페이지 수
			if( page.getPageCount() == 0 )
				pageCount = 10;
			else
				pageCount = page.getPageCount();
				
			
			if( page.getPageNum() == 0 ) {
				page = new Page(1, rowsPerPage, totalCount, pageCount);
			} else {
				page = new Page(pageNum, rowsPerPage, totalCount, pageCount);
			}
			
			
			if( keyword == null || keyword == "" ) {
				page.setKeyword("");
				model.addAttribute("list", service.list(page));
			} else {
				page.setKeyword(keyword);
				model.addAttribute("list", service.search(page));
			}
						
			model.addAttribute("page", page);
			
//			log.info(totalCount.toString());
//			log.info(page.toString());
			}	
}