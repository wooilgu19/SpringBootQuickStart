package com.rubypaper;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@SpringBootTest
public class JpaCachTest {	

	@Test
	void insertBoard() {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Board board = new Board();
		board.setTitle("MyBatis 테스트");
		board.setWriter("테스터");
		board.setContent("MyBatis 테스트 중입니다.");
		board.setRegDate(new Date());
		board.setCnt(0);
		em.persist(board);
		
		System.out.println("---글 등록 성공!!");

		tx.commit();

		em.close();
		emf.close();
	}

}
