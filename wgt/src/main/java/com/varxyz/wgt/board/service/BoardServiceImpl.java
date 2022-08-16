package com.varxyz.wgt.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.varxyz.wgt.board.domain.Board;

@Component("boardService")
public class BoardServiceImpl implements BoardService {

	@Override
	public List<Board> list() {
		List<Board> list = new ArrayList<>();
		return list;
	}

	@Override
	public void create(Board board, String imgName) {
		dao.create(board, imgName);
	}

	@Override
	public List<Board> read(Board board) {
		return dao.read(board);
	}

	@Override
	public void update(Board board) {
		dao.update(board);
	}

	@Override
	public List<Board> delete(int number) {
		return dao.delete(number);
	}

	@Override
	public List<Board> search(String title) {
		return dao.seasrch(title);
	}

	@Override
	public Integer totalCount() throws Exception {
		return null;
	}

	@Override
	public Board read(Integer number) {
		return null;
	}

	
}
