package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString(exclude = "user")
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String title;
	
	// Many에 해당하는 객체(Board)를 검색할 때, 연관된 One(User)에 해당하는 객체도 같이 검색해라.
	// @ManyToOne에 의해 BOARD와 USER 테이블에 대한 JOIN이 동작한다.
	@ManyToOne(optional = false, fetch = FetchType.EAGER)  
	// BOARD 테이블에 USER_ID 컬럼을 추가하고 FK 제약조건을 설정해라.
	// BOARD 테이블에 INSERT할 때, user 변수가 참조하는 user 객체의 식별자 변수값(seq)을 USER_ID 컬럼에 저장해라.
	@JoinColumn(name = "USER_ID") //FK
	private User user;  //연관관계의 주인이 됨
}





