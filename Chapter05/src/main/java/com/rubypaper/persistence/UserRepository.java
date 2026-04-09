package com.rubypaper.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubypaper.domain.User;

// JpaRepository를 상속한 인터페이스만 정의하면 구현 클래스는 Spring에서 자동으로 제공한다.
public interface UserRepository extends JpaRepository<User, String> {
	
}




