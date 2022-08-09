package com.varxyz.wgt.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.varxyz.wgt.board.domain.Page;
import com.varxyz.wgt.board.service.BoardService;


@Controller
public class BoardController {

	@GetMapping("/wgt/home")
	public String list() {
		return "/wgt/home";
	}
	
	@GetMapping("/wgt/board")
	public String post() {
		return "/wgt/board";
	}
	
	@Autowired
	private BoardService service;
	
	@GetMapping("")
	
	// 게시글 목록 화면
		@RequestMapping(value = "/waiting/home", method = RequestMethod.GET)
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