package com.varxyz.wgt.board.dao;

import java.io.File;
import java.util.List;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.varxyz.wgt.board.domain.Board;
import com.varxyz.wgt.board.domain.Likes;

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
	public void update(Board board, String imgname) { //3가지 방법, request.getparameter / Board board / Requestparam
		String sql = "UPDATE Board SET title = ?, content = ?, imgname = ? WHERE number = ?";
		jdbcTemplate.update(sql, board.getTitle(), board.getContent(), imgname, board.getNumber());
	}

	//게시글 삭제
	public int delete(int number, String imgname) {
		String sql = "DELETE FROM Board WHERE number = ?";
		File file = new File("C:\\NCS\\Where-are-you-going-today\\wgt\\src\\main\\webapp\\resources\\board\\img\\upload" + imgname + ".jpg");
		file.delete();
		return jdbcTemplate.update(sql, number);
	}
	
	//제목으로 게시글 찾기
	public List<Board> search(String title) {
		String sql = "SELECT * FROM Board WHERE title like '%" + title + "%' ORDER BY regDate DESC";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Board>(Board.class));
	}
	
	//고유번호로 게시물 정보 갖고오기
	public Board searchByNumber(int number) {
		String sql = "SELECT * FROM Board WHERE number = ?";
		return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Board>(Board.class), number);
	}//query = list<object>로 반환  queryforobject = 객체로만 반환
	
	// 좋아요 업데이트
	public void likecountUpdate(int likecount, int number) {
		String sql = "UPDATE Board SET likecount = ? WHERE number = ?";
		jdbcTemplate.update(sql,likecount, number);
	}
	
	public void likeuser(Likes likes) {
		String sql = "INSERT INTO Likes (userId, likeCheck, number) VALUES (?, ?, ?)";
		jdbcTemplate.update(sql, likes.getNumber(), likes.getUserId(), likes.getLikeCheck());
	}
	
	//ID로 게시글 찾기
//	public List<Board> findByuserId(String userId) {
//		String sql = "SELECT * FROM Board WHERE userId = ?";
//		List<Board> list = new ArrayList<>();
//		list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Board>(Board.class));
//		return list;
//	}

}
