package com.rubypaper.domain;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
@Table(name = "USERS")
@ToString(exclude = "boardList")
public class User {
	@Id 
	//@GeneratedValue(strategy = GeneraionType.IDENTITY) 
	private String id;
	private String name;
	
	//One에 해당하는 User 객체를 검색할 때, Many에 해당하는 Board 객체들도 같이 가져와라.
	// 양방향 매핑에서는 연관관계의 주인이 아닌 변수에 mappedBy 설정을 추가한다.
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Board> boardList = new ArrayList<>();
		
}





