package com.varxyz.wgt.board.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {
	private int number;
	private String title;
	private String content;
	private String userId;
	private Date regDate;
	private String image;
	private int view;
	
	public Board() {
		super();
	}
}
