package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String title;
	private String writer;
	private String content;
	
	@Column(name = "REGDATE", updatable = false)
	private Date regDate;
	private int cnt;
}





