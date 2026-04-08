package com.rubypaper.domain;

import java.util.Date;

import lombok.Data;

// BOARD 테이블의 하나의 ROW와 매핑되는 클래스
@Data
public class BoardVO {
	private int seq;
	private String title;
	private String writer;
	private String content;
	private Date regDate;
	private int cnt;
}
