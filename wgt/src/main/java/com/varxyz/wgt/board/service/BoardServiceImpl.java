package com.varxyz.wgt.board.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.board.domain.Likes;

@Component("boardService")
public class BoardServiceImpl implements BoardService {

	@Override
	public List<Board> list() {
		List<Board> list = new ArrayList<>();
		return list;
	}

	@Override
	public void create(Board board, String imgName, String userId) {
		dao.create(board, imgName, userId);
	}

	@Override
	public List<Board> read(Board board) {
		return dao.read(board);
	}

	@Override
	public void update(Board board, String imgname) {
		dao.update(board, imgname);
	}

	@Override
	public int delete(int number, String imgname) {
		return dao.delete(number, imgname);
	}

	@Override
	public List<Board> search(String title) {
		return dao.search(title);
	}

	@Override
	public Board searchByNumber(long number) {
		return dao.searchByNumber(number);
	}

	@Override
	public void likeuser(Likes likes) {
		dao.likeuser(likes);
	}

	@Override
	public List<Likes> findLikes(String userId, long number) {
		return dao.findLikes(userId, number);
	}

	@Override
	public void checkUpdate(String userId, long number, String check) {
		dao.checkUpdate(userId, number, check);
	}

	@Override
	public void likecountPlus(int likecount, long number) {
		dao.likecountPlus(likecount, number);
	}

	@Override
	public void likecountDown(int likecount, long number) {
		dao.likecountDown(likecount, number);
	}

	@Override
	public void updateLikeImg(String userId, long number, String likeImg) {
			dao.updateLikeImg(userId, number, likeImg);
	}

	
	
}
