package com.rubypaper.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USERS")
public class User {
	@Id
	private String username; // 회원 아이디
	private String password;
	private String name;	 // 회원 이름
	
	@Enumerated(EnumType.STRING)
	private Role role;
	private boolean enabled;
}
