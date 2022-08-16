package com.varxyz.wgt.board.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.varxyz.wgt.board.domain.Board;

@Component("boardDao")
public class BoardDao {
	private JdbcTemplate jdbcTemplate;

	public BoardDao(DataSource dataSource) {
	      jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//게시글 생성
	public void create(Board board, String imgName) {
		String sql = "INSERT INTO Board (title, content, imgname) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, board.getTitle(), board.getContent(), imgName);
	}
	
	//게시글 읽기
	public List<Board> read(Board board) {
		String sql = "SELECT * FROM Board ORDER BY regDate DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Board>(Board.class));
	}
	
	//게시글 수정
	public void update(Board board) {
		String sql = "UPDATE Board SET title = ?, content = ?, imgname =? WHERE userId = ?";
		jdbcTemplate.update(sql, board.getTitle(), board.getContent(), board.getImgname());
	}

	//게시글 삭제
	public List<Board> delete(int number) {
		String sql = "DELETE FROM Board WHERE number = ?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Board>(Board.class), number);
	}
	
	//ID로 게시글 찾기
	public List<Board> findByuserId(String userId) {
		String sql = "SELECT * FROM Board WHERE userId = ?";
		List<Board> list = new ArrayList<>();
		list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Board>(Board.class));
		return list;
	}
	
	//제목으로 찾기
	public Board findByTitle(String title) {
		String sql = "SELECT * FROM Board WHERE title = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Board>(Board.class), title);
	}
}
