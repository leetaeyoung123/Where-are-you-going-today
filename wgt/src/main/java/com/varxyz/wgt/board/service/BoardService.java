package com.varxyz.wgt.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.varxyz.wgt.board.dao.BoardDao;
import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.data.DataSourceConfig;

public interface BoardService {

	AnnotationConfigApplicationContext context =
		new AnnotationConfigApplicationContext(DataSourceConfig.class);

	BoardDao dao = context.getBean("boardDao", BoardDao.class);

	// 게시글 목록 조회
		public List<Board> list();
		
		// 게시글 쓰기
		public void create(Board board, String imgName);
		
		// 게시글 읽기
		public Board read(Integer number);
		public List<Board> read(Board board);
		
		// 게시글 수정
		public void update(Board board);
		
		// 게시글 삭제
		public List<Board> delete(int number);
		
		// 게시글 검색
		public List<Board> search(String keyword);
		
		public Integer totalCount() throws Exception;

		public List<Board> boardList = new ArrayList<>();
}
