package com.rubypaper.domain;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Transient;
import lombok.Data;

// BOARD 테이블의 하나의 ROW와 매핑되는 클래스
@Entity // 필수 : 이 클래스로부터 생성된 객체는 엔티티 객체(JPA가 관리할 수 있는 객체)다.
@Data
public class Board {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seq;
	private String title;
	private String writer;
	private String content;
	
	@Column(name = "REG_DATE", updatable = false )
	
	private Date regDate;	
	private int cnt;
	
	//searchKeyword 변수는 영속화 대상에서 제외한다. 즉 테이블과 매핑하지 않는다.
	@Transient
	private String searchKeyword;
}
