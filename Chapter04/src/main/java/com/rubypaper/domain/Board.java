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
@Table(name = "BOARD") // 옵션 : 클래스 이름과 테이블 이름이 동일한 경우 생략

//시퀀스 설정
@SequenceGenerator(name = "KEY_GENERATOR",
                   sequenceName = "BOARD_SEQUENCE",
                   initialValue = 1,
                   allocationSize = 1)
// 테이블 설정
//@TableGenerator(name = "KEY_GENERATOR",
//				table = "KEY_TABLE",
//				pkColumnName = "TABLE_NAME",
//				pkColumnValue = "BOARD",
//				valueColumnName = "NEXT_VAL",
//				initialValue = 0, //초기 값을 0으로 해야 1부터 생성된다.
//				allocationSize = 1)
@Data
public class Board {
	@Id // 필수 : 식별자 변수 지정(테이블의 PK 컬럼과 매핑되는 변수)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "KEY_GNERATOR") // 옵션 : 1부터 1씩 증가된 값을 자동으로 할당해라.
//	@GeneratedValue(strategy = GenerationType.IDENTITY) // 옵션 : 1부터 1씩 증가된 값을 자동으로 할당해라.
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
