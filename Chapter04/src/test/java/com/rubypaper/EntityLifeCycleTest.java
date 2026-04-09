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
public class EntityLifeCycleTest {	
	
//	@Test
	void mergeBoard2() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();		

		EntityTransaction tx = em.getTransaction();
		
		tx.begin();		
		
		Board board = new Board();
		board.setSeq(1);
		board.setTitle("111111112");
		// merge()는 INSERT 기능과 UPDATE 기능을 모두 가진다.
		em.merge(board);
	
		tx.commit();
		
		em.close();
		emf.close();
	}
	
//	@Test
	void mergeBoard1() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();		

		EntityTransaction tx = em.getTransaction();
		
		tx.begin();		
		
		Board board = new Board();
		board.setTitle("JPA 테스트");
		em.persist(board);
		
		em.detach(board);
		
		board.setTitle("111111");
		
		// merge()는 DETATCHED 상태의 객체를 MANAGED 상태로 되돌린다. 이때 UPDATE 발생된다.
		em.merge(board);
	
		tx.commit();
		
		em.close();
		emf.close();
	}

	
	//@Test
	void managedTest() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		EntityManager em = emf.createEntityManager();
//		EntityTransaction tx = em.getTransaction();
//		
//		tx.begin();

//		Board board = new Board();
//		board.setTitle("MyBatis 테스트");
//		board.setWriter("테스터");
//		board.setContent("MyBatis 테스트 중입니다.");
//		board.setRegDate(new Date());
//		board.setCnt(0);
//		em.persist(board);
		
		// MANAGED 상태의 엔티티를 검색하면 SELECT가 동작하지 않는다.
		Board findBoard = em.find(Board.class, 1);
		System.out.println("---> " + findBoard.toString());		
		
//		tx.commit();
		
		em.close();
		emf.close();
	}

	//@Test
	void insertBoard() {
		// EntityManagerFactoryBean 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
		
		// EntityManager 생성
		EntityManager em = emf.createEntityManager();
		
		// Transaction 생성
		EntityTransaction tx = em.getTransaction();
		
		// 트랜잭션 시작
		tx.begin();
		
		// NEW 상태
		Board board = new Board();
		board.setTitle("MyBatis 테스트");
		board.setWriter("테스터");
		board.setContent("MyBatis 테스트 중입니다.");
		board.setRegDate(new Date());
		board.setCnt(0);
		
		System.out.println("1. board가 관리되고 있나? " + em.contains(board));
		
		// MANAGED 상태
		em.persist(board);
		System.out.println("2. board가 관리되고 있나? " + em.contains(board));
		
		// MANAGED 상태의 객체를 수정하면 자동으로 UPDATE 처리된다.
		//board.setTitle("-----제목 수정");
		
		// DETACHED 상태는 한번 MANAGED 상태에 있던 객체가 컨테이너에서 벗어난 상태다.
		// MANAGED 상태 --> DETACHED 상태
//		em.detach(board);
//		System.out.println("3. board가 관리되고 있나? " + em.contains(board));
//		
//		// DETACHED 상태의 객체는 값을 수정해도 테이블에 영향을 주지 않는다.
//		board.setContent("-----내용 수정");
		
		// REMOVED 상태
		em.remove(board);
		
		// 트랜잭션 종료
		tx.commit();
		
		// 자원 해제
		em.close();
		emf.close();
	}

}
